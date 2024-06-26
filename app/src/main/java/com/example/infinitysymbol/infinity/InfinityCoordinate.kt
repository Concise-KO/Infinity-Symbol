package com.example.infinitysymbol.infinity

import kotlin.math.cos
import kotlin.math.sin

data class InfinityCoordinate(val x: Float, val y: Float)

fun calculateCoordinates(theta: Double, scale: Float) = InfinityCoordinate(
    (scale * cos(theta) / (1 + sin(theta) * sin(theta))).toFloat(),
    (scale * sin(theta) * cos(theta) / (1 + sin(theta) * sin(theta))).toFloat()
)


