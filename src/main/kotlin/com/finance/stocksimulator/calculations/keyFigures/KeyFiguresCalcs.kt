package com.finance.stocksimulator.calculations.keyFigures

import com.finance.stocksimulator.alphaVantageAPI.FetchAlphaVantageDataAPI
import com.google.gson.JsonObject
import org.springframework.stereotype.Service

@Service
class KeyFiguresCalcs(private val fetchData: FetchAlphaVantageDataAPI) {

    fun priceEarnings(financialsMap: MutableMap<String, JsonObject>){

        //get the specifics needed
        val stockClosePrice = fetchData.fetchSingleData("IBM", "TIME_SERIES_DAILY_ADJUSTED").get("Time Series (Daily)")
        print(stockClosePrice)
        //do calculation

        // return p/e
    }

    fun peg(){
        print("hello")
    }

    fun earnings(){
        print("earnings")
    }

}