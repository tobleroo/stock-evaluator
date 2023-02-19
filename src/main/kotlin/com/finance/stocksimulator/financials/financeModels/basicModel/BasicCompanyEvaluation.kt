package com.finance.stocksimulator.financials.financeModels.basicModel

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

    val evaluatedPeRatio: String?
    val evaluatedEarningsPerShare: String?
    val evaluatedRevenueGrowthPercentage: String?
    val evaluatedDebtToEquity: String?
    val evaluatedReturnOnEquity: String?
    val evaluatedGrossMarginPercentage: String?
    val evaluatedOperationMarginPercentage: String?
    val evaluatedMarketCap: String?
    val evaluatedDividendYieldPercentage: String?


    fun evaluatePERatio(peRatio : Double?): String?

    fun evaluateEarningsPerShare(earningsPerShare: Double?): String?

    fun evaluateRevenueGrowth(revenueGrowthPercentage: Double?): String?

    fun evaluateDebtToEquity(debtToEquity: Double?): String?

    fun evaluateReturnOnEquity(returnOnEquity: Int?): String?

    fun evaluateGrossMargin(grossMarginPercentage: Double?): String?

    fun evaluateOperationMargin(operationMarginPercentage: Double?): String?

    fun evaluateMarketCap(marketCap: Long?): String?

    fun evaluateDividendYield(dividendYieldPercentage: Double?): String?

}