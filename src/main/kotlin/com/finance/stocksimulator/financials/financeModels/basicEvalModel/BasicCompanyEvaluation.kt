package com.finance.stocksimulator.financials.financeModels.basicEvalModel

interface BasicCompanyEvaluation {

    val peRatio: Double?
    val earningsPerShare: Double?
    val revenueGrowthPercentage: Double?
    val debtToEquity: Double?
    val returnOnEquity: Int?
    val grossMarginPercentage: Double?
    val operationMarginPercentage: Double?
    val marketCap: Long?
    val dividendYieldPercentage: Double?
    val betaValue: Double?
    val profitMargin: Double?
    val operatingMargin: Double?
    val netMargin: Double?
    val ebitda: Double?
    val preTaxMargin: Double?
}