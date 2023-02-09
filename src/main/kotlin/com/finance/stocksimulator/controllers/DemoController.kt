package com.finance.stocksimulator.controllers

import com.finance.stocksimulator.alphaVantageAPI.service.AlphaStockApiService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController( private val alphaApiService: AlphaStockApiService) {


    @GetMapping("/all-data/{symbol}")
    fun stockAllData(@PathVariable symbol: String): String{
//        val stockAllData = alphaApiService.fetchAllAlphaData(symbol)


//        KeyFiguresCalcs.priceEarningsGrowths(stockAllData)
//        KeyFiguresCalcs.returnOnCapital(stockAllData)
        return "hello"
    }

}
