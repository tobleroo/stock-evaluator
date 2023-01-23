package com.finance.stocksimulator.alphaVantageAPI.stockModels

data class IncomeData(
    val symbol: String,
    val annualReports: List<IncomeAnnualData>,
    val quarterlyReports: List<IncomeQuartData>
)
