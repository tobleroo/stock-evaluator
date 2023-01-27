package com.finance.stocksimulator.alphaVantageAPI.service

import com.finance.stocksimulator.alphaVantageAPI.FetchAlphaVantageDataAPI
import com.finance.stocksimulator.alphaVantageAPI.stockModels.CompanyFullData
import org.springframework.stereotype.Service
import kotlin.reflect.full.memberProperties

@Service
class AlphaStockApiService (private val fetchAlphaApi: FetchAlphaVantageDataAPI){

    private var collectedStocks = arrayListOf<CompanyFullData>()

    fun fetchAllAlphaData(companySymbol: String): CompanyFullData{
        val company = checkIfCompanyExistsInList(companySymbol)

        if(company.symbol == null){
            company.symbol = companySymbol
        }
        if (company.overview == null){
            company.overview = fetchAlphaApi.fetchOverviewData(companySymbol, "OVERVIEW")
        }else print("overview exists")
        if (company.incomeData == null){
            company.incomeData = fetchAlphaApi.fetchIncomeData(companySymbol, "INCOME_STATEMENT")
        }else print("income exists")
        if (company.balanceData == null){
            company.balanceData = fetchAlphaApi.fetchBalanceData(companySymbol, "BALANCE_SHEET")
        }else print("baalanbce exists")
        if (company.cashFlowData == null){
            company.cashFlowData = fetchAlphaApi.fetchCashFlowData(companySymbol, "CASH_FLOW")
        }else print("cashflow exists")
        if(company.globalQuote == null){
            company.globalQuote = fetchAlphaApi.fetchGlobalQuote(companySymbol, "GLOBAL_QUOTE")
        }

        return company
    }

    fun fetchSingleAlphaData(companySymbol: String, dataCategory: String): CompanyFullData {

        val company = checkIfCompanyExistsInList(companySymbol)

        if(checkIfCompanyHasData(dataCategory, company)){

            when (dataCategory){
                "OVERVIEW" -> company.overview = fetchAlphaApi.fetchOverviewData(companySymbol, dataCategory)
                "INCOME_STATEMENT" -> company.incomeData = fetchAlphaApi.fetchIncomeData(companySymbol, dataCategory)
                "BALANCE_SHEET" -> company.balanceData = fetchAlphaApi.fetchBalanceData(companySymbol, dataCategory)
                "CASH_FLOW" -> company.cashFlowData = fetchAlphaApi.fetchCashFlowData(companySymbol, dataCategory)
                "GLOBAL_QUOTE" -> company.globalQuote = fetchAlphaApi.fetchGlobalQuote(companySymbol, dataCategory)
            }
        }

        return company
    }


    private fun checkIfCompanyExistsInList(symbol: String): CompanyFullData {
       var company = CompanyFullData()
       if(collectedStocks.isNotEmpty()){
           collectedStocks.forEach {
               if(it.symbol == symbol){
                   company = it
               }else {
                   company.symbol = symbol
                   collectedStocks.add(company)
               }
           }
       }
        return company
    }

    private fun checkIfCompanyHasData(category: String, company: CompanyFullData): Boolean{

        val categoryExistsOrNot: Boolean = when (category) {
            "OVERVIEW" -> company.overview == null
            "INCOME_STATEMENT" -> company.incomeData == null
            "CASH_FLOW" -> company.cashFlowData == null
            "BALANCE_SHEET" -> company.balanceData == null
            else -> false
        }
        return categoryExistsOrNot
    }

    fun getStockFromList(symbol: String): CompanyFullData{

        var company = CompanyFullData()
        collectedStocks.forEach {
            if(it.symbol == symbol){
                company = it
            }
        }
        return company
    }

    fun getListOfStocks(): List<CompanyFullData>{
        return collectedStocks
    }

}