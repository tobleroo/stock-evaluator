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

            val peRatio = KeyFiguresCalcs.priceEarningsRatio(companyData.globalQuote!!.price,
                companyData.cashFlowData!!.annualReports[0].profitLoss,
                companyData.overview!!.SharesOutstanding)

            val EPS = KeyFiguresCalcs.earningsPerShare(companyData.overview!!.SharesOutstanding,
                companyData.cashFlowData!!.annualReports[0].profitLoss)

            val revenueGrowth = KeyFiguresCalcs.revenueGrowthPercentage(companyData.cashFlowData!!.annualReports[0].profitLoss,
                companyData.cashFlowData!!.annualReports[1].profitLoss)

            val debtToEquity = KeyFiguresCalcs.deptToEquity(companyData.balanceData!!.annualReports[0].currentDebt,
                companyData.balanceData!!.annualReports[0].totalShareholderEquity)

            val roeDupont = KeyFiguresCalcs.returnOnEquityDupont(companyData.incomeData!!.annualReports[0].netIncome,
                companyData.balanceData!!.annualReports[0].intangibleAssets,
                companyData.balanceData!!.annualReports[0].totalShareholderEquity)

            val grossMargin = KeyFiguresCalcs.grossMarginPercentage(companyData.incomeData!!.annualReports[0].totalRevenue  ,
                companyData.incomeData!!.annualReports[0].costofGoodsAndServicesSold)

            val operationMargin = KeyFiguresCalcs.operationMarginPercentage(companyData.incomeData!!.annualReports[0].grossProfit,
                companyData.incomeData!!.annualReports[0].operatingExpenses,
                companyData.incomeData!!.annualReports[0].totalRevenue)

            val marketCap = KeyFiguresCalcs.marketCapitalization(companyData.globalQuote!!.price,
                companyData.overview!!.SharesOutstanding)

            val dividendYield = KeyFiguresCalcs.dividendYieldPercentage(companyData.overview!!.DividendPerShare,
                companyData.globalQuote!!.previousclose)


            return when (companyData.overview?.Sector){
                ("TECHNOLOGY") -> { TechCompanyEvaluation(peRatio, EPS, revenueGrowth, debtToEquity,
                        roeDupont, grossMargin, operationMargin, marketCap, dividendYield) }
                else -> throw IllegalArgumentException("something went wrong")
            }

        }
    }
}