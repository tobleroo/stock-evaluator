package com.finance.stocksimulator.financials.services

import com.finance.stocksimulator.alphaVantageAPI.stockModels.CompanyFullData
import com.finance.stocksimulator.financials.calculations.KeyFiguresCalcs
import com.finance.stocksimulator.financials.financeModels.basicModel.BasicCompanyEvaluation
import com.finance.stocksimulator.financials.financeModels.basicModel.TechCompanyEvaluation
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

@Service
class EvaluationService {

    companion object{

        fun evaluateCompany(companyData: CompanyFullData): BasicCompanyEvaluation {

            val peRatio = KeyFiguresCalcs.priceEarningsRatio(companyData.globalQuote!!.price.toDouble(),
                companyData.cashFlowData!!.annualReports[0].profitLoss.toDouble(),
                companyData.overview!!.SharesOutstanding.toLong())

            val EPS = KeyFiguresCalcs.earningsPerShare(companyData.overview!!.SharesOutstanding.toLong(),
                companyData.cashFlowData!!.annualReports[0].profitLoss.toLong())

            val revenueGrowth = KeyFiguresCalcs.revenueGrowthPercentage(companyData.cashFlowData!!.annualReports[0].profitLoss.toLong(),
                companyData.cashFlowData!!.annualReports[1].profitLoss.toLong())

            val debtToEquity = KeyFiguresCalcs.deptToEquity(companyData.balanceData!!.annualReports[0].currentDebt.toLong(),
                companyData.balanceData!!.annualReports[0].totalShareholderEquity.toLong())

            val roeDupont = KeyFiguresCalcs.returnOnEquityDupont(companyData.incomeData!!.annualReports[0].netIncome.toDouble(),
                companyData.balanceData!!.annualReports[0].intangibleAssets.toLong(),
                companyData.balanceData!!.annualReports[0].totalShareholderEquity.toDouble())

            val grossMargin = KeyFiguresCalcs.grossMarginPercentage(companyData.incomeData!!.annualReports[0].totalRevenue.toLong(),
                companyData.incomeData!!.annualReports[0].costofGoodsAndServicesSold.toLong())

            val operationMargin = KeyFiguresCalcs.operationMarginPercentage(companyData.incomeData!!.annualReports[0].grossProfit.toLong(),
                companyData.incomeData!!.annualReports[0].operatingExpenses.toLong(),
                companyData.incomeData!!.annualReports[0].totalRevenue.toLong())

            val marketCap = KeyFiguresCalcs.marketCapitalization(companyData.globalQuote!!.price.toDouble(),
                companyData.overview!!.SharesOutstanding.toLong())

            val dividendYield = KeyFiguresCalcs.dividendYieldPercentage(companyData.overview!!.DividendPerShare.toDouble(),
                companyData.globalQuote!!.previousclose.toDouble())


            return when (companyData.overview?.Sector){
                ("TECHNOLOGY") -> { TechCompanyEvaluation(peRatio, EPS, revenueGrowth, debtToEquity,
                        roeDupont, grossMargin, operationMargin, marketCap, dividendYield) }
                else -> throw IllegalArgumentException("something went wrong")
            }

        }
    }
}