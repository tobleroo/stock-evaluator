package com.finance.stocksimulator.calculations.keyFigures

import com.finance.stocksimulator.Services.KeyService
import com.finance.stocksimulator.alphaVantageAPI.FetchAlphaVantageDataAPI
import com.finance.stocksimulator.alphaVantageAPI.alphaData
import com.google.gson.JsonObject
import org.springframework.stereotype.Service
import java.math.BigDecimal
import kotlin.reflect.typeOf

@Service
class KeyFiguresCalcs() {

    fun priceEarnings(data: MutableMap<String, JsonObject>): BigDecimal? {

        val stockClosePrice = data.get("TIME_SERIES_DAILY_ADJUSTED")
//            ?.getAsJsonObject("Time Series (Daily)")
//            ?.getAsJsonObject("2023-01-13")?.get("close")
        print(stockClosePrice)

        val companyProfit = data.get("INCOME_STATEMENT")
//            ?.getAsJsonObject("annualReports")
//            ?.get("grossProfit")
        print(companyProfit)

        return null

//        val stockClosePrice = fetchData.fetchSingleData("IBM", "TIME_SERIES_DAILY_ADJUSTED")
//            .getAsJsonObject("Time Series (Daily)")
//            .getAsJsonObject("2023-01-13")
//            .get("4. close").asBigDecimal
//
//        val profits = fetchData.fetchSingleData("IBM", "INCOME_STATEMENT").getAsJsonArray("annualReports")
//
//        print(profits.get(0).asJsonObject.get("grossProfit").asBigDecimal)
    }

}