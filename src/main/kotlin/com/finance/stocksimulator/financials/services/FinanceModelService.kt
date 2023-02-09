package com.finance.stocksimulator.financials.services

import com.finance.stocksimulator.alphaVantageAPI.stockModels.CompanyFullData
import com.finance.stocksimulator.financials.calculations.KeyFiguresCalcs
import com.finance.stocksimulator.financials.financeModels.DuPontModel
import org.springframework.stereotype.Service

@Service
class FinanceModelService {

    fun createDuPontModel(companyData: CompanyFullData): DuPontModel{
        val netProfitMargin = KeyFiguresCalcs.netProfitMargin(
            companyData.incomeData!!.annualReports[0].netIncome.toBigDecimal(),
            companyData.incomeData!!.annualReports[0].totalRevenue.toBigDecimal())

        val assetTurnover = KeyFiguresCalcs.assetTurnover(
            companyData.incomeData!!.annualReports[0].costofGoodsAndServicesSold.toBigDecimal(),
            companyData.balanceData!!.annualReports[0].totalCurrentAssets.toBigDecimal())

        val equityMultiplier = KeyFiguresCalcs.equityMultiplier(
            companyData.balanceData!!.annualReports[0].totalCurrentAssets.toBigDecimal(),
            companyData.balanceData!!.annualReports[0].totalShareholderEquity.toBigDecimal())

        return DuPontModel(netProfitMargin, assetTurnover, equityMultiplier)
    }


}