package com.finance.stocksimulator.alphaVantageAPI.models

data class ListingStocks(
    val symbol: String,
    val name: String,
    val exchange: String,
    val assetType: String,
    val ipoDate: String,
    val delistingDate: String? = null,
    val status: String
)
