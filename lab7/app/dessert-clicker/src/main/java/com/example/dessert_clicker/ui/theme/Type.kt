package com.example.dessert_clicker.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Material 3 использует новые названия стилей
val Typography = Typography(
    bodyLarge = TextStyle(  // было: body1
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    headlineMedium = TextStyle(  // было: h4
        color = Color(0xFF008577),
        fontSize = 33.sp,
    ),
    titleLarge = TextStyle(  // было: h6
        color = Color(0x99000000),
        fontSize = 20.sp
    )
)