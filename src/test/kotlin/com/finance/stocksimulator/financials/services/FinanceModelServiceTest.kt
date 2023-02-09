package com.finance.stocksimulator.financials.services

import com.finance.stocksimulator.alphaVantageAPI.service.AlphaStockApiService
import org.junit.jupiter.api.Test

class FinanceModelServiceTest {

    @Test
    fun createDuPontModel() {

        val financeModelService = FinanceModelService()
        val company = AlphaStockApiService.fetchAllAlphaData("IBM", true)

        val duPontModel = financeModelService.createDuPontModel(company)

        println(duPontModel.duPontValueInvestopedia)
    }
}