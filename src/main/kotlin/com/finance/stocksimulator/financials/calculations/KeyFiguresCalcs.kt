package com.finance.stocksimulator.financials.calculations

import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.pow
import kotlin.math.roundToInt

@Service
class KeyFiguresCalcs() {

    companion object KeyCalcs {

//        EPS
        fun earningsPerShare(amountShares: Long, profit: Long): Long{
            return profit.div(amountShares)
        }

//        pe-ratio
        fun priceEarningsRatio(stockPrice: Double, profitLoss: Double, amountShares: Long): Double {
            return stockPrice.div(profitLoss.div(amountShares))
        }

//      revenue growth
        fun revenueGrowth(latestYearEarnings: Long, yearBeforeEarnings: Long): Double{
            val calc = (latestYearEarnings.minus(yearBeforeEarnings).div(yearBeforeEarnings))
            return calc.toDouble().times(100)
        }

//      ratio debt to equity
        fun deptToEquity(totalDebt: BigDecimal, shareholderEquity: BigDecimal): BigDecimal {
            return totalDebt.divide(shareholderEquity)
        }

//        return on equity (ROE)

//        gross margin

//        operation margin

//        market capitalization

//        beta

//        dividend yield


    }

}

    /*
    skulder
    soliditet
    marginal(er?) ex rörelse, vinst, brutto - marginal
    utdelning

     */
