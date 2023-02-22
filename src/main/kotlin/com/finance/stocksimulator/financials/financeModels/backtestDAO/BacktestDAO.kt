package com.finance.stocksimulator.financials.financeModels.backtestDAO

import com.finance.stocksimulator.financials.financeModels.basicEvalModel.BasicCompanyEvaluation

data class BacktestDAO(val peDiff: Double?,
       val epsDiff: Double?,
       val revenueGrowthDiff: Double?,
       val debtToEquityDiff: Double?,
       val roeDiff: Int?,
       val grossMarginDiff: Double?,
       val operationMarginDiff: Double?,
       val marketCapDiff: Double?,
       val dividendDiff: Double?,
       val betaDiff: Double?,
       val profitMarginDiff: Double?,
       val operatingMarginDiff: Double?,
       val netMarginDiff: Double?,
       val ebitdaDiff: Double?,
       val preTaxMarginDiff: Double?,
       val latestData: BasicCompanyEvaluation,
       val earlierData: BasicCompanyEvaluation)




