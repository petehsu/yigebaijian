package com.petehsu.yigebaijian.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.animation.ValueAnimator
import android.view.animation.LinearInterpolator

class WaveView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint().apply {
        isAntiAlias = true
        style = Paint.Style.FILL
        color = Color.parseColor("#88ADD8E6") // 淡蓝色半透明
    }
    
    private var waveOffset = 0f
    private val path = Path()
    private var amplitude = 50f  // 波浪振幅
    private var period = 400f    // 波浪周期
    
    private val animator = ValueAnimator.ofFloat(0f, period).apply {
        duration = 2000
        repeatCount = ValueAnimator.INFINITE
        interpolator = LinearInterpolator()
        addUpdateListener { animation ->
            waveOffset = animation.animatedValue as Float
            invalidate()
        }
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animator.start()
    }

    override fun onDetachedFromWindow() {
        animator.cancel()
        super.onDetachedFromWindow()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        
        path.reset()
        path.moveTo(-period, height.toFloat())
        
        var x = -period
        while (x <= width + period) {
            val y = height - amplitude * Math.sin(((x + waveOffset) * 2 * Math.PI / period).toDouble()).toFloat()
            path.lineTo(x, y)
            x += 10
        }
        
        path.lineTo(width.toFloat(), height.toFloat())
        path.close()
        
        canvas.drawPath(path, paint)
    }
} 