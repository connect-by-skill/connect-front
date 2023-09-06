package com.example.presentation.theme.color

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color

data class WhaleColors(
    val material: ColorScheme,
    val tertiary: Color = material.primary,
    val onPrimaryAlt: Color = material.onPrimary,
    val success: Color = Color.Green,
    val checked: Color = Color.White,
    val unchecked: Color = Color.White,
    val checkmark: Color = material.primary,
    val disabledSecondary: Color = material.secondary.copy(alpha = 0.5f),
    val textFiledBackground: Color = Color.LightGray,
    val textFiledBackgroundVariant: Color = Color.DarkGray,
    val textSubColor: Color = Color(0xFF9E9E9E),
    val textHighlightColor: Color = Color(0xFF0A66C2),
    val iconSubColor: Color = Color(0xFFA3A3A3),
    val launcherScreenBackground: Color = material.primary,
    val progressItemColor: Color = Color.Black
) {
    val primary: Color get() = material.primary
    val secondary: Color get() = material.secondary
    val background: Color get() = material.background
    val surface: Color get() = material.surface
    val error: Color get() = material.error
    val onPrimary: Color get() = material.onPrimary
    val onSecondary: Color get() = material.onSecondary
    val onBackground: Color get() = material.onBackground
    val onSurface: Color get() = material.onSurface
    val onError: Color get() = material.onError
}
