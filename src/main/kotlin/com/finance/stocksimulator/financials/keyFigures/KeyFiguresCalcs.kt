package com.finance.stocksimulator.financials.keyFigures

import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.pow
import kotlin.math.roundToInt

@Service
class KeyFiguresCalcs() {

    companion object KeyCalcs {

//        pe-ratio
        fun priceEarningsRatio(stockPrice: Double, profitLoss: Double, amountShares: Int): Double {
           return stockPrice / (profitLoss / amountShares)
        }

//        peg-ratio  ------- X
        fun priceEarningsGrowths(sharePrice: BigDecimal,
                                 latestEarnings: BigDecimal,
                                 sharesAmount: BigDecimal,
                                 earningsLastYear: BigDecimal): Double {

            val thisYearEPS = latestEarnings.divide(sharesAmount, 2, RoundingMode.HALF_UP)
            val lastYearEPS = earningsLastYear.divide(sharesAmount, 2 , RoundingMode.HALF_UP)
            val growthRate = ((thisYearEPS.divide(lastYearEPS,2 , RoundingMode.HALF_UP)) - BigDecimal(1)) * BigDecimal(100)

            val demo = sharePrice/thisYearEPS
            return demo.divide(growthRate, 2, RoundingMode.HALF_UP).toDouble()
        }

//        roc - ratio
        fun returnOnCapital(netIncome: BigDecimal, debt: BigDecimal, equity: BigDecimal): BigDecimal{

            return netIncome.divide(debt.plus(equity), 3 , RoundingMode.HALF_UP) * BigDecimal(100)
        }

//        CAGR
        fun compoundAnnualGrowthRate(endValue: BigDecimal, beginValue: BigDecimal, years: Int): Int{

            val firstStep = endValue.divide(beginValue, 5, RoundingMode.HALF_UP)

            val secondStep = firstStep.toDouble()
                .pow((1.toBigDecimal().divide(years.toBigDecimal(),2 , RoundingMode.HALF_UP)).toDouble())

            val thirdStep = (secondStep - 1) * 100

            // need to round to 2 decimals instead. this is not accurate
            return thirdStep.roundToInt()
        }

        //resultat efte finans poster
        fun resultAfterFinancePosts(income: BigDecimal, costs: BigDecimal): BigDecimal{
            return income.minus(costs)
        }

        //ränte kostnader
        fun interestCosts(): BigDecimal{

        }

        // resultat före finans kostnader

        //nettoomsättning

        // vinstmarginal

        // justerat eget kapital

        // räntebärande skulder

        // sysselsatt kapital

        // kap.oms.hast.ggr/år

        // avkastning sysselsatt kapital

    }

}

    /*
    skulder
    soliditet
    marginal(er?) ex rörelse, vinst, brutto - marginal
    utdelning

     */
