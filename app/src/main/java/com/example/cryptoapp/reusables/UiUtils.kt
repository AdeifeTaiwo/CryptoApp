package com.example.cryptoapp.reusables

import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import com.example.cryptoapp.ui.theme.CryptoOrange4

    fun DrawScope.drawCurvyLines() {
        val stroke = Path().apply {
            moveTo(size.width.times(.9f), size.height.times(0f))

            quadraticBezierTo(
                size.width.times(.9f), size.height.times(.28f),
                size.width.times(.73f), size.width.times(.15f)
            )

            quadraticBezierTo(
                size.width.times(.53f), size.height.times(0f),
                size.width.times(.55f), size.width.times(.25f)
            )
        }
        drawPath(
            stroke,
            color = CryptoOrange4,
            style = Stroke(
                width = 50f,
                cap = StrokeCap.Round
            )
        )
    }