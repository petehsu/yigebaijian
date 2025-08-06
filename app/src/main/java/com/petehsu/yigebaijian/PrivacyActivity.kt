package com.petehsu.yigebaijian

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import android.net.Uri
import android.util.Log
import android.view.WindowManager
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import com.petehsu.yigebaijian.ui.theme.一个摆件Theme
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController

/**
 * 隐私政策同意界面
 * 用于在应用首次启动或用户未同意隐私政策时显示隐私政策对话框
 */
class PrivacyActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        // 设置沉浸式体验
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        
        Log.d("PrivacyActivity", "onCreate: 显示隐私政策界面")
        
        // 检查用户是否已经同意隐私政策
        val prefs = getSharedPreferences("app_settings", Context.MODE_PRIVATE)
        val hasAgreedPrivacy = prefs.getBoolean("has_agreed_privacy", false)
        
        // 如果用户已经同意，直接跳转到主界面
        if (hasAgreedPrivacy) {
            Log.d("PrivacyActivity", "用户已同意隐私政策，直接跳转到主界面")
            startMainActivity()
            finish()
            return
        }
        
        // 设置内容视图，显示隐私政策对话框
        setContent {
            一个摆件Theme {
                // 设置系统UI控制器
                val systemUiController = rememberSystemUiController()
                val darkIcons = MaterialTheme.colorScheme.surface.luminance() > 0.5f
                
                DisposableEffect(systemUiController, darkIcons) {
                    // 更新所有系统栏颜色为透明并且隐藏状态栏
                    systemUiController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = darkIcons,
                        isNavigationBarContrastEnforced = false
                    )
                    // 隐藏系统栏
                    systemUiController.setStatusBarColor(Color.Transparent)
                    systemUiController.setNavigationBarColor(Color.Transparent)
                    
                    onDispose {}
                }
                
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PrivacyPolicyDialog(
                        onAgree = {
                            // 保存用户已同意隐私政策
                            prefs.edit()
                                .putBoolean("has_agreed_privacy", true)
                                .putBoolean("is_first_launch", false)
                                .apply()
                            
                            // 同意后跳转到主界面
                            startMainActivity()
                            finish()
                        },
                        onDismiss = {
                            // 用户不同意，退出应用
                            finish()
                        }
                    )
                }
            }
        }
    }
    
    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    
    private fun openUrl(context: Context, url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    }
}

@Composable
fun PrivacyPolicyDialog(
    onAgree: () -> Unit,
    onDismiss: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF000000)), // 黑色背景
        contentAlignment = Alignment.Center // 内容居中
    ) {
        // 横屏模式下的对话框布局
        Card(
            modifier = Modifier
                .fillMaxWidth(0.75f) // 最大宽度为屏幕的75%
                .padding(horizontal = 24.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // 标题
                Text(
                    text = "温馨提示",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // 内容
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                ) {
                    Text(
                        "欢迎使用一个摆件！我们非常重视您的个人信息和隐私保护。",
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Spacer(modifier = Modifier.height(8.dp))
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    val context = LocalContext.current
                    val annotatedString = buildAnnotatedString {
                        append("在您使用\"一个摆件\"之前，请您仔细阅读")
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
                        append("如您阅读之后同意此政策和协议，请点击\"同意并继续\"并开始使用我们的产品和服务，我们尽全力保护您的个人信息安全。")
                    }

                    ClickableText(
                        text = annotatedString,
                        onClick = { offset ->
                            annotatedString.getStringAnnotations(offset, offset)
                                .firstOrNull()?.let { span ->
                                    when (span.tag) {
                                        "agreement" -> {
                                            val intent = Intent(Intent.ACTION_VIEW)
                                            intent.data = Uri.parse("http://www.petehsu.xyz/yigebaijian-legal/user-agreement.html")
                                            context.startActivity(intent)
                                        }
                                        "privacy" -> {
                                            val intent = Intent(Intent.ACTION_VIEW)
                                            intent.data = Uri.parse("http://www.petehsu.xyz/yigebaijian-legal/privacy-policy.html")
                                            context.startActivity(intent)
                                        }
                                    }
                                }
                        },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
                
                Spacer(modifier = Modifier.height(24.dp))
                
                // 按钮
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("不同意")
                    }
                    
                    Spacer(modifier = Modifier.width(8.dp))
                    
                    Button(onClick = onAgree) {
                        Text("同意并继续")
                    }
                }
            }
        }
    }
} 