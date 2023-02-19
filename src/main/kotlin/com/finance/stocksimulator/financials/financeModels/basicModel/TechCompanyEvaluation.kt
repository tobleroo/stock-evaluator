package com.finance.stocksimulator.financials.financeModels.basicModel

class TechCompanyEvaluation(
    override val peRatio: Double?,
    override val earningsPerShare: Double?,
    override val revenueGrowthPercentage: Double?,
    override val debtToEquity: Double?,
    override val returnOnEquity: Int?,
    override val grossMarginPercentage: Double?,
    override val operationMarginPercentage: Double?,
    override val marketCap: Long?,
    override val dividendYieldPercentage: Double? ) : BasicCompanyEvaluation {

    override val evaluatedPeRatio: String?
    override val evaluatedEarningsPerShare: String?
    override val evaluatedRevenueGrowthPercentage: String?
    override val evaluatedDebtToEquity: String?
    override val evaluatedReturnOnEquity: String?
    override val evaluatedGrossMarginPercentage: String?
    override val evaluatedOperationMarginPercentage: String?
    override val evaluatedMarketCap: String?
    override val evaluatedDividendYieldPercentage: String?

    init {
        evaluatedPeRatio = evaluatePERatio(peRatio)
        evaluatedEarningsPerShare = evaluateEarningsPerShare(earningsPerShare)
        evaluatedRevenueGrowthPercentage = evaluateRevenueGrowth(revenueGrowthPercentage)
        evaluatedDebtToEquity = evaluateDebtToEquity(debtToEquity)
        evaluatedReturnOnEquity = evaluateReturnOnEquity(returnOnEquity)
        evaluatedGrossMarginPercentage = evaluateGrossMargin(grossMarginPercentage)
        evaluatedOperationMarginPercentage = evaluateOperationMargin(operationMarginPercentage)
        evaluatedMarketCap = evaluateMarketCap(marketCap)
        evaluatedDividendYieldPercentage = evaluateDividendYield(dividendYieldPercentage)
    }
    override fun evaluatePERatio(peRatio: Double?): String? {
        if (peRatio == null) {
            return null
        }

        return when {
                    peRatio < 26 -> "bad"
                    peRatio > 26 || peRatio < 30 -> "average"
                    else -> "good"
        }
    }

    override fun evaluateEarningsPerShare(earningsPerShare: Double?): String? {
        return null
    }

    override fun evaluateRevenueGrowth(revenueGrowthPercentage: Double?): String {
        return "not implemented"
    }

    override fun evaluateDebtToEquity(debtToEquity: Double?): String {
        return "not implemented"
    }

    override fun evaluateReturnOnEquity(returnOnEquity: Int?): String {
        return "not implemented"
    }

    override fun evaluateGrossMargin(grossMarginPercentage: Double?): String {
        return "not implemented"
    }

    override fun evaluateOperationMargin(operationMarginPercentage: Double?): String {
        return "not implemented"
    }

    override fun evaluateMarketCap(marketCap: Long?): String {
        return "not implemented"
    }

    override fun evaluateDividendYield(dividendYieldPercentage: Double?): String {
        return "not implemented"
    }

    override fun toString(): String {
        return "TechCompanyEvaluation(peRatio=$peRatio, earningsPerShare=$earningsPerShare, " +
                "revenueGrowthPercentage=$revenueGrowthPercentage, debtToEquity=$debtToEquity," +
                " returnOnEquity=$returnOnEquity, grossMarginPercentage=$grossMarginPercentage," +
                " operationMarginPercentage=$operationMarginPercentage, marketCap=$marketCap," +
                " dividendYieldPercentage=$dividendYieldPercentage, evaluatedPeRatio=$evaluatedPeRatio," +
                " evaluatedEarningsPerShare=$evaluatedEarningsPerShare," +
                " evaluatedRevenueGrowthPercentage=$evaluatedRevenueGrowthPercentage," +
                " evaluatedDebtToEquity=$evaluatedDebtToEquity, evaluatedReturnOnEquity=$evaluatedReturnOnEquity," +
                " evaluatedGrossMarginPercentage=$evaluatedGrossMarginPercentage, " +
                "evaluatedOperationMarginPercentage=$evaluatedOperationMarginPercentage," +
                " evaluatedMarketCap=$evaluatedMarketCap, " +
                "evaluatedDividendYieldPercentage=$evaluatedDividendYieldPercentage)"
    }


}