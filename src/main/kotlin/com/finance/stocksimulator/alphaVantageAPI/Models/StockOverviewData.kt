package com.finance.stocksimulator.alphaVantageAPI.Models

data class StockOverviewData(
    val Symbol: String,
    val Name: String,
    val Description: String,
    val Exchange: String,
    val Currency: String,
    val Country: String,
    val Sector: String,
    val Industry: String,
    val AnalystTargetPrice: Float,
)
