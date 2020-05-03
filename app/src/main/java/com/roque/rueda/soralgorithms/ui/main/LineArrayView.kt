package com.roque.rueda.soralgorithms.ui.main

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import kotlin.random.Random

const val DEFAULT_NUMBER_SIZE = 10

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
        color = Color.RED
        flags = Paint.ANTI_ALIAS_FLAG
        style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (canvas == null) {
            return
        }

        val lineWidth = width.toFloat() / linesToDraw.size.toFloat()
        paint.strokeWidth = lineWidth

        linesToDraw.forEachIndexed { index, line ->
            val startX = lineWidth * index + 1
            val startY = 0f
            val endX = lineWidth * index + 1
            val endY = line.toFloat()
            canvas.drawLine(startX, startY, endX, endY, paint)
        }
    }
}