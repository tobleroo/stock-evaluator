package com.finance.stocksimulator.alphaVantageAPI.models

data class CashFlowData(
    val Symbol: String,
    val annualReports: List<CashAnnualData>,
    val quarterlyReports: List<CashQuarterlyData>
)
