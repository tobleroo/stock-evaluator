package com.finance.stocksimulator.alphaVantageAPI.models

data class BalanceData(
    val symbol: String,
    val annualReports: List<BalanceAnnualData>,
    val quarterlyReports: List<BalanceQuartData>
)
