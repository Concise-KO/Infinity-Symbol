package com.example.infinitysymbol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.infinitysymbol.infinity.DrawInfinity
import com.example.infinitysymbol.infinity.generateSequenceInRange
import com.example.infinitysymbol.ui.theme.BackgroundColor
import com.example.infinitysymbol.ui.theme.InfinitySymbolTheme
import kotlin.math.PI

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            InfinitySymbolTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(BackgroundColor)
                ) {
                    DrawInfinity(
                        modifier = Modifier.align(Alignment.Center),
                        thetaValues = generateSequenceInRange(0.0, 2 * PI, 0.001),
                        enableAnimation = true
                    )
                }
            }
        }
    }
}


