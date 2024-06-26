package com.example.infinitysymbol.infinity

fun generateSequenceInRange(start: Double, end: Double, step: Double) =
    generateSequence(start) { it + step }.takeWhile { it <= end }.toList()