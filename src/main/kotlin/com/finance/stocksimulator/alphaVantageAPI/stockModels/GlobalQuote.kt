package com.finance.stocksimulator.alphaVantageAPI.stockModels

data class GlobalQuote(
    val symbol: String,
    val open: String,
    val high: String,
    val low: String,
    val price: String,
    val volume: String,
    val latesttradingday: String,
    val previousclose: String,
    val change: String,
    val changepercent: String

)
