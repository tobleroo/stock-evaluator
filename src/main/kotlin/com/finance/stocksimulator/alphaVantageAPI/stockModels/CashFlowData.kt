package com.finance.stocksimulator.alphaVantageAPI.stockModels

data class CashFlowData(
    val symbol: String,
    val annualReports: List<CashAnnualData>,
    val quarterlyReports: List<CashQuarterlyData>
)
