package com.finance.stocksimulator.financials.services

import com.finance.stocksimulator.alphaVantageAPI.stockModels.CompanyFullData
import com.finance.stocksimulator.financials.calculations.KeyFiguresCalcs
import com.finance.stocksimulator.financials.financeModels.basicEvalModel.BasicCompanyEvaluation
import com.finance.stocksimulator.financials.financeModels.basicEvalModel.TechCompanyEvaluation
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

@Service
class EvaluationService {

    companion object{

        fun evaluateCompany(companyData: CompanyFullData, year: Int = 0): BasicCompanyEvaluation {

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

            val betaValue = KeyFiguresCalcs.betaValue(companyData.overview!!.Beta)

            val profitMargin = KeyFiguresCalcs.profitMargin(companyData.incomeData!!.annualReports[year].netIncome,
                companyData.incomeData!!.annualReports[year].totalRevenue)

            val operatingMargin = KeyFiguresCalcs.operatingMargin(companyData.incomeData!!.annualReports[year].operatingIncome,
                companyData.incomeData!!.annualReports[year].totalRevenue)

            val netMargin = KeyFiguresCalcs.netMargin(companyData.incomeData!!.annualReports[year].netIncome,
                companyData.incomeData!!.annualReports[year].totalRevenue)

            val ebitda = KeyFiguresCalcs.ebitda(companyData.incomeData!!.annualReports[year].totalRevenue,
                companyData.incomeData!!.annualReports[year].costofGoodsAndServicesSold,
                companyData.incomeData!!.annualReports[year].operatingExpenses,
                companyData.incomeData!!.annualReports[year].depreciation,
                companyData.balanceData!!.annualReports[year].accumulatedDepreciationAmortizationPPE)

            val preTax = KeyFiguresCalcs.preTaxMargin(companyData.incomeData!!.annualReports[year].incomeBeforeTax,
                companyData.incomeData!!.annualReports[year].totalRevenue)


            return when (companyData.overview?.Sector){
                ("TECHNOLOGY") -> { TechCompanyEvaluation(peRatio, EPS, revenueGrowth, debtToEquity,
                        roeDupont, grossMargin, operationMargin, marketCap, dividendYield, betaValue,
                    profitMargin, operatingMargin, netMargin, ebitda, preTax) }
                else -> throw IllegalArgumentException("havent implemented class for ${companyData.overview?.Sector}")
            }

        }
    }
}