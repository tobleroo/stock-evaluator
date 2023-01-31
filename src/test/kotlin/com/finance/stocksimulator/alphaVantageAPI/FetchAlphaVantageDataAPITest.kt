package com.finance.stocksimulator.alphaVantageAPI

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class FetchAlphaVantageDataAPITest {

    private val fetchData = FetchAlphaVantageDataAPI()
    @Test
    fun fetchOverviewData() {
        // this makes sure removeJsonKeysFromOverviewData function also works
        val overviewObj = fetchData.fetchOverviewData("IBM", "OVERVIEW", true)

        assertTrue(overviewObj.AssetType.isNotEmpty())
    }

    @Test
    fun fetchIncomeData() {
        val incomeObj = fetchData.fetchIncomeData("IBM", "INCOME_STATEMENT", true)

        assertTrue(incomeObj.annualReports.isNotEmpty())
        assertTrue(incomeObj.quarterlyReports.isNotEmpty())
    }

    @Test
    fun fetchBalanceData() {
        val balanceObj = fetchData.fetchBalanceData("IBM", "BALANCE_SHEET", true)

        assertTrue(balanceObj.annualReports.isNotEmpty())
        assertTrue(balanceObj.quarterlyReports.isNotEmpty())
    }

    @Test
    fun fetchCashFlowData() {
        val cashFlowObj = fetchData.fetchCashFlowData("IBM", "CASH_FLOW", true)

        assertTrue(cashFlowObj.quarterlyReports.isNotEmpty())
        assertTrue(cashFlowObj.annualReports.isNotEmpty())
    }

    @Test
    fun fetchGlobalQuote() {
        // this test also makes sure function : removeJsonKeyPartsFromGlobalData works as intended
        val globalDataObj = fetchData.fetchGlobalQuote("IBM", "GLOBAL_QUOTE", true)

        assertTrue(globalDataObj.previousclose.isNotEmpty())
        assertTrue(globalDataObj.price.isNotEmpty())
    }

    @Test
    fun fetchAlphaStockJson() {
        val jsonString = fetchData.fetchAlphaStockJson("IBM", "OVERVIEW", true)
        assertTrue(jsonString.isNotEmpty())

    }

    @Test
    fun fetchAlphaListing() {
        val listingObj = fetchData.fetchAlphaListing()

        assertTrue(listingObj[0].assetType.isNotEmpty())
    }


}