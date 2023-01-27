package com.finance.stocksimulator.calculations.keyFigures

import com.finance.stocksimulator.alphaVantageAPI.stockModels.GlobalQuote
import com.finance.stocksimulator.alphaVantageAPI.stockModels.IncomeData
import com.finance.stocksimulator.alphaVantageAPI.stockModels.StockOverviewData
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class KeyFiguresCalcs() {

    companion object KeyCalcs {
//        pe-ratio
        fun priceEarningsRatio(stockPrice: Float, profitLoss: Float, amountShares: Int): Float {
           return stockPrice / (profitLoss / amountShares)
        }

//        peg-ratio
        fun priceEarningsGrowths(stockData: GlobalQuote?, incomeData: IncomeData?, overviewData: StockOverviewData?){
            // (stock price / eps ) / eps growth rate
            val growthRate =
                ((incomeData!!.annualReports[0].netIncome.toBigDecimal() / overviewData!!.SharesOutstanding.toBigDecimal())
                        / ((incomeData.annualReports[1].netIncome.toBigDecimal() / overviewData.SharesOutstanding.toBigDecimal())))


            println(incomeData!!.annualReports[0].netIncome.toBigDecimal())
            println(incomeData.annualReports[1].netIncome.toBigDecimal())
            println(overviewData.SharesOutstanding.toBigDecimal())
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

}