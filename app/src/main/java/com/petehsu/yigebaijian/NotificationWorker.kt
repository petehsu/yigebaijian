package com.petehsu.yigebaijian

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString

class NotificationWorker(
    private val context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    companion object {
        private const val CHANNEL_ID = "todo_notification_channel"
        private const val NOTIFICATION_ID = 1001
    }

    override suspend fun doWork(): Result {
        try {
            checkAndShowNotification()
            return Result.success()
        } catch (e: Exception) {
            Log.e("NotificationWorker", "Error showing notification", e)
            return Result.failure()
        }
    }

    private fun checkAndShowNotification() {
        val now = LocalDateTime.now()
        val currentDayOfWeek = now.dayOfWeek.value
        val today = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))

        // 从 SharedPreferences 获取待办事项
        val prefs = context.getSharedPreferences("todo_items", Context.MODE_PRIVATE)
        val todoJson = prefs.getString("items", "[]") ?: "[]"
        val todoItems = try {
            Json.decodeFromString<List<TodoItem>>(todoJson)
        } catch (e: Exception) {
            emptyList<TodoItem>()
        }

        // 获取今天的特殊待办
        val specialTodos = todoItems.filter { todo ->
            val isSpecialTodo = todo.content.startsWith("今天是你") || // 生日待办
                    todo.content.contains("默哀") || // 默哀待办
                    todo.content.contains("纪念日") || // 纪念日待办
                    todo.content.contains("清明节") // 清明节待办
            
            isSpecialTodo && todo.dayOfWeek == currentDayOfWeek
        }

        // 如果有特殊待办，显示特殊待办的内容
        if (specialTodos.isNotEmpty()) {
            val pendingIntent = PendingIntent.getActivity(
                context,
                0,
                Intent(context, MainActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
                },
                PendingIntent.FLAG_IMMUTABLE
            )

            // 构建通知内容
            val notificationText = specialTodos.joinToString("\n") { it.content }

            // 构建通知样式
            val style = NotificationCompat.BigTextStyle()
                .setBigContentTitle("今日特殊纪念")
                .bigText(notificationText)

            val notification = NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("今日特殊纪念")
                .setContentText(specialTodos.first().content)
                .setStyle(style)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build()

            try {
                NotificationManagerCompat.from(context).notify(NOTIFICATION_ID, notification)
            } catch (e: SecurityException) {
                Log.e("NotificationWorker", "通知权限未授权", e)
            }
        }
    }
} 