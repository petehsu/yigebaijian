package com.petehsu.yigebaijian

import android.app.Activity
import android.content.Context
import android.util.Log

/**
 * 隐私政策检查工具类
 * 用于检查用户是否同意隐私政策，如果未同意则结束Activity
 */
object PrivacyUtils {
    
    /**
     * 检查用户是否同意隐私政策
     * @param activity 要检查的Activity
     * @return 是否已同意隐私政策，true表示已同意，false表示未同意
     */
    fun checkPrivacyAgreement(activity: Activity): Boolean {
        val prefs = activity.getSharedPreferences("app_settings", Context.MODE_PRIVATE)
        val hasAgreedPrivacy = prefs.getBoolean("has_agreed_privacy", false)
        
        if (!hasAgreedPrivacy) {
            Log.e("PrivacyUtils", "用户未同意隐私政策，无法启动应用")
            activity.finish()
            return false
        }
        
        return true
    }
} 