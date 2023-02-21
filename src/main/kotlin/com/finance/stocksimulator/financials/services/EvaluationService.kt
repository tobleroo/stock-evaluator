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

        fun evaluateCompany(companyData: CompanyFullData, year: Int): BasicCompanyEvaluation {

            val peRatio = KeyFiguresCalcs.priceEarningsRatio(companyData.globalQuote!!.price,
                companyData.cashFlowData!!.annualReports[year].profitLoss,
                companyData.overview!!.SharesOutstanding)

            val EPS = KeyFiguresCalcs.earningsPerShare(companyData.overview!!.SharesOutstanding,
                companyData.cashFlowData!!.annualReports[year].profitLoss)

            val revenueGrowth = KeyFiguresCalcs.revenueGrowthPercentage(companyData.cashFlowData!!.annualReports[year].profitLoss,
                companyData.cashFlowData!!.annualReports[year+1].profitLoss)

            val debtToEquity = KeyFiguresCalcs.deptToEquity(companyData.balanceData!!.annualReports[year].currentDebt,
                companyData.balanceData!!.annualReports[year].totalShareholderEquity)

            val roeDupont = KeyFiguresCalcs.returnOnEquityDupont(companyData.incomeData!!.annualReports[year].netIncome,
                companyData.balanceData!!.annualReports[year].intangibleAssets,
                companyData.balanceData!!.annualReports[year].totalShareholderEquity)

            val grossMargin = KeyFiguresCalcs.grossMarginPercentage(companyData.incomeData!!.annualReports[year].totalRevenue  ,
                companyData.incomeData!!.annualReports[year].costofGoodsAndServicesSold)

            val operationMargin = KeyFiguresCalcs.operationMarginPercentage(companyData.incomeData!!.annualReports[year].grossProfit,
                companyData.incomeData!!.annualReports[year].operatingExpenses,
                companyData.incomeData!!.annualReports[year].totalRevenue)

            val marketCap = KeyFiguresCalcs.marketCapitalization(companyData.globalQuote!!.price,
                companyData.overview!!.SharesOutstanding)

            val dividendYield = KeyFiguresCalcs.dividendYieldPercentage(companyData.overview!!.DividendPerShare,
                companyData.globalQuote!!.previousclose)


            return when (companyData.overview?.Sector){
                ("TECHNOLOGY") -> { TechCompanyEvaluation(peRatio, EPS, revenueGrowth, debtToEquity,
                        roeDupont, grossMargin, operationMargin, marketCap, dividendYield) }
                else -> throw IllegalArgumentException("havent implemented class for ${companyData.overview?.Sector}")
            }

        }
    }
}