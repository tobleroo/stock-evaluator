package com.finance.stocksimulator.Services

import com.fasterxml.jackson.databind.JsonSerializable
import com.finance.stocksimulator.calculations.keyFigures.KeyFiguresCalcs
import com.google.gson.JsonObject
import org.springframework.stereotype.Service

@Service
class KeyService(private val keyCalculator: KeyFiguresCalcs) {

    fun getAllKeyCalculations(rawData: MutableMap<String, JsonObject>): JsonObject{
        val dataJson = JsonObject()

        print(rawData["cashFlow"]?.get("annualReports")?.asJsonObject)

//        val peRatio = keyCalculator.priceEarnings(rawData)
//        print(peRatio)

        return dataJson
    }
}