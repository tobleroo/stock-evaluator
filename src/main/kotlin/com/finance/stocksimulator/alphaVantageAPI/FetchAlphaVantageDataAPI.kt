package com.finance.stocksimulator.alphaVantageAPI

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.finance.stocksimulator.alphaVantageAPI.models.BalanceData
import com.finance.stocksimulator.alphaVantageAPI.models.IncomeData
import com.finance.stocksimulator.alphaVantageAPI.models.StockOverviewData

import com.google.gson.Gson
import com.google.gson.JsonObject
import org.springframework.stereotype.Service
import java.net.URL

@Service
class FetchAlphaVantageDataAPI {

    val mapper = jacksonObjectMapper()
    fun fetchOverviewData(company: String, dataCat: String): StockOverviewData {

        val jsonData = alphaApiFetch(company, dataCat)

        val refinedString = removeJsonKeysFromOverviewData(jsonData)

        return mapper.readValue(refinedString)
    }

    fun fetchIncomeData(company: String, dataCat: String): IncomeData {
        return mapper.readValue(alphaApiFetch(company, dataCat))
    }

    fun fetchBalanceData(company: String, dataCat: String): BalanceData {
        val jsonData = alphaApiFetch(company, dataCat)

        return mapper.readValue(jsonData)
    }



    private fun removeJsonKeysFromOverviewData(jsonData :String): String{

        val gson = Gson()

        val gsonObj = gson.fromJson(jsonData, JsonObject::class.java)

        gsonObj.remove("52WeekHigh")
        gsonObj.remove("52WeekLow")
        gsonObj.remove("50DayMovingAverage")
        gsonObj.remove("200DayMovingAverage")

        return gsonObj.toString()
    }

    fun alphaApiFetch(company: String, dataCat: String): String{
        val url =
            URL("https://www.alphavantage.co/query?function=${dataCat}&symbol=${company}&apikey=${alphaData.alpha_KEY}")

        val data = url.openStream().bufferedReader().use {
            it.readText()
        }
        return data
    }



}