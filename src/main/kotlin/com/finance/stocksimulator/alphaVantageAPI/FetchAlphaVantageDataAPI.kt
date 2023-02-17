package com.finance.stocksimulator.alphaVantageAPI

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.finance.stocksimulator.alphaVantageAPI.stockModels.*

import com.google.gson.Gson
import com.google.gson.JsonObject
import org.springframework.stereotype.Service
import java.net.URL

@Service
class FetchAlphaVantageDataAPI {

    val mapper = jacksonObjectMapper()

    fun fetchOverviewData(company: String, dataCat: String, demoUse: Boolean): StockOverviewData {

        val jsonData = fetchAlphaStockJson(company, dataCat, demoUse)

        val refinedString = removeJsonKeysFromOverviewData(jsonData)

        return mapper.readValue(refinedString)
    }

    fun fetchIncomeData(company: String, dataCat: String, demoUse: Boolean): IncomeData {
        return mapper.readValue(fetchAlphaStockJson(company, dataCat, demoUse))
    }

    fun fetchBalanceData(company: String, dataCat: String, demoUse: Boolean): BalanceData {
        val jsonData = fetchAlphaStockJson(company, dataCat, demoUse)

        return mapper.readValue(jsonData)
    }

    fun fetchCashFlowData(company: String, dataCat: String, demoUse: Boolean): CashFlowData {
        return mapper.readValue(fetchAlphaStockJson(company, dataCat, demoUse))
    }

    fun fetchGlobalQuote(company: String, dataCat: String, demoUse: Boolean): GlobalQuote {
        val rawJson = fetchAlphaStockJson(company, dataCat, demoUse)

        val data = removeJsonKeyPartsFromGlobalData(rawJson)

        return GlobalQuote(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8], data[9])

    }


//    tools for fetching data from the api
    private fun removeJsonKeyPartsFromGlobalData(jsonData: String): MutableList<String> {

        val finalData = mutableListOf<String>()
        val withoutBlanks = jsonData.replace(" ","")
        val stringArr = withoutBlanks.split(',').toMutableList()

        val symbol = stringArr[0]
        val partSymbol = symbol.split(":")
        finalData.add(partSymbol[2])
        stringArr.removeAt(0)


        for(data in stringArr){
            val demo = data.split('"')
            finalData.add(demo[3])
        }
        return finalData
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

    fun fetchAlphaStockJson(company: String, dataCat: String, useAsDemo:Boolean): String{

        val url = when (useAsDemo){
            false -> URL("https://www.alphavantage.co/query?function=${dataCat}&symbol=${company}&apikey=${alphaData.alpha_KEY}")

            true -> URL("https://www.alphavantage.co/query?function=${dataCat}&symbol=IBM&apikey=demo")
        }

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