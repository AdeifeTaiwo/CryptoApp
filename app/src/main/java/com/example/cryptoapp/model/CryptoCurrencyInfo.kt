package com.example.cryptoapp.model

import androidx.compose.ui.graphics.Color

data class CryptoCurrencyInfo(
    val value:Float,
    val currency: String,
    val monthlyPreview: List<Pair<String, Float>>
)

data class CurrentCryptoBackgroundInfo(
    val month: String,
    val color : Color
)
