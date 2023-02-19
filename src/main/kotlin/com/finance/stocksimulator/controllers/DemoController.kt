package com.finance.stocksimulator.controllers

import com.finance.stocksimulator.alphaVantageAPI.service.AlphaStockApiService
import com.finance.stocksimulator.alphaVantageAPI.stockModels.ListingStocks
import com.finance.stocksimulator.financials.services.EvaluationService
import com.finance.stocksimulator.financials.services.Stuff
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController() {


    @GetMapping("/all-data/{symbol}")
    fun stockAllData(@PathVariable symbol: String): String{
//        val stockAllData = alphaApiService.fetchAllAlphaData(symbol)


//        KeyFiguresCalcs.priceEarningsGrowths(stockAllData)
//        KeyFiguresCalcs.returnOnCapital(stockAllData)
        return "hello"
    }

    @GetMapping("/evaluated")
    fun EvaluatedStock(): String{
        val stockData = AlphaStockApiService.fetchAllAlphaData("AAPL", false)

        return EvaluationService.evaluateCompany(stockData).toString()
    }

    @GetMapping("/exchange")
    fun seeAllExchanges(): List<ListingStocks>{
        val listing = AlphaStockApiService.getListing()

       return Stuff.extractExchanges(listing)
    }

}
