package com.finance.stocksimulator.alphaVantageAPI.service

import com.finance.stocksimulator.alphaVantageAPI.stockModels.CompanyFullData
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AlphaStockApiServiceTest {


    @Test
    fun fetchAllAlphaData() {
        val allDataObj: CompanyFullData = AlphaStockApiService.fetchAllAlphaData("IBM", true)

        allDataObj.incomeData?.annualReports?.isNotEmpty()?.let { assertTrue(it) }
        allDataObj.balanceData?.annualReports?.isNotEmpty()?.let { assertTrue(it) }
        allDataObj.overview?.AssetType?.isNotEmpty()?.let { assertTrue(it) }
        allDataObj.cashFlowData?.annualReports?.isNotEmpty()?.let { assertTrue(it) }
        allDataObj.globalQuote?.price?.isNotEmpty()?.let { assertTrue(it) }

    }

    @Test
    fun getStockFromList() {
        //first make sure there is a company in the list
        AlphaStockApiService.fetchAllAlphaData("IBM", true)

        val objFromList: CompanyFullData = AlphaStockApiService.getStockFromList("IBM")
        assertTrue(!objFromList.symbol.isNullOrBlank())
    }

    @Test
    fun getListOfStocks() {
        //first make sure there is at least one company in the list
        AlphaStockApiService.fetchAllAlphaData("IBM", true)

        val listOfCompanies = AlphaStockApiService.getListOfStocks()
        println(listOfCompanies.size)
//        assertTrue(listOfCompanies.isNotEmpty())
    }

    @Test
    fun `call two times but list should still only have one company`(){
        AlphaStockApiService.fetchAllAlphaData("IBM", true)
        AlphaStockApiService.fetchAllAlphaData("IBM", true)

        val listOfCompanies = AlphaStockApiService.getListOfStocks()

        assertEquals(1, listOfCompanies.size)
    }
}