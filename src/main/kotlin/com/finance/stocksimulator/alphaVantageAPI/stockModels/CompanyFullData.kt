package com.finance.stocksimulator.alphaVantageAPI.stockModels

data class CompanyFullData(
    var symbol: String? = null,
    var overview: StockOverviewData? = null,
    var incomeData: IncomeData? = null,
    var cashFlowData: CashFlowData? = null,
    var balanceData: BalanceData? = null,
    var globalQuote: GlobalQuote? = null)
