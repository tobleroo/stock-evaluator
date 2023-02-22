package com.finance.stocksimulator.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.finance.stocksimulator.alphaVantageAPI.service.AlphaStockApiService
import com.finance.stocksimulator.financials.financeModels.basicEvalModel.BasicCompanyEvaluation
import com.finance.stocksimulator.financials.services.BacktestService
import com.finance.stocksimulator.financials.services.EvaluationService
import com.google.gson.Gson
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BacktestController {

    val mapper = ObjectMapper().registerKotlinModule()

    @GetMapping("backtest")
    fun backTestCompany(): String{

        val companyData = AlphaStockApiService.fetchAllAlphaData("IBM", true)

        val companyLatest = EvaluationService.evaluateCompany(companyData, 0)
        val earlierData = EvaluationService.evaluateCompany(companyData, 3)

        val theList = listOf(companyLatest, earlierData)

        return mapper.writeValueAsString(theList)

    }
}