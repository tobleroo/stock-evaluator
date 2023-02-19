package com.finance.stocksimulator.financials.calculations

import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.pow
import kotlin.math.roundToInt

class NotUsedMethods {

    //        peg-ratio  ------- X
    fun priceEarningsGrowths(sharePrice: Long, latestEarnings: Long,
                             sharesAmount: Long, earningsLastYear: Long): Double {

        val thisYearEps = latestEarnings.div(sharesAmount).toDouble()
        val lastYearEps = earningsLastYear.div(sharesAmount).toDouble()
        val growthRate = (thisYearEps.div(lastYearEps) - 1).times(100)

        val demo = sharePrice.div(thisYearEps)
        val final = demo.div(growthRate)

        return (final * 100).roundToInt() / 100.0
    }


    //        roc - ratio
    fun returnOnCapital(netIncome: Long, debt: Long, equity: Long): Double{

        val stepOne = debt.plus(equity).toDouble()
        val stepTwo = netIncome.div(stepOne)
        val stepThree = stepTwo.times(100)
        return (stepThree * 10).roundToInt() / 10.0
    }

    //        CAGR
    fun compoundAnnualGrowthRate(endValue: Long, beginValue: Long, years: Int): Double{

        val firstStep = endValue.toDouble().div(beginValue)
        val secondStep = firstStep.pow((1 / years.toDouble()))
        val thirdStep = (secondStep - 1) * 100

        return (thirdStep * 100).roundToInt() / 100.0
    }

    // till du-pont modellen
    fun netProfitMargin(netIncome: BigDecimal, revenue: BigDecimal):BigDecimal{
        return netIncome.divide(revenue, 3 , RoundingMode.HALF_DOWN)
    }

    fun assetTurnover(sales: BigDecimal, averageTotalAssets: BigDecimal): BigDecimal{
        return sales.divide(averageTotalAssets, 3, RoundingMode.HALF_DOWN)
    }

    fun equityMultiplier(averageTotalAssets: BigDecimal, averageShareHolderEquity: BigDecimal): BigDecimal{
        return averageTotalAssets.divide(averageShareHolderEquity, 3, RoundingMode.HALF_DOWN)
    }

    //ratio debt to equity
    fun deptToEquity(totalDebt: BigDecimal, shareholderEquity: BigDecimal): BigDecimal {
        return totalDebt.divide(shareholderEquity)
    }

    // intrinsic value / egenvärde
    // discounted cash flow
    fun discountedCashFlow(earnings: Double, amountShares: Long,
                           latestYearEarnings: Long, lastYearEarnings: Long,
                           stockPrice: Double ): Double? {
        /*
        EPS * (1 + R) * P/E-ratio
        r = expected earnings growth rate
         */

        val ePS = earnings.div(amountShares)
        val expextedGrowthRate = latestYearEarnings.div(lastYearEarnings).toDouble()
//        val peRatio = KeyFiguresCalcs.priceEarningsRatio(stockPrice, earnings, amountShares)

//        return ePS.times(1 + expextedGrowthRate).times(peRatio)
        return null
    }
}