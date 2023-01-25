package com.finance.stocksimulator.alphaVantageAPI.stockModels

data class CompanyFullData(
    var symbol: String? = null,
    var overview: StockOverviewData? = null,
    var incomeData: IncomeData? = null,
    var cashFlowData: CashFlowData? = null,
    var balanceData: BalanceData? = null,
    var globalQuote: GlobalQuote? = null)
{

    val earningsPerShare by lazy { cashFlowData?.annualReports?.get(0)?.profitLoss?.toBigDecimal()!! /
            overview?.SharesOutstanding!!.toBigDecimal()
    }

    val epsGrowthRate by lazy {  }

}
