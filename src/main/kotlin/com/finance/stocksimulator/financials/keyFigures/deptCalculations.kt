package com.finance.stocksimulator.financials.keyFigures

import java.math.BigDecimal

class deptCalculations {

    companion object{

        fun netDept(shortTermDept: BigDecimal, longTermDept: BigDecimal, liquidity: BigDecimal): BigDecimal{
            // (short term dept + long term dept) - cash and liquidity
            return (shortTermDept + longTermDept) - liquidity
        }

        // D/E-ratio
        fun deptEquity(totalLiabilities: BigDecimal, shareholderEquity: BigDecimal): BigDecimal{
            return totalLiabilities.divide(shareholderEquity)
        }
    }
}