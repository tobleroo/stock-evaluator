package com.finance.stocksimulator.alphaVantageAPI.service

import com.finance.stocksimulator.alphaVantageAPI.FetchAlphaVantageDataAPI
import com.finance.stocksimulator.alphaVantageAPI.stockModels.CompanyFullData
import com.finance.stocksimulator.alphaVantageAPI.stockModels.ListingStocks
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AlphaStockApiService (){


    companion object{

        private val fetchAlphaApi: FetchAlphaVantageDataAPI = FetchAlphaVantageDataAPI()
        private var collectedStocks = arrayListOf<CompanyFullData>()

        fun fetchAllAlphaData(companySymbol: String, useForTests: Boolean): CompanyFullData{

            var company = CompanyFullData()

            if(!checkIfCompanyExistsInList(companySymbol)){


                company.symbol = companySymbol
                company.overview = fetchAlphaApi.fetchOverviewData(companySymbol, "OVERVIEW", useForTests)
                company.incomeData = fetchAlphaApi.fetchIncomeData(companySymbol, "INCOME_STATEMENT", useForTests)
                company.balanceData = fetchAlphaApi.fetchBalanceData(companySymbol, "BALANCE_SHEET", useForTests)
                company.cashFlowData = fetchAlphaApi.fetchCashFlowData(companySymbol, "CASH_FLOW", useForTests)
                company.globalQuote = fetchAlphaApi.fetchGlobalQuote(companySymbol, "GLOBAL_QUOTE", useForTests)

                collectedStocks.add(company)
            }else{
                company = getStockFromList(companySymbol)
            }

            return company
        }

        private fun checkIfCompanyExistsInList(symbol: String): Boolean {

            var existsOrNot: Boolean = false

            collectedStocks.forEach {
                if(it.symbol == symbol) existsOrNot = true
            }

            return existsOrNot

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

        fun getListing(): List<ListingStocks>{
            return fetchAlphaApi.fetchAlphaListing()
        }

    }

}