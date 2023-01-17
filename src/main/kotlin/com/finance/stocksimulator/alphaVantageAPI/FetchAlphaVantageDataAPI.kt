package com.finance.stocksimulator.alphaVantageAPI

import com.google.gson.Gson
import com.google.gson.JsonObject
import org.springframework.stereotype.Service
import java.net.URL

@Service
class FetchAlphaVantageDataAPI {

//    val companyData: MutableMap<String, JsonObject>
//        get() {
//            return companyData
//        }

    fun fetchSingleData(company: String, dataCat: String): JsonObject {

        val url =
            URL("https://www.alphavantage.co/query?function=${dataCat}&symbol=${company}&apikey=${alphaData.alpha_KEY}")

        val data = url.openStream().bufferedReader().use {
            it.readText()
        }

        val gson = Gson()

        return gson.fromJson(data, JsonObject::class.java)
    }

    fun fetchAllDataOneCompany(company: String): MutableMap<String, JsonObject> {

//        if(companyData.isNotEmpty()) companyData.clear()
        return mutableMapOf(
            "overview" to fetchSingleData(company, AlphaCategories.OVERVIEW.toString()),
            "income" to fetchSingleData(company, AlphaCategories.INCOME_STATEMENT.toString()),
            "balance" to fetchSingleData(company, AlphaCategories.BALANCE_SHEET.toString()),
            "cashFlow" to fetchSingleData(company, AlphaCategories.CASH_FLOW.toString()),
            "dailyData" to fetchSingleData(company, AlphaCategories.TIME_SERIES_DAILY_ADJUSTED.toString())
        )
//        companyData["overview"] = fetchSingleData(company, AlphaCategories.OVERVIEW.toString())
//        companyData["income"] = fetchSingleData(company, AlphaCategories.INCOME_STATEMENT.toString())
//        companyData["balance"] =  fetchSingleData(company, AlphaCategories.BALANCE_SHEET.toString())
//        companyData["cashFlow"] = fetchSingleData(company, AlphaCategories.CASH_FLOW.toString())
//        companyData["dailyData"] = fetchSingleData(company, AlphaCategories.TIME_SERIES_DAILY_ADJUSTED.toString())
    }



}