package com.example.infinitysymbol.infinity

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import com.example.infinitysymbol.ui.theme.Purple1
import com.example.infinitysymbol.ui.theme.Purple2
import com.example.infinitysymbol.ui.theme.Purple3

@Composable
fun DrawInfinity(
    modifier: Modifier = Modifier,
    stroke: Float = 50f,
    enableAnimation: Boolean = true,
    brush: Brush = Brush.linearGradient(listOf(Purple3, Purple2, Purple1)),
    thetaValues: List<Double>
) {

    val transition = rememberInfiniteTransition(label = "")
    val animatedValue by transition.animateFloat(
        initialValue = 0f, targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )

    val thetaValuesAnimation = if (enableAnimation) thetaValues.map { it * animatedValue } else thetaValues

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(.3f)
    ) {

        val path = Path().apply {

            var firstPoint = true

            for (theta in thetaValuesAnimation) {

                val (x, y) = calculateCoordinates(theta = theta, scale = 300f)

                val xMiddleOfCanvas = x + size.width / 2
                val yMiddleOfCanvas = y + size.height / 2

                if (firstPoint) {
                    moveTo(xMiddleOfCanvas, yMiddleOfCanvas)
                    firstPoint = false
                } else {
                    lineTo(xMiddleOfCanvas, yMiddleOfCanvas)
                }

            }
        }

        drawPath(
            path = path,
            brush = brush,
            style = Stroke(width = stroke)
        )
    }
}
