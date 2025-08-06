package com.petehsu.yigebaijian

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.zIndex
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.petehsu.yigebaijian.ui.theme.一个摆件Theme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.min
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import kotlinx.coroutines.delay
import androidx.compose.foundation.border
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.DisposableEffect
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.input.pointer.pointerInput
import coil.compose.AsyncImage
import android.widget.VideoView
import androidx.compose.ui.viewinterop.AndroidView
import android.media.MediaPlayer
import android.view.Gravity
import android.widget.FrameLayout
import java.io.File
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.remember
import androidx.compose.ui.composed
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.background
import androidx.compose.animation.*
import android.os.BatteryManager
import android.app.ActivityManager
import android.content.Context.ACTIVITY_SERVICE
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import kotlinx.coroutines.withTimeout
import android.net.wifi.WifiManager
import java.net.NetworkInterface
import java.net.Inet4Address
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import kotlinx.serialization.json.Json
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.ui.graphics.graphicsLayer
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.random.Random
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.toArgb
import android.graphics.Paint
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.layout.boundsInRoot
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntSize
import java.time.temporal.ChronoUnit
import androidx.compose.ui.draw.blur
import androidx.compose.material3.Slider
import kotlinx.coroutines.Job
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.gestures.forEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import kotlinx.coroutines.CoroutineScope
import android.content.ContentResolver
import android.webkit.MimeTypeMap
import androidx.core.content.FileProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.animation.animateColorAsState
import java.time.DayOfWeek
import androidx.compose.ui.text.font.FontFamily
import java.time.ZoneId
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.cos
import android.view.Surface
import java.time.Instant
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import java.time.LocalDate
import android.view.SurfaceView
import com.petehsu.yigebaijian.view.WaveView  // 添加 WaveView 导入
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.layout.ContentScale
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.Worker
import androidx.work.WorkerParameters
import android.widget.Toast
import android.view.WindowManager

// 添加时间设置数据类
data class TimeDisplaySettings(
    val alpha: Float = 1f,
    val fontSize: Float = 200f,  // 修改默认字体大小为 200f
    val fontWeight: Int = 400,
    val showSeconds: Boolean = false,
    val showMillis: Boolean = false,
    val use24Hour: Boolean = true,
    val isTimeOnTop: Boolean = false,
    val isCentered: Boolean = true,
    val keepScreenOn: Boolean = false,  // 添加常亮显示选项
    val timeColor: Long = 0xFFFFFFFF  // 添加时间颜色设置，默认白色
)

// 添加人生日期设置数据类
data class LifeTimeSettings(
    val birthDate: LocalDateTime? = null,
    val endDate: LocalDateTime? = null,
    val isCustomEndDate: Boolean = false,
    val birthday: LocalDate? = null  // 添加生日字段
)

// 添加人生进度显示设置数据类
data class LifeProgressDisplaySettings(
    val showRemainingPercent: Boolean = false,  // 是否显示剩余百分比
    val showDecimalPercent: Boolean = false,    // 是否显示百分比小数
    val passedTimeUnit: CustomTimeUnit = CustomTimeUnit.DAY,  // 过去时间的单位
    val remainingTimeUnit: CustomTimeUnit = CustomTimeUnit.DAY  // 剩余时间的单位
)

enum class CustomTimeUnit {
    YEAR, QUARTER, MONTH, WEEK, DAY, HOUR, MINUTE, SECOND, MILLISECOND;

    fun getDisplayText(): String {
        return when (this) {
            YEAR -> "年"
            QUARTER -> "季"
            MONTH -> "月"
            WEEK -> "周"
            DAY -> "天"
            HOUR -> "时"
            MINUTE -> "分"
            SECOND -> "秒"
            MILLISECOND -> "毫秒"
        }
    }
}

// 添加圆环设置数据类
data class CircleSettings(
    val yearColor: Color = Color(0xFF2196F3),
    val yearStrokeWidth: Float = 5f,
    val showYearCircle: Boolean = true,
    val showYearBackground: Boolean = true,

    val dayColor: Color = Color(0xFFFF1744),
    val dayStrokeWidth: Float = 5f,
    val showDayCircle: Boolean = true,
    val showDayBackground: Boolean = true,

    val minuteColor: Color = Color(0xFFFFD600),
    val minuteStrokeWidth: Float = 5f,
    val showMinuteCircle: Boolean = true,
    val showMinuteBackground: Boolean = true,

    val batteryColor: Color = Color(0xFF00E676),
    val batteryStrokeWidth: Float = 5f,
    val showBatteryCircle: Boolean = true,
    val showBatteryBackground: Boolean = true,

    val musicColor: Color = Color(0xFFE040FB),
    val musicStrokeWidth: Float = 5f,
    val showMusicCircle: Boolean = true,
    val showMusicBackground: Boolean = true,

    val breathingBallColor: Color = Color(0xFFAA00FF),
    val breathingBallStrokeWidth: Float = 5f,
    val showBreathingBall: Boolean = true,
    val showBreathingBallBackground: Boolean = true
)

data class SystemInfo(
    val ipAddress: String = "",
    val steps: Long = 0L,  // 从 Int 改为 Long
    val batteryLevel: Int = 0,
    val batteryCharging: Boolean = false,
    val memoryInfo: String = ""
)

@Serializable
data class TodoItem(
    val id: Long = System.currentTimeMillis(),
    val content: String,
    val dayOfWeek: Int, // 1-7 代表周一到周日
    val hour: Int,
    val minute: Int,
    val dueDate: String? = null // 添加截止日期字段，格式：yyyy-MM-dd
)

// 添加星星数据类
data class Star(
    val x: Float,
    val y: Float,
    val baseRadius: Float,
    val phase: Float
)

// 添加雨滴数据类
private data class RainDrop(
    val x: Float,
    val y: Float,
    val speed: Float,
    val length: Float,
    val alpha: Float,
    val width: Float,
    val angle: Float,
    val depth: Float
)

@Composable
fun rememberStars(count: Int, seed: Int): List<Star> {
    return remember(seed) {
        val random = Random(seed)
        List(count) {
            Star(
                x = random.nextFloat(),
                y = random.nextFloat(),
                baseRadius = random.nextFloat() * 2f + 1f,
                phase = random.nextFloat() * 2f * Math.PI.toFloat()
            )
        }
    }
}

// 添加年度进度显示设置数据类
data class YearProgressDisplaySettings(
    val showRemainingPercent: Boolean = false,  // 是否显示剩余百分比
    val showDecimalPercent: Boolean = false,    // 是否显示百分比小数
    val passedTimeUnit: CustomTimeUnit = CustomTimeUnit.DAY,  // 过去时间的单位
    val remainingTimeUnit: CustomTimeUnit = CustomTimeUnit.DAY,  // 剩余时间的单位
    val enableRainEffect: Boolean = false  // 是否启用下雨效果
)

@Composable
fun YearProgressDisplaySettingsDialog(
    onDismiss: () -> Unit
) {
    val mainActivity = LocalContext.current as MainActivity
    val settings = mainActivity._yearProgressDisplaySettings.value

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("年度进度显示设置", color = Color.Black) },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // 百分比设置
                Text("百分比设置", color = Color.Black, fontWeight = FontWeight.Bold)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("显示剩余百分比", color = Color.Black)
                    Switch(
                        checked = settings.showRemainingPercent,
                        onCheckedChange = {
                            val newSettings = settings.copy(showRemainingPercent = it)
                            mainActivity._yearProgressDisplaySettings.value = newSettings
                            mainActivity.getSharedPreferences("app_settings", Context.MODE_PRIVATE)
                                .edit()
                                .putBoolean("year_progress_show_remaining", it)
                                .apply()
                        }
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("显示小数", color = Color.Black)
                    Switch(
                        checked = settings.showDecimalPercent,
                        onCheckedChange = {
                            val newSettings = settings.copy(showDecimalPercent = it)
                            mainActivity._yearProgressDisplaySettings.value = newSettings
                            mainActivity.getSharedPreferences("app_settings", Context.MODE_PRIVATE)
                                .edit()
                                .putBoolean("year_progress_show_decimal", it)
                                .apply()
                        }
                    )
                }

                Divider(color = Color.LightGray)

                // 已过时间单位设置
                Text("已过时间单位", color = Color.Black, fontWeight = FontWeight.Bold)
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(CustomTimeUnit.values()) { unit ->
                        Surface(
                            modifier = Modifier.clickable {
                                val newSettings = settings.copy(passedTimeUnit = unit)
                                mainActivity._yearProgressDisplaySettings.value = newSettings
                                mainActivity.getSharedPreferences("app_settings", Context.MODE_PRIVATE)
                                    .edit()
                                    .putString("year_progress_passed_unit", unit.name)
                                    .apply()
                            },
                            color = if (settings.passedTimeUnit == unit)
                                MaterialTheme.colorScheme.primary
                            else
                                MaterialTheme.colorScheme.surface,
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text(
                                text = unit.getDisplayText(),
                                modifier = Modifier.padding(8.dp),
                                color = if (settings.passedTimeUnit == unit)
                                    Color.White
                                else
                                    Color.Black
                            )
                        }
                    }
                }

                // 剩余时间单位设置
                Text("剩余时间单位", color = Color.Black, fontWeight = FontWeight.Bold)
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(CustomTimeUnit.values()) { unit ->
                        Surface(
                            modifier = Modifier.clickable {
                                val newSettings = settings.copy(remainingTimeUnit = unit)
                                mainActivity._yearProgressDisplaySettings.value = newSettings
                                mainActivity.getSharedPreferences("app_settings", Context.MODE_PRIVATE)
                                    .edit()
                                    .putString("year_progress_remaining_unit", unit.name)
                                    .apply()
                            },
                            color = if (settings.remainingTimeUnit == unit)
                                MaterialTheme.colorScheme.primary
                            else
                                MaterialTheme.colorScheme.surface,
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text(
                                text = unit.getDisplayText(),
                                modifier = Modifier.padding(8.dp),
                                color = if (settings.remainingTimeUnit == unit)
                                    Color.White
                                else
                                    Color.Black
                            )
                        }
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("确定", color = Color.Black)
            }
        }
    )
}

// 在 MainActivity 类之前添加 FarewellMessage 数据类
data class FarewellMessage(
    val text: String,
    val delay: Long = 3000  // 默认延迟3秒
)

// 添加生日消息数据类
data class BirthdayMessage(
    val text: String,
    val delay: Long = 3000  // 默认延迟3秒
)

// 添加三天光明消息数据类
data class ThreeDaysMessage(
    val text: String,
    val delay: Long = 2000  // 默认延迟2秒
)

// 添加特殊彩蛋消息数据类
data class SpecialFarewellMessage(
    val text: String,
    val delay: Long = 3000
)

class MainActivity : ComponentActivity() {
    // 将 aboutPageLayout 改为 internal
    internal lateinit var aboutPageLayout: FrameLayout

    companion object {
        private const val CHANNEL_ID = "todo_notification_channel"
        private const val NOTIFICATION_ID = 1001
    }

    internal lateinit var musicPlayer: MusicPlayer
    internal var _lifeTimeSettings = mutableStateOf(LifeTimeSettings())
    internal var _lifeProgressDisplaySettings = mutableStateOf(LifeProgressDisplaySettings())
    internal var _yearProgressDisplaySettings = mutableStateOf(YearProgressDisplaySettings())
    internal var _showLifeProgress = mutableStateOf(false)
    internal var _showYearProgress = mutableStateOf(false)
    internal var _showHourglassProgress = mutableStateOf(false)
    internal var _showPendulumBallPanel = mutableStateOf(false) // 摆球界面状态
    internal var _showLifeRemaining = mutableStateOf(false)
    internal var _showMinimalUI = mutableStateOf(false)
    internal var _showMinimalClockUI = mutableStateOf(false)  // 添加新的极简时钟界面状态
    internal var _showAboutScreen = mutableStateOf(false)
    internal var _showBlurSlider = mutableStateOf(false)
    internal var blurSliderJob: Job? = null
    internal var _backgroundUri = mutableStateOf<String?>(null)
    internal var _isBackgroundVideo = mutableStateOf(false)
    internal var _showMinimalClockUI2 = mutableStateOf(false)
    internal var _showMinimalClockUI3 = mutableStateOf(false)
    internal var _hitokoto = mutableStateOf("")

    // 歌词相关状态
    internal var _originalHitokoto = mutableStateOf("") // 保存原始一言
    internal var _currentLyrics = mutableStateOf<String?>(null) // 当前歌词
    internal var _isLyraPlayerPlaying = mutableStateOf(false) // LyraPlayer是否在播放
    internal var _hasLyrics = mutableStateOf(false) // 当前歌曲是否有歌词
    internal var _songTitle = mutableStateOf<String?>(null) // 歌曲标题
    internal var _artist = mutableStateOf<String?>(null) // 艺术家

    internal var _isWhiteText = mutableStateOf(false)
    internal var _timeSettings = mutableStateOf(TimeDisplaySettings())
    internal var _circleSettings = mutableStateOf(CircleSettings())
    internal var _systemInfo = mutableStateOf(SystemInfo())
    internal var _showTodoList = mutableStateOf(false)
    internal var _todoItems = mutableStateOf<List<TodoItem>>(emptyList())
    private var sensorManager: SensorManager? = null
    private var accelerometerSensor: Sensor? = null
    private var stepCounter: Sensor? = null
    private var stepCounterListener: SensorEventListener? = null
    private var gyroscopeSensor: Sensor? = null
    private var _tiltX = mutableStateOf(0f)
    private var _tiltY = mutableStateOf(0f)
    internal val tiltX: State<Float> = _tiltX
    internal val tiltY: State<Float> = _tiltY

    private var lastTimestamp = 0L
    private var tiltXFromAccelerometer = 0f
    private var tiltYFromAccelerometer = 0f

    private var lastAcceleration = FloatArray(3)
    private var lastTime = 0L
    // 修改isShaking的声明
    private var _isShaking = mutableStateOf(false)
    internal val isShaking: State<Boolean> = _isShaking

    // 添加景深壁纸选择状态
    private var isSelectingDepthBackground = false

    // 歌词广播接收器（接收来自LyricsReceiver的内部广播）
    private val lyricsReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action == "com.petehsu.yigebaijian.UPDATE_LYRICS") {
                val lyrics = intent.getStringExtra("lyrics")
                val isPlaying = intent.getBooleanExtra("isPlaying", false)
                val hasLyrics = intent.getBooleanExtra("hasLyrics", false)
                val songTitle = intent.getStringExtra("songTitle")
                val artist = intent.getStringExtra("artist")

                Log.d("YiGeBaiJian", "收到歌词更新广播: lyrics=$lyrics, isPlaying=$isPlaying, hasLyrics=$hasLyrics")

                // 更新状态
                _currentLyrics.value = lyrics
                _isLyraPlayerPlaying.value = isPlaying
                _hasLyrics.value = hasLyrics
                _songTitle.value = songTitle
                _artist.value = artist

                // 更新一言显示
                updateHitokotoDisplay()
            }
        }
    }

    // 添加彩蛋文本数据类
    internal var _showFarewellScreen = mutableStateOf(false)
    // 将 farewellMessages 改为 internal
    internal val farewellMessages = listOf(
        FarewellMessage("人的一生会经历六次死亡", 4000),          // 开场，需要足够时间理解
        FarewellMessage("第一次，是心跳停止，呼吸消逝", 5000),    // 第一个死亡
        FarewellMessage("第二次，是葬礼的结束，亲友散去", 5000),   // 第二个死亡，较长的句子
        FarewellMessage("第三次，是这世上最后一个记得你的人，把你忘记", 5000),  // 第三个死亡，最长的句子
        FarewellMessage("当你的故事不再被提起", 2000),           // 短句
        FarewellMessage("当所有与你有关的痕迹都消失", 3000),      // 短句
        FarewellMessage("当时间本身也遗忘了一切", 3000),         // 短句
        FarewellMessage("今天，你将抵达宁静的彼岸", 4000),       // 转折
        FarewellMessage("放下所有的疲惫与忧虑", 2000),          // 安慰
        FarewellMessage("让心灵在自由中轻盈起舞", 3000),        // 轻快
        FarewellMessage("愿你在无尽的星空下", 3000),           // 短句
        FarewellMessage("找到属于自己的那片宁静", 3000),        // 期望
        FarewellMessage("微笑着告别^_^", 2000),                  // 最短的句子
        FarewellMessage("因为每一次告别，都是新的开始", 0)       // 最后一句，永久显示
    )

    // 添加生日彩蛋状态
    internal var _showBirthdayScreen = mutableStateOf(false)

    // 添加生日消息列表
    internal val birthdayMessages = listOf(
        BirthdayMessage("你看，蜡烛在零点重新生长", 7000),
        BirthdayMessage("你听，年轮合拢的清脆回响", 6000),
        BirthdayMessage("你收下春雾凝成的霜", 3000),
        BirthdayMessage("背着十二个月亮的行囊", 4000),
        BirthdayMessage("你站在时间的十字路口", 3000),
        BirthdayMessage("左手沙漏，右手星斗", 3000),
        BirthdayMessage("老树根下睡着新雪", 2000),
        BirthdayMessage("这次你要把春天种在哪片衣袖？", 0)  // 最后一句永久显示
    )

    // 将 private 改为 internal
    internal var birthdayMediaPlayer: MediaPlayer? = null

    // 添加三天光明彩蛋状态
    internal var _showThreeDaysScreen = mutableStateOf(false)

    // 添加三天光明消息列表
    internal val threeDaysMessages = listOf(
        ThreeDaysMessage("《假如给我三天光明》即将到期", 2000),
        ThreeDaysMessage("海伦·凯勒说", 1000),
        ThreeDaysMessage("『把活着的每一天看作生命的最后一天』", 3000),
        ThreeDaysMessage("第一天，请凝视爱人的眼睛", 2000),
        ThreeDaysMessage("第二天，聆听风吟鸟鸣", 2000),
        ThreeDaysMessage("第三天，触摸世界的纹理", 2000),
        ThreeDaysMessage("现在，你的三天开始了", 2000)  // 添加最后显示时间以便实现渐出效果
    )

    // 添加音频播放器
    private var mediaPlayer: MediaPlayer? = null

    // 添加音频播放函数
    private fun playThreeDaysAudio() {
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(this, R.raw.st)
        mediaPlayer?.start()
    }

    private val accelerometerListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent) {
            val currentTime = System.currentTimeMillis()
            if ((currentTime - lastTime) > 100) {
                val diffTime = currentTime - lastTime
                lastTime = currentTime

                val x = event.values[0]
                val y = event.values[1]
                val z = event.values[2]

                val speed = kotlin.math.abs(x + y + z - lastAcceleration[0] - lastAcceleration[1] - lastAcceleration[2]) / diffTime * 10000

                if (speed > 800) {
                    _isShaking.value = true
                    MainScope().launch {
                        delay(2000)
                        _isShaking.value = false
                    }
                }

                lastAcceleration[0] = x
                lastAcceleration[1] = y
                lastAcceleration[2] = z
            }

            // 根据屏幕方向调整传感器数据
            val rotation = windowManager.defaultDisplay.rotation
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]

            // 根据屏幕方向调整倾斜角度计算
            when (rotation) {
                Surface.ROTATION_90 -> {
                    tiltXFromAccelerometer = kotlin.math.atan2(y, kotlin.math.sqrt(x * x + z * z)) * 180f / Math.PI.toFloat()
                    tiltYFromAccelerometer = kotlin.math.atan2(-x, kotlin.math.sqrt(y * y + z * z)) * 180f / Math.PI.toFloat()
                }
                Surface.ROTATION_270 -> {
                    tiltXFromAccelerometer = kotlin.math.atan2(-y, kotlin.math.sqrt(x * x + z * z)) * 180f / Math.PI.toFloat()
                    tiltYFromAccelerometer = kotlin.math.atan2(x, kotlin.math.sqrt(y * y + z * z)) * 180f / Math.PI.toFloat()
                }
                else -> {
                    tiltXFromAccelerometer = kotlin.math.atan2(x, kotlin.math.sqrt(y * y + z * z)) * 180f / Math.PI.toFloat()
                    tiltYFromAccelerometer = kotlin.math.atan2(y, kotlin.math.sqrt(x * x + z * z)) * 180f / Math.PI.toFloat()
                }
            }
        }

        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
    }

    private val gyroscopeListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent) {
            val currentTime = System.currentTimeMillis()
            if (lastTimestamp == 0L) {
                lastTimestamp = currentTime
                return
            }
            val dt = (currentTime - lastTimestamp) / 1000f // 转换为秒

            // 根据屏幕方向调整陀螺仪数据
            val rotation = windowManager.defaultDisplay.rotation
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]

            // 调整陀螺仪数据
            val (deltaX, deltaY) = when (rotation) {
                Surface.ROTATION_90 -> Pair(y * dt, -x * dt)
                Surface.ROTATION_270 -> Pair(-y * dt, x * dt)
                else -> Pair(x * dt, y * dt)
            }

            // 使用互补滤波器融合加速度计和陀螺仪数据
            val alpha = 0.98f
            _tiltX.value = (alpha * (_tiltX.value + deltaX) + (1 - alpha) * tiltXFromAccelerometer).coerceIn(-30f, 30f)
            _tiltY.value = (alpha * (_tiltY.value + deltaY) + (1 - alpha) * tiltYFromAccelerometer).coerceIn(-30f, 30f)

            lastTimestamp = currentTime
        }

        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
    }

    // 添加一个状态变量来标记是否是景深模式
    private var isDepthMode = false

    // 修改 onSelectDepth 函数
    private fun onSelectDepth() {
        isDepthMode = true
        pickBackground.launch("image/*")
    }

    // 修改 pickBackground 的回调
    private val pickBackground = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        // 保存当前的前景图状态
        val currentForegroundUri = _foregroundUri.value

        uri?.let {
            try {
                // 检查文件类型
                val mimeType = contentResolver.getType(uri)
                val isVideo = mimeType?.startsWith("video/") == true

                // 如果是视频，先检查大小
                if (isVideo) {
                    contentResolver.openFileDescriptor(uri, "r")?.use { pfd ->
                        val fileSize = pfd.statSize
                        if (fileSize > 50 * 1024 * 1024) {
                            MainScope().launch(Dispatchers.Main) {
                                Toast.makeText(
                                    this@MainActivity,
                                    "视频文件过大，建议使用小于50MB的视频",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                            return@registerForActivityResult
                        }
                    }
                }

                // 创建目标目录
                val backgroundDir = File(getExternalFilesDir(null), "backgrounds").apply {
                    if (!exists()) {
                        mkdirs()
                    }
                }

                // 根据文件类型生成文件名
                val extension = if (isVideo) {
                    mimeType?.substringAfter("/") ?: "mp4"
                } else {
                    getFileExtension(uri)
                }
                val fileName = "background_${System.currentTimeMillis()}.$extension"
                val targetFile = File(backgroundDir, fileName)

                // 复制文件
                contentResolver.openInputStream(uri)?.use { input ->
                    targetFile.outputStream().use { output ->
                        input.copyTo(output)
                    }
                }

                // 更新背景设置
                _backgroundUri.value = targetFile.absolutePath
                _isBackgroundVideo.value = isVideo

                // 保存设置
                getSharedPreferences("app_settings", Context.MODE_PRIVATE).edit()
                    .putString("background_uri", targetFile.absolutePath)
                    .putBoolean("is_video", isVideo)
                    .putBoolean("is_custom_background", true)
                    .apply()

                // 如果是景深模式，选完背景后立即启动前景图选择
                if (isDepthMode) {
                    pickForeground.launch("image/*")
                    isDepthMode = false  // 重置状态
                }

            } catch (e: Exception) {
                Log.e("MainActivity", "Error setting background", e)
                // 发生错误时恢复前景图
                _foregroundUri.value = currentForegroundUri
                MainScope().launch(Dispatchers.Main) {
                    Toast.makeText(
                        this@MainActivity,
                        "设置背景失败：${e.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    // 前景图片选择器
    private val pickForeground = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let {
            try {
                // 创建目标目录
                val backgroundDir = File(getExternalFilesDir(null), "backgrounds").apply {
                    if (!exists()) {
                        mkdirs()
                    }
                }

                // 生成文件名
                val extension = getFileExtension(uri)
                val fileName = "foreground_${System.currentTimeMillis()}.$extension"
                val targetFile = File(backgroundDir, fileName)

                // 复制文件
                contentResolver.openInputStream(uri)?.use { input ->
                    targetFile.outputStream().use { output ->
                        input.copyTo(output)
                    }
                }

                // 更新前景图URI
                _foregroundUri.value = targetFile.absolutePath

                // 保存设置到 SharedPreferences
                getSharedPreferences("app_settings", Context.MODE_PRIVATE).edit()
                    .putString("foreground_uri", targetFile.absolutePath)
                    .apply()

            } catch (e: Exception) {
                Log.e("MainActivity", "Error setting foreground", e)
                MainScope().launch(Dispatchers.Main) {
                    Toast.makeText(
                        this@MainActivity,
                        "设置前景图失败：${e.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val allGranted = permissions.entries.all { it.value }
        if (allGranted) {
            Log.d("MainActivity", "All permissions granted, initializing")
            initializeMusicPlayer()
        } else {
            Log.d("MainActivity", "Some permissions denied")
            // 显示权限说明对话框
            showPermissionDialog = true
        }
    }

    private var showPermissionDialog by mutableStateOf(false)

    @Composable
    private fun showPermissionExplanationDialog() {
        AlertDialog(
            onDismissRequest = { showPermissionDialog = false },
            title = {
                Text("需要权限")
            },
            text = {
                Text("应用需要访问音频文件的权限才能播放音乐。请在设置中授予权限。")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showPermissionDialog = false
                        val intent = Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                        intent.data = Uri.fromParts("package", packageName, null)
                        startActivity(intent)
                    }
                ) {
                    Text("去设置")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = { showPermissionDialog = false }
                ) {
                    Text("取消")
                }
            }
        )
    }

    private fun checkAndRequestPermissions() {
        val permissions = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            arrayOf(
                Manifest.permission.READ_MEDIA_AUDIO,
                Manifest.permission.POST_NOTIFICATIONS,
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.ACTIVITY_RECOGNITION
            )
        } else {
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.RECORD_AUDIO,
                Manifest.permission.ACTIVITY_RECOGNITION
            )
        }

        val allPermissionsGranted = permissions.all {
            ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED
        }

        if (allPermissionsGranted) {
            Log.d("MainActivity", "All permissions already granted")
            initializeMusicPlayer()
        } else {
            Log.d("MainActivity", "Requesting permissions")
            requestPermissionLauncher.launch(permissions)
        }
    }

    private fun initializeMusicPlayer() {
        try {
            Log.d("MainActivity", "Starting to initialize MusicPlayer...")
            if (!::musicPlayer.isInitialized) {
                Log.d("MainActivity", "MusicPlayer not initialized, creating new instance...")
                musicPlayer = MusicPlayer(this)
                Log.d("MainActivity", "Successfully created new MusicPlayer instance")
                // 初始化后立即刷新歌曲列表
                Log.d("MainActivity", "Refreshing song list for new instance...")
                musicPlayer.refreshSongList()
            } else {
                Log.d("MainActivity", "MusicPlayer already initialized, refreshing song list...")
                // 如果已经初始化，也要刷新歌曲列表
                musicPlayer.refreshSongList()
            }

            // 确保音乐播放器已正确初始化
            if (::musicPlayer.isInitialized) {
                Log.d("MainActivity", "MusicPlayer initialization check passed")
            } else {
                Log.e("MainActivity", "MusicPlayer initialization failed")
            }
        } catch (e: Exception) {
            Log.e("MainActivity", "Failed to initialize MusicPlayer", e)
            e.printStackTrace()
        }
    }

    private val stepSensorListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent) {
            val steps = event.values[0].toLong()
            _systemInfo.value = _systemInfo.value.copy(steps = steps)
            Log.d("MainActivity", "Step count updated: $steps")
        }
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}
    }

    override fun onResume() {
        super.onResume()
        // 恢复步数传感器监听
        stepCounter?.let {
            sensorManager?.registerListener(stepSensorListener, it, SensorManager.SENSOR_DELAY_UI)
        }
        // 使用更高的采样率注册传感器
        accelerometerSensor?.let {
            sensorManager?.registerListener(
                accelerometerListener,
                it,
                SensorManager.SENSOR_DELAY_GAME
            )
        }
        gyroscopeSensor?.let {
            sensorManager?.registerListener(
                gyroscopeListener,
                it,
                SensorManager.SENSOR_DELAY_GAME
            )
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause: Stopping rain and life progress sounds")
        // 暂停步数传感器监听
        sensorManager?.unregisterListener(stepSensorListener)
        // 取消陀螺仪监听
        sensorManager?.unregisterListener(gyroscopeListener)
        // 取消加速度传感器监听
        sensorManager?.unregisterListener(accelerometerListener)
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop: Stopping rain and life progress sounds")
    }

    private var sliderVisibilityJob: Job? = null
    private var lastTapTime = 0L

    // 添加双击检测函数
    private fun checkDoubleTap(currentTime: Long, showSlider: MutableState<Boolean>, scope: CoroutineScope) {
        if (currentTime - lastTapTime < 300) {
            showSlider.value = !showSlider.value
            sliderVisibilityJob?.cancel()
            if (showSlider.value) {
                sliderVisibilityJob = scope.launch {
                    delay(3000)
                    showSlider.value = false
                }
            }
        }
        lastTapTime = currentTime
    }

    // 在 MainActivity 类中添加检查是否是国庆节的函数
    internal fun isNationalDay(date: LocalDateTime): Boolean {
        return date.monthValue == 10 && date.dayOfMonth in 1..7
    }

    // 修改背景更新函数
    private fun updateBackgroundForDate() {
        try {
            val now = LocalDateTime.now()
            val prefs = getSharedPreferences("app_settings", Context.MODE_PRIVATE)
            val isCustomBackground = prefs.getBoolean("is_custom_background", false)
            
            // 如果用户设置了自定义背景，则不自动切换
            if (isCustomBackground) {
                return
            }

            val backgroundDir = File(getExternalFilesDir(null), "backgrounds")
            if (!backgroundDir.exists()) {
                backgroundDir.mkdirs()
            }

            // 检查是否是国家公祭日
            if (isNationalMemorialDay(now)) {
                val memorialBgFile = File(backgroundDir, "njdts.jpg")
                val memorialFgFile = File(backgroundDir, "njdts_fg.png")

                // 复制背景文件（如果不存在）
                if (!memorialBgFile.exists()) {
                    resources.openRawResource(R.raw.njdts).use { input ->
                        memorialBgFile.outputStream().use { output ->
                            input.copyTo(output)
                        }
                    }
                }

                // 复制前景文件（如果不存在）
                if (!memorialFgFile.exists()) {
                    resources.openRawResource(R.raw.njdts_fg).use { input ->
                        memorialFgFile.outputStream().use { output ->
                            input.copyTo(output)
                        }
                    }
                }

                // 更新背景设置
                _backgroundUri.value = memorialBgFile.absolutePath
                _foregroundUri.value = memorialFgFile.absolutePath
                _isBackgroundVideo.value = false

                // 保存设置
                prefs.edit()
                    .putString("background_uri", memorialBgFile.absolutePath)
                    .putString("foreground_uri", memorialFgFile.absolutePath)
                    .putBoolean("is_video", false)
                    .apply()

                Log.d("MainActivity", "Updated to memorial day background")
            }
        } catch (e: Exception) {
            Log.e("MainActivity", "Error updating background for date", e)
        }
    }

    /**
     * 更新一言显示逻辑
     */
    private fun updateHitokotoDisplay() {
        val isPlaying = _isLyraPlayerPlaying.value
        val hasLyrics = _hasLyrics.value
        val currentLyrics = _currentLyrics.value

        _hitokoto.value = when {
            // 正在播放且有歌词且歌词不为空
            isPlaying && hasLyrics && !currentLyrics.isNullOrBlank() -> {
                Log.d("YiGeBaiJian", "显示歌词: $currentLyrics")
                currentLyrics
            }
            // 其他情况显示原始一言
            else -> {
                Log.d("YiGeBaiJian", "显示一言: ${_originalHitokoto.value}")
                _originalHitokoto.value
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate called")

        enableEdgeToEdge()

        // 设置窗口标志
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // 获取 WindowInsetsController
        val windowInsetsController = WindowCompat.getInsetsController(window, window.decorView)
        windowInsetsController.apply {
            // 隐藏系统栏
            hide(WindowInsetsCompat.Type.systemBars())
            // 设置系统栏行为
            systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
            
            // 初始化传感器
            sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
            accelerometerSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
            gyroscopeSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
            stepCounter = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

            val prefs = getSharedPreferences("app_settings", Context.MODE_PRIVATE)

            // 检查并设置背景
            try {
                // 创建私有目录用于存储背景
                val backgroundDir = File(getExternalFilesDir(null), "backgrounds").apply {
                    if (!exists()) {
                        mkdirs()
                    }
                }

                // 检查是否是国庆节
                val isNationalDay = isNationalDay(LocalDateTime.now())

                if (isNationalDay) {
                    // 复制国庆节背景图片
                    val nationalDayFile = File(backgroundDir, "gqzjm.jpg")
                    if (!nationalDayFile.exists()) {
                        resources.openRawResource(R.raw.gqzjm).use { input ->
                            nationalDayFile.outputStream().use { output ->
                                input.copyTo(output)
                            }
                        }
                    }
                    // 设置国庆节背景
                    _backgroundUri.value = nationalDayFile.absolutePath
                    _foregroundUri.value = null  // 国庆节时清除前景
                    _isBackgroundVideo.value = false

                    // 保存背景设置
                    prefs.edit()
                        .putString("background_uri", nationalDayFile.absolutePath)
                        .remove("foreground_uri")  // 清除前景URI
                        .putBoolean("is_video", false)
                        .apply()
                } else {
                    // 非国庆节时使用保存的背景或默认背景
                    val savedBackgroundUri = prefs.getString("background_uri", null)
                    val savedForegroundUri = prefs.getString("foreground_uri", null)

                    if (savedBackgroundUri == null) {
                        // 复制默认背景图片
                        val defaultBgFile = File(backgroundDir, "default_background.jpg")
                        val defaultFgFile = File(backgroundDir, "default_foreground.png")

                        // 复制默认背景
                        if (!defaultBgFile.exists()) {
                            resources.openRawResource(R.raw.bg).use { input ->
                                defaultBgFile.outputStream().use { output ->
                                    input.copyTo(output)
                                }
                            }
                        }

                        // 复制默认前景
                        if (!defaultFgFile.exists()) {
                            resources.openRawResource(R.raw.fg).use { input ->
                                defaultFgFile.outputStream().use { output ->
                                    input.copyTo(output)
                                }
                            }
                        }

                        // 保存背景和前景设置
                        prefs.edit()
                            .putString("background_uri", defaultBgFile.absolutePath)
                            .putString("foreground_uri", defaultFgFile.absolutePath)
                            .putBoolean("is_video", false)
                            .apply()

                        _backgroundUri.value = defaultBgFile.absolutePath
                        _foregroundUri.value = defaultFgFile.absolutePath
                        _isBackgroundVideo.value = false
                    } else {
                        val isVideo = prefs.getBoolean("is_video", false)
                        _backgroundUri.value = savedBackgroundUri
                        _foregroundUri.value = savedForegroundUri
                        _isBackgroundVideo.value = isVideo
                    }
            }
        
        // 初始化生日设置
        val birthDateMillis = prefs.getLong("birth_date", -1)
        val endDateMillis = prefs.getLong("end_date", -1)
        val isCustomEndDate = prefs.getBoolean("is_custom_end_date", false)

        // 加载时间显示设置
        _timeSettings.value = TimeDisplaySettings(
            alpha = prefs.getFloat("time_alpha", 0.53f),
                fontSize = prefs.getFloat("time_font_size", 269f),  // 将默认值从 200f 改为 269f
            fontWeight = prefs.getInt("time_font_weight", 900),
            showSeconds = prefs.getBoolean("time_show_seconds", false),
            showMillis = prefs.getBoolean("time_show_millis", false),
            use24Hour = prefs.getBoolean("time_use_24_hour", true),
            isTimeOnTop = prefs.getBoolean("time_is_on_top", true),
            isCentered = prefs.getBoolean("time_is_centered", true),
                keepScreenOn = prefs.getBoolean("keep_screen_on", false),  // 添加常亮显示选项
            timeColor = prefs.getLong("time_color", 0xFFFFFFFF)  // 添加时间颜色加载
        )

        // 加载年度进度显示设置
        _yearProgressDisplaySettings.value = YearProgressDisplaySettings(
            showRemainingPercent = prefs.getBoolean("year_progress_show_remaining", false),
            showDecimalPercent = prefs.getBoolean("year_progress_show_decimal", false),
            passedTimeUnit = CustomTimeUnit.valueOf(prefs.getString("year_progress_passed_unit", CustomTimeUnit.DAY.name) ?: CustomTimeUnit.DAY.name),
            remainingTimeUnit = CustomTimeUnit.valueOf(prefs.getString("year_progress_remaining_unit", CustomTimeUnit.DAY.name) ?: CustomTimeUnit.DAY.name),
            enableRainEffect = prefs.getBoolean("year_progress_enable_rain_effect", false)
        )

        // 加载生命进度显示设置
        _lifeProgressDisplaySettings.value = LifeProgressDisplaySettings(
            showRemainingPercent = prefs.getBoolean("life_progress_show_remaining", false),
            showDecimalPercent = prefs.getBoolean("life_progress_show_decimal", false),
            passedTimeUnit = CustomTimeUnit.valueOf(prefs.getString("life_progress_passed_unit", CustomTimeUnit.DAY.name) ?: CustomTimeUnit.DAY.name),
            remainingTimeUnit = CustomTimeUnit.valueOf(prefs.getString("life_progress_remaining_unit", CustomTimeUnit.DAY.name) ?: CustomTimeUnit.DAY.name)
        )

        // 加载圆环设置
        _circleSettings.value = CircleSettings(
            yearColor = Color(prefs.getString("year_circle_color", "FF2196F3")?.toULong(16)?.toLong() ?: 0xFF2196F3),
            yearStrokeWidth = prefs.getFloat("year_circle_width", 5f),
            showYearCircle = prefs.getBoolean("show_year_circle", true),
            showYearBackground = prefs.getBoolean("show_year_background", true),

            dayColor = Color(prefs.getString("day_circle_color", "FFFF1744")?.toULong(16)?.toLong() ?: 0xFFFF1744),
            dayStrokeWidth = prefs.getFloat("day_circle_width", 5f),
            showDayCircle = prefs.getBoolean("show_day_circle", true),
            showDayBackground = prefs.getBoolean("show_day_background", true),

            minuteColor = Color(prefs.getString("minute_circle_color", "FFFFD600")?.toULong(16)?.toLong() ?: 0xFFFFD600),
            minuteStrokeWidth = prefs.getFloat("minute_circle_width", 5f),
            showMinuteCircle = prefs.getBoolean("show_minute_circle", true),
            showMinuteBackground = prefs.getBoolean("show_minute_background", true),

            batteryColor = Color(prefs.getString("battery_circle_color", "FF00E676")?.toULong(16)?.toLong() ?: 0xFF00E676),
            batteryStrokeWidth = prefs.getFloat("battery_circle_width", 5f),
            showBatteryCircle = prefs.getBoolean("show_battery_circle", true),
            showBatteryBackground = prefs.getBoolean("show_battery_background", true),

            musicColor = Color(prefs.getString("music_circle_color", "FFE040FB")?.toULong(16)?.toLong() ?: 0xFFE040FB),
            musicStrokeWidth = prefs.getFloat("music_circle_width", 5f),
            showMusicCircle = prefs.getBoolean("show_music_circle", true),
            showMusicBackground = prefs.getBoolean("show_music_background", true),

            breathingBallColor = Color(prefs.getString("breathing_ball_color", "FFAA00FF")?.toULong(16)?.toLong() ?: 0xFFAA00FF),
            breathingBallStrokeWidth = prefs.getFloat("breathing_ball_width", 5f),
            showBreathingBall = prefs.getBoolean("show_breathing_ball", true),
            showBreathingBallBackground = prefs.getBoolean("show_breathing_ball_background", true)
        )

        // 加载文字颜色设置
            _isWhiteText.value = prefs.getBoolean("is_white_text", true)  // 修改默认值为true

        if (birthDateMillis != -1L) {
            val birthDate = Instant.ofEpochMilli(birthDateMillis)
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime()
            val endDate = if (endDateMillis != -1L) {
                Instant.ofEpochMilli(endDateMillis)
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime()
            } else {
                // 将默认死亡日期设为生日后一天再加80年，避免与生日重合
                birthDate.plusDays(1).plusYears(80)  // 先加一天再加80年
            }
            _lifeTimeSettings.value = LifeTimeSettings(
                birthDate = birthDate,
                endDate = endDate,
                isCustomEndDate = isCustomEndDate
            )
        }

            // 加载待办事项
            loadTodoItems()

            // 检查是否首次启动
            val isFirstLaunch = prefs.getBoolean("is_first_launch", true)
            var showAgreement by mutableStateOf(isFirstLaunch)

        // 初始化关于页面布局
        aboutPageLayout = FrameLayout(this).apply {
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
            }

            // 注册内部歌词更新广播接收器
            val lyricsFilter = IntentFilter("com.petehsu.yigebaijian.UPDATE_LYRICS")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                registerReceiver(lyricsReceiver, lyricsFilter, Context.RECEIVER_NOT_EXPORTED)
            } else {
                registerReceiver(lyricsReceiver, lyricsFilter)
            }
            Log.d("YiGeBaiJian", "内部歌词更新广播接收器已注册")

            setContent {
                一个摆件Theme {
                    // 将 blurRadius 提升为状态
                    var blurRadius by remember { 
                        mutableStateOf(
                            getSharedPreferences("app_settings", Context.MODE_PRIVATE)
                                .getFloat("blur_radius", 0f)
                        )
                    }
                    
                    // 添加这两行状态声明
                    val showSliderState = remember { mutableStateOf(false) }
                    val showWallpaperDialog = remember { mutableStateOf(false) }

                    Box(modifier = Modifier.fillMaxSize()) {
                        // 1. 底层背景
                        BackgroundLayer(blurRadius)

                        // 2. 主界面内容，添加 onBlurChange 回调
                        MainContent(
                            blurRadius = blurRadius,
                            onBlurChange = { newValue -> 
                                blurRadius = newValue
                            },
                            showSliderState = showSliderState,
                            showWallpaperDialog = showWallpaperDialog
                        )

                        // 显示壁纸选择对话框
                        if (showWallpaperDialog.value) {
                            WallpaperTypeDialog(
                                onDismiss = { showWallpaperDialog.value = false },
                                onSelectNormal = {
                                    showWallpaperDialog.value = false
                                    isSelectingDepthBackground = false
                                    _foregroundUri.value = null
                                    getSharedPreferences("app_settings", Context.MODE_PRIVATE).edit()
                                        .remove("foreground_uri")
                                        .apply()
                                    pickBackground.launch("*/*")  // 允许所有类型
                                },
                                onSelectDepth = {
                                    showWallpaperDialog.value = false
                                    isSelectingDepthBackground = true
                                    onSelectDepth()
                                }
                            )
                        }

                        // 3. 最上层放置所有彩蛋界面
                        Box(modifier = Modifier.fillMaxSize()) {
                            // 特殊彩蛋（生日死亡）
                            AnimatedVisibility(
                                visible = _showSpecialFarewellScreen.value,
                                enter = fadeIn(),
                                exit = fadeOut()
                            ) {
                                SpecialFarewellScreen()
                            }

                            // 生日彩蛋
                            AnimatedVisibility(
                                visible = _showBirthdayScreen.value,
                                enter = fadeIn(),
                                exit = fadeOut()
                            ) {
                                BirthdayScreen()
                            }

                            // 死亡彩蛋
                            AnimatedVisibility(
                                visible = _showFarewellScreen.value,
                                enter = fadeIn(),
                                exit = fadeOut()
                            ) {
                                FarewellScreen()
                            }

                            // 三天光明彩蛋
                            AnimatedVisibility(
                                visible = _showThreeDaysScreen.value,
                                enter = fadeIn(),
                                exit = fadeOut()
                            ) {
                                ThreeDaysScreen()
                            }
                        }

                        // 添加隐私政策对话框
                        if (showAgreement) {
                            val context = LocalContext.current  // 添加这一行获取 context
                            
                            AlertDialog(
                                onDismissRequest = {
                                    showAgreement = false
                                    finish()
                                },
                                title = { Text("用户协议与隐私政策") },
                                text = {
                                    Column {
                                        Text("欢迎使用一个摆件！在使用我们的服务之前，请仔细阅读并同意以下协议：")
                                        Spacer(modifier = Modifier.height(8.dp))

                                        val annotatedString = buildAnnotatedString {
                                            append("点击阅读")
                                            pushStringAnnotation("agreement", "")
                                            withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary, textDecoration = TextDecoration.Underline)) {
                                                append("《用户协议》")
                                            }
                                            pop()
                                            append("和")
                                            pushStringAnnotation("privacy", "")
                                            withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary, textDecoration = TextDecoration.Underline)) {
                                                append("《隐私政策》")
                                            }
                                            pop()
                                        }

                                        ClickableText(
                                            text = annotatedString,
                                            onClick = { offset ->
                                                annotatedString.getStringAnnotations(offset, offset)
                                                    .firstOrNull()?.let { span ->
                                                        when (span.tag) {
                                                            "agreement" -> openUrl(context, "http://www.petehsu.xyz/yigebaijian-legal/user-agreement.html")
                                                            "privacy" -> openUrl(context, "http://www.petehsu.xyz/yigebaijian-legal/privacy-policy.html")
                                                        }
                                                    }
                                            }
                                        )
                                    }
                                },
                                confirmButton = {
                                    Button(onClick = {
                                        showAgreement = false
                                        // 保存首次启动状态
                                        prefs.edit()
                                            .putBoolean("is_first_launch", false)
                                            .apply()
            // 在用户同意后请求权限
            checkAndRequestPermissions()
            setupNotificationWorker()
            loadTodoItems()
            updateTodoNotification()
                                    }) {
                                        Text("同意并继续")
                                    }
                                },
                                dismissButton = {
                                    TextButton(
                                        onClick = {
                                            showAgreement = false
                                            finish()
                                        }
                                    ) {
                                        Text("不同意")
                                    }
                                }
                            )
                        }
                    }
                }
            }
        } catch (e: Exception) {
            Log.e("MainActivity", "Error setting background", e)
        }
            
            // 添加定期检查彩蛋条件
            MainScope().launch {
                while (true) {
                    checkAllConditions()
                    delay(60000) // 每分钟检查一次
                }
            }

            // 添加定期检查纪念日
            MainScope().launch {
                while (true) {
                    createMemorialTodoIfNeeded()  // 检查并创建纪念日待办
                    updateBackgroundForDate()      // 检查并更新特殊日期背景
                    delay(60000) // 每分钟检查一次
                }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // 注销步数监听器
        stepCounterListener?.let {
            sensorManager?.unregisterListener(it)
        }
        if (::musicPlayer.isInitialized) {
            musicPlayer.release()
        }
        mediaPlayer?.release()
        mediaPlayer = null
        threeDaysMediaPlayer?.release()
        threeDaysMediaPlayer = null

        // 注销歌词广播接收器
        try {
            unregisterReceiver(lyricsReceiver)
            Log.d("YiGeBaiJian", "歌词广播接收器已注销")
        } catch (e: Exception) {
            Log.e("YiGeBaiJian", "注销歌词广播接收器失败: ${e.message}")
        }
    }

    private fun loadTodoItems() {
        val prefs = getSharedPreferences("todo_items", Context.MODE_PRIVATE)
        val todoJson = prefs.getString("items", "[]")
        try {
            _todoItems.value = Json.decodeFromString<List<TodoItem>>(todoJson ?: "[]")
        } catch (e: Exception) {
            Log.e("MainActivity", "Error loading todo items", e)
            _todoItems.value = emptyList()
        }
    }

    internal fun saveTodoItems() {
        val prefs = getSharedPreferences("todo_items", Context.MODE_PRIVATE)
        try {
            val todoJson = Json.encodeToString(_todoItems.value)
            prefs.edit().putString("items", todoJson).apply()
            
            // 在主线程中更新通知
            MainScope().launch {
                updateTodoNotification()
                Log.d("TodoItems", "Todo items saved and notification updated")
            }
        } catch (e: Exception) {
            Log.e("TodoItems", "Error saving todo items", e)
        }
    }

    private fun getUriForFile(file: File): Uri {
        return FileProvider.getUriForFile(
            this,
            "${applicationContext.packageName}.provider",
            file
        )
    }

    // 添加前景图片URI状态
    internal var _foregroundUri = mutableStateOf<String?>(null)

    // 添加恢复默认壁纸的函数
    private fun restoreDefaultWallpaper() {
        try {
            val backgroundDir = File(getExternalFilesDir(null), "backgrounds").apply {
                if (!exists()) {
                    mkdirs()
                }
            }

            // 复制默认背景
            val defaultBgFile = File(backgroundDir, "default_background.jpg")
            if (!defaultBgFile.exists()) {
                resources.openRawResource(R.raw.bg).use { input ->
                    defaultBgFile.outputStream().use { output ->
                        input.copyTo(output)
                    }
                }
            }

            // 复制默认前景
            val defaultFgFile = File(backgroundDir, "default_foreground.png")
            if (!defaultFgFile.exists()) {
                resources.openRawResource(R.raw.fg).use { input ->
                    defaultFgFile.outputStream().use { output ->
                        input.copyTo(output)
                    }
                }
            }

            // 更新背景设置
            _backgroundUri.value = defaultBgFile.absolutePath
            _foregroundUri.value = defaultFgFile.absolutePath
            _isBackgroundVideo.value = false

            // 保存设置
            getSharedPreferences("app_settings", Context.MODE_PRIVATE).edit()
                .putString("background_uri", defaultBgFile.absolutePath)
                .putString("foreground_uri", defaultFgFile.absolutePath)
                .putBoolean("is_video", false)
                .putBoolean("is_custom_background", false)
                .apply()

            Log.d("MainActivity", "Successfully restored default wallpaper")
        } catch (e: Exception) {
            Log.e("MainActivity", "Error restoring default wallpaper", e)
        }
    }

    // 修改 WallpaperTypeDialog
    @Composable
    fun WallpaperTypeDialog(
        onDismiss: () -> Unit,
        onSelectNormal: () -> Unit,
        onSelectDepth: () -> Unit
    ) {
        // 在对话框显示前保存当前的前景图状态
        val currentForegroundUri = _foregroundUri.value
        
        AlertDialog(
            onDismissRequest = {
                // 在对话框关闭时恢复前景图状态
                _foregroundUri.value = currentForegroundUri
                onDismiss()
            },
            title = { Text("选择壁纸类型") },
            text = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    TextButton(
                        onClick = {
                            onSelectNormal()
                            // 启动文件选择器，允许选择图片或视频
                            pickBackground.launch("*/*")  // 允许所有类型
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("普通壁纸")
                    }
                    TextButton(
                        onClick = {
                            onSelectDepth()
                            // 如果选择景深壁纸但没有前景图，恢复之前的前景图
                            if (_foregroundUri.value == null) {
                                _foregroundUri.value = currentForegroundUri
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("景深壁纸")
                    }
                    // 添加恢复默认选项
                    TextButton(
                        onClick = {
                            restoreDefaultWallpaper()
                            onDismiss()
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("恢复默认")
                    }
                }
            },
            confirmButton = {},
            dismissButton = {
                TextButton(
                    onClick = {
                        // 在取消时恢复前景图状态
                        _foregroundUri.value = currentForegroundUri
                        onDismiss()
                    }
                ) {
                    Text("取消")
                }
            }
        )
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "待办事项通知"  // 直接使用字符串而不是 getString(R.string.channel_name)
            val descriptionText = "显示待办事项的数量"  // 直接使用字符串而不是 getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun updateTodoNotification() {
        try {
            val currentDate = LocalDateTime.now()
            val today = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            val currentDayOfWeek = currentDate.dayOfWeek.value
            val currentTimeInMinutes = currentDate.hour * 60 + currentDate.minute
            
            // 对待办事项进行分类
            val allTodos = _todoItems.value
            
            // 修改分类逻辑
            val overdueTodos = allTodos.filter { todo ->
                val dueDate = todo.dueDate
                if (dueDate == null || dueDate == today) {
                    // 如果是本周的待办
                    when {
                        // 如果是过去的日期
                        todo.dayOfWeek < currentDayOfWeek -> true
                        // 如果是今天但时间已过
                        todo.dayOfWeek == currentDayOfWeek && 
                        (todo.hour * 60 + todo.minute) < currentTimeInMinutes -> true
                        // 其他情况不算过期
                        else -> false
                    }
                } else {
                    dueDate < today
                }
            }
            
            val todayTodos = allTodos.filter { todo ->
                val dueDate = todo.dueDate
                if (dueDate == null || dueDate == today) {
                    // 如果是今天的待办且时间未到
                    todo.dayOfWeek == currentDayOfWeek && 
                    (todo.hour * 60 + todo.minute) >= currentTimeInMinutes
                } else {
                    dueDate == today
                }
            }
            
            val futureTodos = allTodos.filter { todo ->
                val dueDate = todo.dueDate
                if (dueDate == null || dueDate == today) {
                    // 只有未来日期的才算未来待办
                    todo.dayOfWeek > currentDayOfWeek
                } else {
                    dueDate > today
                }
            }

            Log.d("Notification", "All todos: ${allTodos.size}")
            Log.d("Notification", "Current day: $currentDayOfWeek, Current time: $currentTimeInMinutes")
            Log.d("Notification", "Overdue: ${overdueTodos.size}, Today: ${todayTodos.size}, Future: ${futureTodos.size}")

            // 构建通知内容
            val notificationTitle = "待办事项提醒"
            val notificationText = buildString {
                // 总是显示所有类型的待办数量，即使是0
                append("过期待办：${overdueTodos.size}项\n")
                append("今日待办：${todayTodos.size}项\n")
                append("未来待办：${futureTodos.size}项")
            }.trimEnd()

            val intent = Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            val pendingIntent = PendingIntent.getActivity(
                this, 0, intent,
                PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
            )

            val notification = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle(notificationTitle)
                .setContentText("过期：${overdueTodos.size} 今日：${todayTodos.size} 未来：${futureTodos.size}")
                .setStyle(NotificationCompat.BigTextStyle().bigText(notificationText))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setOngoing(true)  // 设置为持续通知
                .build()

            with(NotificationManagerCompat.from(this)) {
                if (ContextCompat.checkSelfPermission(
                        this@MainActivity,
                        Manifest.permission.POST_NOTIFICATIONS
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    // 只有在有任何待办事项时才显示通知
                    if (allTodos.isNotEmpty()) {
                        notify(NOTIFICATION_ID, notification)
                        Log.d("Notification", "Notification updated: $notificationText")
                    } else {
                        // 如果没有待办事项，取消通知
                        cancel(NOTIFICATION_ID)
                        Log.d("Notification", "Notification cancelled - no todos")
                    }
                } else {
                    Log.d("Notification", "No notification permission")
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        requestPermissionLauncher.launch(
                            arrayOf(Manifest.permission.POST_NOTIFICATIONS)
                        )
                    }
                }
            }
        } catch (e: Exception) {
            Log.e("Notification", "Error updating notification", e)
            e.printStackTrace()
        }
    }

    @Composable
    private fun TodoNotificationObserver() {
        val todoItems = _todoItems.value
        DisposableEffect(todoItems) {
            updateTodoNotification()
            onDispose { }
        }
    }

    @Composable
    private fun NotificationHandler() {
        val todoCount = _todoItems.value.size
        LaunchedEffect(todoCount) {
            updateTodoNotification()
        }
    }

    // 将 setupAboutPage 改为 internal
    internal fun setupAboutPage() {
        // 添加 WaveView 到关于页面的布局中
        val waveView = WaveView(this)
        aboutPageLayout.addView(waveView, 0) // 添加到最底层

        // 设置 WaveView 的布局参数
        waveView.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        )
    }

    // 在生命周期设置发生变化时也进行检查
    internal fun updateLifeTimeSettings(newSettings: LifeTimeSettings) {
        _lifeTimeSettings.value = newSettings
        // 立即检查是否需要触发彩蛋
        val endDate = newSettings.endDate
        if (endDate != null) {
            val now = LocalDateTime.now()
            val remainingHours = ChronoUnit.HOURS.between(now, endDate)
            if (remainingHours <= 72) {
                _showFarewellScreen.value = true
            }
        }
    }

    // 将 FarewellScreen 定义为 MainActivity 的私有 Composable 函数
    @Composable
    internal fun FarewellScreen() {
        var currentMessageIndex by remember { mutableStateOf(0) }
        var showCurrentMessage by remember { mutableStateOf(true) }

        // 使用 DisposableEffect 来控制音乐播放
        DisposableEffect(Unit) {
            startFarewellMusic()
            onDispose {
                stopFarewellMusic()
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ) {
            AnimatedVisibility(
                visible = showCurrentMessage,
                enter = fadeIn(
                    animationSpec = tween(1000, easing = LinearEasing)
                ),
                exit = fadeOut(
                    animationSpec = tween(1000, easing = LinearEasing)
                )
            ) {
                if (currentMessageIndex < farewellMessages.size) {
                    Text(
                        text = farewellMessages[currentMessageIndex].text,
                        color = Color.White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 32.dp)
                    )
                }
            }
        }

        LaunchedEffect(currentMessageIndex) {
            if (currentMessageIndex < farewellMessages.size) {
                showCurrentMessage = true
                delay(farewellMessages[currentMessageIndex].delay)
                if (currentMessageIndex < farewellMessages.size - 1) {
                    showCurrentMessage = false
                    delay(1000)
                    currentMessageIndex++
                }
            }
        }
    }

    // 添加音频播放器变量
    private var farewellMediaPlayer: MediaPlayer? = null

    // 添加音频播放控制函数
    private fun startFarewellMusic() {
        farewellMediaPlayer?.release()
        farewellMediaPlayer = MediaPlayer.create(this, R.raw.sw).apply {
            isLooping = false
            setVolume(0.5f, 0.5f)
            start()
        }
    }

    private fun stopFarewellMusic() {
        farewellMediaPlayer?.apply {
            if (isPlaying) {
                stop()
            }
            release()
        }
        farewellMediaPlayer = null
    }

    // 添加生日音频播放控制函数
    internal fun startBirthdayMusic() {
        birthdayMediaPlayer?.release()
        birthdayMediaPlayer = MediaPlayer.create(this, R.raw.sr).apply {
            isLooping = false
            setVolume(1f, 1f)  // 从0.5f改为1f，设置为100%音量
            start()
        }
    }

    // 添加生日音频播放控制函数
    internal fun stopBirthdayMusic() {
        birthdayMediaPlayer?.apply {
            if (isPlaying) {
                stop()
            }
            release()
        }
        birthdayMediaPlayer = null
    }

    // 修改 checkThreeDays 函数
    internal fun checkThreeDays() {
        if (_showSpecialFarewellScreen.value) return
        val prefs = getSharedPreferences("app_settings", Context.MODE_PRIVATE)
        // 从 SharedPreferences 中读取状态
        val hasShownThreeDays = prefs.getBoolean("has_shown_three_days", false)
        
        // 如果已经显示过，直接返回
        if (hasShownThreeDays) {
            return
        }

        val currentDate = LocalDateTime.now()
        val endDate = _lifeTimeSettings.value.endDate
        if (endDate != null) {
            val remainingDays = ChronoUnit.DAYS.between(currentDate, endDate)
            if (remainingDays <= 3L && remainingDays > 0L) {
                _showThreeDaysScreen.value = true
                // 将状态保存到 SharedPreferences
                prefs.edit()
                    .putBoolean("has_shown_three_days", true)
                    .apply()
            }
        }
    }

    // 添加三天光明彩蛋状态和相关变量
    internal var threeDaysMediaPlayer: MediaPlayer? = null

    // 添加音频播放控制函数
    internal fun startThreeDaysMusic() {
        threeDaysMediaPlayer?.release()
        threeDaysMediaPlayer = MediaPlayer.create(this, R.raw.st).apply {
            isLooping = false
            setVolume(1f, 1f)
            start()
        }
    }

    internal fun stopThreeDaysMusic() {
        threeDaysMediaPlayer?.apply {
            if (isPlaying) {
                stop()
            }
            release()
        }
        threeDaysMediaPlayer = null
    }

    // 在 MainActivity 类中添加检查是否是国家公祭日的函数
    internal fun isNationalMemorialDay(date: LocalDateTime): Boolean {
        return date.monthValue == 12 && date.dayOfMonth == 13
    }

    // 在 MainActivity 类中修改 createMemorialTodoIfNeeded 函数
    private fun createMemorialTodoIfNeeded() {
        val now = LocalDateTime.now()
        val today = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
        
        // 获取当前待办列表
        val currentTodos = _todoItems.value.toMutableList()
        
        // 根据不同日期设置不同的默哀内容
        val memorialContent = when {
            now.monthValue == 12 && now.dayOfMonth == 13 ->
                "为因南京大屠杀而死难的几十万同胞默哀"
            now.monthValue == 4 && now.dayOfMonth in 4..6 ->
                "清明节 - 缅怀先烈，铭记历史"
            now.monthValue == 9 && now.dayOfMonth == 30 ->
                "烈士纪念日 - 缅怀革命先烈"
            now.monthValue == 9 && now.dayOfMonth == 3 ->
                "中国人民抗日战争胜利纪念日 - 铭记历史，珍爱和平"
            now.monthValue == 7 && now.dayOfMonth == 28 ->
                "唐山大地震47周年 - 愿逝者安息，愿生者坚强"
            now.monthValue == 5 && now.dayOfMonth == 12 ->
                "汶川地震15周年 - 缅怀同胞，铭记历史"
            else -> null
        }

        // 如果是特殊纪念日且还没有添加相应待办
        if (memorialContent != null) {
            val memorialTodoExists = currentTodos.any { todo ->
                todo.content == memorialContent && todo.dueDate == today
            }

            if (!memorialTodoExists) {
                // 创建新的待办
                val memorialTodo = TodoItem(
                    content = memorialContent,
                    dayOfWeek = now.dayOfWeek.value,
                    hour = now.hour,
                    minute = now.minute,
                    dueDate = today
                )
                
                // 添加到待办列表开头
                currentTodos.add(0, memorialTodo)
                
                // 更新待办列表
                _todoItems.value = currentTodos
                saveTodoItems()
                
                // 立即更新通知
                updateTodoNotification()
                
                Log.d("MainActivity", "Created memorial todo: $memorialContent")
            }
        }
    }

    // 在 MainActivity 类中添加检查是否是特殊纪念日的函数
    internal fun isSpecialMemorialDay(date: LocalDateTime): Boolean {
        return when {
            // 南京大屠杀死难者国家公祭日 - 12月13日
            date.monthValue == 12 && date.dayOfMonth == 13 -> true
            // 清明节 - 农历清明节
            date.monthValue == 4 && date.dayOfMonth in 4..6 -> true  // 大约在4月4-6日
            // 烈士纪念日 - 9月30日
            date.monthValue == 9 && date.dayOfMonth == 30 -> true
            // 中国人民抗日战争胜利纪念日 - 9月3日
            date.monthValue == 9 && date.dayOfMonth == 3 -> true
            // 日本签署投降书日 - 9月2日
            date.monthValue == 9 && date.dayOfMonth == 2 -> true
            // 日本宣布无条件投降日 - 8月15日
            date.monthValue == 8 && date.dayOfMonth == 15 -> true
            // 唐山大地震纪念日 - 7月28日
            date.monthValue == 7 && date.dayOfMonth == 28 -> true
            // 汶川地震纪念日 - 5月12日
            date.monthValue == 5 && date.dayOfMonth == 12 -> true
            else -> false
        }
    }

    // 添加特殊彩蛋消息列表
    internal val specialFarewellMessages = listOf(
        SpecialFarewellMessage("最后一根火柴划亮的时候", 3000),
        SpecialFarewellMessage("你发现", 1000),
        SpecialFarewellMessage("整个星空都是火柴盒", 3000),
        SpecialFarewellMessage("雨季存了太多未读信件", 3000),
        SpecialFarewellMessage("萤火虫会加班派送", 3000),
        SpecialFarewellMessage("没吃完的蛋糕", 2000),
        SpecialFarewellMessage("别担心", 1000),
        SpecialFarewellMessage("候鸟会衔去明年发芽", 2000),
        SpecialFarewellMessage("走散了", 1000),
        SpecialFarewellMessage("就吹声口哨", 1000),
        SpecialFarewellMessage("银河便利店全年无休", 0)  // 最后一条消息永久显示
    )

    // 添加特殊彩蛋状态
    internal val _showSpecialFarewellScreen = mutableStateOf(false)
    internal val showSpecialFarewellScreen: State<Boolean> = _showSpecialFarewellScreen

    // 添加特殊彩蛋音频播放器
    internal var specialFarewellMediaPlayer: MediaPlayer? = null


    // 添加音频控制函数
    internal fun startSpecialFarewellMusic() {
        specialFarewellMediaPlayer = MediaPlayer.create(this, R.raw.srsw)
        specialFarewellMediaPlayer?.start()
    }

    internal fun stopSpecialFarewellMusic() {
        specialFarewellMediaPlayer?.apply {
            if (isPlaying) {
                stop()
            }
            release()
        }
        specialFarewellMediaPlayer = null
    }

    // 修改检查逻辑的顺序，明确声明返回类型
    internal fun checkAllConditions(): Unit {
        Log.d("CheckConditions", "Starting condition checks...")

        // 如果已经在显示任何彩蛋，就不要再检查了
        if (_showSpecialFarewellScreen.value || _showBirthdayScreen.value || 
            _showFarewellScreen.value || _showThreeDaysScreen.value) {
            return
        }

        val currentDate = LocalDateTime.now()
        val birthDate = _lifeTimeSettings.value.birthDate
        val endDate = _lifeTimeSettings.value.endDate

        Log.d("CheckConditions", "Current Date: $currentDate")
        Log.d("CheckConditions", "Birth Date: $birthDate")
        Log.d("CheckConditions", "End Date: $endDate")

        if (birthDate != null && endDate != null) {
            // 检查月份和日期是否匹配
            val isBirthDay = currentDate.monthValue == birthDate.monthValue && 
                            currentDate.dayOfMonth == birthDate.dayOfMonth
            
            val isDeathDay = currentDate.monthValue == endDate.monthValue && 
                            currentDate.dayOfMonth == endDate.dayOfMonth

            // 获取今天的日期字符串，格式如：2024-03-21
            val today = currentDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            
            // 从 SharedPreferences 中读取状态
            val prefs = getSharedPreferences("app_settings", Context.MODE_PRIVATE)
            val lastShownBirthday = prefs.getString("last_shown_birthday", "")

            // 如果是生日
            if (isBirthDay) {
                // 如果同时是死亡日期且是用户自定义的，并且是同一年，触发特殊彩蛋
                if (isDeathDay && _lifeTimeSettings.value.isCustomEndDate && 
                    currentDate.year == endDate.year) {
                    Log.d("CheckConditions", "Triggering special farewell screen")
                    _showSpecialFarewellScreen.value = true
                    startSpecialFarewellMusic()
                } else if (lastShownBirthday != today) {
                    // 如果今天还没有显示过生日彩蛋，则显示
                    Log.d("CheckConditions", "Triggering birthday screen")
                    _showBirthdayScreen.value = true
                    // 保存今天的日期
                    prefs.edit()
                        .putString("last_shown_birthday", today)
                        .apply()
                }
                return
            }

            // 如果只是死亡日期且是用户自定义的
            if (isDeathDay && _lifeTimeSettings.value.isCustomEndDate && 
                currentDate.year == endDate.year) {
                Log.d("CheckConditions", "Triggering farewell screen")
                _showFarewellScreen.value = true
                return
            }

            // 检查是否还剩三天
            val remainingHours = ChronoUnit.HOURS.between(currentDate, endDate)
            if (remainingHours <= 72 && remainingHours > 0) {  // 添加 remainingHours > 0 的条件
                Log.d("CheckConditions", "Triggering three days screen")
                _showThreeDaysScreen.value = true
                return
            }
        }
    }

    // 删除或注释掉 checkEndDate 函数中的检查逻辑
    internal fun checkEndDate() {
        // 不再单独检查死亡日期
        return
    }

    // 添加背景层 Composable
    @Composable
    private fun BackgroundLayer(blurRadius: Float) {
        // 添加调试日志
        LaunchedEffect(blurRadius) {
            Log.d("BlurDebug", "BackgroundLayer blur radius: $blurRadius, Android version: ${Build.VERSION.SDK_INT}")
        }
        
        Box(
            modifier = Modifier
                .fillMaxSize()
                .let { modifier ->
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                        // Android 12+ 支持原生模糊
                        modifier.blur(blurRadius.dp)
                    } else {
                        // Android 12以下版本，使用alpha效果模拟模糊
                        modifier.alpha(if (blurRadius > 0) 0.7f else 1f)
                    }
                }
        ) {
            _backgroundUri.value?.let { uriString ->
                if (_isBackgroundVideo.value) {
                    // 视频背景
                    AndroidView(
                        factory = { context ->
                            VideoView(context).apply {
                                layoutParams = FrameLayout.LayoutParams(
                                    FrameLayout.LayoutParams.MATCH_PARENT,
                                    FrameLayout.LayoutParams.MATCH_PARENT,
                                    Gravity.CENTER
                                )
                                setVideoURI(Uri.parse(uriString))
                                setOnPreparedListener { mp ->
                                    mp.isLooping = true // 循环播放
                                    // 设置视频缩放模式
                                    val videoRatio = mp.videoWidth.toFloat() / mp.videoHeight.toFloat()
                                    val screenRatio = context.resources.displayMetrics.widthPixels.toFloat() / 
                                                    context.resources.displayMetrics.heightPixels.toFloat()
                                    
                                    val scale = if (videoRatio > screenRatio) {
                                        context.resources.displayMetrics.heightPixels.toFloat() * videoRatio / 
                                        context.resources.displayMetrics.widthPixels.toFloat()
                                    } else {
                                        context.resources.displayMetrics.widthPixels.toFloat() / 
                                        (context.resources.displayMetrics.heightPixels.toFloat() * videoRatio)
                                    }
                                    
                                    scaleX = scale
                                    scaleY = scale
                                }
                                start()
                            }
                        },
                        modifier = Modifier.fillMaxSize()
                    )
                } else {
                    // 图片背景
                    AsyncImage(
                        model = uriString,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }

    // 添加主界面内容 Composable
    @Composable
    private fun MainContent(
        blurRadius: Float,
        onBlurChange: (Float) -> Unit,
        showSliderState: MutableState<Boolean>,
        showWallpaperDialog: MutableState<Boolean>
    ) {
        val context = LocalContext.current

        Box(modifier = Modifier.fillMaxSize()) {
            // 主界面内容
            MainScreen(
                musicPlayer = if (::musicPlayer.isInitialized) musicPlayer else null,
                onDoubleTap = {
                    if (!_showMinimalUI.value && !_showAboutScreen.value && !_showYearProgress.value &&
                        !_showLifeProgress.value && !_showHourglassProgress.value && !_showPendulumBallPanel.value && !_showTodoList.value) {
                        showSliderState.value = !showSliderState.value
                        sliderVisibilityJob?.cancel()
                        if (showSliderState.value) {
                            sliderVisibilityJob = MainScope().launch {
                                delay(3000)
                                showSliderState.value = false
                            }
                        }
                    }
                },
                onLongPress = { showWallpaperDialog.value = true }
            )

            // 前景层 - 使用透明度动画优化显示效果
            val foregroundAlpha by animateFloatAsState(
                targetValue = if (!_showMinimalUI.value && !_showAboutScreen.value &&
                    !_showYearProgress.value && !_showLifeProgress.value &&
                    !_showHourglassProgress.value && !_showPendulumBallPanel.value &&
                    !_showTodoList.value && !_showFarewellScreen.value &&
                    !_showBirthdayScreen.value && !_showThreeDaysScreen.value &&
                    !_showSpecialFarewellScreen.value) 1f else 0f,
                animationSpec = tween(durationMillis = 300),
                label = "foreground alpha"
            )
            
            _foregroundUri.value?.let { uriString ->
                AsyncImage(
                    model = uriString,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .alpha(foregroundAlpha)
                        .zIndex(1f), // 设置较低层级确保其他界面在上方
                    contentScale = ContentScale.Crop
                )
            }

            // 模糊度滑条
            AnimatedVisibility(
                visible = showSliderState.value,
                enter = fadeIn() + slideInVertically { it },
                exit = fadeOut() + slideOutVertically { it },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 32.dp)
                    .zIndex(10f) // 设置最高层级，确保不被前景图挡住
            ) {
                Card(
                    modifier = Modifier.padding(16.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.9f)
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "模糊度：${blurRadius.toInt()}",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        
                        // 添加版本兼容性提示
                        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
                            Text(
                                text = "非常抱歉，您当前的Android版本暂不支持模糊效果，我们为您提供了透明度调节作为替代方案",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                        }
                        Slider(
                            value = blurRadius,
                            onValueChange = { newValue ->
                                Log.d("BlurDebug", "Slider value changed to: $newValue")
                                onBlurChange(newValue)
                                context.getSharedPreferences("app_settings", Context.MODE_PRIVATE)
                                    .edit()
                                    .putFloat("blur_radius", newValue)
                                    .apply()
                            },
                            valueRange = 0f..100f,
                            modifier = Modifier.width(300.dp)
                        )
                    }
                }
            }
        }
    }

    // 在 MainActivity 类中添加
    private fun setupNotificationWorker() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.NOT_REQUIRED)
            .build()

        val notificationWorkRequest = PeriodicWorkRequestBuilder<NotificationWorker>(
            15, TimeUnit.MINUTES,  // 每15分钟检查一次
            5, TimeUnit.MINUTES    // 灵活间隔
        )
        .setConstraints(constraints)
        .build()

        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "notification_work",
            ExistingPeriodicWorkPolicy.KEEP,
            notificationWorkRequest
        )
    }

    // 添加获取文件扩展名的函数
    private fun getFileExtension(uri: Uri): String {
        val contentResolver = applicationContext.contentResolver
        val mimeTypeMap = MimeTypeMap.getSingleton()
        
        // 首先尝试从 ContentResolver 获取 MIME 类型
        val mimeType = contentResolver.getType(uri)
        
        return if (mimeType != null) {
            // 从 MIME 类型获取扩展名
            mimeTypeMap.getExtensionFromMimeType(mimeType) ?: "jpg"
        } else {
            // 如果无法获取 MIME 类型，从 URI 路径获取扩展名
            val path = uri.path
            if (path != null && path.lastIndexOf('.') != -1) {
                path.substring(path.lastIndexOf('.') + 1).lowercase()
            } else {
                // 默认使用 jpg 扩展名
                "jpg"
            }
        }
    }
}

@Composable
fun MainScreen(
    musicPlayer: MusicPlayer?,
    onDoubleTap: () -> Unit = {},
    onLongPress: () -> Unit = {}
) {
    val mainActivity = LocalContext.current as MainActivity
    val timeSettings = mainActivity._timeSettings.value
    val textColor = if (mainActivity._isWhiteText.value) Color.White else Color.Black
    val showTodoList = mainActivity._showTodoList.value
    val showYearProgress = mainActivity._showYearProgress.value
    val showLifeProgress = mainActivity._showLifeProgress.value
    val showMinimalUI = mainActivity._showMinimalUI.value
    val yearProgressSettings = mainActivity._yearProgressDisplaySettings.value
    var showDisplaySettings by remember { mutableStateOf(false) }
    val showHourglassProgress = mainActivity._showHourglassProgress.value
    val showLifeGridProgress = mainActivity._showPendulumBallPanel.value
    val showAboutScreen = mainActivity._showAboutScreen.value

    // 使用全局一言状态
    val hitokoto = mainActivity._hitokoto.value
    var from by remember { mutableStateOf("") }

    // 获取一言
    LaunchedEffect(Unit) {
        try {
            withContext(Dispatchers.IO) {
                val response = URL("https://v1.hitokoto.cn/?c=i&encode=json").readText()
                val json = Json { ignoreUnknownKeys = true }
                val data = json.decodeFromString<HitokotoResponse>(response)

                // 同时更新原始一言和当前显示的一言
                mainActivity._originalHitokoto.value = data.hitokoto
                mainActivity._hitokoto.value = data.hitokoto
                from = data.from

                Log.d("YiGeBaiJian", "获取一言成功: ${data.hitokoto}")
            }
        } catch (e: Exception) {
            val defaultHitokoto = "生命的意义不仅是活着，而是我们给予生命的意义。"
            mainActivity._originalHitokoto.value = defaultHitokoto
            mainActivity._hitokoto.value = defaultHitokoto
            from = "一个摆件"
            Log.e("YiGeBaiJian", "获取一言失败，使用默认一言: ${e.message}")
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        // 主界面内容
        Box(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures(
                        onDoubleTap = { onDoubleTap() },  // 使用传入的onDoubleTap参数
                        onLongPress = { onLongPress() }
                    )
                }
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        if (kotlin.math.abs(dragAmount.y) > kotlin.math.abs(dragAmount.x)) {
                            // 垂直滑动
                            if (dragAmount.y > 10) {  // 下滑打开极简界面
                                mainActivity._showMinimalUI.value = true
                            } else if (dragAmount.y < -10) {  // 上滑打开年度进度
                                mainActivity._showYearProgress.value = true
                            }
                        } else {
                            // 水平滑动
                            if (dragAmount.x > 10) {  // 右滑打开待办
                                mainActivity._showTodoList.value = true
                            }
                        }
                    }
                }
        ) {
            if (timeSettings.isCentered) {
                // 居中模式：只显示时间和一言
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    TimeDisplay(
                        modifier = Modifier.fillMaxWidth(),
                        isPlaying = musicPlayer?.isPlaying?.value ?: false,
                        songList = emptyList(),  // 居中模式不显示歌单
                        currentSong = null,
                        onSongClick = { },
                        showEmptyMessage = false,
                        textColor = textColor,
                        showRemainingTime = false  // 不显示剩余时间框
                    )
                }

                // 一言显示（保持在底部）
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(16.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.End
                    ) {
                        if (musicPlayer?.isPlaying?.value == true && musicPlayer.currentLyric?.value != null) {
                            Text(
                                text = musicPlayer.currentLyric?.value ?: "",
                                color = textColor.copy(alpha = 0.8f),
                                fontSize = 14.sp,
                                textAlign = TextAlign.End
                            )
                        } else {
                            Text(
                                text = hitokoto,
                                color = textColor.copy(alpha = 0.8f),
                                fontSize = 14.sp,
                                textAlign = TextAlign.End,
                                modifier = Modifier.padding(bottom = 2.dp)
                            )
                            Text(
                                text = "—— $from",
                                color = textColor.copy(alpha = 0.6f),
                                fontSize = 12.sp,
                                textAlign = TextAlign.End
                            )
                        }
                    }
                }
            } else {
                // 原有的完整布局
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // 左侧时间显示
                    TimeDisplay(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .padding(16.dp),
                        isPlaying = musicPlayer?.isPlaying?.value ?: false,
                        songList = musicPlayer?.getSongList() ?: emptyList(),
                        currentSong = musicPlayer?.currentSongName?.value,
                        onSongClick = { songName ->
                            musicPlayer?.playByName(songName)
                        },
                        showEmptyMessage = musicPlayer == null,
                        textColor = textColor,
                        showRemainingTime = true  // 显示剩余时间框
                    )

                    // 右侧圆环和呼吸球
                    CircleProgressSection(
                        modifier = Modifier
                            .width(240.dp)
                            .fillMaxHeight()
                            .padding(end = 16.dp),
                        onBreathingBallClick = { musicPlayer?.togglePlayPause() },
                        musicPlayer = musicPlayer,
                        textColor = textColor
                    )
                }

                // 一言显示
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(16.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.End
                    ) {
                        if (musicPlayer?.isPlaying?.value == true && musicPlayer.currentLyric?.value != null) {
                            Text(
                                text = musicPlayer.currentLyric?.value ?: "",
                                color = textColor.copy(alpha = 0.8f),
                                fontSize = 14.sp,
                                textAlign = TextAlign.End
                            )
                        } else {
                            Text(
                                text = hitokoto,
                                color = textColor.copy(alpha = 0.8f),
                                fontSize = 14.sp,
                                textAlign = TextAlign.End,
                                modifier = Modifier.padding(bottom = 2.dp)
                            )
                            Text(
                                text = "—— $from",
                                color = textColor.copy(alpha = 0.6f),
                                fontSize = 12.sp,
                                textAlign = TextAlign.End
                            )
                        }
                    }
                }
            }
        }

        // 极简界面（带动画）
        AnimatedVisibility(
            visible = showMinimalUI && !showTodoList,
            enter = slideInVertically(initialOffsetY = { -it }),  // 从上往下滑入
            exit = slideOutVertically(targetOffsetY = { -it })    // 向上滑出
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.White
            ) {
                MinimalUI(
                    modifier = Modifier.fillMaxSize(),
                    textColor = textColor,
                    onClose = { mainActivity._showMinimalUI.value = false }
                )
            }
        }

        // 年度进度页面（带动画）
        AnimatedVisibility(
            visible = showYearProgress && !showTodoList,
            enter = slideInVertically(initialOffsetY = { it }),
            exit = slideOutVertically(targetOffsetY = { it })
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.Transparent
            ) {
                YearProgressPanel(
                    modifier = Modifier.fillMaxSize(),
                    textColor = textColor
                )
            }
        }

        // 人生进度页面（带动画）
        AnimatedVisibility(
            visible = showLifeProgress && !showTodoList,
            enter = slideInHorizontally(initialOffsetX = { it }),
            exit = slideOutHorizontally(targetOffsetX = { it })
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.Transparent
            ) {
                LifeProgressPanel(
                    modifier = Modifier.fillMaxSize(),
                    textColor = textColor,
                    lifeTimeSettings = mainActivity._lifeTimeSettings.value
                )
            }
        }

        // 待办事项侧边栏
        AnimatedVisibility(
            visible = showTodoList,
            enter = slideInHorizontally(initialOffsetX = { -it }),
            exit = slideOutHorizontally(targetOffsetX = { -it })
        ) {
            TodoListPanel(
                modifier = Modifier
                    .width(400.dp)
                    .fillMaxHeight(),
                onClose = { mainActivity._showTodoList.value = false },
                textColor = Color.Black
            )
        }

        // 沙漏进度页面（带动画）
        AnimatedVisibility(
            visible = showHourglassProgress && !showTodoList,
            enter = slideInHorizontally(initialOffsetX = { it }),  // 从右往左滑入
            exit = slideOutHorizontally(targetOffsetX = { it })    // 向右滑出
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.Transparent
            ) {
                GridProgressPanel(
                    modifier = Modifier.fillMaxSize(),
                    textColor = textColor
                )
            }
        }

        // 添加人生进度格子界面
        AnimatedVisibility(
            visible = showLifeGridProgress && !showTodoList,
            enter = slideInHorizontally(initialOffsetX = { it }),  // 从右往左滑入
            exit = slideOutHorizontally(targetOffsetX = { it })    // 向右滑出
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.Transparent
            ) {
                LifeGridProgressPanel(
                    modifier = Modifier.fillMaxSize(),
                    textColor = textColor
                )
            }
        }

        // 添加关于页面
        AnimatedVisibility(
            visible = showAboutScreen,
            enter = slideInVertically(initialOffsetY = { -it }),  // 从上往下滑入
            exit = slideOutVertically(targetOffsetY = { -it })    // 向上滑出
        ) {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.surface
            ) {
                AboutScreen(
                    modifier = Modifier.fillMaxSize(),
                    onClose = { mainActivity._showAboutScreen.value = false }
                )
            }
        }
    }

    // 添加极简时钟界面
    AnimatedVisibility(
        visible = mainActivity._showMinimalClockUI.value,
        enter = slideInHorizontally(initialOffsetX = { it }),
        exit = slideOutHorizontally(targetOffsetX = { it })
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black
        ) {
            MinimalClockUI(
                modifier = Modifier.fillMaxSize(),
                onClose = { mainActivity._showMinimalClockUI.value = false }
            )
        }
    }

    // 添加新的极简界面3
    AnimatedVisibility(
        visible = mainActivity._showMinimalClockUI2.value,
        enter = slideInHorizontally(initialOffsetX = { it }),
        exit = slideOutHorizontally(targetOffsetX = { it })
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black
        ) {
            MinimalClockUI2(
                modifier = Modifier.fillMaxSize(),
                onClose = { mainActivity._showMinimalClockUI2.value = false }
            )
        }
    }

    // 添加新的极简界面4
    AnimatedVisibility(
        visible = mainActivity._showMinimalClockUI3.value,
        enter = slideInHorizontally(initialOffsetX = { it }),
        exit = slideOutHorizontally(targetOffsetX = { it })
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black
        ) {
            MinimalClockUI3(
                modifier = Modifier.fillMaxSize(),
                onClose = { mainActivity._showMinimalClockUI3.value = false }
            )
        }
    }

    // 添加生日彩蛋界面包装器
    AnimatedVisibility(
        visible = mainActivity._showBirthdayScreen.value,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        BirthdayScreenWrapper(mainActivity)
    }

    // 添加三天光明彩蛋界面包装器
    AnimatedVisibility(
        visible = mainActivity._showThreeDaysScreen.value,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        ThreeDaysScreenWrapper(mainActivity)
    }

    // 添加特殊彩蛋界面包装器
    SpecialFarewellScreenWrapper(mainActivity)
}

@Composable
private fun FarewellScreenWrapper(mainActivity: MainActivity) {
    Box(modifier = Modifier.fillMaxSize()) {
        if (mainActivity._showFarewellScreen.value) {
            mainActivity.FarewellScreen()
        }
    }
}

@Composable
fun TimeDisplay(
    modifier: Modifier = Modifier,
    isPlaying: Boolean,
    songList: List<String>,
    currentSong: String?,
    onSongClick: (String) -> Unit,
    showEmptyMessage: Boolean,
    textColor: Color,
    showRemainingTime: Boolean = true  // 添加新参数
) {
    val currentTime = remember { mutableStateOf(LocalDateTime.now()) }
    var showSongList by remember { mutableStateOf(false) }
    var lastInteractionTime by remember { mutableStateOf(0L) }
    var showSettings by remember { mutableStateOf(false) }
    val mainActivity = LocalContext.current as MainActivity
    val timeSettings = mainActivity._timeSettings.value

    // 用于控制时间透明度的动画
    var timeAlpha by remember { mutableStateOf(0f) }
    val animatedAlpha by animateFloatAsState(
        targetValue = timeAlpha,
        animationSpec = tween(durationMillis = 5000, easing = FastOutSlowInEasing)  // 将动画时长从3000毫秒增加到5000毫秒，并添加缓动效果
    )

    LaunchedEffect(timeSettings.alpha) {
        // 每次透明度设置变化时，更新动画目标值
        timeAlpha = timeSettings.alpha
    }

    val remainingDays by remember(currentTime.value) {
        derivedStateOf {
            calculateRemainingDaysInYear(currentTime.value)
        }
    }

    val remainingMinutes by remember(currentTime.value) {
        derivedStateOf {
            calculateRemainingMinutesInDay(currentTime.value)
        }
    }

    val formattedTime by remember(currentTime.value, timeSettings) {
        derivedStateOf {
            val pattern = buildString {
                append(if (timeSettings.use24Hour) "HH:mm" else "hh:mm a")
                if (timeSettings.showSeconds) append(":ss")
                if (timeSettings.showMillis) append(".SSS")
            }
            if (timeSettings.showMillis) {
                val millis = System.currentTimeMillis()
                val dateTime = java.time.Instant.ofEpochMilli(millis)
                    .atZone(java.time.ZoneId.systemDefault())
                    .toLocalDateTime()
                dateTime.format(DateTimeFormatter.ofPattern(pattern))
            } else {
                currentTime.value.format(DateTimeFormatter.ofPattern(pattern))
            }
        }
    }

    LaunchedEffect(Unit) {
        while (true) {
            currentTime.value = LocalDateTime.now()
            delay(if (timeSettings.showMillis) 16 else 1000)
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    if (kotlin.math.abs(dragAmount.y) > kotlin.math.abs(dragAmount.x)) {
                        // 垂直滑动
                        if (dragAmount.y > 10) {  // 下滑打开极简界面
                            mainActivity._showMinimalUI.value = true
                        } else if (dragAmount.y < -10) {  // 上滑打开年度进度
                            mainActivity._showYearProgress.value = true
                        }
                    } else {
                        // 水平滑动
                        if (dragAmount.x > 10) {  // 右滑打开待办
                            mainActivity._showTodoList.value = true
                        }
                    }
                }
            }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            // 根据 isCentered 设置水平对齐方式
            horizontalAlignment = if (timeSettings.isCentered) Alignment.CenterHorizontally else Alignment.Start
        ) {
            if (timeSettings.isTimeOnTop) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    // 根据 isCentered 设置内容对齐方式
                    contentAlignment = if (timeSettings.isCentered) Alignment.Center else Alignment.CenterStart
                ) {
                    Text(
                        text = formattedTime,
                        style = MaterialTheme.typography.displayLarge.copy(
                            fontSize = timeSettings.fontSize.sp,
                            fontWeight = FontWeight(timeSettings.fontWeight)
                        ),
                        color = Color(timeSettings.timeColor).copy(alpha = animatedAlpha),
                        modifier = Modifier
                            .padding(if (timeSettings.isCentered) 0.dp else 16.dp)  // 居中时移除左边距
                            .pointerInput(Unit) {
                                detectTapGestures(
                                    onTap = {
                                        mainActivity._isWhiteText.value = !mainActivity._isWhiteText.value
                                        mainActivity.getSharedPreferences("app_settings", Context.MODE_PRIVATE)
                                            .edit()
                                            .putBoolean("is_white_text", mainActivity._isWhiteText.value)
                                            .apply()
                                    },
                                    onLongPress = { showSettings = true }
                                )
                            }
                    )
                }
            }

            // 只在非居中模式下显示剩余时间框
            if (showRemainingTime) {
                Surface(
                    modifier = Modifier
                        .noRippleClickable {
                            showSongList = !showSongList
                            lastInteractionTime = System.currentTimeMillis()
                        }
                        .border(
                            width = 1.dp,
                            color = textColor.copy(alpha = 0.8f),
                            shape = MaterialTheme.shapes.medium
                        )
                        .requiredHeight(150.dp)
                        // 移除 fillMaxWidth，改用 wrapContentWidth
                        .wrapContentWidth()
                        .padding(horizontal = if (timeSettings.isCentered) 0.dp else 16.dp),
                    color = Color.Transparent,
                    shape = MaterialTheme.shapes.medium,
                    tonalElevation = 0.dp
                ) {
                    if (showSongList) {
                        SongListContent(
                            showEmptyMessage = showEmptyMessage,
                            songList = songList,
                            currentSong = currentSong,
                            onSongClick = { song ->
                                onSongClick(song)
                                lastInteractionTime = System.currentTimeMillis()
                            },
                            textColor = textColor
                        )
                    } else {
                        RemainingTimeContent(
                            remainingDays = remainingDays,
                            remainingMinutes = remainingMinutes,
                            textColor = textColor,
                            isTimeOnTop = timeSettings.isTimeOnTop
                        )
                    }
                }
            }

            if (!timeSettings.isTimeOnTop) {
                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = if (timeSettings.isCentered) Alignment.Center else Alignment.CenterStart
                ) {
                    Text(
                        text = formattedTime,
                        style = MaterialTheme.typography.displayLarge.copy(
                            fontSize = timeSettings.fontSize.sp,
                            fontWeight = FontWeight(timeSettings.fontWeight)
                        ),
                        color = Color(timeSettings.timeColor).copy(alpha = animatedAlpha),
                        modifier = Modifier
                            .padding(if (timeSettings.isCentered) 0.dp else 16.dp)  // 居中时移除左边距
                            .pointerInput(Unit) {
                                detectTapGestures(
                                    onTap = {
                                        mainActivity._isWhiteText.value = !mainActivity._isWhiteText.value
                                        mainActivity.getSharedPreferences("app_settings", Context.MODE_PRIVATE)
                                            .edit()
                                            .putBoolean("is_white_text", mainActivity._isWhiteText.value)
                                            .apply()
                                    },
                                    onLongPress = { showSettings = true }
                                )
                            }
                    )
                }
            }
        }
    }

    if (showSettings) {
        TimeSettingsDialog(
            settings = timeSettings,
            onSettingsChange = { newSettings ->
                mainActivity._timeSettings.value = newSettings
                mainActivity.getSharedPreferences("app_settings", Context.MODE_PRIVATE)
                    .edit()
                    .putFloat("time_alpha", newSettings.alpha)
                    .putFloat("time_font_size", newSettings.fontSize)
                    .putInt("time_font_weight", newSettings.fontWeight)
                    .putBoolean("time_show_seconds", newSettings.showSeconds)
                    .putBoolean("time_show_millis", newSettings.showMillis)
                    .putBoolean("time_use_24_hour", newSettings.use24Hour)
                    .putBoolean("time_is_on_top", newSettings.isTimeOnTop)
                    .putBoolean("time_is_centered", newSettings.isCentered)
                    .putBoolean("keep_screen_on", newSettings.keepScreenOn)
                    .putLong("time_color", newSettings.timeColor)  // 添加时间颜色保存
                    .apply()
            },
            onDismiss = { showSettings = false }
        )
    }
}

@Composable
private fun RemainingTimeContent(
    remainingDays: Int,
    remainingMinutes: Int,
    textColor: Color,
    isTimeOnTop: Boolean
) {
    val mainActivity = LocalContext.current as MainActivity
    val showLifeRemaining = mainActivity._showLifeRemaining.value
    val lifeTimeSettings = mainActivity._lifeTimeSettings.value
    val (_, _, remainingLifeDays) = if (showLifeRemaining && lifeTimeSettings.birthDate != null && lifeTimeSettings.endDate != null) {
        calculateLifeProgress(lifeTimeSettings)
    } else {
        Triple(0f, 0L, 0L)
    }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(horizontal = 20.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.SpaceEvenly // 均匀分布
    ) {
        Text(
            text = "今年剩余：${remainingDays}天",
            fontSize = 20.sp,
            color = textColor
        )
        Text(
            text = "今天剩余：${remainingMinutes}分钟",
            fontSize = 20.sp,
            color = textColor
        )
        if (showLifeRemaining && lifeTimeSettings.birthDate != null && lifeTimeSettings.endDate != null) {
            Text(
                text = "人生剩余：${remainingLifeDays}天",
                fontSize = 20.sp,
                color = textColor
            )
        }
    }
}

@Composable
private fun CircleProgressSection(
    modifier: Modifier = Modifier,
    onBreathingBallClick: () -> Unit,
    musicPlayer: MusicPlayer?,
    textColor: Color
) {
    var showSettings by remember { mutableStateOf(false) }
    val mainActivity = LocalContext.current as MainActivity
    val circleSettings = mainActivity._circleSettings.value

    // 使用 animateFloatAsState 来实现平滑动画
    var targetProgress by remember { mutableStateOf(calculateMinuteProgress()) }
    val minuteProgress by animateFloatAsState(
        targetValue = targetProgress,
        animationSpec = tween(
            durationMillis = 1000,
            easing = LinearEasing
        ),
        label = "minute progress"
    )

    LaunchedEffect(Unit) {
        while (true) {
            targetProgress = calculateMinuteProgress()
            kotlinx.coroutines.delay(1000)
        }
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        // 固定圆环大小和位置
        val baseSize = 200.dp
        val sizeStep = 40.dp

        // 年度进度圆环
        if (circleSettings.showYearCircle) {
            Box(
                modifier = Modifier
                    .size(baseSize)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onLongPress = { showSettings = true }
                        )
                    }
            ) {
                ProgressCircle(
                    progress = calculateYearProgress(),
                    color = circleSettings.yearColor,
                    size = baseSize,
                    strokeWidth = circleSettings.yearStrokeWidth.dp,
                    showBackground = circleSettings.showYearBackground
                )
            }
        }

        // 日进度圆环
        if (circleSettings.showDayCircle) {
            Box(
                modifier = Modifier
                    .size(baseSize - sizeStep)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onLongPress = { showSettings = true }
                        )
                    }
            ) {
                ProgressCircle(
                    progress = calculateDayProgress(),
                    color = circleSettings.dayColor,
                    size = baseSize - sizeStep,
                    strokeWidth = circleSettings.dayStrokeWidth.dp,
                    showBackground = circleSettings.showDayBackground
                )
            }
        }

        // 分钟进度圆环
        if (circleSettings.showMinuteCircle) {
            Box(
                modifier = Modifier
                    .size(baseSize - sizeStep * 2)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onLongPress = { showSettings = true }
                        )
                    }
            ) {
                ProgressCircle(
                    progress = minuteProgress,
                    color = circleSettings.minuteColor,
                    size = baseSize - sizeStep * 2,
                    strokeWidth = circleSettings.minuteStrokeWidth.dp,
                    showBackground = circleSettings.showMinuteBackground
                )
            }
        }

        // 电池进度圆环
        if (circleSettings.showBatteryCircle) {
            Box(
                modifier = Modifier
                    .size(baseSize - sizeStep * 3)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onLongPress = { showSettings = true }
                        )
                    }
            ) {
                ProgressCircle(
                    progress = 0.8f,
                    color = circleSettings.batteryColor,
                    size = baseSize - sizeStep * 3,
                    strokeWidth = circleSettings.batteryStrokeWidth.dp,
                    showBackground = circleSettings.showBatteryBackground
                )
            }
        }

        // 音乐进度圆环
        if (circleSettings.showMusicCircle && musicPlayer?.isPlaying?.value == true) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onLongPress = { showSettings = true }
                        )
                    }
            ) {
                val duration = musicPlayer.duration.value ?: 1
                val position = musicPlayer.currentPosition.value
                val musicProgress = position.toFloat() / duration.toFloat()

                ProgressCircle(
                    progress = musicProgress.coerceIn(0f, 1f),
                    color = circleSettings.musicColor,
                    size = 60.dp,
                    strokeWidth = circleSettings.musicStrokeWidth.dp,
                    showBackground = circleSettings.showMusicBackground
                )
            }
        }

        // 呼吸球
        if (circleSettings.showBreathingBall) {
            Box(
                modifier = Modifier
                    .size(45.dp)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onTap = {
                                Log.d("MainActivity", "Breathing ball clicked, musicPlayer initialized: ${musicPlayer != null}")
                                musicPlayer?.let { player ->
                                    Log.d("MainActivity", "Songs count: ${player.getSongList().size}")
                                }
                                onBreathingBallClick()
                            },
                            onLongPress = { showSettings = true }
                        )
                    }
            ) {
                BreathingBall(
                    modifier = Modifier.size(45.dp),
                    onClick = null,
                    color = circleSettings.breathingBallColor,
                    strokeWidth = circleSettings.breathingBallStrokeWidth.dp,
                    isPlaying = musicPlayer?.isPlaying?.value ?: false,
                    amplitude = musicPlayer?.currentAmplitude?.value ?: 0f
                )
            }
        }
    }

    if (showSettings) {
        CircleSettingsDialog(
            settings = circleSettings,
            onSettingsChange = { newSettings ->
                mainActivity._circleSettings.value = newSettings
                // 保存设置
                try {
                    val editor = mainActivity.getSharedPreferences("app_settings", Context.MODE_PRIVATE)
                        .edit()
                        .putString("year_circle_color", newSettings.yearColor.value.toString(16).uppercase())
                        .putString("day_circle_color", newSettings.dayColor.value.toString(16).uppercase())
                        .putString("minute_circle_color", newSettings.minuteColor.value.toString(16).uppercase())
                        .putString("battery_circle_color", newSettings.batteryColor.value.toString(16).uppercase())
                        .putString("music_circle_color", newSettings.musicColor.value.toString(16).uppercase())
                        .putString("breathing_ball_color", newSettings.breathingBallColor.value.toString(16).uppercase())
                        .putFloat("year_circle_width", newSettings.yearStrokeWidth)
                        .putFloat("day_circle_width", newSettings.dayStrokeWidth)
                        .putFloat("minute_circle_width", newSettings.minuteStrokeWidth)
                        .putFloat("battery_circle_width", newSettings.batteryStrokeWidth)
                        .putFloat("music_circle_width", newSettings.musicStrokeWidth)
                        .putFloat("breathing_ball_width", newSettings.breathingBallStrokeWidth)
                        .putBoolean("show_year_circle", newSettings.showYearCircle)
                        .putBoolean("show_day_circle", newSettings.showDayCircle)
                        .putBoolean("show_minute_circle", newSettings.showMinuteCircle)
                        .putBoolean("show_battery_circle", newSettings.showBatteryCircle)
                        .putBoolean("show_music_circle", newSettings.showMusicCircle)
                        .putBoolean("show_breathing_ball", newSettings.showBreathingBall)
                        .putBoolean("show_year_background", newSettings.showYearBackground)
                        .putBoolean("show_day_background", newSettings.showDayBackground)
                        .putBoolean("show_minute_background", newSettings.showMinuteBackground)
                        .putBoolean("show_battery_background", newSettings.showBatteryBackground)
                        .putBoolean("show_music_background", newSettings.showMusicBackground)
                        .putBoolean("show_breathing_ball_background", newSettings.showBreathingBallBackground)
                    editor.apply()
                } catch (e: Exception) {
                    Log.e("MainActivity", "Failed to save circle settings", e)
                }
            },
            onDismiss = { showSettings = false }
        )
    }
}

@Composable
fun ProgressCircle(
    progress: Float,
    color: Color,
    size: Dp,
    strokeWidth: Dp,
    showBackground: Boolean = true
) {
    Canvas(
        modifier = Modifier.size(size)
    ) {
        // 背景圆环
        if (showBackground) {
            drawArc(
                color = color.copy(alpha = 0.12f),
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }

        // 进度圆环
        drawArc(
            color = color,
            startAngle = -90f,
            sweepAngle = 360f * progress,
            useCenter = false,
            style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round)
        )
    }
}

@Composable
fun BreathingBall(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    color: Color = MaterialTheme.colorScheme.primary,
    strokeWidth: Dp = 2.dp,
    isPlaying: Boolean,
    amplitude: Float = 0f
) {
    val infiniteTransition = rememberInfiniteTransition(label = "breathing")

    val scale by if (isPlaying) {
        val baseScale = 1f + (amplitude * 0.5f)
        infiniteTransition.animateFloat(
            initialValue = baseScale,
            targetValue = baseScale,
            animationSpec = infiniteRepeatable(
                animation = tween(50, easing = LinearEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = "music scale"
        )
    } else {
        infiniteTransition.animateFloat(
            initialValue = 0.8f,
            targetValue = 1.2f,
            animationSpec = infiniteRepeatable(
                animation = tween(2000, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = "scale"
        )
    }

    Canvas(
        modifier = modifier
            .scale(scale)
            .then(if (onClick != null) Modifier.noRippleClickable(onClick = onClick) else Modifier)
    ) {
        if (isPlaying) {
            val radius = size.minDimension / 2
            val centerX = size.width / 2
            val centerY = size.height / 2
            val path = Path()

            val baseSegments = 4
            val angleStep = (2 * Math.PI) / baseSegments

            var startAngle = 0.0
            var x = centerX + radius * kotlin.math.cos(startAngle).toFloat()
            var y = centerY + radius * kotlin.math.sin(startAngle).toFloat()
            path.moveTo(x, y)

            for (i in 0 until baseSegments) {
                val endAngle = startAngle + angleStep

                val randomPoints = (0..2).random()
                val subAngleStep = angleStep / (randomPoints + 1)

                var currentAngle = startAngle
                for (j in 0..randomPoints) {
                    currentAngle += subAngleStep

                    val shouldAddPeak = Math.random() < 0.7
                    val noise = if (shouldAddPeak) {
                        1f + amplitude * (Math.random() * 0.8f).toFloat()
                    } else {
                        1f
                    }

                    val controlAngle1 = currentAngle - subAngleStep / 3
                    val controlAngle2 = currentAngle - subAngleStep * 2 / 3

                    val nextX = centerX + radius * kotlin.math.cos(currentAngle).toFloat()
                    val nextY = centerY + radius * kotlin.math.sin(currentAngle).toFloat()

                    val control1X = centerX + radius * noise * kotlin.math.cos(controlAngle1).toFloat()
                    val control1Y = centerY + radius * noise * kotlin.math.sin(controlAngle1).toFloat()

                    val control2X = centerX + radius * noise * kotlin.math.cos(controlAngle2).toFloat()
                    val control2Y = centerY + radius * noise * kotlin.math.sin(controlAngle2).toFloat()

                    path.cubicTo(
                        control1X, control1Y,
                        control2X, control2Y,
                        nextX, nextY
                    )
                }

                startAngle = endAngle
            }

            path.close()
            drawPath(
                path = path,
                color = color,
                style = Stroke(
                    width = strokeWidth.toPx(),
                    cap = StrokeCap.Round,
                    join = StrokeJoin.Round
                )
            )
        } else {
            drawCircle(
                color = color,
                radius = size.minDimension / 2,
                style = Stroke(
                    width = strokeWidth.toPx(),
                    cap = StrokeCap.Round
                ),
                center = Offset(size.width / 2, size.height / 2)
            )
        }
    }
}

// 工具函数
fun calculateRemainingDaysInYear(now: LocalDateTime): Int {
    return now.toLocalDate().lengthOfYear() - now.dayOfYear + 1
}

fun calculateRemainingMinutesInDay(now: LocalDateTime): Int {
    return 24 * 60 - (now.hour * 60 + now.minute)
}

fun calculateYearProgress(): Float {
    val now = LocalDateTime.now()
    val dayOfYear = now.dayOfYear
    val daysInYear = now.toLocalDate().lengthOfYear()
    return dayOfYear.toFloat() / daysInYear
}

fun calculateDayProgress(): Float {
    val now = LocalDateTime.now()
    val minutesInDay = now.hour * 60 + now.minute
    return minutesInDay.toFloat() / (24 * 60)
}

fun calculateMinuteProgress(): Float {
    val now = LocalDateTime.now()
    return (now.second + now.nano / 1_000_000_000f) / 60f
}

fun openUrl(context: Context, url: String) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(intent)
}

// Modifier 扩展函数
fun Modifier.noRippleClickable(onClick: () -> Unit) = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }
    ) {
        onClick()
    }
}

@Composable
fun DynamicTextDisplay(
    modifier: Modifier = Modifier,
    isPlaying: Boolean,
    currentLyric: String?,
    musicPlayer: MusicPlayer?,
    textColor: Color
) {
    if (isPlaying && currentLyric != null && musicPlayer != null) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = musicPlayer.displayedLyric.value,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 14.sp,
                color = textColor.copy(alpha = 0.8f)
            )
        }
    } else {
        HitokotoDisplay(modifier = modifier, textColor = textColor)
    }
}

@Composable
fun HitokotoDisplay(
    modifier: Modifier = Modifier,
    textColor: Color
) {
    var hitokoto by remember { mutableStateOf<Hitokoto?>(null) }
    var isLoading by remember { mutableStateOf(false) }

    // 获取新的一言
    suspend fun refreshHitokoto() {
        if (isLoading) return
        isLoading = true
        try {
            hitokoto = HitokotoApi.getRandomHitokoto()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            isLoading = false
        }
    }

    // 初始加载和定时更新
    LaunchedEffect(Unit) {
        refreshHitokoto()

        while (true) {
            delay(60000) // 每分钟自动更新
            refreshHitokoto()
        }
    }

    hitokoto?.let { quote ->
        Column(
            modifier = modifier
                .noRippleClickable {
                    MainScope().launch {
                        refreshHitokoto()
                    }
                }
                .alpha(if (isLoading) 0.5f else 1f),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = quote.hitokoto,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 14.sp,
                color = textColor.copy(alpha = 0.8f)
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = buildString {
                    append("—— ")
                    append(quote.from)
                    quote.fromWho?.let {
                        append(" · ")
                        append(it)
                    }
                },
                style = MaterialTheme.typography.bodySmall,
                fontSize = 12.sp,
                color = textColor.copy(alpha = 0.6f)
            )
        }
    }
}

@Composable
fun AgreementDialog(
    onAgree: () -> Unit,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    val activity = (context as? ComponentActivity)

    AlertDialog(
        onDismissRequest = {
            onDismiss()
            activity?.finish()
        },
        title = { Text("用户协议与隐私政策") },
        text = {
            Column {
                Text("欢迎使用一个摆件！在使用我们的服务之前，请仔细阅读并同意以下协议：")
                Spacer(modifier = Modifier.height(8.dp))

                val annotatedString = buildAnnotatedString {
                    append("点击阅读")
                    pushStringAnnotation("agreement", "")
                    withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary, textDecoration = TextDecoration.Underline)) {
                        append("《用户协议》")
                    }
                    pop()
                    append("和")
                    pushStringAnnotation("privacy", "")
                    withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary, textDecoration = TextDecoration.Underline)) {
                        append("《隐私政策》")
                    }
                    pop()
                }

                ClickableText(
                    text = annotatedString,
                    onClick = { offset ->
                        annotatedString.getStringAnnotations(offset, offset)
                            .firstOrNull()?.let { span ->
                                when (span.tag) {
                                    "agreement" -> openUrl(context, "https://petehsu.github.io/yigebaijian-legal/user-agreement.html")
                                    "privacy" -> openUrl(context, "https://petehsu.github.io/yigebaijian-legal/privacy-policy.html")
                                }
                            }
                    }
                )
            }
        },
        confirmButton = {
            Button(onClick = onAgree) {
                Text("同意并继续")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismiss()
                    activity?.finish()
                }
            ) {
                Text("不同意")
            }
        }
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    一个摆件Theme {
        // 使用虚拟数据进行预览
        MainScreen(
            musicPlayer = null
        )
    }
}

@Composable
fun TodoListPanel(
    modifier: Modifier = Modifier,
    onClose: () -> Unit,
    textColor: Color
) {
    val mainActivity = LocalContext.current as MainActivity
    var showAddDialog by remember { mutableStateOf(false) }
    val todoItems = mainActivity._todoItems.value
    val groupedItems = todoItems.groupBy { it.dayOfWeek }

    // 根据主界面的文字颜色来决定待办界面的颜色方案
    val isMainTextWhite = mainActivity._isWhiteText.value
    val todoBgColor = if (isMainTextWhite) Color.White else Color.Black
    val todoTextColor = if (isMainTextWhite) Color.Black else Color.White

    Surface(
        modifier = modifier,
        color = todoBgColor.copy(alpha = 0.9f),
        shape = RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "待办事项",
                    style = MaterialTheme.typography.titleLarge,
                    color = todoTextColor
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    IconButton(onClick = { showAddDialog = true }) {
                        Icon(Icons.Default.Add, contentDescription = "添加", tint = todoTextColor)
                    }
                    IconButton(
                        onClick = {
                            mainActivity._showYearProgress.value = false
                            onClose()
                        }
                    ) {
                        Icon(Icons.Default.Close, contentDescription = "关闭", tint = todoTextColor)
                    }
                }
            }

            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                items((1..7).toList()) { dayOfWeek ->
                    val items = groupedItems[dayOfWeek] ?: emptyList()
                    if (items.isNotEmpty()) {
                        TodoDayGroup(
                            dayOfWeek = dayOfWeek,
                            items = items,
                            textColor = todoTextColor
                        )
                    }
                }
            }
        }
    }

    if (showAddDialog) {
        AddTodoDialog(
            onDismiss = { showAddDialog = false },
            onAdd = { content, dayOfWeek, hour, minute ->
                val newTodo = TodoItem(
                    content = content,
                    dayOfWeek = dayOfWeek,
                    hour = hour,
                    minute = minute,
                    dueDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                )
                mainActivity._todoItems.value = mainActivity._todoItems.value + newTodo
                mainActivity.saveTodoItems()
                showAddDialog = false
            },
            textColor = todoTextColor
        )
    }
}

@Composable
fun TodoDayGroup(
    dayOfWeek: Int,
    items: List<TodoItem>,
    textColor: Color
) {
    val mainActivity = LocalContext.current as MainActivity
    var expanded by remember { mutableStateOf(false) }
    val dayNames = listOf("周一", "周二", "周三", "周四", "周五", "周六", "周日")

    val today = java.time.LocalDateTime.now().dayOfWeek.value
    val isToday = dayOfWeek == today

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded },
            color = textColor.copy(alpha = 0.1f),
            shape = RoundedCornerShape(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = dayNames[dayOfWeek - 1] + (if (isToday) "（今天）" else ""),
                    style = MaterialTheme.typography.titleMedium,
                    color = textColor
                )
                Text(
                    text = if (expanded) "▼" else "▶",
                    color = textColor
                )
            }
        }

        AnimatedVisibility(visible = expanded) {
            Column(
                modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            ) {
                items.sortedBy { it.hour * 60 + it.minute }.forEach { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 2.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${String.format("%02d:%02d", item.hour, item.minute)} ${item.content}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = textColor,
                            modifier = Modifier.weight(1f)
                        )
                        IconButton(
                            onClick = {
                                mainActivity._todoItems.value = mainActivity._todoItems.value.filter { it.id != item.id }
                                mainActivity.saveTodoItems()
                            }
                        ) {
                            Icon(
                                Icons.Default.Delete,
                                contentDescription = "删除",
                                tint = textColor
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AddTodoDialog(
    onDismiss: () -> Unit,
    onAdd: (String, Int, Int, Int) -> Unit,
    textColor: Color
) {
    var content by remember { mutableStateOf("") }
    var selectedDayOfWeek by remember { mutableStateOf(1) }
    var selectedHour by remember { mutableStateOf(9) }
    var selectedMinute by remember { mutableStateOf(0) }
    val dayNames = listOf("周一", "周二", "周三", "周四", "周五", "周六", "周日")

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                "添加待办事项",
                color = textColor,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedTextField(
                    value = content,
                    onValueChange = { content = it },
                    label = { Text("待办内容", color = textColor, fontSize = 16.sp) },
                    textStyle = LocalTextStyle.current.copy(fontSize = 16.sp, color = textColor),
                    modifier = Modifier.fillMaxWidth()
                )

                Text(
                    "选择星期",
                    style = MaterialTheme.typography.bodyMedium,
                    color = textColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(dayNames.indices.toList()) { index ->
                        Surface(
                            modifier = Modifier.clickable { selectedDayOfWeek = index + 1 },
                            color = if (selectedDayOfWeek == index + 1)
                                MaterialTheme.colorScheme.primary
                            else
                                MaterialTheme.colorScheme.surface,
                            shape = RoundedCornerShape(4.dp)
                        ) {
                            Text(
                                text = dayNames[index],
                                modifier = Modifier.padding(8.dp),
                                fontSize = 16.sp,
                                color = if (selectedDayOfWeek == index + 1)
                                    MaterialTheme.colorScheme.onPrimary
                                else
                                    textColor
                            )
                        }
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                "小时：${String.format("%02d", selectedHour)}",
                                style = MaterialTheme.typography.bodyMedium,
                                color = textColor,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                        Slider(
                            value = selectedHour.toFloat(),
                            onValueChange = { selectedHour = it.toInt() },
                            valueRange = 0f..23f,
                            steps = 23
                        )
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                "分钟：${String.format("%02d", selectedMinute)}",
                                style = MaterialTheme.typography.bodyMedium,
                                color = textColor,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                        Slider(
                            value = selectedMinute.toFloat(),
                            onValueChange = { selectedMinute = it.toInt() },
                            valueRange = 0f..59f,
                            steps = 59
                        )
                    }
                }
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    if (content.isNotBlank()) {
                        onAdd(content, selectedDayOfWeek, selectedHour, selectedMinute)
                    }
                }
            ) {
                Text("添加", color = textColor, fontSize = 16.sp)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("取消", color = textColor, fontSize = 16.sp)
            }
        }
    )
}

@Composable
private fun YearProgressPanel(
    modifier: Modifier = Modifier,
    textColor: Color
) {
    val mainActivity = LocalContext.current as MainActivity
    val settings = mainActivity._yearProgressDisplaySettings.value
    var showDisplaySettings by remember { mutableStateOf(false) }
    val currentTime = remember { mutableStateOf(LocalDateTime.now()) }
    
    // 实时更新时间
    LaunchedEffect(settings.passedTimeUnit, settings.remainingTimeUnit) {
        while (true) {
            currentTime.value = LocalDateTime.now()
            delay(if (settings.passedTimeUnit == CustomTimeUnit.MILLISECOND || settings.remainingTimeUnit == CustomTimeUnit.MILLISECOND) 8 else 1000)
        }
    }
    
    val remainingDays = 365 - currentTime.value.dayOfYear
    val remainingMinutes = 60 - currentTime.value.minute
    
    // 计算更精确的年度进度，包含当天的时分秒毫秒
    val dayProgress = (currentTime.value.hour * 3600000L + 
                      currentTime.value.minute * 60000L + 
                      currentTime.value.second * 1000L + 
                      currentTime.value.nano / 1_000_000L).toFloat() / (24f * 60f * 60f * 1000f)
    val progress = (currentTime.value.dayOfYear - 1 + dayProgress) / 365f

    // 判断是否为白天（6:00-18:00）
    val isDaytime = currentTime.value.hour in 6..18

    // 使用remember记住当前的下雨效果状态
    var isRainEffectEnabled by remember(settings.enableRainEffect) { mutableStateOf(settings.enableRainEffect) }

    // 根据时间和下雨效果设置背景颜色，添加平滑动画
    val backgroundColor by animateColorAsState(
        targetValue = if (!isDaytime) {
            Color.Black
        } else if (isRainEffectEnabled) {
            Color(0xFF808080)  // 下雨时使用灰色背景
        } else {
            Color(0xFFF5F5F5)
        },
        animationSpec = tween(
            durationMillis = 1000,
            easing = FastOutSlowInEasing
        ),
        label = "background color"
    )

    val waveColor by animateColorAsState(
        targetValue = if (!isDaytime) Color(0xFF1A3B66) else Color(0xFF87CEEB),
        animationSpec = tween(
            durationMillis = 1000,
            easing = FastOutSlowInEasing
        ),
        label = "wave color"
    )

    // 文字颜色
    val textColorMain = if (!isDaytime || isRainEffectEnabled) {
        Color.White.copy(alpha = 0.9f)
    } else {
        Color.Black.copy(alpha = 0.9f)
    }
    val textColorSecondary = if (!isDaytime || isRainEffectEnabled) {
        Color.White.copy(alpha = 0.7f)
    } else {
        Color.Black.copy(alpha = 0.7f)
    }

    Box(
        modifier = modifier
            .background(backgroundColor)
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    // 检测垂直方向的拖动
                    if (kotlin.math.abs(dragAmount.y) > kotlin.math.abs(dragAmount.x)) {
                        // 下滑返回
                        if (dragAmount.y > 10) {
                            mainActivity._showYearProgress.value = false
                        }
                    }
                    // 检测水平方向的拖动
                    if (kotlin.math.abs(dragAmount.x) > kotlin.math.abs(dragAmount.y)) {
                        // 左滑显示人生进度
                        if (dragAmount.x < -10) {
                            mainActivity._showLifeProgress.value = true
                        }
                    }
                }
            }
            .pointerInput(Unit) {
                detectTapGestures(
                    onDoubleTap = {
                        // 双击切换下雨效果
                        isRainEffectEnabled = !isRainEffectEnabled
                        val newSettings = settings.copy(enableRainEffect = isRainEffectEnabled)
                        mainActivity._yearProgressDisplaySettings.value = newSettings
                        mainActivity.getSharedPreferences("app_settings", Context.MODE_PRIVATE)
                            .edit()
                            .putBoolean("year_progress_enable_rain_effect", isRainEffectEnabled)
                            .apply()
                    },
                    onLongPress = { showDisplaySettings = true }
                )
            }
    ) {
        // 添加星星的绘制
        if (!isRainEffectEnabled) {
            StarrySky(modifier = Modifier.fillMaxSize())
        }

        // 如果启用了下雨效果，添加雨滴动画
        if (isRainEffectEnabled) {
            RainEffect()
        }

        // 水波动画
        val infiniteTransition = rememberInfiniteTransition(label = "wave")
        val waveOffset1 by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 2f * Math.PI.toFloat(),
            animationSpec = infiniteRepeatable(
                animation = tween(7000, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            ),
            label = "wave offset 1"
        )

        val waveOffset2 by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 2f * Math.PI.toFloat(),
            animationSpec = infiniteRepeatable(
                animation = tween(5000, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            ),
            label = "wave offset 2"
        )

        val waveOffset3 by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 2f * Math.PI.toFloat(),
            animationSpec = infiniteRepeatable(
                animation = tween(3000, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            ),
            label = "wave offset 3"
        )

        Canvas(modifier = Modifier.fillMaxSize()) {
            val width = size.width
            val height = size.height
            val waterHeight = height * (1 - progress)

            fun drawWave(offset: Float, amplitude: Float, period: Float, alpha: Float) {
                val path = Path()

                // 计算倾斜偏移
                val tiltX = mainActivity.tiltX.value

                // 只在手机横放时（-45度到45度之间）检测倾斜
                val isHorizontal = mainActivity.tiltY.value > -45f && mainActivity.tiltY.value < 45f

                // 将倾斜角度转换为弧度，并根据横放状态调整灵敏度
                val tiltXRad = if (isHorizontal) {
                    (tiltX * Math.PI.toFloat() / 180f) * 4f // 增加横放时的灵敏度
                } else {
                    0f // 竖直时不应用倾斜效果
                }

                // 扩展绘制范围以确保倾斜时波浪仍然填满屏幕
                val extendedWidth = width * 2f
                val startX = -extendedWidth * 0.25f
                val endX = width + extendedWidth * 0.25f

                // 计算基准水位，确保波浪始终在正确位置
                val baseWaterHeight = waterHeight + height * 0.02f

                // 移动到起始点
                path.moveTo(startX, baseWaterHeight)

                // 绘制波浪
                val step = 8f // 减小步长以获得更平滑的波浪
                var x = startX
                while (x <= endX) {
                    val normalizedX = (x - startX) / width
                    val phase = normalizedX * 2f * Math.PI.toFloat() + offset

                    // 计算波浪高度，加入倾斜效果
                    val waveHeight = amplitude * kotlin.math.sin(phase)

                    // 倾斜时波浪堆积效果
                    val tiltEffect = if (isHorizontal) {
                        // 使用非线性函数来实现柔和的倾斜限制
                        val tiltFactor = kotlin.math.sin(-tiltXRad * 0.5f) * 0.8f
                        val distanceFromCenter = (x - width / 2f) / (width / 2f)
                        height * tiltFactor * distanceFromCenter * 0.5f
                    } else {
                        0f
                    }

                    // 合成最终位置
                    val y = baseWaterHeight + waveHeight + tiltEffect

                    path.lineTo(x, y)
                    x += step
                }

                // 完成路径，确保波浪填充到底部
                path.lineTo(endX, height)
                path.lineTo(startX, height)
                path.close()

                // 绘制波浪
                drawPath(
                    path = path,
                    color = waveColor.copy(alpha = alpha)
                )
            }

            // 使用动画的偏移值绘制三层波浪
            drawWave(waveOffset1, 25f, width / 2f, 0.3f)
            drawWave(waveOffset2, 20f, width / 3f, 0.2f)
            drawWave(waveOffset3, 15f, width / 4f, 0.1f)
        }

        // 如果启用了下雨效果，添加雨滴动画
        if (isRainEffectEnabled) {
            RainEffect()
        }

        // 年度进度信息
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val percentText = if (settings.showRemainingPercent) {
                if (settings.showDecimalPercent) {
                    String.format("%.2f%%", (1f - progress) * 100f)
                } else {
                    "${((1f - progress) * 100f).toInt()}%"
                }
            } else {
                if (settings.showDecimalPercent) {
                    String.format("%.2f%%", progress * 100f)
                } else {
                    "${(progress * 100f).toInt()}%"
                }
            }

            Text(
                text = percentText,
                fontSize = 64.sp,
                fontWeight = FontWeight.Bold,
                color = textColorMain  // 使用textColorMain而不是textColor
            )

            val passedDays = currentTime.value.dayOfYear - 1
            val passedTimeText = when (settings.passedTimeUnit) {
                CustomTimeUnit.YEAR -> "今年已经过去了${passedDays / 365}年"
                CustomTimeUnit.QUARTER -> "今年已经过去了${passedDays / 91}季"
                CustomTimeUnit.MONTH -> "今年已经过去了${passedDays / 30}月"
                CustomTimeUnit.WEEK -> "今年已经过去了${passedDays / 7}周"
                CustomTimeUnit.DAY -> "今年已经过去了${passedDays}天"
                CustomTimeUnit.HOUR -> "今年已经过去了${passedDays * 24 + currentTime.value.hour}小时"
                CustomTimeUnit.MINUTE -> "今年已经过去了${passedDays * 24 * 60 + currentTime.value.hour * 60 + currentTime.value.minute}分钟"
                CustomTimeUnit.SECOND -> "今年已经过去了${passedDays * 24 * 60 * 60 + currentTime.value.hour * 3600 + currentTime.value.minute * 60 + currentTime.value.second}秒"
                CustomTimeUnit.MILLISECOND -> "今年已经过去了${passedDays * 24L * 60L * 60L * 1000L + currentTime.value.hour * 3600000L + currentTime.value.minute * 60000L + currentTime.value.second * 1000L + currentTime.value.nano / 1_000_000L}毫秒"
            }
            Text(
                text = passedTimeText,
                fontSize = 20.sp,
                color = textColorSecondary
            )

            val remainingTimeText = when (settings.remainingTimeUnit) {
                CustomTimeUnit.YEAR -> "还剩${remainingDays / 365}年"
                CustomTimeUnit.QUARTER -> "还剩${remainingDays / 91}季"
                CustomTimeUnit.MONTH -> "还剩${remainingDays / 30}月"
                CustomTimeUnit.WEEK -> "还剩${remainingDays / 7}周"
                CustomTimeUnit.DAY -> "还剩${remainingDays}天"
                CustomTimeUnit.HOUR -> "还剩${remainingDays * 24 - currentTime.value.hour}小时"
                CustomTimeUnit.MINUTE -> "还剩${remainingDays * 24 * 60 - (currentTime.value.hour * 60 + currentTime.value.minute)}分钟"
                CustomTimeUnit.SECOND -> "还剩${remainingDays * 24 * 60 * 60 - (currentTime.value.hour * 3600 + currentTime.value.minute * 60 + currentTime.value.second)}秒"
                CustomTimeUnit.MILLISECOND -> "还剩${remainingDays * 24L * 60L * 60L * 1000L - (currentTime.value.hour * 3600000L + currentTime.value.minute * 60000L + currentTime.value.second * 1000L + currentTime.value.nano / 1_000_000L)}毫秒"
            }
            Text(
                text = remainingTimeText,
                fontSize = 20.sp,
                color = textColorSecondary
            )
        }
    }

    if (showDisplaySettings) {
        YearProgressDisplaySettingsDialog(
            onDismiss = { showDisplaySettings = false }
        )
    }
}

@Composable
private fun RainEffect() {
    val infiniteTransition = rememberInfiniteTransition(label = "rain")
    val rainDrops = remember {
        List(700) {  // 增加雨滴数量
            RainDrop(
                x = Random.nextFloat(),
                y = Random.nextFloat() * 4f - 3f,  // 让雨滴从更高的位置开始
                speed = Random.nextFloat() * 3f + 2f,  // 增加速度范围
                length = Random.nextFloat() * 35f + 25f,
                alpha = Random.nextFloat() * 0.25f + 0.1f,
                width = Random.nextFloat() * 1.2f + 0.5f,
                angle = 0f,  // 移除倾斜效果
                depth = Random.nextFloat()
            )
        }
    }

    val animationProgress by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(6000, easing = LinearEasing),  // 增加动画时间
            repeatMode = RepeatMode.Restart
        ),
        label = "rain animation"
    )

    Canvas(modifier = Modifier.fillMaxSize()) {
        rainDrops.forEach { drop ->
            drawRainDrop(drop, animationProgress)
        }
    }
}

private fun DrawScope.drawRainDrop(drop: RainDrop, animationProgress: Float) {
    val startY = (drop.y + animationProgress * drop.speed) * size.height

    // 计算雨滴的终点，考虑角度和风的影响
    val xOffset = 0f  // 移除风的效果，保持垂直
    val yOffset = drop.length

    val endY = startY + yOffset
    val startX = drop.x * size.width
    val endX = startX + xOffset

    // 只绘制在屏幕范围内的雨滴
    if (endY >= 0 && startY <= size.height) {
        // 根据深度调整雨滴的视觉效果
        val depthAlpha = drop.alpha * (0.5f + drop.depth * 0.5f)
        val depthWidth = drop.width * (0.5f + drop.depth * 0.5f)

        // 绘制雨滴的主体
        drawLine(
            color = Color.White.copy(alpha = depthAlpha),
            start = Offset(startX, startY),
            end = Offset(endX, endY),
            strokeWidth = depthWidth,
            cap = StrokeCap.Round
        )

        // 添加雨滴头部的光晕效果
        drawCircle(
            color = Color.White.copy(alpha = depthAlpha * 0.6f),
            radius = depthWidth * 2f,
            center = Offset(endX, endY)
        )

        // 添加雨滴尾部的拖尾效果
        val gradient = Brush.verticalGradient(
            colors = listOf(
                Color.White.copy(alpha = 0f),
                Color.White.copy(alpha = depthAlpha)
            ),
            startY = startY,
            endY = endY
        )

        drawLine(
            brush = gradient,
            start = Offset(startX, startY),
            end = Offset(endX, endY),
            strokeWidth = depthWidth * 0.5f,
            cap = StrokeCap.Round
        )
    }
}

@Composable
fun TimeSettingsDialog(
    settings: TimeDisplaySettings,
    onSettingsChange: (TimeDisplaySettings) -> Unit,
    onDismiss: () -> Unit
) {
    val mainActivity = LocalContext.current as MainActivity
    
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("显示设置", color = Color.Black) },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // 透明度设置
                Text("透明度: ${(settings.alpha * 100).toInt()}%", color = Color.Black)
                Slider(
                    value = settings.alpha,
                    onValueChange = { onSettingsChange(settings.copy(alpha = it)) },
                    valueRange = 0.1f..1f
                )

                // 字体大小设置
                Column {
                    Text("字体大小：${settings.fontSize.toInt()}", color = Color.Black)
                    Slider(
                        value = settings.fontSize,
                        onValueChange = { onSettingsChange(settings.copy(fontSize = it)) },
                        valueRange = 64f..400f,  // 将最大值从 200f 增加到 400f
                        steps = 0
                    )
                }

                // 字体粗细设置
                Text("字体粗细: ${settings.fontWeight}", color = Color.Black)
                Slider(
                    value = settings.fontWeight.toFloat(),
                    onValueChange = { onSettingsChange(settings.copy(fontWeight = it.toInt())) },
                    valueRange = 100f..900f,
                    steps = 8
                )

                // 显示秒数设置
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("显示秒数", color = Color.Black)
                    Switch(
                        checked = settings.showSeconds,
                        onCheckedChange = { onSettingsChange(settings.copy(showSeconds = it)) }
                    )
                }

                // 显示毫秒设置
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("显示毫秒", color = Color.Black)
                    Switch(
                        checked = settings.showMillis,
                        onCheckedChange = { onSettingsChange(settings.copy(showMillis = it)) }
                    )
                }

                // 24小时制设置
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("使用24小时制", color = Color.Black)
                    Switch(
                        checked = settings.use24Hour,
                        onCheckedChange = { onSettingsChange(settings.copy(use24Hour = it)) }
                    )
                }

                // 添加位置设置
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("时间显示在上方", color = Color.Black)
                    Switch(
                        checked = settings.isTimeOnTop,
                        onCheckedChange = { onSettingsChange(settings.copy(isTimeOnTop = it)) }
                    )
                }

                // 添加居中显示设置
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("居中显示", color = Color.Black)
                    Switch(
                        checked = settings.isCentered,
                        onCheckedChange = { onSettingsChange(settings.copy(isCentered = it)) }
                    )
                }

                // 添加常亮显示设置
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("常亮显示", color = Color.Black)
                    Switch(
                        checked = settings.keepScreenOn,
                        onCheckedChange = { 
                            onSettingsChange(settings.copy(keepScreenOn = it))
                            if (it) {
                                mainActivity.window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
                            } else {
                                mainActivity.window.clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
                            }
                            mainActivity.getSharedPreferences("app_settings", Context.MODE_PRIVATE)
                                .edit()
                                .putBoolean("keep_screen_on", it)
                                .apply()
                        }
                    )
                }

                // 添加时间颜色设置
                Text("时间颜色", color = Color.Black)
                val timeColors = listOf(
                    0xFFFFFFFF, // 白色
                    0xFF000000, // 黑色
                    0xFF808080, // 灰色
                    0xFF2196F3, // 蓝色
                    0xFFFF1744, // 红色
                    0xFFFFD600, // 黄色
                    0xFF00E676, // 绿色
                    0xFFE040FB, // 粉色
                    0xFFAA00FF, // 紫色
                    0xFF3F51B5, // 靛蓝
                    0xFFFF5722, // 橙色
                    0xFF795548  // 棕色
                )
                LazyVerticalGrid(
                    columns = GridCells.Fixed(6),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.height(120.dp)
                ) {
                    items(timeColors) { colorValue ->
                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .background(
                                    Color(colorValue),
                                    CircleShape
                                )
                                .border(
                                    width = if (settings.timeColor == colorValue) 3.dp else 1.dp,
                                    color = if (settings.timeColor == colorValue) Color.Blue else Color.Gray,
                                    shape = CircleShape
                                )
                                .clickable {
                                    onSettingsChange(settings.copy(timeColor = colorValue))
                                }
                        )
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("确定", color = Color.Black)
            }
        }
    )
}

@Composable
fun CircleSettingsDialog(
    settings: CircleSettings,
    onSettingsChange: (CircleSettings) -> Unit,
    onDismiss: () -> Unit
) {
    val colors = listOf(
        // 添加黑白灰三色
        Color.White, Color.Black, Color.Gray,
        // 原有的颜色
        Color(0xFF2196F3), Color(0xFFFF1744), Color(0xFFFFD600),
        Color(0xFF00E676), Color(0xFFE040FB), Color(0xFFAA00FF),
        Color(0xFF3F51B5), Color(0xFFFF5722), Color(0xFF795548),
        Color(0xFF607D8B), Color(0xFF9C27B0), Color(0xFF009688),
        Color(0xFFFF9800), Color(0xFF8BC34A), Color(0xFFCDDC39),
        Color(0xFFFFC107), Color(0xFF03A9F4), Color(0xFF673AB7),
        Color(0xFFE91E63), Color(0xFF4CAF50)
    )

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("圆环设置", color = Color.Black) },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // 年度圆环设置
                CircleSettingSection(
                    title = "年度圆环",
                    color = settings.yearColor,
                    strokeWidth = settings.yearStrokeWidth,
                    isVisible = settings.showYearCircle,
                    showBackground = settings.showYearBackground,
                    onColorChange = { onSettingsChange(settings.copy(yearColor = it)) },
                    onStrokeWidthChange = { onSettingsChange(settings.copy(yearStrokeWidth = it)) },
                    onVisibilityChange = { onSettingsChange(settings.copy(showYearCircle = it)) },
                    onBackgroundChange = { onSettingsChange(settings.copy(showYearBackground = it)) },
                    colors = colors
                )

                // 日圆环设置
                CircleSettingSection(
                    title = "日圆环",
                    color = settings.dayColor,
                    strokeWidth = settings.dayStrokeWidth,
                    isVisible = settings.showDayCircle,
                    showBackground = settings.showDayBackground,
                    onColorChange = { onSettingsChange(settings.copy(dayColor = it)) },
                    onStrokeWidthChange = { onSettingsChange(settings.copy(dayStrokeWidth = it)) },
                    onVisibilityChange = { onSettingsChange(settings.copy(showDayCircle = it)) },
                    onBackgroundChange = { onSettingsChange(settings.copy(showDayBackground = it)) },
                    colors = colors
                )

                // 分钟圆环设置
                CircleSettingSection(
                    title = "分钟圆环",
                    color = settings.minuteColor,
                    strokeWidth = settings.minuteStrokeWidth,
                    isVisible = settings.showMinuteCircle,
                    showBackground = settings.showMinuteBackground,
                    onColorChange = { onSettingsChange(settings.copy(minuteColor = it)) },
                    onStrokeWidthChange = { onSettingsChange(settings.copy(minuteStrokeWidth = it)) },
                    onVisibilityChange = { onSettingsChange(settings.copy(showMinuteCircle = it)) },
                    onBackgroundChange = { onSettingsChange(settings.copy(showMinuteBackground = it)) },
                    colors = colors
                )

                // 电池圆环设置
                CircleSettingSection(
                    title = "电池圆环",
                    color = settings.batteryColor,
                    strokeWidth = settings.batteryStrokeWidth,
                    isVisible = settings.showBatteryCircle,
                    showBackground = settings.showBatteryBackground,
                    onColorChange = { onSettingsChange(settings.copy(batteryColor = it)) },
                    onStrokeWidthChange = { onSettingsChange(settings.copy(batteryStrokeWidth = it)) },
                    onVisibilityChange = { onSettingsChange(settings.copy(showBatteryCircle = it)) },
                    onBackgroundChange = { onSettingsChange(settings.copy(showBatteryBackground = it)) },
                    colors = colors
                )

                // 音乐圆环设置
                CircleSettingSection(
                    title = "音乐圆环",
                    color = settings.musicColor,
                    strokeWidth = settings.musicStrokeWidth,
                    isVisible = settings.showMusicCircle,
                    showBackground = settings.showMusicBackground,
                    onColorChange = { onSettingsChange(settings.copy(musicColor = it)) },
                    onStrokeWidthChange = { onSettingsChange(settings.copy(musicStrokeWidth = it)) },
                    onVisibilityChange = { onSettingsChange(settings.copy(showMusicCircle = it)) },
                    onBackgroundChange = { onSettingsChange(settings.copy(showMusicBackground = it)) },
                    colors = colors
                )

                // 呼吸球设置
                CircleSettingSection(
                    title = "呼吸球",
                    color = settings.breathingBallColor,
                    strokeWidth = settings.breathingBallStrokeWidth,
                    isVisible = settings.showBreathingBall,
                    showBackground = settings.showBreathingBallBackground,
                    onColorChange = { onSettingsChange(settings.copy(breathingBallColor = it)) },
                    onStrokeWidthChange = { onSettingsChange(settings.copy(breathingBallStrokeWidth = it)) },
                    onVisibilityChange = { onSettingsChange(settings.copy(showBreathingBall = it)) },
                    onBackgroundChange = { onSettingsChange(settings.copy(showBreathingBallBackground = it)) },
                    colors = colors
                )
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("确定", color = Color.Black)
            }
        }
    )
}

@Composable
private fun CircleSettingSection(
    title: String,
    color: Color,
    strokeWidth: Float,
    isVisible: Boolean,
    showBackground: Boolean,
    onColorChange: (Color) -> Unit,
    onStrokeWidthChange: (Float) -> Unit,
    onVisibilityChange: (Boolean) -> Unit,
    onBackgroundChange: (Boolean) -> Unit,
    colors: List<Color>
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
            Text(title, color = Color.Black, fontWeight = FontWeight.Bold)
                    Switch(
                checked = isVisible,
                onCheckedChange = onVisibilityChange
            )
        }

        if (isVisible) {
            // 背景显示开关
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("显示背景环", color = Color.Black)
                Switch(
                    checked = showBackground,
                    onCheckedChange = onBackgroundChange
                )
            }

            // 颜色选择器
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(colors) { colorOption ->
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .background(colorOption, CircleShape)
                            .border(
                                width = 2.dp,
                                color = if (color == colorOption) Color.White else Color.Transparent,
                                shape = CircleShape
                            )
                            .clickable { onColorChange(colorOption) }
                    )
                }
            }

            // 线条宽度设置
            Text("线条宽度: ${strokeWidth.toInt()}", color = Color.Black)
            Slider(
                value = strokeWidth,
                onValueChange = onStrokeWidthChange,
                valueRange = 1f..20f
            )
        }

        Divider(color = Color.LightGray, thickness = 0.5.dp)
    }
}

@Composable
fun LifeProgressPanel(
    modifier: Modifier = Modifier,
    textColor: Color,
    lifeTimeSettings: LifeTimeSettings
) {
    var showDateSettings by remember { mutableStateOf(false) }
    var showDisplaySettings by remember { mutableStateOf(false) }
    var showRemainingSettings by remember { mutableStateOf(false) }
    val mainActivity = LocalContext.current as MainActivity
    val displaySettings = mainActivity._lifeProgressDisplaySettings.value
    val yearProgressSettings = mainActivity._yearProgressDisplaySettings.value
    val isVisible = mainActivity._showLifeProgress.value

    // 添加当前时间状态
    var currentTime by remember { mutableStateOf(LocalDateTime.now()) }

    // 根据年度进度界面的显示单位决定更新频率（同步设置）
    LaunchedEffect(yearProgressSettings.passedTimeUnit, yearProgressSettings.remainingTimeUnit) {
        while (true) {
            currentTime = LocalDateTime.now()
            // 根据年度进度界面的最小时间单位决定更新频率
            val minTimeUnit = minOf(yearProgressSettings.passedTimeUnit, yearProgressSettings.remainingTimeUnit)
            val delayMillis = when (minTimeUnit) {
                CustomTimeUnit.MILLISECOND -> 8L // 提高到约120fps，减少毫秒显示延迟
                CustomTimeUnit.SECOND -> 1000L
                else -> 1000L
            }
            delay(delayMillis)
        }
    }

    // 计算生命进度
    val (progress, passedDays, remainingDays) = calculateLifeProgress(lifeTimeSettings, currentTime)

    // 计算日夜背景色
    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val isNight = hour !in 6..18

    val backgroundColor = if (isNight) {
        Color.Black
    } else if (yearProgressSettings.enableRainEffect) {
        Color(0xFF808080)  // 下雨时使用灰色背景
    } else {
        Color(0xFFF5F5F5)
    }

    val waveColor = if (isNight) Color(0xFF1A3B66) else Color(0xFF87CEEB)

    // 文字颜色
    val textColorMain = if (isNight || yearProgressSettings.enableRainEffect) {
        Color.White.copy(alpha = 0.9f)
    } else {
        Color.Black.copy(alpha = 0.9f)
    }
    val textColorSecondary = if (isNight || yearProgressSettings.enableRainEffect) {
        Color.White.copy(alpha = 0.7f)
    } else {
        Color.Black.copy(alpha = 0.7f)
    }

    Box(
        modifier = modifier
            .background(backgroundColor)
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    if (kotlin.math.abs(dragAmount.x) > kotlin.math.abs(dragAmount.y)) {
                        if (dragAmount.x > 10) {  // 右滑返回
                            mainActivity._showLifeProgress.value = false
                        } else if (dragAmount.x < -10) {  // 左滑显示年度方格界面
                            mainActivity._showHourglassProgress.value = true
                        }
                    }
                }
            }
            .pointerInput(Unit) {
                detectTapGestures(
                    onDoubleTap = { showDateSettings = true },
                    onLongPress = { showRemainingSettings = true }
                )
            }
    ) {
        // 修改星星效果和下雨效果的显示逻辑
        if (yearProgressSettings.enableRainEffect) {
            RainEffect()
        } else {
            StarrySky(modifier = Modifier.fillMaxSize())
        }

        // 水波动画
        val infiniteTransition = rememberInfiniteTransition(label = "wave")
        val waveOffset1 by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 2f * Math.PI.toFloat(),
            animationSpec = infiniteRepeatable(
                animation = tween(7000, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            ),
            label = "wave offset 1"
        )

        val waveOffset2 by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 2f * Math.PI.toFloat(),
            animationSpec = infiniteRepeatable(
                animation = tween(5000, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            ),
            label = "wave offset 2"
        )

        val waveOffset3 by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 2f * Math.PI.toFloat(),
            animationSpec = infiniteRepeatable(
                animation = tween(3000, easing = LinearEasing),
                repeatMode = RepeatMode.Restart
            ),
            label = "wave offset 3"
        )

        Canvas(modifier = Modifier.fillMaxSize()) {
            val width = size.width
            val height = size.height
            val waterHeight = height * (1 - progress)

            fun drawWave(offset: Float, amplitude: Float, period: Float, alpha: Float) {
                val path = Path()

                // 计算倾斜偏移
                val tiltX = mainActivity.tiltX.value

                // 只在手机横放时（-45度到45度之间）检测倾斜
                val isHorizontal = mainActivity.tiltY.value > -45f && mainActivity.tiltY.value < 45f

                // 将倾斜角度转换为弧度，并根据横放状态调整灵敏度
                val tiltXRad = if (isHorizontal) {
                    (tiltX * Math.PI.toFloat() / 180f) * 4f // 增加横放时的灵敏度
                } else {
                    0f // 竖直时不应用倾斜效果
                }

                // 扩展绘制范围以确保倾斜时波浪仍然填满屏幕
                val extendedWidth = width * 2f
                val startX = -extendedWidth * 0.25f
                val endX = width + extendedWidth * 0.25f

                // 计算基准水位，确保波浪始终在正确位置
                val baseWaterHeight = waterHeight + height * 0.02f

                // 移动到起始点
                path.moveTo(startX, baseWaterHeight)

                // 绘制波浪
                val step = 8f // 减小步长以获得更平滑的波浪
                var x = startX
                while (x <= endX) {
                    val normalizedX = (x - startX) / width
                    val phase = normalizedX * 2f * Math.PI.toFloat() + offset

                    // 计算波浪高度，加入倾斜效果
                    val waveHeight = amplitude * kotlin.math.sin(phase)

                    // 倾斜时波浪堆积效果
                    val tiltEffect = if (isHorizontal) {
                        // 使用非线性函数来实现柔和的倾斜限制
                        val tiltFactor = kotlin.math.sin(-tiltXRad * 0.5f) * 0.8f
                        val distanceFromCenter = (x - width / 2f) / (width / 2f)
                        height * tiltFactor * distanceFromCenter * 0.5f
                    } else {
                        0f
                    }

                    // 合成最终位置
                    val y = baseWaterHeight + waveHeight + tiltEffect

                    path.lineTo(x, y)
                    x += step
                }

                // 完成路径，确保波浪填充到底部
                path.lineTo(endX, height)
                path.lineTo(startX, height)
                path.close()

                // 绘制波浪
                drawPath(
                    path = path,
                    color = waveColor.copy(alpha = alpha)
                )
            }

            // 使用动画的偏移值绘制三层波浪，增加波浪振幅使效果更明显
            drawWave(waveOffset1, 25f, width / 2f, 0.3f)
            drawWave(waveOffset2, 20f, width / 3f, 0.2f)
            drawWave(waveOffset3, 15f, width / 4f, 0.1f)
        }

        // 显示进度信息
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (lifeTimeSettings.birthDate == null) {
                Text(
                    text = "双击设置出生日期",
                    fontSize = 24.sp,
                    color = textColorMain
                )
            } else {
                // 百分比显示
                val percentText = if (displaySettings.showRemainingPercent) {
                    if (displaySettings.showDecimalPercent) {
                        String.format("%.2f%%", (1 - progress) * 100)
                    } else {
                        "${((1 - progress) * 100).toInt()}%"
                    }
                } else {
                    if (displaySettings.showDecimalPercent) {
                        String.format("%.2f%%", progress * 100)
                    } else {
                        "${(progress * 100).toInt()}%"
                    }
                }

                Text(
                    text = percentText,
                    fontSize = 64.sp,
                    fontWeight = FontWeight.Bold,
                    color = textColorMain
                )

                // 过去时间显示（使用年度进度界面的单位设置）
                val passedTimeText = when (yearProgressSettings.passedTimeUnit) {
                    CustomTimeUnit.YEAR -> "人生已经过去了${passedDays / 365}年"
                    CustomTimeUnit.QUARTER -> "人生已经过去了${passedDays / 91}季"
                    CustomTimeUnit.MONTH -> "人生已经过去了${passedDays / 30}月"
                    CustomTimeUnit.WEEK -> "人生已经过去了${passedDays / 7}周"
                    CustomTimeUnit.DAY -> "人生已经过去了${passedDays}天"
                    CustomTimeUnit.HOUR -> "人生已经过去了${passedDays * 24 + currentTime.hour}小时"
                    CustomTimeUnit.MINUTE -> "人生已经过去了${passedDays * 24 * 60 + currentTime.hour * 60 + currentTime.minute}分钟"
                    CustomTimeUnit.SECOND -> "人生已经过去了${passedDays * 24 * 60 * 60 + currentTime.hour * 3600 + currentTime.minute * 60 + currentTime.second}秒"
                    CustomTimeUnit.MILLISECOND -> "人生已经过去了${passedDays * 24 * 60 * 60 * 1000 + currentTime.hour * 3600000 + currentTime.minute * 60000 + currentTime.second * 1000 + currentTime.nano / 1_000_000}毫秒"
                }
                Text(
                    text = passedTimeText,
                    fontSize = 20.sp,
                    color = textColorSecondary
                )

                // 剩余时间显示（使用年度进度界面的单位设置）
                val remainingTimeText = when (yearProgressSettings.remainingTimeUnit) {
                    CustomTimeUnit.YEAR -> "还剩${remainingDays / 365}年"
                    CustomTimeUnit.QUARTER -> "还剩${remainingDays / 91}季"
                    CustomTimeUnit.MONTH -> "还剩${remainingDays / 30}月"
                    CustomTimeUnit.WEEK -> "还剩${remainingDays / 7}周"
                    CustomTimeUnit.DAY -> "还剩${remainingDays}天"
                    CustomTimeUnit.HOUR -> "还剩${remainingDays * 24 - currentTime.hour}小时"
                    CustomTimeUnit.MINUTE -> "还剩${remainingDays * 24 * 60 - (currentTime.hour * 60 + currentTime.minute)}分钟"
                    CustomTimeUnit.SECOND -> "还剩${remainingDays * 24 * 60 * 60 - (currentTime.hour * 3600 + currentTime.minute * 60 + currentTime.second)}秒"
                    CustomTimeUnit.MILLISECOND -> "还剩${remainingDays * 24 * 60 * 60 * 1000 - (currentTime.hour * 3600000 + currentTime.minute * 60000 + currentTime.second * 1000 + currentTime.nano / 1_000_000)}毫秒"
                }
                Text(
                    text = remainingTimeText,
                    fontSize = 20.sp,
                    color = textColorSecondary
                )
            }
        }
    }

    if (showDateSettings) {
        LifeDateSettingsDialog(
            settings = lifeTimeSettings,
            onDismiss = { showDateSettings = false }
        )
    }

    if (showDisplaySettings) {
        LifeProgressDisplaySettingsDialog(
            settings = displaySettings,
            onSettingsChange = { newSettings ->
                mainActivity._lifeProgressDisplaySettings.value = newSettings
                // 保存设置
                mainActivity.getSharedPreferences("app_settings", Context.MODE_PRIVATE)
                    .edit()
                    .putBoolean("life_progress_show_remaining", newSettings.showRemainingPercent)
                    .putBoolean("life_progress_show_decimal", newSettings.showDecimalPercent)
                    .putString("life_progress_passed_unit", newSettings.passedTimeUnit.name)
                    .putString("life_progress_remaining_unit", newSettings.remainingTimeUnit.name)
                    .apply()
            },
            onDismiss = { showDisplaySettings = false }
        )
    }

    // 添加人生剩余设置对话框
    if (showRemainingSettings) {
        RemainingSettingsDialog(
            onDismiss = { showRemainingSettings = false }
        )
    }
}

@Composable
private fun RemainingSettingsDialog(
    onDismiss: () -> Unit
) {
    val mainActivity = LocalContext.current as MainActivity
    val prefs = mainActivity.getSharedPreferences("app_settings", Context.MODE_PRIVATE)

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("人生剩余显示设置", color = Color.Black) },
        text = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("在主界面显示人生剩余", color = Color.Black)
                Switch(
                    checked = mainActivity._showLifeRemaining.value,
                    onCheckedChange = {
                        mainActivity._showLifeRemaining.value = it
                        prefs.edit()
                            .putBoolean("show_life_remaining", it)
                            .apply()
                    }
                )
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("确定")
            }
        }
    )
}

@Composable
fun LifeDateSettingsDialog(
    settings: LifeTimeSettings,
    onDismiss: () -> Unit
) {
    val mainActivity = LocalContext.current as MainActivity
    // 修改默认日期为2005年8月6日
    var selectedDate by remember {
        mutableStateOf(
            settings.birthDate?.toLocalDate()
                ?: java.time.LocalDate.of(2005, 8, 6)
        )
    }
    var showEndDateOptions by remember { mutableStateOf(settings.birthDate != null) }
    var showCustomEndDatePicker by remember { mutableStateOf(false) }
    val prefs = mainActivity.getSharedPreferences("app_settings", Context.MODE_PRIVATE)

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("生命进度设置", color = Color.Black) },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // 出生日期设置
                Text("出生日期", color = Color.Black, fontWeight = FontWeight.Bold)
                DatePicker(
                    selectedDate = selectedDate,
                    onDateSelected = { date ->
                        selectedDate = date
                        val birthDateTime = date.atStartOfDay()
                        val newSettings = settings.copy(
                            birthDate = birthDateTime,
                            endDate = if (!settings.isCustomEndDate) {
                                // 如果不是自定义结束日期，则设置为80岁
                                birthDateTime.plusYears(80)
                            } else {
                                settings.endDate
                            }
                        )
                        mainActivity._lifeTimeSettings.value = newSettings
                        prefs.edit()
                            .putLong("birth_date", newSettings.birthDate?.atZone(java.time.ZoneId.systemDefault())?.toInstant()?.toEpochMilli() ?: -1)
                            .putLong("end_date", newSettings.endDate?.atZone(java.time.ZoneId.systemDefault())?.toInstant()?.toEpochMilli() ?: -1)
                            .putBoolean("is_custom_end_date", newSettings.isCustomEndDate)
                            .apply()
                        showEndDateOptions = true

                        // 如果已经设置了生日和预期寿命，自动开启人生剩余显示
                        if (newSettings.birthDate != null && newSettings.endDate != null) {
                            mainActivity._showLifeRemaining.value = true
                            prefs.edit()
                                .putBoolean("show_life_remaining", true)
                                .apply()
                        }
                    }
                )

                // 预期寿命设置
                if (showEndDateOptions) {
                    Text("预期寿命", color = Color.Black, fontWeight = FontWeight.Bold)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("自定义结束日期", color = Color.Black)
                        Switch(
                            checked = settings.isCustomEndDate,
                            onCheckedChange = { isCustom ->
                                val birthDate = settings.birthDate
                                if (birthDate != null) {
                                    val newSettings = settings.copy(
                                        isCustomEndDate = isCustom,
                                        endDate = if (!isCustom) {
                                            // 如果不是自定义，则设置为80岁
                                            birthDate.plusYears(80)
                                        } else {
                                            settings.endDate
                                        }
                                    )
                                    mainActivity._lifeTimeSettings.value = newSettings
                                    prefs.edit()
                                        .putLong("birth_date", newSettings.birthDate?.atZone(java.time.ZoneId.systemDefault())?.toInstant()?.toEpochMilli() ?: -1)
                                        .putLong("end_date", newSettings.endDate?.atZone(java.time.ZoneId.systemDefault())?.toInstant()?.toEpochMilli() ?: -1)
                                        .putBoolean("is_custom_end_date", newSettings.isCustomEndDate)
                                        .apply()
                                    showCustomEndDatePicker = isCustom
                                }
                            }
                        )
                    }

                    if (showCustomEndDatePicker) {
                        val endDate = settings.endDate?.toLocalDate() ?: selectedDate.plusYears(80)
                        DatePicker(
                            selectedDate = endDate,
                            onDateSelected = { date ->
                                val endDateTime = date.atStartOfDay()
                                val newSettings = settings.copy(
                                    endDate = endDateTime
                                )
                                mainActivity._lifeTimeSettings.value = newSettings
                                prefs.edit()
                                    .putLong("birth_date", newSettings.birthDate?.atZone(java.time.ZoneId.systemDefault())?.toInstant()?.toEpochMilli() ?: -1)
                                    .putLong("end_date", newSettings.endDate?.atZone(java.time.ZoneId.systemDefault())?.toInstant()?.toEpochMilli() ?: -1)
                                    .putBoolean("is_custom_end_date", newSettings.isCustomEndDate)
                                    .apply()

                                // 如果已经设置了生日和预期寿命，自动开启人生剩余显示
                                if (newSettings.birthDate != null && newSettings.endDate != null) {
                                    mainActivity._showLifeRemaining.value = true
                                    prefs.edit()
                                        .putBoolean("show_life_remaining", true)
                                        .apply()
                                }
                            }
                        )
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("确定")
            }
        }
    )
}

@Composable
fun DatePicker(
    selectedDate: java.time.LocalDate,
    onDateSelected: (java.time.LocalDate) -> Unit
) {
    var year by remember { mutableStateOf(selectedDate.year) }
    var month by remember { mutableStateOf(selectedDate.monthValue) }
    var day by remember { mutableStateOf(selectedDate.dayOfMonth) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // 年份选择
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("年份：$year", color = Color.Black)
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                IconButton(onClick = { year-- }) {
                    Text("-", color = Color.Black)
                }
                IconButton(onClick = { year++ }) {
                    Text("+", color = Color.Black)
                }
            }
        }

        // 月份选择
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("月份：$month", color = Color.Black)
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                IconButton(onClick = {
                    if (month > 1) month--
                }) {
                    Text("-", color = Color.Black)
                }
                IconButton(onClick = {
                    if (month < 12) month++
                }) {
                    Text("+", color = Color.Black)
                }
            }
        }

        // 日期选择
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("日期：$day", color = Color.Black)
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                IconButton(onClick = {
                    if (day > 1) day--
                }) {
                    Text("-", color = Color.Black)
                }
                IconButton(onClick = {
                    val maxDay = java.time.YearMonth.of(year, month).lengthOfMonth()
                    if (day < maxDay) day++
                }) {
                    Text("+", color = Color.Black)
                }
            }
        }

        // 确认按钮
        Button(
            onClick = {
                val date = try {
                    java.time.LocalDate.of(year, month, day)
                } catch (e: Exception) {
                    null
                }

                if (date != null) {
                    onDateSelected(date)
                }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("确认")
        }
    }
}

// 计算生命进度的工具函数
fun calculateLifeProgress(settings: LifeTimeSettings, currentTime: LocalDateTime = LocalDateTime.now()): Triple<Float, Long, Long> {
    val birthDate = settings.birthDate
    val endDate = settings.endDate

    if (birthDate == null || endDate == null) {
        return Triple(0f, 0, 0)
    }

    val totalDays = java.time.Duration.between(birthDate, endDate).toDays()
    val passedDays = java.time.Duration.between(birthDate, currentTime).toDays()
    val remainingDays = java.time.Duration.between(currentTime, endDate).toDays()

    val progress = passedDays.toFloat() / totalDays.toFloat()

    return Triple(progress.coerceIn(0f, 1f), passedDays, remainingDays)
}

@Composable
fun LifeProgressDisplaySettingsDialog(
    settings: LifeProgressDisplaySettings,
    onSettingsChange: (LifeProgressDisplaySettings) -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("显示设置", color = Color.Black) },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // 百分比设置
                Text("百分比设置", color = Color.Black, fontWeight = FontWeight.Bold)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (settings.showRemainingPercent) "显示剩余百分比" else "显示已过百分比",
                        color = Color.Black
                    )
                    Switch(
                        checked = settings.showRemainingPercent,
                        onCheckedChange = { onSettingsChange(settings.copy(showRemainingPercent = it)) }
                    )
                }

                // 百分比小数设置
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("显示小数", color = Color.Black)
                    Switch(
                        checked = settings.showDecimalPercent,
                        onCheckedChange = { onSettingsChange(settings.copy(showDecimalPercent = it)) }
                    )
                }

                Divider(color = Color.LightGray)

                // 单位设置说明
                Text("时间单位设置", color = Color.Black, fontWeight = FontWeight.Bold)
                Text(
                    text = "时间单位已与年度进度界面同步，请在年度进度界面中修改单位设置",
                    color = Color.Gray,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text("确定", color = Color.Black)
            }
        }
    )
}

@Composable
fun StarrySky(modifier: Modifier = Modifier) {
    val mainActivity = LocalContext.current as MainActivity
    val settings = mainActivity._yearProgressDisplaySettings.value

    if (!settings.enableRainEffect) {
        val stars = rememberStars(100, 0)
        val infiniteTransition = rememberInfiniteTransition(label = "stars")
        val starAlpha by infiniteTransition.animateFloat(
            initialValue = 0.3f,
            targetValue = 1f,
            animationSpec = infiniteRepeatable(
                animation = tween(1500, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = "star alpha"
        )

        Canvas(modifier = modifier.fillMaxSize()) {
            stars.forEach { star ->
                val currentTime = System.currentTimeMillis() / 1000f
                val flickerOffset = kotlin.math.sin(currentTime + star.phase)
                val radius = star.baseRadius * (1f + flickerOffset * 0.3f)
                val alpha = (starAlpha + flickerOffset * 0.2f).coerceIn(0.3f, 1f)

                drawCircle(
                    color = Color.White.copy(alpha = alpha),
                    radius = radius,
                    center = Offset(
                        x = star.x * size.width,
                        y = star.y * size.height
                    )
                )

                // 添加星光效果
                drawCircle(
                    color = Color.White.copy(alpha = alpha * 0.3f),
                    radius = radius * 2,
                    center = Offset(
                        x = star.x * size.width,
                        y = star.y * size.height
                    )
                )

                // 添加十字光芒效果
                val glowRadius = radius * 3
                drawLine(
                    color = Color.White.copy(alpha = alpha * 0.2f),
                    start = Offset(
                        x = star.x * size.width - glowRadius,
                        y = star.y * size.height
                    ),
                    end = Offset(
                        x = star.x * size.width + glowRadius,
                        y = star.y * size.height
                    ),
                    strokeWidth = 1f
                )
                drawLine(
                    color = Color.White.copy(alpha = alpha * 0.2f),
                    start = Offset(
                        x = star.x * size.width,
                        y = star.y * size.height - glowRadius
                    ),
                    end = Offset(
                        x = star.x * size.width,
                        y = star.y * size.height + glowRadius
                    ),
                    strokeWidth = 1f
                )
            }
        }
    }
}

@Composable
fun GridProgressPanel(
    modifier: Modifier = Modifier,
    textColor: Color
) {
    val mainActivity = LocalContext.current as MainActivity
    val yearProgressSettings = mainActivity._yearProgressDisplaySettings.value
    val lifeTimeSettings = mainActivity._lifeTimeSettings.value

    // 计算年度进度
    val progress = calculateYearProgress()
    val totalDays = 365
    val passedDays = (progress * totalDays).toInt()

    // 计算生日对应的天数
    val birthDayIndex = if (lifeTimeSettings.birthDate != null) {
        val birthDate = lifeTimeSettings.birthDate
        val currentYear = LocalDateTime.now().year
        val birthday = LocalDateTime.of(currentYear, birthDate.monthValue, birthDate.dayOfMonth, 0, 0)
        val startOfYear = LocalDateTime.of(currentYear, 1, 1, 0, 0)
        ChronoUnit.DAYS.between(startOfYear, birthday).toInt()
    } else {
        -1  // 如果没有设置生日，返回-1
    }

    // 生日格子的发光动画
    val birthdayGlow by rememberInfiniteTransition(label = "birthday").animateFloat(
        initialValue = 0.3f,
        targetValue = 0.8f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "birthday glow"
    )

    // 计算日夜背景色
    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val isNight = hour !in 6..18

    val backgroundColor = if (isNight) Color.Black else Color(0xFFF5F5F5)
    val gridLineColor = if (isNight) Color.White else Color.Black

    // 记录被点击的方块位置列表
    var selectedBoxes by remember { mutableStateOf(listOf<Pair<Int, Offset>>()) }

    // 记录每个方块的位置
    val boxPositions = remember { mutableMapOf<Int, Offset>() }

    Box(
        modifier = modifier
            .background(backgroundColor)
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    if (kotlin.math.abs(dragAmount.x) > kotlin.math.abs(dragAmount.y)) {
                        if (dragAmount.x > 10) {  // 右滑返回
                            mainActivity._showHourglassProgress.value = false
                        } else if (dragAmount.x < -10) {  // 左滑显示摆球界面
                            mainActivity._showPendulumBallPanel.value = true
                        }
                    }
                }
            }
    ) {
        // 星星效果和下雨效果
        if (yearProgressSettings.enableRainEffect) {
            RainEffect()
        } else {
            StarrySky(modifier = Modifier.fillMaxSize())
        }

        // 使用LazyVerticalGrid来自动适应屏幕大小
        LazyVerticalGrid(
            columns = GridCells.Fixed(26), // 增加列数以在一页显示所有365个方格
            modifier = Modifier
                .fillMaxSize()
                .padding(2.dp),
            horizontalArrangement = Arrangement.spacedBy(1.dp),
            verticalArrangement = Arrangement.spacedBy(1.dp),
            userScrollEnabled = false  // 禁用滚动，一页显示所有方格
        ) {
            items(totalDays) { dayIndex ->
                var isPressed by remember { mutableStateOf(false) }
                val isBirthday = dayIndex == birthDayIndex

                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .onGloballyPositioned { coordinates ->
                            // 记录方块的中心位置
                            val center = coordinates.boundsInRoot().center
                            boxPositions[dayIndex] = center
                        }
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onPress = {
                                    isPressed = true
                                    // 添加到选中列表
                                    boxPositions[dayIndex]?.let { pos ->
                                        if (selectedBoxes.none { it.first == dayIndex }) {
                                            selectedBoxes = selectedBoxes + (dayIndex to pos)
                                        }
                                    }
                                    tryAwaitRelease()
                                    isPressed = false
                                    // 如果超过5秒或选中超过5个方块，清除选中状态
                                    if (selectedBoxes.size >= 5) {
                                        selectedBoxes = emptyList()
                                    }
                                }
                            )
                        }
                        .scale(if (isPressed || selectedBoxes.any { it.first == dayIndex }) 1.2f else 1f)
                        .border(
                            width = 0.5.dp,
                            color = gridLineColor.copy(alpha = 0.3f),
                            shape = RoundedCornerShape(1.dp)
                        )
                        .background(
                            color = if (isBirthday) {
                                if (isNight) Color.White else Color.Yellow  // 生日格子：夜晚用白色，白天用黄色
                            } else if (dayIndex < passedDays) {
                                Color(0xFF2196F3)  // 已过去的日子用蓝色
                            } else {
                                textColor.copy(alpha = 0.1f)  // 未来的日子用半透明
                            },
                            shape = RoundedCornerShape(1.dp)
                        )
                ) {
                    if (isPressed || selectedBoxes.any { it.first == dayIndex }) {
                        Box(
                            modifier = Modifier
                                .matchParentSize()
                                .background(
                                    color = Color(0xFF64B5F6).copy(alpha = 0.5f),
                                    shape = RoundedCornerShape(1.dp)
                                )
                        )
                    }

                    // 生日格子的发光效果
                    if (isBirthday) {
                        Box(
                            modifier = Modifier
                                .matchParentSize()
                                .background(
                                    brush = Brush.radialGradient(
                                        colors = listOf(
                                            Color.White.copy(alpha = birthdayGlow),
                                            Color.White.copy(alpha = 0f)
                                        )
                                    ),
                                    shape = RoundedCornerShape(1.dp)
                                )
                        )
                    }
                }
            }
        }

        // 绘制闪电效果
        if (selectedBoxes.size >= 2) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                for (i in 0 until selectedBoxes.size - 1) {
                    val start = selectedBoxes[i].second
                    val end = selectedBoxes[i + 1].second

                    val path = Path()
                    path.moveTo(start.x, start.y)

                    // 在直线路径上添加随机偏移，创建闪电效果
                    val distance = kotlin.math.hypot(end.x - start.x, end.y - start.y)
                    val segments = (distance / 20).toInt().coerceAtLeast(2)

                    for (j in 1 until segments) {
                        val t = j.toFloat() / segments
                        val x = start.x + (end.x - start.x) * t
                        val y = start.y + (end.y - start.y) * t

                        // 添加随机偏移
                        val offsetX = (Random.nextFloat() - 0.5f) * 10
                        val offsetY = (Random.nextFloat() - 0.5f) * 10

                        path.lineTo(x + offsetX, y + offsetY)
                    }

                    path.lineTo(end.x, end.y)

                    // 绘制发光效果
                    drawPath(
                        path = path,
                        color = Color(0xFF64B5F6).copy(alpha = 0.8f),
                        style = Stroke(width = 3f)
                    )

                    // 绘制内部亮线
                    drawPath(
                        path = path,
                        color = Color.White.copy(alpha = 0.9f),
                        style = Stroke(width = 1f)
                    )
                }
            }
        }
    }

    // 自动清除选中状态
    LaunchedEffect(selectedBoxes) {
        if (selectedBoxes.isNotEmpty()) {
            delay(5000)
            selectedBoxes = emptyList()
        }
    }
}

@Composable
fun LifeGridProgressPanel(
    modifier: Modifier = Modifier,
    textColor: Color
) {
    val mainActivity = LocalContext.current as MainActivity
    val lifeTimeSettings = mainActivity._lifeTimeSettings.value
    val yearProgressSettings = mainActivity._yearProgressDisplaySettings.value

    // 使用by语法来自动处理State
    var currentSeconds by remember { mutableStateOf(0L) }
    var remainingSeconds by remember { mutableStateOf(0L) }
    
    // 判断是否为白天（6:00-18:00）
    val currentTime = LocalDateTime.now()
    val isDaytime = currentTime.hour in 6..18
    
    // 根据时间和下雨效果设置背景颜色
    val backgroundColor = if (!isDaytime) {
        Color.Black
    } else if (yearProgressSettings.enableRainEffect) {
        Color(0xFF808080)  // 下雨时使用灰色背景
    } else {
        Color(0xFFF5F5F5)  // 白天使用浅灰色背景
    }
    
    // 根据背景调整文字和元素颜色
    val elementColor = if (!isDaytime || yearProgressSettings.enableRainEffect) {
        Color.White
    } else {
        Color.Black
    }
    
    val pendulumColor = if (!isDaytime) {
        Color.White
    } else if (yearProgressSettings.enableRainEffect) {
        Color.White
    } else {
        Color(0xFF1976D2)  // 白天使用蓝色
    }

    // 每秒更新时间和秒数
    LaunchedEffect(lifeTimeSettings) {
        while(true) {
            val now = LocalDateTime.now()
            val birthDate = lifeTimeSettings.birthDate
            val endDate = lifeTimeSettings.endDate

            if (birthDate != null && endDate != null) {
                val birth = LocalDateTime.of(
                    birthDate.year,
                    birthDate.monthValue,
                    birthDate.dayOfMonth,
                    0, 0
                )

                // 计算已经过去的秒数
                currentSeconds = ChronoUnit.SECONDS.between(birth, now).coerceAtLeast(0)

                // 计算剩余的秒数
                remainingSeconds = ChronoUnit.SECONDS.between(now, endDate).coerceAtLeast(0)
            }

            delay(1000) // 每秒更新一次
        }
    }

    // 钟摆动画
    val infiniteTransition = rememberInfiniteTransition(label = "pendulum")
    val angle by infiniteTransition.animateFloat(
        initialValue = -30f,
        targetValue = 30f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pendulum angle"
    )

    // 呼吸动画
    val breatheAnimation by infiniteTransition.animateFloat(
        initialValue = 0.2f,
        targetValue = 0.8f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "breathe"
    )

    Box(
        modifier = modifier
            .background(backgroundColor)
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    if (kotlin.math.abs(dragAmount.x) > kotlin.math.abs(dragAmount.y)) {
                        if (dragAmount.x > 10) {  // 右滑返回
                            mainActivity._showPendulumBallPanel.value = false
                        }
                    }
                }
            }
    ) {
        // 钟摆
        Canvas(modifier = Modifier.fillMaxSize()) {
            val centerX = size.width / 2
            val topY = size.height * 0.2f
            val length = size.height * 0.4f
            val ballRadius = 20.dp.toPx()

            // 计算钟摆球的位置
            val radians = angle * (Math.PI / 180f).toFloat()
            val ballX = centerX + kotlin.math.sin(radians) * length
            val ballY = topY + kotlin.math.cos(radians) * length

            // 绘制钟摆线
            drawLine(
                color = pendulumColor.copy(alpha = 0.6f),
                start = Offset(centerX, topY),
                end = Offset(ballX, ballY),
                strokeWidth = 2.dp.toPx()
            )

            // 绘制钟摆球（空心带呼吸效果）
            drawCircle(
                color = pendulumColor.copy(alpha = breatheAnimation),
                radius = ballRadius,
                center = Offset(ballX, ballY),
                style = Stroke(width = 2.dp.toPx())
            )

            // 绘制外部发光效果
            drawCircle(
                color = pendulumColor.copy(alpha = breatheAnimation * 0.3f),
                radius = ballRadius * 1.5f,
                center = Offset(ballX, ballY),
                style = Stroke(width = 1.dp.toPx())
            )
        }

        // 显示秒数信息
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "$currentSeconds",
                fontSize = 24.sp,
                color = elementColor
            )
            Text(
                text = " | ",
                fontSize = 24.sp,
                color = elementColor,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Text(
                text = "$remainingSeconds",
                fontSize = 24.sp,
                color = elementColor
            )
        }
    }
}

// 一言API响应数据类
@Serializable
private data class HitokotoResponse(
    val hitokoto: String,
    val from: String
)

@Composable
private fun SongListContent(
    showEmptyMessage: Boolean,
    songList: List<String>,
    currentSong: String?,
    onSongClick: (String) -> Unit,
    textColor: Color
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "歌单：",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = textColor,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        if (showEmptyMessage) {
            Text(
                text = "正在初始化音乐播放器，请稍候...",
                fontSize = 14.sp,
                color = textColor,
                modifier = Modifier.padding(vertical = 2.dp)
            )
        } else if (songList.isEmpty()) {
            EmptySongListMessage(textColor = textColor)
        } else {
            LazyColumn(
                modifier = Modifier.heightIn(max = 200.dp)
            ) {
                itemsIndexed(
                    items = songList,
                    key = { index, item -> item }
                ) { _, song ->
                    val isCurrentSong = song == currentSong
                    Text(
                        text = if (isCurrentSong) "▶ $song" else "    $song",  // 使用空格保持对齐
                        fontSize = 14.sp,
                        color = textColor,
                        modifier = Modifier
                            .noRippleClickable(onClick = { onSongClick(song) })
                            .padding(vertical = 2.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun EmptySongListMessage(textColor: Color) {
    Column(
        modifier = Modifier.padding(vertical = 2.dp)
    ) {
        Text(
            text = "未找到音乐文件，请将音乐文件放入以下目录：",
            fontSize = 14.sp,
            color = textColor,
            modifier = Modifier.padding(vertical = 2.dp)
        )
        Text(
            text = "/storage/emulated/0/Music/ygbjmusic/",
            fontSize = 12.sp,
            color = textColor,
            modifier = Modifier.padding(vertical = 2.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "支持的音频格式：",
            fontSize = 14.sp,
            color = textColor,
            modifier = Modifier.padding(vertical = 2.dp)
        )
        Text(
            text = "MP3, WAV, OGG, M4A, FLAC",
            fontSize = 12.sp,
            color = textColor,
            modifier = Modifier.padding(vertical = 2.dp)
        )
    }
}

@Composable
fun MinimalUI(
    modifier: Modifier = Modifier,
    textColor: Color,
    onClose: () -> Unit
) {
    val currentTime = remember { mutableStateOf(LocalDateTime.now()) }
    val mainActivity = LocalContext.current as MainActivity
    var isDark by remember { mutableStateOf(false) }

    val backgroundColor by animateColorAsState(
        targetValue = if (isDark) Color.Black else Color.White,
        animationSpec = tween(500, easing = FastOutSlowInEasing),
        label = "background"
    )

    val mainTextColor by animateColorAsState(
        targetValue = if (isDark) Color.White else Color.Black,
        animationSpec = tween(500, easing = FastOutSlowInEasing),
        label = "text"
    )

    val currentDayColor by animateColorAsState(
        targetValue = if (isDark) Color.White else Color.Red,
        animationSpec = tween(500, easing = FastOutSlowInEasing),
        label = "current day"
    )

    LaunchedEffect(Unit) {
        while (true) {
            currentTime.value = LocalDateTime.now()
            delay(1000)
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                isDark = !isDark
            }
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    if (kotlin.math.abs(dragAmount.y) > kotlin.math.abs(dragAmount.x)) {
                        if (dragAmount.y < -10) {  // 上滑关闭
                            onClose()
                        } else if (dragAmount.y > 10) {  // 下滑打开关于页面
                            mainActivity._showAboutScreen.value = true
                        }
                    } else {
                        if (dragAmount.x < -10) {  // 左滑打开极简界面2
                            mainActivity._showMinimalClockUI.value = true
                        }
                    }
                }
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // 左侧时钟
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1.2f)  // 增加权重，给时间更多空间
                    .padding(start = 32.dp, end = 16.dp),  // 调整padding
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = currentTime.value.format(DateTimeFormatter.ofPattern("HH:mm")),
                    style = MaterialTheme.typography.displayLarge.copy(
                        fontSize = 180.sp,
                        fontWeight = FontWeight.Thin,
                        letterSpacing = (-8).sp
                    ),
                    color = mainTextColor,
                    softWrap = false
                )
            }

            // 右侧日历
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.8f)  // 减少日历的权重
                    .padding(start = 16.dp, end = 32.dp),  // 调整padding
                contentAlignment = Alignment.Center
            ) {
                CalendarDisplay(
                    currentTime = currentTime.value,
                    textColor = Color.Gray,
                    currentDayColor = currentDayColor
                )
            }
        }
    }
}

@Composable
private fun CalendarDisplay(
    currentTime: LocalDateTime,
    textColor: Color,
    currentDayColor: Color
) {
    val mainActivity = LocalContext.current as MainActivity

    // 检查是否是生日
    val isBirthday = remember(currentTime) {
        val birthDate = mainActivity._lifeTimeSettings.value.birthDate
        birthDate?.let {
            currentTime.monthValue == it.monthValue &&
                    currentTime.dayOfMonth == it.dayOfMonth
        } ?: false
    }

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.width(240.dp)
    ) {
        // 月份标题
        Text(
            text = if (isBirthday) "Happy Birthday" else currentTime.format(DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH)),
            style = MaterialTheme.typography.headlineMedium.copy(
                fontFamily = FontFamily.Monospace,
                fontSize = 28.sp,
                letterSpacing = 0.sp,
                fontWeight = FontWeight.Light
            ),
            color = textColor,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // 星期标题
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            listOf("S", "M", "T", "W", "T", "F", "S").forEach { day ->
                Text(
                    text = day,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontFamily = FontFamily.Monospace,
                        fontSize = 16.sp,
                        letterSpacing = 0.sp,
                        fontWeight = FontWeight.Light
                    ),
                    color = textColor,
                    modifier = Modifier.width(24.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 日期网格
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val calendar = Calendar.getInstance().apply {
                time = Date.from(currentTime.atZone(ZoneId.systemDefault()).toInstant())
            }
            val currentDay = calendar.get(Calendar.DAY_OF_MONTH)
            val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
            calendar.set(Calendar.DAY_OF_MONTH, 1)
            val firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1

            var dayCounter = 1
            repeat(6) { week ->
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    repeat(7) { dayOfWeek ->
                        if ((week == 0 && dayOfWeek < firstDayOfWeek) || dayCounter > daysInMonth) {
                            Text(
                                text = "  ",
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontFamily = FontFamily.Monospace,
                                    fontSize = 16.sp,
                                    letterSpacing = 0.sp,
                                    fontWeight = FontWeight.Light
                                ),
                                color = textColor,
                                modifier = Modifier.width(24.dp)
                            )
                        } else {
                            Text(
                                text = String.format("%02d", dayCounter),
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontFamily = FontFamily.Monospace,
                                    fontSize = 16.sp,
                                    letterSpacing = 0.sp,
                                    fontWeight = if (dayCounter == currentDay) FontWeight.Bold else FontWeight.Light
                                ),
                                color = if (dayCounter == currentDay) {
                                    if (isBirthday) Color(0xFFFFD700) else currentDayColor
                                } else textColor,
                                modifier = Modifier.width(24.dp)
                            )
                            dayCounter++
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier,
    onClose: () -> Unit
) {
    val mainActivity = LocalContext.current as MainActivity
    val surfaceColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.95f)
    val primaryColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.9f)
    val onSurfaceColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.9f)
    val onSurfaceVariantColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f)

    // 移除动态背景颜色，使用固定的白色背景
    val backgroundColor = Color.White

    // 使用固定的浅蓝色波浪
    val waveColor = Color(0xFF87CEEB)

    // 添加波浪动画所需的状态
    val infiniteTransition = rememberInfiniteTransition(label = "wave")
    val waveOffset1 by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 2f * Math.PI.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(7000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "wave offset 1"
    )

    val waveOffset2 by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 2f * Math.PI.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(5000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "wave offset 2"
    )

    val waveOffset3 by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 2f * Math.PI.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "wave offset 3"
    )

    // 计算生命进度
    val birthDate = LocalDateTime.of(2005, 8, 6, 0, 0)
    val endDate = LocalDateTime.of(2105, 8, 6, 0, 0)
    val currentTime = LocalDateTime.now()

    val totalDays = ChronoUnit.DAYS.between(birthDate, endDate)
    val passedDays = ChronoUnit.DAYS.between(birthDate, currentTime)
    val progress = (passedDays.toFloat() / totalDays.toFloat()).coerceIn(0f, 1f)

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
                    .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    if (kotlin.math.abs(dragAmount.y) > kotlin.math.abs(dragAmount.x)) {
                        if (dragAmount.y < -10) {  // 上滑关闭
                            onClose()
                        }
                    }
                }
            }
    ) {
        // 绘制波浪
        Canvas(modifier = Modifier.fillMaxSize()) {
            val width = size.width
            val height = size.height
            val waterHeight = height * (1 - progress)  // 使用生命进度计算水位高度

            fun drawWave(offset: Float, amplitude: Float, period: Float, alpha: Float) {
                val path = Path()

                // 计算倾斜偏移
                val tiltX = mainActivity.tiltX.value

                // 只在手机横放时（-45度到45度之间）检测倾斜
                val isHorizontal = mainActivity.tiltY.value > -45f && mainActivity.tiltY.value < 45f

                // 将倾斜角度转换为弧度，并根据横放状态调整灵敏度
                val tiltXRad = if (isHorizontal) {
                    (tiltX * Math.PI.toFloat() / 180f) * 4f
                } else {
                    0f
                }

                val extendedWidth = width * 2f
                val startX = -extendedWidth * 0.25f
                val endX = width + extendedWidth * 0.25f

                val baseWaterHeight = waterHeight + height * 0.02f

                path.moveTo(startX, baseWaterHeight)

                val step = 8f
                var x = startX
                while (x <= endX) {
                    val normalizedX = (x - startX) / width
                    val phase = normalizedX * 2f * Math.PI.toFloat() + offset

                    val waveHeight = amplitude * kotlin.math.sin(phase)

                    val tiltEffect = if (isHorizontal) {
                        val tiltFactor = kotlin.math.sin(-tiltXRad * 0.5f) * 0.8f
                        val distanceFromCenter = (x - width / 2f) / (width / 2f)
                        height * tiltFactor * distanceFromCenter * 0.5f
                    } else {
                        0f
                    }

                    val y = baseWaterHeight + waveHeight + tiltEffect

                    path.lineTo(x, y)
                    x += step
                }

                path.lineTo(endX, height)
                path.lineTo(startX, height)
                path.close()

                drawPath(
                    path = path,
                    color = waveColor.copy(alpha = alpha)  // 使用动态波浪颜色
                )
            }

            drawWave(waveOffset1, 25f, width / 2f, 0.3f)
            drawWave(waveOffset2, 20f, width / 3f, 0.2f)
            drawWave(waveOffset3, 15f, width / 4f, 0.1f)
        }

        // UI 内容
        Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(32.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.Top)  // 改为顶部对齐，并设置元素间距
) {
    Spacer(modifier = Modifier.height(5.dp))  // 顶部添加空间
            // Logo和应用名称
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // 检查是否是生日
                val currentDate = LocalDateTime.now()
                val isBirthday = remember(currentDate) {
                    val birthDate = mainActivity._lifeTimeSettings.value.birthDate
                    birthDate?.let {
                        currentDate.monthValue == it.monthValue &&
                                currentDate.dayOfMonth == it.dayOfMonth
                    } ?: false
                }

                // 分开管理上下文本的状态
                var headerClickCount by remember { mutableStateOf(0) }  // 专门用于控制顶部文本
                var quoteClickCount by remember { mutableStateOf(0) }   // 专门用于控制底部文本

                Text(
                    text = when {
                        // 国庆节和生日重合时，使用独立的 headerClickCount
                        mainActivity.isNationalDay(currentDate) && isBirthday -> when (headerClickCount % 2) {
                            0 -> "丹心向国"
                            else -> "生日快乐"
                        }
                        // 仅国庆节时
                        mainActivity.isNationalDay(currentDate) -> "丹心向国"
                        // 仅生日时
                        isBirthday -> "生日快乐"
                        // 普通日期
                        else -> "一个摆件"
                    },
                    style = MaterialTheme.typography.displayLarge.copy(
                        fontWeight = FontWeight.Light,
                        letterSpacing = 2.sp
                    ),
                    color = when {
                        mainActivity.isNationalDay(currentDate) && isBirthday -> if (headerClickCount % 2 == 0) Color(0xFFE53935) else Color(0xFFFFD700)
                        mainActivity.isNationalDay(currentDate) -> Color(0xFFE53935)
                        isBirthday -> Color(0xFFFFD700)
                        else -> primaryColor
                    },
                    modifier = if (mainActivity.isNationalDay(currentDate) && isBirthday) {
                        Modifier.clickable { headerClickCount++ }  // 使用 headerClickCount
                    } else {
                        Modifier
                    }
                )

                Text(
                    text = when {
                        // 国庆节和生日重合的情况，使用独立的 quoteClickCount
                        mainActivity.isNationalDay(currentDate) && isBirthday -> when (quoteClickCount % 4) {
                            0 -> "试看将来的环球"
                            1 -> "必是赤旗的世界"
                            2 -> "愿时光永远眷顾这一天"
                            3 -> "愿岁月静好，未来可期"
                            else -> "试看将来的环球"
                        }
                        // 其他情况保持不变...
                        mainActivity.isNationalDay(currentDate) -> when (quoteClickCount % 2) {
                            0 -> "试看将来的环球"
                            1 -> "必是赤旗的世界"
                            else -> "试看将来的环球"
                        }
                        // 仅生日的情况
                        isBirthday -> when (quoteClickCount % 2) {
                            0 -> "愿时光永远眷顾这一天"
                            1 -> "愿岁月静好，未来可期"
                            else -> "愿时光永远眷顾这一天"
                        }
                        // 普通日期的情况
                        else -> when (quoteClickCount % 2) {
                            0 -> "生命的意义不仅是活着"
                            1 -> "而是我们给予生命的意义"
                            else -> "生命的意义不仅是活着"
                        }
                    },
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Light,
                        letterSpacing = 4.sp
                    ),
                    color = onSurfaceVariantColor,
                    modifier = Modifier.clickable { quoteClickCount++ }
                )

                // 添加版本号显示的点击状态
                var versionClickCount by remember { mutableStateOf(0) }

                Text(
                    text = when {
                        // 国庆节和生日重合时
                        mainActivity.isNationalDay(currentDate) && isBirthday -> {
                            val birthDate = mainActivity._lifeTimeSettings.value.birthDate
                            val age = birthDate?.let {
                                ChronoUnit.YEARS.between(it, LocalDateTime.now())
                            } ?: 0
                            // 计算新中国成立周年
                            val chinaAge = currentDate.year - 1949
                            if (versionClickCount % 2 == 0) {
                                "v$chinaAge"  // 默认显示新中国成立周年
                            } else {
                                "v$age"       // 点击后显示实际年龄
                            }
                        }
                        // 仅国庆节时
                        mainActivity.isNationalDay(currentDate) -> {
                            val chinaAge = currentDate.year - 1949
                            "v$chinaAge"
                        }
                        // 仅生日时
                        isBirthday && mainActivity._lifeTimeSettings.value.birthDate != null -> {
                            val birthDate = mainActivity._lifeTimeSettings.value.birthDate
                            val age = birthDate?.let {
                                ChronoUnit.YEARS.between(it, LocalDateTime.now())
                            } ?: 0
                            "v$age"
                        }
                        // 普通日期
                        else -> "v3.0"
                    },
                    style = MaterialTheme.typography.bodyMedium,
                    color = onSurfaceVariantColor,
                    modifier = if (mainActivity.isNationalDay(currentDate) && isBirthday) {
                        // 只在国庆和生日重合时允许点击切换
                        Modifier
                            .padding(top = 8.dp)
                            .clickable { versionClickCount++ }
                    } else {
                        Modifier.padding(top = 8.dp)
                    }
                )
            }

            Spacer(modifier = Modifier.height(1.dp))  // 减小为原来的三分之一

            // 致谢按钮
            var showCreditsDialog by remember { mutableStateOf(false) }

            TextButton(
                onClick = { showCreditsDialog = true }
            ) {
                Text(
                    text = "致谢名单",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        letterSpacing = 1.sp
                    ),
                    color = primaryColor
                )
            }

            // 开发者详情弹窗
            if (showCreditsDialog) {
                var showFriendDialog by remember { mutableStateOf(false) }  // 移到这里

                AlertDialog(
                    onDismissRequest = { showCreditsDialog = false },
                    title = {
                        Text(
                            text = if (mainActivity.isNationalDay(LocalDateTime.now())) "感恩有您" else "致谢名单",
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    },
                    text = {
                        Column(
                modifier = Modifier
                                .fillMaxWidth()
                                .verticalScroll(rememberScrollState()),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            if (mainActivity.isNationalDay(LocalDateTime.now())) {
                                // 革命先辈部分
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(
                                        text = "革命先辈",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFE53935)
                                    )
                                    Text(
                                        text = "毛泽东 | 周恩来 | 朱德 | 刘少奇 | 邓小平",
                                        textAlign = TextAlign.Center
                                    )
                                    Text(
                                        text = "陈云 | 彭德怀 | 刘伯承 | 贺龙 | 陈毅",
                                        textAlign = TextAlign.Center
                                    )
                                    Text(
                                        text = "罗荣桓 | 徐向前 | 聂荣臻 | 叶剑英",
                                        textAlign = TextAlign.Center
                                    )

                                    Spacer(modifier = Modifier.height(16.dp))

                                    // 科学家部分
                                    Text(
                                        text = "科学家",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFE53935)
                                    )
                                    Text(
                                        text = "钱学森 | 华罗庚 | 邓稼先 | 袁隆平 | 屠呦呦",
                                        textAlign = TextAlign.Center
                                    )

                                    Spacer(modifier = Modifier.height(16.dp))

                                    // 英雄模范部分
                                    Text(
                                        text = "英雄模范",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFE53935)
                                    )
                                    Text(
                                        text = "雷锋 | 焦裕禄 | 孔繁森",
                                        textAlign = TextAlign.Center
                                    )

                                    Spacer(modifier = Modifier.height(16.dp))

                                    // 人民子弟兵部分
                                    Text(
                                        text = "人民子弟兵",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFE53935)
                                    )
                                    Text(
                                        text = "中国人民解放军全体官兵",
                                        textAlign = TextAlign.Center
                                    )

                                    Spacer(modifier = Modifier.height(16.dp))

                                    // 各行各业劳动者部分
                                    Text(
                                        text = "各行各业劳动者",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFE53935)
                                    )
                                    Text(
                                        text = "工人 | 农民 | 教师 | 医生",
                                        textAlign = TextAlign.Center
                                    )
                                    Text(
                                        text = "科研人员 | 企业家 | 公务员",
                                        textAlign = TextAlign.Center
                                    )

                                    Spacer(modifier = Modifier.height(16.dp))

                                    // 国际友人部分
                                    Text(
                                        text = "国际友人",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFFE53935)
                                    )
                                    Text(
                                        text = "白求恩 | 埃德加·斯诺 | 路易·艾黎",
                                        textAlign = TextAlign.Center
                                    )

                                    Spacer(modifier = Modifier.height(16.dp))

                                    // 结语
                                    Text(
                                        text = "以及每个为新中国成立而做出贡献的同志！",
                                        textAlign = TextAlign.Center,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = Color(0xFFE53935)
                                    )
                                    Text(
                                        text = "他们的伟大是几千行代码写不下的！",
                                        textAlign = TextAlign.Center,
                                        style = MaterialTheme.typography.bodyMedium,
                                        color = Color(0xFFE53935)
                                    )
                                }
                            } else {
                                // 首席测试部分
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "首席测试：",
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = FontWeight.Bold
                                    )
                                    ClickableText(
                                        text = buildAnnotatedString {
                                            withStyle(
                                                style = SpanStyle(
                                                    color = MaterialTheme.colorScheme.onSurface,
                                                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                                                )
                                            ) {
                                                append("酷安@发旧的情书")
                                            }
                                        },
                                        onClick = {
                                            try {
                                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("coolmarket://www.coolapk.com/u/9907460"))
                                                intent.setPackage("com.coolapk.market")
                                                mainActivity.startActivity(intent)
                                            } catch (e: Exception) {
                                                val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.coolapk.com/u/9907460"))
                                                mainActivity.startActivity(webIntent)
                                            }
                                        },
                                        style = TextStyle(textAlign = TextAlign.Center)
                                    )
                                }

                                // 彩蛋配音部分
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "彩蛋配音：",
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = FontWeight.Bold
                                    )
                                    
                                    // 添加谭如意的点击状态
                                    var showTanVoiceDialog by remember { mutableStateOf(false) }
                                    
                                    // 将谭如意的文本改为可点击
                                    ClickableText(
                                        text = buildAnnotatedString {
                                            withStyle(
                                                style = SpanStyle(
                                                    color = MaterialTheme.colorScheme.onSurface,
                                                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                                                )
                                            ) {
                                                append("重庆幼儿师范高等专科学校在读学生谭如意")
                                            }
                                        },
                                        onClick = { showTanVoiceDialog = true },
                                        style = TextStyle(textAlign = TextAlign.Center)
                                    )
                                    
                                    // 谭如意的弹窗
                                    if (showTanVoiceDialog) {
                                        AlertDialog(
                                            onDismissRequest = { showTanVoiceDialog = false },
                                            title = {
                                                Text(
                                                    text = "配音作品",
                                                    style = MaterialTheme.typography.titleMedium,
                                                    modifier = Modifier.fillMaxWidth(),
                                                    textAlign = TextAlign.Center
                                                )
                                            },
                                            text = {
                                                Column(
                                                    modifier = Modifier.fillMaxWidth(),
                                                    horizontalAlignment = Alignment.CenterHorizontally,
                                                    verticalArrangement = Arrangement.spacedBy(8.dp)
                                                ) {
                                                    Text(
                                                        text = "《三天光明》和数个未使用到软件的音频",
                                                        style = MaterialTheme.typography.bodyMedium
                                                    )
                                                }
                                            },
                                            confirmButton = {
                                                TextButton(onClick = { showTanVoiceDialog = false }) {
                                                    Text("关闭")
                                                }
                                            }
                                        )
                                    }
                                    
                                    // 姚红的点击状态
                                    var showYaoVoiceDialog by remember { mutableStateOf(false) }
                                    
                                    // 姚红的可点击文本
                                    ClickableText(
                                        text = buildAnnotatedString {
                                            withStyle(
                                                style = SpanStyle(
                                                    color = MaterialTheme.colorScheme.onSurface,
                                                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                                                )
                                            ) {
                                                append("同学：姚红")
                                            }
                                        },
                                        onClick = { showYaoVoiceDialog = true },
                                        style = TextStyle(textAlign = TextAlign.Center)
                                    )
                                    
                                    // 姚红的弹窗
                                    if (showYaoVoiceDialog) {
                                        AlertDialog(
                                            onDismissRequest = { showYaoVoiceDialog = false },
                                            title = {
                                                Text(
                                                    text = "配音作品",
                                                    style = MaterialTheme.typography.titleMedium,
                                                    modifier = Modifier.fillMaxWidth(),
                                                    textAlign = TextAlign.Center
                                                )
                                            },
                                            text = {
                                                Column(
                                                    modifier = Modifier.fillMaxWidth(),
                                                    horizontalAlignment = Alignment.CenterHorizontally,
                                                    verticalArrangement = Arrangement.spacedBy(8.dp)
                                                ) {
                                                    Text(
                                                        text = "《过期的蛋糕》",
                                                        style = MaterialTheme.typography.bodyMedium
                                                    )
                                                    Text(
                                                        text = "《旅程的终点》",
                                                        style = MaterialTheme.typography.bodyMedium
                                                    )
                                                    Text(
                                                        text = "《新的岁月》",
                                                        style = MaterialTheme.typography.bodyMedium
                                                    )
                                                }
                                            },
                                            confirmButton = {
                                                TextButton(onClick = { showYaoVoiceDialog = false }) {
                                                    Text("关闭")
                                                }
                                            }
                                        )
                                    }
                                }

                                // 默认壁纸部分
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "默认壁纸：",
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = "Pexels@Simon Migaj",
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                    ClickableText(
                                        text = buildAnnotatedString {
                                            withStyle(
                                                style = SpanStyle(
                                                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                                                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                                                )
                                            ) {
                                                append("「Person Standing on Slope Glacier Mountain」")
                                            }
                                        },
                                        onClick = {
                                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(
                                                "https://www.pexels.com/photo/person-standing-on-slope-glacier-mountain-1081111/"
                                            ))
                                            mainActivity.startActivity(intent)
                                        },
                modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(top = 4.dp),
                                        style = TextStyle(
                                            textAlign = TextAlign.Center,
                                            fontSize = MaterialTheme.typography.bodyMedium.fontSize
                                        )
                                    )
                                }

                                // 友情串客部分
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        text = "友情串客：",
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontWeight = FontWeight.Bold
                                    )
                                    ClickableText(
                                        text = buildAnnotatedString {
                                            withStyle(
                                                style = SpanStyle(
                                                    color = MaterialTheme.colorScheme.onSurface,
                                                    fontSize = MaterialTheme.typography.bodyMedium.fontSize
                                                )
                                            ) {
                                                append("职高好友肖杭")
                                            }
                                        },
                                        onClick = { showFriendDialog = true },
                                        style = TextStyle(textAlign = TextAlign.Center)
                                    )
                                }
                                Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = Modifier.padding(top = 16.dp)
) {
    Text(
        text = "宣传大使：",
        style = MaterialTheme.typography.bodyMedium,
        fontWeight = FontWeight.Bold
    )
    Text(
        text = "重庆幼儿师范高等专科学校李金桂",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurface,
        textAlign = TextAlign.Center
    )
}
                            }
                        }
                    },
                    confirmButton = {
                        TextButton(onClick = { showCreditsDialog = false }) {
                            Text("关闭")
                        }
                    }
                )

                // 友情串客详情弹窗
                if (showFriendDialog) {
                    AlertDialog(
                        onDismissRequest = { showFriendDialog = false },
                        title = null,
                        text = {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .verticalScroll(rememberScrollState()),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                // 头像
                                Image(
                                    painter = painterResource(id = R.raw.xh),
                                    contentDescription = "肖杭头像",
                                    modifier = Modifier
                                        .size(120.dp)
                                        .clip(CircleShape)
                                        .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape),
                                    contentScale = ContentScale.Crop
                                )

                                // 名字
                                Text(
                                    text = "肖杭",
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.Bold
                                )

                                // 添加描述文字
                                Text(
                                    text = "职高好友，感谢职高多年来的帮助。",
                                    style = MaterialTheme.typography.bodyMedium,
                                    textAlign = TextAlign.Center,
                                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                                )

                                // 社交链接
                                Row(
                                    horizontalArrangement = Arrangement.Center,
                                    modifier = Modifier.padding(top = 8.dp)
                                ) {
                                    IconButton(
                                        onClick = {
                                            try {
                                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("coolmarket://www.coolapk.com/u/21093552"))
                                                intent.setPackage("com.coolapk.market")
                                                mainActivity.startActivity(intent)
                                            } catch (e: Exception) {
                                                val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.coolapk.com/u/21093552"))
                                                mainActivity.startActivity(webIntent)
                                            }
                                        }
                                    ) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.coolapk),
                                            contentDescription = "酷安",
                                            modifier = Modifier.size(28.dp),
                                            tint = MaterialTheme.colorScheme.onSurface
                                        )
                                    }
                                }
                            }
                        },
                        confirmButton = {
                            TextButton(onClick = { showFriendDialog = false }) {
                                Text("关闭")
                            }
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(1.dp))  // 减小为原来的三分之一

            // 开发者信息
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(1.dp),  // 减少元素间距
    modifier = Modifier.padding(bottom = 1.dp)  // 添加底部padding，让后面的元素靠近一些
            ) {
                if (!mainActivity.isNationalDay(LocalDateTime.now())) {
                    Text(
                        text = "开发者",
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Light,
                            letterSpacing = 1.sp
                        ),
                        color = onSurfaceColor
                    )
                }

                var showDeveloperDialog by remember { mutableStateOf(false) }
                // 删除这行，因为友情串客的对话框状态已经在致谢名单弹窗中定义了
                // var showFriendDialog by remember { mutableStateOf(false) }

                // 开发者信息
                // 开发者信息
ClickableText(
    text = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = onSurfaceVariantColor,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                letterSpacing = 1.sp
            )
        ) {
            append(if (mainActivity.isNationalDay(LocalDateTime.now()))
                "中华人民共和国万岁"
            else
                "酷安：@请叫我徐总"
            )
        }
    },
    onClick = { showDeveloperDialog = true },
    style = TextStyle(textAlign = TextAlign.Center)
)
Spacer(modifier = Modifier.height(8.dp))
Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.spacedBy(0.dp),  // 使用非常紧凑的间距
    modifier = Modifier.padding(top = 0.dp)  // 减少顶部间距
) {
// 备案号（保留原来的ClickableText内容）
ClickableText(
    text = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = onSurfaceVariantColor,
                fontSize = MaterialTheme.typography.bodySmall.fontSize,
                letterSpacing = 0.5.sp
            )
        ) {
            append("渝ICP备2025053053号-2A")
        }
    },
    onClick = { 
        // 点击跳转到工信部备案管理系统网站
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://beian.miit.gov.cn/"))
        mainActivity.startActivity(intent)
    },
    style = TextStyle(textAlign = TextAlign.Center)
)

// 使用Row将隐私政策和用户协议放在同一行
Row(
    horizontalArrangement = Arrangement.Center,
    modifier = Modifier.padding(top = 0.dp)  // 减少顶部间距
) {
    // 隐私政策链接
    ClickableText(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    letterSpacing = 0.5.sp
                )
            ) {
                append("隐私政策")
            }
        },
        onClick = { 
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.petehsu.xyz/yigebaijian-legal/privacy-policy.html"))
            mainActivity.startActivity(intent)
        },
        style = TextStyle(textAlign = TextAlign.Center)
    )
    
    // 间隔线
    Text(
        text = " | ",
        style = MaterialTheme.typography.bodySmall,
        color = onSurfaceVariantColor,
        modifier = Modifier.padding(horizontal = 4.dp)
    )
    
    // 用户协议链接
    ClickableText(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    letterSpacing = 0.5.sp
                )
            ) {
                append("用户协议")
            }
        },
        onClick = { 
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.petehsu.xyz/yigebaijian-legal/user-agreement.html"))
            mainActivity.startActivity(intent)
        },
        style = TextStyle(textAlign = TextAlign.Center)
    )
    }
}

                // 开发者详情弹窗
                if (showDeveloperDialog) {
                    AlertDialog(
                        onDismissRequest = { showDeveloperDialog = false },
                        title = null,
                        text = {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .verticalScroll(rememberScrollState()),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                if (mainActivity.isNationalDay(LocalDateTime.now())) {
                                    // 国庆节期间显示国旗和介绍文本
                                    Image(
                                        painter = painterResource(id = R.raw.guoqi),
                                        contentDescription = "国旗",
                                        modifier = Modifier
                                            .size(120.dp)
                                            .clickable {
                                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gov.cn/"))
                                                mainActivity.startActivity(intent)
                                            },
                                        contentScale = ContentScale.Fit
                                    )

                                    Text(
                                        text = "中华人民共和国国旗",
                                        style = MaterialTheme.typography.titleLarge,
                                        fontWeight = FontWeight.Bold
                                    )

                                    Text(
                                        text = "中国，宛如一部气势恢宏的史书，承载着五千年璀璨文明。她坐落于亚洲东部，幅员辽阔，人口众多，是当之无愧的东方巨龙。如今，中国在经济、科技等领域展翅腾飞，正向着民族复兴的伟大梦想奋勇前行，奏响时代最强音。",
                                        style = MaterialTheme.typography.bodyMedium,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.padding(horizontal = 16.dp)
                                    )
                                } else {
                                    // 普通时期显示开发者信息
                                    Image(
    painter = painterResource(id = R.raw.tx),
    contentDescription = "开发者头像",
    modifier = Modifier
        .size(120.dp)
        .clip(CircleShape)
        .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
        .clickable {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.petehsu.xyz/"))
            mainActivity.startActivity(intent)
        },
    contentScale = ContentScale.Crop
)

                                    Text(
                                        text = "徐远豪",
                                        style = MaterialTheme.typography.titleLarge,
                                        fontWeight = FontWeight.Bold
                                    )

                                    // 计算年龄
                                    val birthDate = LocalDateTime.of(2005, 8, 6, 0, 0)
                                    val age = ChronoUnit.YEARS.between(birthDate, LocalDateTime.now())

                                    Text(
                                        text = "${age}岁重庆幼儿师范高等专科学校在读大专生",
                                        style = MaterialTheme.typography.bodyMedium,
                                        textAlign = TextAlign.Center
                                    )

                                    Spacer(modifier = Modifier.height(8.dp))

                                    // 只在非国庆节期间显示社交链接
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(24.dp),
                                        modifier = Modifier.padding(top = 8.dp)
                                    ) {
                                        IconButton(
                                            onClick = {
                                                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/petehsu"))
                                                mainActivity.startActivity(intent)
                                            }
                                        ) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.github),
                                                contentDescription = "Github",
                                                modifier = Modifier.size(28.dp),
                                                tint = MaterialTheme.colorScheme.onSurface
                                            )
                                        }

                                        IconButton(
                                            onClick = {
                                                try {
                                                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("coolmarket://www.coolapk.com/u/6717911"))
                                                    intent.setPackage("com.coolapk.market")
                                                    mainActivity.startActivity(intent)
                                                } catch (e: Exception) {
                                                    val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.coolapk.com/u/6717911"))
                                                    mainActivity.startActivity(webIntent)
                                                }
                                            }
                                        ) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.coolapk),
                                                contentDescription = "酷安",
                                                modifier = Modifier.size(28.dp),
                                                tint = MaterialTheme.colorScheme.onSurface
                                            )
                                        }
                                    }
                                }
                            }
                        },
                        confirmButton = {
                            TextButton(onClick = { showDeveloperDialog = false }) {
                                Text("关闭")
                            }
                        }
                    )
                }

                // 删除这个 Spacer
                // Spacer(modifier = Modifier.height(16.dp))

                // 删除整个友情串客部分（包括 Column、Text、ClickableText 和相关的弹窗）
            }
        }
    }
}

@Composable
fun MinimalClockUI(
    modifier: Modifier = Modifier,
    onClose: () -> Unit
) {
    val currentTime = remember { mutableStateOf(LocalDateTime.now()) }
    val mainActivity = LocalContext.current as MainActivity
    var isDark by remember { mutableStateOf(true) }  // 默认为暗色模式

    val backgroundColor by animateColorAsState(
        targetValue = if (isDark) Color.Black else Color.White,
        animationSpec = tween(500, easing = FastOutSlowInEasing),
        label = "background"
    )

    val clockHandsColor by animateColorAsState(
        targetValue = if (isDark) Color.White else Color.Black,
        animationSpec = tween(500, easing = FastOutSlowInEasing),
        label = "clock hands"
    )

    val timeTextColor by animateColorAsState(
        targetValue = if (isDark) Color.White else Color.Black,
        animationSpec = tween(500, easing = FastOutSlowInEasing),
        label = "time text"
    )

    val arcColor by animateColorAsState(
        targetValue = if (isDark) Color.White else Color.Red,
        animationSpec = tween(500, easing = FastOutSlowInEasing),
        label = "arc"
    )

    // 添加纳秒精度的动画值
    val animatedSecond by remember(currentTime.value) {
        mutableStateOf(currentTime.value.second + currentTime.value.nano / 1_000_000_000f)
    }

    LaunchedEffect(Unit) {
        while (true) {
            currentTime.value = LocalDateTime.now()
            delay(8)  // 约120fps的更新频率，提高毫秒显示流畅度
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                isDark = !isDark
            }
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    if (kotlin.math.abs(dragAmount.x) > kotlin.math.abs(dragAmount.y)) {
                        if (dragAmount.x > 10) {  // 右滑返回
                            onClose()
                        } else if (dragAmount.x < -10) {  // 左滑打开极简界面3
                            mainActivity._showMinimalClockUI2.value = true
                        }
                    }
                }
            }
    ) {
        Row(
                modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Canvas(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val center = Offset(size.width / 2, size.height / 2)
                    val radius = size.minDimension / 2 * 0.9f

                    // 绘制灰色背景圆圈
                    drawCircle(
                        color = Color.Gray.copy(alpha = 0.15f),  // 降低透明度从0.3f到0.15f
                        radius = radius,
                        center = center,
                        style = Stroke(width = 1.dp.toPx())
                    )

                    // 计算当前时间的角度
                    val hour = currentTime.value.hour % 12
                    val minute = currentTime.value.minute

                    val hourAngle = (hour * 30 + minute * 0.5f) * (Math.PI / 180f).toFloat()
                    val minuteAngle = minute * 6 * (Math.PI / 180f).toFloat()

                    // 使用animatedSecond计算角度
                    val arcLength = 90f  // 增加弧线长度到90度
                    val secondAngle = animatedSecond * 6f - arcLength / 2

                    // 创建特殊画笔
                    val arcPaint = android.graphics.Paint().apply {
                        style = android.graphics.Paint.Style.STROKE
                        strokeCap = android.graphics.Paint.Cap.ROUND
                        isAntiAlias = true

                        // 创建渐变
                        shader = android.graphics.LinearGradient(
                            0f, 0f, size.width, 0f,
                            intArrayOf(
                                Color.Transparent.toArgb(),
                                arcColor.toArgb(),
                                arcColor.toArgb(),
                                Color.Transparent.toArgb()
                            ),
                            floatArrayOf(0f, 0.3f, 0.7f, 1f),
                            android.graphics.Shader.TileMode.CLAMP
                        )

                        // 创建路径效果，实现两端细中间粗的效果
                        val intervals = FloatArray(180) { i ->
                            val progress = i / 180f
                            val distanceFromCenter = kotlin.math.abs(progress - 0.5f) * 2
                            val width = if (progress in 0.3f..0.7f) {
                                1.5.dp.toPx()  // 减小中间部分的粗度
                            } else {
                                1.5.dp.toPx() * (1 - distanceFromCenter).pow(3).toFloat()  // 保持相同的过渡效果
                            }
                            width
                        }
                        this.strokeWidth = 1.5.dp.toPx()  // 减小基础线条粗度
                    }

                    // 使用drawIntoCanvas绘制弧线
                    drawIntoCanvas { canvas ->
                        canvas.nativeCanvas.drawArc(
                            center.x - radius,
                            center.y - radius,
                            center.x + radius,
                            center.y + radius,
                            secondAngle,
                            arcLength,
                            false,
                            arcPaint
                        )
                    }

                    // 绘制时针
                    drawLine(
                        color = clockHandsColor,
                        start = center,
                        end = Offset(
                            x = center.x + kotlin.math.sin(hourAngle) * radius * 0.4f,
                            y = center.y - kotlin.math.cos(hourAngle) * radius * 0.4f
                        ),
                        strokeWidth = 1.5.dp.toPx(),
                        cap = StrokeCap.Round
                    )

                    // 绘制分针
                    drawLine(
                        color = clockHandsColor,
                        start = center,
                        end = Offset(
                            x = center.x + kotlin.math.sin(minuteAngle) * radius * 0.6f,
                            y = center.y - kotlin.math.cos(minuteAngle) * radius * 0.6f
                        ),
                        strokeWidth = 1.dp.toPx(),
                        cap = StrokeCap.Round
                    )
                }
            }

            // 数字时间显示部分
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 48.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = currentTime.value.format(DateTimeFormatter.ofPattern("HH:mm")),
                    color = timeTextColor,
                    fontSize = 64.sp,
                    fontWeight = FontWeight.ExtraLight
                )
                Text(
                    text = currentTime.value.format(DateTimeFormatter.ofPattern("ss")),
                    color = timeTextColor.copy(alpha = 0.7f),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraLight
                )
            }
        }
    }
}

@Composable
fun YearProgressUI(
    modifier: Modifier = Modifier,
    textColorMain: Color,
    textColorSecondary: Color
) {
    val currentTime = remember { mutableStateOf(LocalDateTime.now()) }

    LaunchedEffect(Unit) {
        while (true) {
            currentTime.value = LocalDateTime.now()
            delay(1000)
        }
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = currentTime.value.format(DateTimeFormatter.ofPattern("HH:mm")),
                color = textColorMain,
                fontSize = 64.sp,
                fontWeight = FontWeight.ExtraLight
            )
            Text(
                text = currentTime.value.format(DateTimeFormatter.ofPattern("yyyy.MM.dd")),
                color = textColorSecondary,
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraLight
            )
        }
    }
}

// 添加新的极简界面3
@Composable
fun MinimalClockUI2(
    modifier: Modifier = Modifier,
    onClose: () -> Unit
) {
    val currentTime = remember { mutableStateOf(LocalDateTime.now()) }
    val mainActivity = LocalContext.current as MainActivity
    var isDark by remember { mutableStateOf(true) }  // 默认为暗色模式

    val backgroundColor by animateColorAsState(
        targetValue = if (isDark) Color.Black else Color.White,
        animationSpec = tween(500, easing = FastOutSlowInEasing),
        label = "background"
    )

    val timeTextColor by animateColorAsState(
        targetValue = if (isDark) Color.White else Color.Black,
        animationSpec = tween(500, easing = FastOutSlowInEasing),
        label = "time text"
    )

    LaunchedEffect(Unit) {
        while (true) {
            currentTime.value = LocalDateTime.now()
            delay(1000)
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                isDark = !isDark
            }
                    .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    if (kotlin.math.abs(dragAmount.x) > kotlin.math.abs(dragAmount.y)) {
                        if (dragAmount.x > 10) {  // 右滑返回
                            onClose()
                        } else if (dragAmount.x < -10) {  // 左滑打开极简界面4
                            mainActivity._showMinimalClockUI3.value = true
                        }
                    }
                }
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = currentTime.value.format(DateTimeFormatter.ofPattern("HH:mm")),
            style = MaterialTheme.typography.displayLarge.copy(
                fontSize = 320.sp,  // 从240.sp增加到320.sp
                fontWeight = FontWeight.ExtraBold,  // 从Bold改为ExtraBold
                letterSpacing = (-12).sp  // 调整字母间距以适应更大的字体
            ),
            color = timeTextColor
        )
    }
}

// 添加新的极简界面4
@Composable
fun MinimalClockUI3(
    modifier: Modifier = Modifier,
    onClose: () -> Unit
) {
    val currentTime = remember { mutableStateOf(LocalDateTime.now()) }
    val mainActivity = LocalContext.current as MainActivity
    var isDark by remember { mutableStateOf(true) }

    val backgroundColor by animateColorAsState(
        targetValue = if (isDark) Color.Black else Color.White,
        animationSpec = tween(500, easing = FastOutSlowInEasing),
        label = "background"
    )

    val textColor by animateColorAsState(
        targetValue = if (isDark) Color.White else Color.Black,
        animationSpec = tween(500, easing = FastOutSlowInEasing),
        label = "text"
    )

    LaunchedEffect(Unit) {
        while (true) {
            currentTime.value = LocalDateTime.now()
            delay(1000)
        }
    }

    LaunchedEffect(Unit) {
        try {
            val response = withContext(Dispatchers.IO) {
                URL("https://v1.hitokoto.cn/?c=i&encode=text").readText()
            }
            mainActivity._hitokoto.value = response
        } catch (e: Exception) {
            mainActivity._hitokoto.value = "生命的意义不仅是活着，而是我们给予生命的意义。"
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                isDark = !isDark
            }
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    if (kotlin.math.abs(dragAmount.x) > kotlin.math.abs(dragAmount.y)) {
                        if (dragAmount.x > 10) {  // 右滑返回
                            onClose()
                        }
                    }
                }
            }
            .padding(32.dp),  // 移动padding到这里
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))

        // 时间
        Text(
            text = currentTime.value.format(DateTimeFormatter.ofPattern("HH:mm")),
            style = MaterialTheme.typography.displayLarge.copy(
                fontSize = 180.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = (-8).sp
            ),
            color = textColor
        )

        // 日期
        Text(
            text = currentTime.value.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日")),
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Light,
                letterSpacing = 4.sp
            ),
            color = textColor.copy(alpha = 0.7f)
        )

        Spacer(modifier = Modifier.weight(1f))

        // 一言
        Text(
            text = mainActivity._hitokoto.value,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Light,
                letterSpacing = 2.sp,
                fontSize = 18.sp
            ),
            color = textColor.copy(alpha = 0.5f),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(horizontal = 48.dp)
                .padding(bottom = 48.dp)
        )
    }
}

// 添加生日彩蛋界面包装器
@Composable
fun BirthdayScreenWrapper(mainActivity: MainActivity) {
    AnimatedVisibility(
        visible = mainActivity._showBirthdayScreen.value,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        BirthdayScreen()
    }
}

// 添加生日彩蛋界面
@Composable
fun BirthdayScreen() {
    val mainActivity = LocalContext.current as MainActivity
    var currentMessageIndex by remember { mutableStateOf(0) }
    var showCurrentMessage by remember { mutableStateOf(true) }
    // 添加音频完成状态
    var isAudioCompleted by remember { mutableStateOf(false) }

    // 添加音频播放完成监听
    LaunchedEffect(Unit) {
        mainActivity.startBirthdayMusic()
        // 监听音频播放完成
        mainActivity.birthdayMediaPlayer?.setOnCompletionListener {
            isAudioCompleted = true
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            mainActivity.stopBirthdayMusic()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = showCurrentMessage,
            enter = fadeIn(
                animationSpec = tween(1000, easing = LinearEasing)
            ),
            exit = fadeOut(
                animationSpec = tween(1000, easing = LinearEasing)
            )
        ) {
            if (currentMessageIndex < mainActivity.birthdayMessages.size) {
                Text(
                    text = mainActivity.birthdayMessages[currentMessageIndex].text,
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 32.dp)
                )
            }
        }
    }

    LaunchedEffect(currentMessageIndex) {
        if (currentMessageIndex < mainActivity.birthdayMessages.size) {
            showCurrentMessage = true
            delay(mainActivity.birthdayMessages[currentMessageIndex].delay)
            if (currentMessageIndex < mainActivity.birthdayMessages.size - 1) {
                showCurrentMessage = false
                delay(1000)
                currentMessageIndex++
            } else {
                // 等待音频播放完成
                while (!isAudioCompleted) {
                    delay(100)
                }
                // 音频播放完成后再延迟一段时间
                delay(2000)
                mainActivity._showBirthdayScreen.value = false
            }
        }
    }
}

// 添加三天光明彩蛋界面包装器
@Composable
fun ThreeDaysScreenWrapper(mainActivity: MainActivity) {
    AnimatedVisibility(
        visible = mainActivity._showThreeDaysScreen.value,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        ThreeDaysScreen()
    }
}

// 添加三天光明彩蛋界面
@Composable
fun ThreeDaysScreen() {
    val mainActivity = LocalContext.current as MainActivity
    var currentMessageIndex by remember { mutableStateOf(0) }
    var showCurrentMessage by remember { mutableStateOf(true) }

    // 添加音频播放完成状态
    var isAudioCompleted by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        mainActivity.startThreeDaysMusic()
        // 监听音频播放完成
        mainActivity.threeDaysMediaPlayer?.setOnCompletionListener {
            isAudioCompleted = true
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            mainActivity.stopThreeDaysMusic()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = showCurrentMessage,
            enter = fadeIn(
                animationSpec = tween(1000, easing = LinearEasing)
            ),
            exit = fadeOut(
                animationSpec = tween(1000, easing = LinearEasing)
            )
        ) {
            if (currentMessageIndex < mainActivity.threeDaysMessages.size) {
                Text(
                    text = mainActivity.threeDaysMessages[currentMessageIndex].text,
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 32.dp)
                )
            }
        }
    }

    LaunchedEffect(currentMessageIndex) {
        if (currentMessageIndex < mainActivity.threeDaysMessages.size) {
            showCurrentMessage = true
            delay(mainActivity.threeDaysMessages[currentMessageIndex].delay)
            if (currentMessageIndex < mainActivity.threeDaysMessages.size - 1) {
                showCurrentMessage = false
                delay(1000)
                currentMessageIndex++
            } else {
                // 等待音频播放完成
                while (!isAudioCompleted) {
                    delay(100)
                }
                // 音频播放完成后再延迟一段时间
                delay(2000)
                mainActivity._showThreeDaysScreen.value = false
            }
        }
    }
}

// 添加特殊彩蛋界面
@Composable
fun SpecialFarewellScreen() {
    val mainActivity = LocalContext.current as MainActivity
    var currentMessageIndex by remember { mutableStateOf(0) }
    var showCurrentMessage by remember { mutableStateOf(true) }
    var isAudioCompleted by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        mainActivity.specialFarewellMediaPlayer?.setOnCompletionListener {
            isAudioCompleted = true
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            mainActivity.stopSpecialFarewellMusic()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = showCurrentMessage,
            enter = fadeIn(animationSpec = tween(1000, easing = LinearEasing)),
            exit = fadeOut(animationSpec = tween(1000, easing = LinearEasing))
        ) {
            if (currentMessageIndex < mainActivity.specialFarewellMessages.size) {
                Text(
                    text = mainActivity.specialFarewellMessages[currentMessageIndex].text,
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 32.dp)
                )
            }
        }
    }

    LaunchedEffect(currentMessageIndex) {
        if (currentMessageIndex < mainActivity.specialFarewellMessages.size) {
            showCurrentMessage = true
            delay(mainActivity.specialFarewellMessages[currentMessageIndex].delay)
            if (currentMessageIndex < mainActivity.specialFarewellMessages.size - 1) {
                showCurrentMessage = false
                delay(1000)
                currentMessageIndex++
            }
            // 删除了最后的退出逻辑，这样最后一句话会永久显示
        }
    }
}

// 添加特殊彩蛋界面包装器
@Composable
fun SpecialFarewellScreenWrapper(mainActivity: MainActivity) {
    // 使用 LaunchedEffect 来监听可见性变化
    LaunchedEffect(mainActivity.showSpecialFarewellScreen.value) {
        if (!mainActivity.showSpecialFarewellScreen.value) {
            // 当界面不可见时停止音乐
            mainActivity.stopSpecialFarewellMusic()
        }
    }

    AnimatedVisibility(
        visible = mainActivity.showSpecialFarewellScreen.value,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        SpecialFarewellScreen()
    }
}