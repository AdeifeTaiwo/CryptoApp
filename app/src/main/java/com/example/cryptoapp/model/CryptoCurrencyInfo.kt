package com.example.cryptoapp.model

data class CryptoCurrencyInfo(
    val value:Float,
    val currency: String,
    val monthlyPreview: List<Pair<String, Float>>
)
