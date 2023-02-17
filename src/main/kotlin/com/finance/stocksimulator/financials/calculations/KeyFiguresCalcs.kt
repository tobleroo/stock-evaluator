package com.finance.stocksimulator.financials.calculations

import org.springframework.stereotype.Service
import java.math.BigDecimal

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
        fun revenueGrowthPercentage(latestYearEarnings: Long, yearBeforeEarnings: Long): Double{
            val calc = (latestYearEarnings.toDouble().minus(yearBeforeEarnings).div(yearBeforeEarnings))
            return calc.times(100)
        }

//      ratio debt to equity
        fun deptToEquity(totalDebt: Long, shareholderEquity: Long): Double {
            return totalDebt.toDouble().div(shareholderEquity)
        }

//        return on equity basic(ROE)
        fun returnOnEquityBasic(netIncome: Double, shareholderEquity: Double): Double{
            return netIncome.div(shareholderEquity).times(100)
        }

//        return on equity dupont model
        fun returnOnEquityDupont(netIncome: Double, totalAssets: Long,
                                 totalEquity: Double): Int{

            val netProfitMarginPercentage = (netIncome.div(totalEquity))

            val assetTurnoverPercentage = netIncome.div(totalAssets)

            val financialLeverage = totalAssets.div(totalEquity)

            return (netProfitMarginPercentage * assetTurnoverPercentage * financialLeverage).times(100).toInt()
        }

        //        gross margin
        fun grossMarginPercentage(revenue: Long, costGoodsSold: Long): Double {
            val step1 = revenue.toDouble().minus(costGoodsSold)
            val step2 = step1.div(revenue)
            return step2.times(100)
        }

//        operation margin
        fun operationMarginPercentage(grossProfit: Long, operatingExpenses: Long, revenue: Long): Double{
            return (grossProfit.toDouble().minus(operatingExpenses)).div(revenue).times(100)
        }

//        market capitalization
        fun marketCapitalization(stockPrice: Double, sharesAmount: Long): Long{
            return stockPrice.times(sharesAmount).toLong()
        }

//        beta (extrem uträkning)
       fun betaValue(){
           TODO("advanced calculation not yet implemented")
       }

//        dividend yield

        fun dividendYieldPercentage(annualDividendPerShare: Double, stockPrice: Double): Double{
            return annualDividendPerShare.div(stockPrice).times(100)
        }

    }

}
