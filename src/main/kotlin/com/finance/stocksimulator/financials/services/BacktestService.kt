package com.finance.stocksimulator.financials.services

import com.finance.stocksimulator.alphaVantageAPI.stockModels.CompanyFullData
import com.finance.stocksimulator.financials.financeModels.basicEvalModel.BasicCompanyEvaluation
import com.finance.stocksimulator.financials.financeModels.basicEvalModel.TechCompanyEvaluation

class BacktestService {

    companion object{

        fun backTestTechStock(companyLatestData: BasicCompanyEvaluation,
                              companyEarlierData: BasicCompanyEvaluation){

            // jämför sen värdena från båda classer och lägg in i backtest objectet

            // check price diff

            // utdelning diff

            /* marginaler:
            * vinst, omsättning
            *
            */

            // soliditet
            // profit diff

            // debt diff

            //

        }
    }


}