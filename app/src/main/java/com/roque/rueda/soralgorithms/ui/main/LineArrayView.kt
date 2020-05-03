package com.roque.rueda.soralgorithms.ui.main

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import com.roque.rueda.soralgorithms.R
import kotlin.random.Random

const val DEFAULT_NUMBER_SIZE = 500

class LineArrayView @JvmOverloads constructor(
    ctx: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(ctx, attrs, defStyleAttr) {

    var linesToDraw: IntArray =
        IntArray(DEFAULT_NUMBER_SIZE) { Random.nextInt(DEFAULT_NUMBER_SIZE) }
        set(value) {
            invalidate()
            field = value
        }

    private val paint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.FILL_AND_STROKE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (canvas == null) {
            return
        }

        val lineWidth = width / linesToDraw.size.toFloat()
        paint.strokeWidth = lineWidth

        linesToDraw.forEachIndexed { index, line ->
            paint.color = getColorForLine(line, linesToDraw.size)
            val startX = lineWidth * index + 1
            val startY = 0f
            val endX = lineWidth * index + 1
            val endY = line.toFloat()
            canvas.drawLine(startX, startY, endX, endY, paint)
        }
    }

    private fun getColorForLine(line: Int, size: Int): Int {
        val percentage = (line * 100 / size) / 100f
        val startColor = ContextCompat.getColor(context, R.color.colorStart)
        val endColor = ContextCompat.getColor(context, R.color.colorEnd)
        return ColorUtils.blendARGB(startColor, endColor, percentage)
    }
}