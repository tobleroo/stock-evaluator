package com.finance.stocksimulator

import com.finance.stocksimulator.alphaVantageAPI.FetchAlphaVantageDataAPI
import com.finance.stocksimulator.financials.keyFigures.KeyFiguresCalcs
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StockSimulatorApplication

fun main(args: Array<String>) {
    runApplication<StockSimulatorApplication>(*args)
}
