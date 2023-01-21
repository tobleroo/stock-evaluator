package com.finance.stocksimulator.alphaVantageAPI

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.finance.stocksimulator.alphaVantageAPI.models.*

import com.google.gson.Gson
import com.google.gson.JsonObject
import org.springframework.stereotype.Service
import java.net.URL

@Service
class FetchAlphaVantageDataAPI {

    val mapper = jacksonObjectMapper()
    fun fetchOverviewData(company: String, dataCat: String): StockOverviewData {

        val jsonData = fetchAlphaStockJson(company, dataCat)

        val refinedString = removeJsonKeysFromOverviewData(jsonData)

        return mapper.readValue(refinedString)
    }

    fun fetchIncomeData(company: String, dataCat: String): IncomeData {
        return mapper.readValue(fetchAlphaStockJson(company, dataCat))
    }

    fun fetchBalanceData(company: String, dataCat: String): BalanceData {
        val jsonData = fetchAlphaStockJson(company, dataCat)

        return mapper.readValue(jsonData)
    }

    fun fetchCashFlowData(company: String, dataCat: String): CashFlowData {
        return mapper.readValue(fetchAlphaStockJson(company, dataCat))
    }

//    alpha vantage sends this api resonse as a CSV file
    fun fetchListings(){

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

    fun fetchAlphaStockJson(company: String, dataCat: String): String{
        val url =
            URL("https://www.alphavantage.co/query?function=${dataCat}&symbol=${company}&apikey=${alphaData.alpha_KEY}")

        val data = url.openStream().bufferedReader().use {
            it.readText()
        }
        return data
    }

    fun fetchAlphaListing(): List<ListingStocks>{
        val url =
            URL("https://www.alphavantage.co/query?function=LISTING_STATUS&apikey=${alphaData.alpha_KEY}")

//        val listings: List<ListingStocks> = listOf()
        val data = url.openStream().bufferedReader()
        return data.lineSequence()
            .map {
                val (symbol, name, exchange, assetType, ipoDate) =
                    it.split(',', ignoreCase = false, limit = 5)
                ListingStocks(symbol, name, exchange, assetType, ipoDate, null , "active")
            }.toList()
    }



}