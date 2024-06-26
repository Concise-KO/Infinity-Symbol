package com.example.infinitysymbol.infinity

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
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
    brush: Brush = Brush.linearGradient(listOf(Purple3, Purple2, Purple1)),
    thetaValues: List<Double>
) {
    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(.3f)
    ) {

        val path = Path().apply {

            var firstPoint = true

            for (theta in thetaValues) {

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
