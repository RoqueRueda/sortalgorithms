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
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (canvas == null) {
            return
        }

        linesToDraw.forEachIndexed { index, line ->
            val startX = 0f + index
            val startY = 0f
            val endX = 0f + index
            val endY = line.toFloat()
            canvas.drawLine(startX, startY, endX, endY, paint)
        }
    }
}