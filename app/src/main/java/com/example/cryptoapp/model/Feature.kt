package com.example.cryptoapp.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Feature(
    val position: Int,
    val title: String,
    @DrawableRes val iconId: Int,
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color
)
