package com.finance.stocksimulator.financials.services

import com.finance.stocksimulator.alphaVantageAPI.stockModels.CompanyFullData
import com.finance.stocksimulator.financials.calculations.BackTestCalculations
import com.finance.stocksimulator.financials.financeModels.backtestDAO.BacktestDAO
import com.finance.stocksimulator.financials.financeModels.basicEvalModel.BasicCompanyEvaluation
import com.finance.stocksimulator.financials.financeModels.basicEvalModel.TechCompanyEvaluation

class BacktestService {

    companion object{

        fun backTestTechStock(companyLatestData: BasicCompanyEvaluation,
                              companyEarlierData: BasicCompanyEvaluation): BacktestDAO?{

            return try{
                val peDiff = BackTestCalculations.calcDifferenceInPercentage(companyLatestData.peRatio, companyEarlierData.peRatio)
                val epsDiff = BackTestCalculations.calcDifferenceInPercentage(companyLatestData.earningsPerShare, companyEarlierData.earningsPerShare)
                val revenueGrowthDiff = BackTestCalculations.calcDifferenceInPercentage(companyLatestData.revenueGrowthPercentage, companyEarlierData.revenueGrowthPercentage)
                val debtToEquityDiff = BackTestCalculations.calcDifferenceInPercentage(companyLatestData.debtToEquity, companyEarlierData.debtToEquity)
                val roeDiff = BackTestCalculations.calcDifferenceInPercentage(companyLatestData.returnOnEquity?.toDouble(), companyEarlierData.returnOnEquity?.toDouble())
                val grossMarginDiff = BackTestCalculations.calcDifferenceInPercentage(companyLatestData.grossMarginPercentage, companyEarlierData.grossMarginPercentage)
                val operationMarginDiff = BackTestCalculations.calcDifferenceInPercentage(companyLatestData.operatingMargin, companyEarlierData.operatingMargin)
                val marketCapDiff = BackTestCalculations.calcDifferenceInPercentage(companyLatestData.marketCap?.toDouble(), companyEarlierData.marketCap?.toDouble())
                val dividendDiff = BackTestCalculations.calcDifferenceInPercentage(companyLatestData.dividendYieldPercentage, companyEarlierData.dividendYieldPercentage)
                val betaDiff = BackTestCalculations.calcDifferenceInPercentage(companyLatestData.betaValue, companyEarlierData.betaValue)
                val profitMarginDiff = BackTestCalculations.calcDifferenceInPercentage(companyLatestData.profitMargin, companyEarlierData.profitMargin)

                val operatingMarginDiff = BackTestCalculations.calcDifferenceInPercentage(companyLatestData.operatingMargin, companyEarlierData.operatingMargin)
                val netMarginDiff = BackTestCalculations.calcDifferenceInPercentage(companyLatestData.netMargin, companyEarlierData.netMargin)
                val ebitdaDiff = BackTestCalculations.calcDifferenceInPercentage(companyLatestData.ebitda, companyEarlierData.ebitda)
                val preTaxMArginDiff = BackTestCalculations.calcDifferenceInPercentage(companyLatestData.preTaxMargin, companyEarlierData.preTaxMargin)

                BacktestDAO(
                    peDiff, epsDiff, revenueGrowthDiff, debtToEquityDiff, roeDiff, grossMarginDiff, operationMarginDiff,
                            marketCapDiff, dividendDiff, betaDiff, profitMarginDiff, operatingMarginDiff, netMarginDiff,
                            ebitdaDiff, preTaxMArginDiff, companyLatestData, companyEarlierData )
            }catch (e: Exception){
                return null
            }





        }
    }


}