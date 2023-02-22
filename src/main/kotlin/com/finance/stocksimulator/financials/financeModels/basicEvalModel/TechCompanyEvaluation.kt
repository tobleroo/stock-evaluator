package com.finance.stocksimulator.financials.financeModels.basicEvalModel

data class TechCompanyEvaluation(
    override val peRatio: Double?,
    override val earningsPerShare: Double?,
    override val revenueGrowthPercentage: Double?,
    override val debtToEquity: Double?,
    override val returnOnEquity: Int?,
    override val grossMarginPercentage: Double?,
    override val operationMarginPercentage: Double?,
    override val marketCap: Long?,
    override val dividendYieldPercentage: Double?,
    override val betaValue: Double?,
    override val profitMargin: Double?,
    override val operatingMargin: Double?,
    override val netMargin: Double?,
    override val ebitda: Double?,
    override val preTaxMargin: Double?
) : BasicCompanyEvaluation