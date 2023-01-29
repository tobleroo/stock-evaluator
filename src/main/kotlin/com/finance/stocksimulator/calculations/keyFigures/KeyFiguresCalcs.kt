package com.finance.stocksimulator.calculations.keyFigures

import com.finance.stocksimulator.alphaVantageAPI.stockModels.CompanyFullData
import com.finance.stocksimulator.alphaVantageAPI.stockModels.GlobalQuote
import com.finance.stocksimulator.alphaVantageAPI.stockModels.IncomeData
import com.finance.stocksimulator.alphaVantageAPI.stockModels.StockOverviewData
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.math.RoundingMode

@Service
class KeyFiguresCalcs() {

    companion object KeyCalcs {
//        pe-ratio
        fun priceEarningsRatio(stockPrice: Float, profitLoss: Float, amountShares: Int): Float {
           return stockPrice / (profitLoss / amountShares)
        }

//        peg-ratio  ------- X
        fun priceEarningsGrowths(companyData: CompanyFullData){

            val sharePrice = companyData.globalQuote!!.previousclose.toBigDecimal()
            val latestEarnings = companyData.cashFlowData!!.annualReports[0].profitLoss.toBigDecimal()
            val sharesAmount = companyData.overview!!.SharesOutstanding.toBigDecimal()

            val earningsLastYear = companyData.cashFlowData!!.annualReports[1].profitLoss.toBigDecimal()

            val thisYearEPS = latestEarnings.divide(sharesAmount, 2, RoundingMode.HALF_UP)
            val lastYearEPS = earningsLastYear.divide(sharesAmount, 2 , RoundingMode.HALF_UP)
            val growthRate = ((thisYearEPS.divide(lastYearEPS,2 , RoundingMode.HALF_UP)) - BigDecimal(1)) * BigDecimal(100)

            val dmeo = sharePrice/thisYearEPS
            val pegRatio = dmeo.divide(growthRate, 2, RoundingMode.HALF_UP)
            println("peg -> $pegRatio")
            }

        fun returnOnCapital(companyData: CompanyFullData){
            val netIncome = companyData.incomeData!!.annualReports[0].netIncome.toBigDecimal()
            val debt = companyData.balanceData!!.annualReports[0].currentDebt.toBigDecimal()
            val equity = companyData.balanceData!!.annualReports[0].totalAssets.toBigDecimal() - companyData.balanceData!!.annualReports[0].totalLiabilities.toBigDecimal()

            val roc = netIncome.divide(debt.plus(equity), 2 , RoundingMode.HALF_UP) * BigDecimal(100)
            println("roc -> $roc%")
        }
    }

}







    /*
    roc
    tillväxt
    vinst
    skulder
    soliditet
    marginal(er?) ex rörelse, vinst, brutto - marginal
    utdelning

     */
