package com.finance.stocksimulator.financials.calculations

import java.math.BigDecimal

class deptCalculations {

    companion object{

        fun netDept(shortTermDept: Long, longTermDept: Long, liquidity: Long): Long{
            // (short term dept + long term dept) - cash and liquidity
            return (shortTermDept + longTermDept) - liquidity
        }

        // D/E-ratio
        fun deptEquity(totalLiabilities: Long, shareholderEquity: Long): Long{
            return totalLiabilities.div(shareholderEquity)
        }
    }
}