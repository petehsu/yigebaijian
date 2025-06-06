package com.petehsu.yigebaijian

import android.app.Activity
import android.content.Context
import android.util.Log

/**
 * 隐私检查混入类
 * 用于在Activity中检查用户是否同意隐私政策
 */
interface PrivacyCheckMixin {
    
    /**
     * 检查用户是否同意隐私政策
     * @param context 上下文
     * @return 是否已同意隐私政策
     */
    fun checkPrivacyAgreement(context: Context): Boolean {
        val prefs = context.getSharedPreferences("app_settings", Context.MODE_PRIVATE)
        val hasAgreedPrivacy = prefs.getBoolean("has_agreed_privacy", false)
        
        if (!hasAgreedPrivacy) {
            Log.e("PrivacyCheck", "用户未同意隐私政策，无法继续")
            return false
        }
        
        return true
    }
    
    /**
     * 在Activity中检查隐私政策
     * 如果未同意则结束Activity
     * @param activity 要检查的Activity
     * @return 是否已同意隐私政策
     */
    fun checkPrivacyForActivity(activity: Activity): Boolean {
        val result = checkPrivacyAgreement(activity)
        if (!result) {
            activity.finish()
        }
        return result
    }
} 