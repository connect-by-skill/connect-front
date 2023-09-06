package com.example.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.presentation.R

private val spoqaThin = FontFamily(
    Font(R.font.spoqa_hans_sans_neo_thin, FontWeight.Thin)
)

private val spoqaLight = FontFamily(
    Font(R.font.spoqa_hans_sans_neo_light, FontWeight.Light)
)

private val spoqaRegular = FontFamily(
    Font(R.font.spoqa_hans_sans_neo_regular, FontWeight.Normal)
)

private val spoqaMedium = FontFamily(
    Font(R.font.spoqa_hans_sans_neo_medium, FontWeight.Medium)
)

private val spoqaBold = FontFamily(
    Font(R.font.spoqa_hans_sans_neo_bold, FontWeight.Bold)
)

val Typography = Typography(
    //큰 UI 제목(예: 홈)
    headlineSmall = TextStyle(
        fontFamily = spoqaMedium,
        fontSize = 24.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = spoqaMedium,
        fontSize = 36.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 48.sp
    ),
    //본문 글
    bodySmall = TextStyle(
        fontFamily = spoqaLight,
        fontSize = 12.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 15.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 15.sp
    ),
    //버튼 글씨
    displaySmall = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 14.sp
    ),
    displayMedium = TextStyle(
        fontFamily = spoqaMedium,
        fontSize = 18.sp
    ),
    displayLarge = TextStyle(
        fontFamily = spoqaBold,
        fontSize = 20.sp
    ),
    //엄청 작은 글씨(부가 설명들) 별점 같은 거 밑에 작은거
    labelSmall = TextStyle(
        fontFamily = spoqaThin,
        fontSize = 10.sp
    ),
    labelMedium = TextStyle(
        fontFamily = spoqaLight,
        fontSize = 13.sp
    ),
    labelLarge = TextStyle(
        fontFamily = spoqaRegular,
        fontSize = 14.sp
    )
)

val Typography.underlineDisplay: TextStyle
    @Composable get() = displayMedium.copy(
        textDecoration = TextDecoration.Underline,
        fontSize = 18.sp
    )

val Typography.menuSmall: TextStyle
    @Composable get() = labelMedium.copy(
        fontSize = 11.sp
    )
val Typography.nameMedium: TextStyle
    @Composable get() = headlineSmall.copy(
        fontSize = 17.sp
    )