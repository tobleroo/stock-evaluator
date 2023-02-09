package com.finance.stocksimulator

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StockSimulatorApplication

fun main(args: Array<String>) {
    runApplication<StockSimulatorApplication>(*args)
}
