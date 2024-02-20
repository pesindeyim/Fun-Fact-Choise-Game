package com.example.funfact

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

object Utils {
    fun generateRandomColor(): Color {
        return Color(
            red = Random.nextFloat(),
            blue = Random.nextFloat(),
            green = Random.nextFloat(),
            alpha = 1F,
            )
    }
}