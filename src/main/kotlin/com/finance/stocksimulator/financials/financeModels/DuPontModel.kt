package com.finance.stocksimulator.financials.financeModels

import java.math.BigDecimal

class DuPontModel (
    netProfitMargin: BigDecimal,
    assetTurnover: BigDecimal,
    equityMultiplier: BigDecimal ){

    var duPontValueInvestopedia: Double

    init {
        duPontValueInvestopedia = (netProfitMargin.multiply(assetTurnover).multiply(equityMultiplier).toDouble()).times(100)
    }

}