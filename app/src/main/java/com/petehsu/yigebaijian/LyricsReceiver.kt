package com.petehsu.yigebaijian

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class LyricsReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("LyricsReceiver", "静态广播接收器收到广播: ${intent?.action}")
        
        if (intent?.action == "com.petehsu.lyraplayer.LYRICS_UPDATE") {
            val lyrics = intent.getStringExtra("lyrics")
            val isPlaying = intent.getBooleanExtra("isPlaying", false)
            val hasLyrics = intent.getBooleanExtra("hasLyrics", false)
            val songTitle = intent.getStringExtra("songTitle")
            val artist = intent.getStringExtra("artist")
            
            Log.d("LyricsReceiver", "收到歌词广播: lyrics=$lyrics, isPlaying=$isPlaying, hasLyrics=$hasLyrics")
            Log.d("LyricsReceiver", "歌曲信息: title=$songTitle, artist=$artist")
            
            // 通过广播通知MainActivity更新界面
            val updateIntent = Intent("com.petehsu.yigebaijian.UPDATE_LYRICS")
            updateIntent.putExtra("lyrics", lyrics)
            updateIntent.putExtra("isPlaying", isPlaying)
            updateIntent.putExtra("hasLyrics", hasLyrics)
            updateIntent.putExtra("songTitle", songTitle)
            updateIntent.putExtra("artist", artist)
            updateIntent.setPackage(context?.packageName)
            
            context?.sendBroadcast(updateIntent)
            Log.d("LyricsReceiver", "已转发歌词更新广播到MainActivity")
        }
    }
}
