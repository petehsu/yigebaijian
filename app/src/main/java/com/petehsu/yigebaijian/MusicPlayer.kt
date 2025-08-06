package com.petehsu.yigebaijian

import android.content.Context
import android.media.MediaPlayer
import android.media.audiofx.Visualizer
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.provider.OpenableColumns
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import java.io.File
import java.io.FileOutputStream
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MusicPlayer(private val context: Context) {
    private var mediaPlayer: MediaPlayer? = null
    private var currentSongIndex = 0
    private var songs = mutableListOf<File>()
    private var currentLyrics = mutableListOf<LyricLine>()
    private var currentLrcFile: File? = null
    
    val isPlaying = mutableStateOf(false)
    val currentSongName = mutableStateOf<String?>(null)
    val currentLyric = mutableStateOf<String?>(null)
    val displayedLyric = mutableStateOf<String>("")  // 用于显示打字效果的歌词
    
    private var visualizer: Visualizer? = null
    private val _currentAmplitude = mutableStateOf(0f)
    val currentAmplitude: State<Float> = _currentAmplitude
    
    // 添加播放进度相关的状态
    private val _currentPosition = mutableStateOf(0)
    val currentPosition: State<Int> = _currentPosition
    private val _duration = mutableStateOf<Int?>(null)
    val duration: State<Int?> = _duration
    
    // 添加更新进度的任务
    private var progressUpdateJob: kotlinx.coroutines.Job? = null
    
    // 添加歌词行数据类
    private data class LyricLine(
        val time: Long, // 时间戳（毫秒）
        val text: String // 歌词文本
    )
    
    companion object {
        private val SUPPORTED_FORMATS = setOf(
            ".mp3", ".MP3",
            ".wav", ".WAV",
            ".ogg", ".OGG",
            ".m4a", ".M4A",
            ".flac", ".FLAC"
        )
    }
    
    init {
        Log.d("MusicPlayer", "Initializing MusicPlayer...")
        createMusicDirectory()
        loadSongs()
    }
    
    fun addSongFromUri(uri: Uri) {
        try {
            // 获取文件名
            var fileName = ""
            context.contentResolver.query(uri, null, null, null, null)?.use { cursor ->
                val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                cursor.moveToFirst()
                fileName = cursor.getString(nameIndex)
            }
            
            // 确保目标目录存在
            val musicDir = File(Environment.getExternalStorageDirectory(), "Music/ygbjmusic")
            if (!musicDir.exists()) {
                createMusicDirectory()
            }
            
            // 创建目标文件
            val targetFile = File(musicDir, fileName)
            
            // 复制文件内容
            context.contentResolver.openInputStream(uri)?.use { input ->
                FileOutputStream(targetFile).use { output ->
                    input.copyTo(output)
                }
            }
            
            Log.d("MusicPlayer", "Copied file to: ${targetFile.absolutePath}")
            
            // 验证文件是否可播放
            try {
                val testPlayer = MediaPlayer()
                testPlayer.setDataSource(targetFile.path)
                testPlayer.prepare()
                testPlayer.release()
                
                // 如果可以播放，添加到列表
                songs.add(targetFile)
                Log.d("MusicPlayer", "Added new song: $fileName")
                
                // 如果是第一首歌，自动开始播放
                if (songs.size == 1) {
                    playSong(0)
                }
            } catch (e: Exception) {
                Log.e("MusicPlayer", "Invalid audio file: $fileName", e)
                targetFile.delete() // 删除无效文件
            }
        } catch (e: Exception) {
            Log.e("MusicPlayer", "Error adding song from uri", e)
        }
    }
    
    fun refreshSongList() {
        Log.d("MusicPlayer", "Refreshing song list...")
        loadSongs()
    }
    
    private fun createMusicDirectory() {
        val musicDir = File(Environment.getExternalStorageDirectory(), "Music/ygbjmusic")
        Log.d("MusicPlayer", "Music directory path: ${musicDir.absolutePath}")
        
        if (!musicDir.exists()) {
            try {
                // 先确保 Music 目录存在
                val musicParentDir = File(Environment.getExternalStorageDirectory(), "Music")
                if (!musicParentDir.exists()) {
                    val created = musicParentDir.mkdir()
                    Log.d("MusicPlayer", "Creating Music directory: $created")
                }
                // 创建 ygbjmusic 目录
                val created = musicDir.mkdir()
                Log.d("MusicPlayer", "Creating ygbjmusic directory: $created")
                if (!created) {
                    Log.e("MusicPlayer", "Failed to create ygbjmusic directory. Parent exists: ${musicDir.parentFile?.exists()}, Parent writable: ${musicDir.parentFile?.canWrite()}")
                }
            } catch (e: Exception) {
                Log.e("MusicPlayer", "Error creating directories", e)
                e.printStackTrace()
            }
        } else {
            Log.d("MusicPlayer", "Music directory exists. Readable: ${musicDir.canRead()}, Writable: ${musicDir.canWrite()}")
        }
    }
    
    private fun loadSongs() {
        Log.d("MusicPlayer", "Loading songs...")
        
        val audioList = mutableListOf<File>()
        
        try {
            // 使用协程在后台加载
            MainScope().launch {
                // 首先检查指定目录
                val musicDir = File(Environment.getExternalStorageDirectory(), "Music/ygbjmusic")
                Log.d("MusicPlayer", "Checking music directory: ${musicDir.absolutePath}")
                Log.d("MusicPlayer", "Directory exists: ${musicDir.exists()}, Is directory: ${musicDir.isDirectory}, Can read: ${musicDir.canRead()}")
                
                if (musicDir.exists() && musicDir.isDirectory) {
                    // 递归扫描目录
                    scanDirectory(musicDir, audioList)
                }
                
                // 如果指定目录没有找到文件，则扫描媒体库
                if (audioList.isEmpty()) {
                    Log.d("MusicPlayer", "No files found in ygbjmusic directory, scanning media store...")
                    scanMediaStore(audioList)
                }
                
                // 如果媒体库也没有找到文件，尝试扫描整个Music目录
                if (audioList.isEmpty()) {
                    Log.d("MusicPlayer", "No files found in media store, scanning entire Music directory...")
                    val musicParentDir = File(Environment.getExternalStorageDirectory(), "Music")
                    if (musicParentDir.exists() && musicParentDir.isDirectory) {
                        scanDirectory(musicParentDir, audioList)
                    }
                }
                
                songs = audioList
                Log.d("MusicPlayer", "Final song list contains ${songs.size} audio files")
                if (songs.isNotEmpty()) {
                    Log.d("MusicPlayer", "First song: ${songs[0].absolutePath}")
                } else {
                    Log.e("MusicPlayer", "No songs found in any location")
                }
                
                // 如果没有找到任何音乐文件，确保目录存在
                if (songs.isEmpty()) {
                    Log.d("MusicPlayer", "No songs found, ensuring directory exists")
                    createMusicDirectory()
                }
            }
        } catch (e: Exception) {
            Log.e("MusicPlayer", "Error loading songs", e)
            e.printStackTrace()
        }
    }
    
    private fun scanDirectory(directory: File, audioList: MutableList<File>) {
        try {
            Log.d("MusicPlayer", "Scanning directory: ${directory.absolutePath}")
            Log.d("MusicPlayer", "Directory exists: ${directory.exists()}, Is directory: ${directory.isDirectory}, Can read: ${directory.canRead()}")
            
            directory.listFiles()?.let { files ->
                Log.d("MusicPlayer", "Found ${files.size} files in directory")
                files.forEach { file ->
                    when {
                        file.isFile && isAudioFile(file.name) -> {
                            Log.d("MusicPlayer", "Found audio file: ${file.name} in ${file.parent}")
                            audioList.add(file)
                        }
                        file.isDirectory -> {
                            Log.d("MusicPlayer", "Scanning subdirectory: ${file.name}")
                            scanDirectory(file, audioList)
                        }
                    }
                }
            } ?: Log.e("MusicPlayer", "listFiles() returned null for directory: ${directory.absolutePath}")
        } catch (e: Exception) {
            Log.e("MusicPlayer", "Error scanning directory: ${directory.absolutePath}", e)
            e.printStackTrace()
        }
    }
    
    private suspend fun scanMediaStore(audioList: MutableList<File>) {
        try {
            Log.d("MusicPlayer", "Scanning media store...")
            val collection = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
                MediaStore.Audio.Media.getContentUri(MediaStore.VOLUME_EXTERNAL)
            } else {
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
            }
            
            val projection = arrayOf(
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.DISPLAY_NAME,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.SIZE
            )
            
            // 移除大小限制，只保留音乐文件的过滤
            val selection = "${MediaStore.Audio.Media.IS_MUSIC} = ?"
            val selectionArgs = arrayOf("1")
            
            Log.d("MusicPlayer", "Querying media store with selection: $selection")
            
            context.contentResolver.query(
                collection,
                projection,
                selection,
                selectionArgs,
                "${MediaStore.Audio.Media.DATE_ADDED} DESC"
            )?.use { cursor ->
                val displayNameColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME)
                val dataColumn = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA)
                
                Log.d("MusicPlayer", "Media store cursor has ${cursor.count} rows")
                
                var scannedCount = 0
                var addedCount = 0
                
                while (cursor.moveToNext()) {
                    scannedCount++
                    try {
                        val displayName = cursor.getString(displayNameColumn)
                        val data = cursor.getString(dataColumn)
                        val file = File(data)
                        Log.d("MusicPlayer", "Checking file: $displayName at ${file.absolutePath}")
                        Log.d("MusicPlayer", "File exists: ${file.exists()}, Can read: ${file.canRead()}")
                        
                        if (file.exists() && file.canRead() && isAudioFile(displayName)) {
                            audioList.add(file)
                            addedCount++
                            Log.d("MusicPlayer", "Added song from media store: $displayName")
                        }
                    } catch (e: Exception) {
                        Log.e("MusicPlayer", "Error processing media item", e)
                    }
                }
                
                Log.d("MusicPlayer", "Media store scan complete: Scanned $scannedCount files, Added $addedCount valid audio files")
            } ?: Log.e("MusicPlayer", "Media store query returned null")
        } catch (e: Exception) {
            Log.e("MusicPlayer", "Error scanning media store", e)
            e.printStackTrace()
        }
    }
    
    private fun isAudioFile(fileName: String): Boolean {
        return try {
            val extension = fileName.lowercase().substringAfterLast(".", "")
            val supported = extension in SUPPORTED_FORMATS.map { it.substring(1) }
            if (supported) {
                Log.d("MusicPlayer", "File $fileName has supported format: $extension")
            }
            supported
        } catch (e: Exception) {
            Log.e("MusicPlayer", "Error checking file format for: $fileName", e)
            false
        }
    }
    
    fun togglePlayPause() {
        Log.d("MusicPlayer", "togglePlayPause called. Songs size: ${songs.size}, MediaPlayer null: ${mediaPlayer == null}, Is playing: ${mediaPlayer?.isPlaying}")
        if (mediaPlayer == null && songs.isNotEmpty()) {
            playSong(0)
        } else if (mediaPlayer?.isPlaying == true) {
            pause()
        } else {
            resume()
        }
    }
    
    private fun parseLrcFile(lrcContent: String): List<LyricLine> {
        val lyrics = mutableListOf<LyricLine>()
        val lines = lrcContent.split("\n")
        
        val timeRegex = "\\[(\\d{2}):(\\d{2})\\.(\\d{2,3})](.*)".toRegex()
        
        for (line in lines) {
            timeRegex.findAll(line).forEach { matchResult ->
                val (minutes, seconds, milliseconds, text) = matchResult.destructured
                val timeMs = minutes.toLong() * 60 * 1000 +
                            seconds.toLong() * 1000 +
                            milliseconds.padEnd(3, '0').toLong()
                
                if (text.isNotBlank()) {
                    lyrics.add(LyricLine(timeMs, text.trim()))
                }
            }
        }
        
        return lyrics.sortedBy { it.time }
    }
    
    private fun loadLyrics(songFile: File) {
        val lrcFile = File(songFile.parentFile, "${songFile.nameWithoutExtension}.lrc")
        currentLyric.value = null
        currentLrcFile = null
        currentLyrics.clear()
        
        if (lrcFile.exists() && lrcFile.canRead()) {
            try {
                currentLrcFile = lrcFile
                val lrcContent = lrcFile.readText()
                currentLyrics = parseLrcFile(lrcContent).toMutableList()
                Log.d("MusicPlayer", "Loaded lyrics file: ${lrcFile.name}")
                Log.d("MusicPlayer", "Parsed ${currentLyrics.size} lyric lines")
            } catch (e: Exception) {
                Log.e("MusicPlayer", "Error loading lyrics", e)
                currentLrcFile = null
                currentLyrics.clear()
            }
        } else {
            Log.d("MusicPlayer", "No lyrics file found for: ${songFile.name}")
        }
    }
    
    private fun updateCurrentLyric(position: Int) {
        if (currentLyrics.isEmpty()) return
        
        // 查找当前时间对应的歌词
        val currentLine = currentLyrics.findLast { it.time <= position } ?: currentLyrics.first()
        
        // 如果是新的歌词行，开始打字效果
        if (currentLyric.value != currentLine.text) {
            currentLyric.value = currentLine.text
            startTypingEffect(currentLine.text)
        }
    }
    
    private var typingJob: kotlinx.coroutines.Job? = null
    
    private fun startTypingEffect(text: String) {
        // 取消现有的打字任务
        typingJob?.cancel()
        
        // 启动新的打字任务
        typingJob = MainScope().launch {
            displayedLyric.value = ""
            val chars = text.toCharArray()
            for (i in chars.indices) {
                if (!isPlaying.value) break  // 如果暂停了，停止打字效果
                displayedLyric.value = text.substring(0, i + 1)
                delay(50)  // 每个字的延迟时间，可以调整
            }
        }
    }
    
    private var lyricUpdateJob: kotlinx.coroutines.Job? = null
    
    private fun startLyricUpdate() {
        // 取消现有的歌词更新任务
        lyricUpdateJob?.cancel()
        
        // 启动新的歌词更新任务
        lyricUpdateJob = MainScope().launch {
            try {
                while (isPlaying.value && mediaPlayer != null && !mediaPlayer!!.isReleased) {
                    mediaPlayer?.currentPosition?.let { position ->
                        updateCurrentLyric(position)
                    }
                    delay(100)
                }
            } catch (e: Exception) {
                Log.e("MusicPlayer", "Error updating lyrics", e)
            }
        }
    }
    
    fun playSong(index: Int) {
        if (index < 0 || index >= songs.size) return
        
        try {
            val song = songs[index]
            Log.d("MusicPlayer", "Trying to play song: ${song.name}, path: ${song.absolutePath}")
            
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer().apply {
                try {
                    setDataSource(song.path)
                    prepare()
                    
                    // 在开始播放前获取时长
                    _duration.value = duration
                    Log.d("MusicPlayer", "Song duration: ${duration}ms")
                    
                    start()
                    setOnCompletionListener {
                        playNext()
                    }
                    
                    Log.d("MusicPlayer", "Successfully started playing: ${song.name}")
                } catch (e: Exception) {
                    Log.e("MusicPlayer", "Error playing song: ${song.name}", e)
                }
            }
            currentSongIndex = index
            currentSongName.value = song.nameWithoutExtension
            isPlaying.value = true
            
            // 启动进度更新任务
            startProgressUpdate()
            
            // 加载歌词
            loadLyrics(song)
            
            // 启动歌词更新
            startLyricUpdate()
            
            // 在开始播放后设置可视化器
            setupVisualizer()
            
        } catch (e: Exception) {
            Log.e("MusicPlayer", "Error in playSong", e)
        }
    }
    
    // 添加一个扩展属性来安全检查 MediaPlayer 是否已释放
    private val MediaPlayer.isReleased: Boolean
        get() = try {
            isPlaying
            false
        } catch (e: IllegalStateException) {
            true
        }
    
    private fun startProgressUpdate() {
        progressUpdateJob?.cancel()
        progressUpdateJob = MainScope().launch {
            while (isPlaying.value && mediaPlayer != null && !mediaPlayer!!.isReleased) {
                try {
                    mediaPlayer?.let { player ->
                        _currentPosition.value = player.currentPosition
                        Log.d("MusicPlayer", "Progress: ${_currentPosition.value}/${_duration.value}")
                    }
                    delay(16) // 约60fps的更新频率
                } catch (e: Exception) {
                    Log.e("MusicPlayer", "Error updating progress", e)
                    break
                }
            }
        }
    }
    
    private fun pause() {
        mediaPlayer?.pause()
        isPlaying.value = false
        // 暂停时停止进度更新、歌词更新和打字效果
        progressUpdateJob?.cancel()
        lyricUpdateJob?.cancel()
        typingJob?.cancel()
    }
    
    private fun resume() {
        mediaPlayer?.start()
        isPlaying.value = true
        // 恢复播放时重新启动进度更新、歌词更新和打字效果
        startProgressUpdate()
        startLyricUpdate()
        currentLyric.value?.let { startTypingEffect(it) }
    }
    
    fun playNext() {
        if (songs.isEmpty()) return
        val nextIndex = (currentSongIndex + 1) % songs.size
        playSong(nextIndex)
    }
    
    fun playPrevious() {
        if (songs.isEmpty()) return
        val previousIndex = if (currentSongIndex > 0) currentSongIndex - 1 else songs.size - 1
        playSong(previousIndex)
    }
    
    fun release() {
        mediaPlayer?.release()
        mediaPlayer = null
        isPlaying.value = false
        currentSongName.value = null
        currentLyric.value = null
        displayedLyric.value = ""
        currentLrcFile = null
        // 重置进度相关状态
        _currentPosition.value = 0
        _duration.value = null
        // 释放时取消所有任务
        progressUpdateJob?.cancel()
        lyricUpdateJob?.cancel()
        typingJob?.cancel()
        
        visualizer?.release()
        visualizer = null
    }
    
    fun getSongList(): List<String> {
        return songs.map { it.nameWithoutExtension }
    }
    
    fun playByName(songName: String) {
        val index = songs.indexOfFirst { it.nameWithoutExtension == songName }
        if (index >= 0) {
            playSong(index)
        }
    }
    
    private fun setupVisualizer() {
        mediaPlayer?.let { player ->
            try {
                visualizer?.release()
                
                visualizer = Visualizer(player.audioSessionId).apply {
                    enabled = false
                    captureSize = Visualizer.getCaptureSizeRange()[0] // 使用最小采样大小以减少 CPU 负载
                    
                    setDataCaptureListener(object : Visualizer.OnDataCaptureListener {
                        private var lastUpdateTime = 0L
                        
                        override fun onWaveFormDataCapture(
                            visualizer: Visualizer,
                            waveform: ByteArray,
                            samplingRate: Int
                        ) {
                            val currentTime = System.currentTimeMillis()
                            // 限制更新频率为每 50ms 一次
                            if (currentTime - lastUpdateTime >= 50) {
                                // 只采样部分数据点以减少计算量
                                val amplitude = waveform.filterIndexed { index, _ -> 
                                    index % 4 == 0 
                                }.map { 
                                    it.toFloat() / 128.0f 
                                }.average().toFloat()
                                _currentAmplitude.value = amplitude.coerceIn(0f, 1f)
                                lastUpdateTime = currentTime
                            }
                        }
                        
                        override fun onFftDataCapture(
                            visualizer: Visualizer,
                            fft: ByteArray,
                            samplingRate: Int
                        ) {
                            // 不处理 FFT 数据
                        }
                    }, Visualizer.getMaxCaptureRate() / 2, true, false) // 降低采样率
                    
                    enabled = true
                }
            } catch (e: Exception) {
                Log.e("MusicPlayer", "Error setting up visualizer", e)
            }
        }
    }
} 