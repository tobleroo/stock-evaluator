package com.finance.stocksimulator.alphaVantageAPI

enum class alphaData(val key: String) {

    alpha_KEY("SRIZ5HLLDG8GZHON")

}

enum class AlphaCategories{
    OVERVIEW, INCOME_STATEMENT, BALANCE_SHEET, CASH_FLOW, TIME_SERIES_DAILY_ADJUSTED,
    GLOBAL_QUOTE
}