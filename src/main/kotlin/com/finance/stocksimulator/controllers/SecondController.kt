package com.finance.stocksimulator.controllers

import com.finance.stocksimulator.alphaVantageAPI.service.AlphaStockApiService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SecondController {

    @GetMapping("/second-test")
    fun getSameCompany(): String {
        return AlphaStockApiService.fetchAllAlphaData("IBM", false).toString()
    }
}