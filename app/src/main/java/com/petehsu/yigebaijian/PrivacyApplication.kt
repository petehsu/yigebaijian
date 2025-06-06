package com.petehsu.yigebaijian

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log

/**
 * 应用类，用于在应用启动时执行隐私检查
 * 通过注册Activity生命周期回调，在每个Activity创建时检查隐私同意状态
 */
class PrivacyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        
        // 注册Activity生命周期回调
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                // 对于PrivacyActivity不做检查，因为它就是显示隐私政策的
                if (activity is PrivacyActivity) {
                    return
                }
                
                // 对所有其他Activity进行检查
                PrivacyUtils.checkPrivacyAgreement(activity)
            }
            
            override fun onActivityStarted(activity: Activity) {}
            override fun onActivityResumed(activity: Activity) {}
            override fun onActivityPaused(activity: Activity) {}
            override fun onActivityStopped(activity: Activity) {}
            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
            override fun onActivityDestroyed(activity: Activity) {}
        })
        
        Log.d("PrivacyApplication", "应用启动，已设置隐私检查")
    }
} 