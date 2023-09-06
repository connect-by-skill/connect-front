package com.example.presentation.theme.color

import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val MainBlue = Color(0xFF2192FF)
val SkyBlue = Color(0xFFD0E7FF)
val DeepBlue = Color(0xFF016ED6)
val LightYellow = Color(0xFFFFF3AE)
val Yellow = Color(0xFFFFE23D)
val DeepYellow = Color(0xFFDABC11)
val LightPurple = Color(0xFFE8E8FC)
val Grey200 = Color(0xFF908499)
val Grey500 = Color(0xFFC2C2C2)
val Grey900 = Color(0xFF151515)
val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)
val Red400 = Color(0xFFFF5258)
val Red  = Color(0xFFFF0000)

sealed class ColorSet {
    open lateinit var LightColors: WhaleColors
    object WhaleColor : ColorSet() {
        override var LightColors = WhaleColors(
            material = lightColorScheme(
                primary = MainBlue,
                onPrimary = White,
                primaryContainer = SkyBlue,
                secondary = LightYellow,
                secondaryContainer = White,
                surface = White,
                onSurface = Black,
                background = SkyBlue,
                onBackground = Black,
                error = Red400,
                tertiary = LightPurple,
                onTertiary = Black,
                onError = Red
            ),
            textFiledBackgroundVariant = Grey500,
        )
    }
}