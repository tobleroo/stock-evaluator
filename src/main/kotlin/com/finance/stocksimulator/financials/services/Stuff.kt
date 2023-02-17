package com.finance.stocksimulator.financials.services

import com.finance.stocksimulator.alphaVantageAPI.stockModels.ListingStocks

class Stuff {

    companion object{

        fun extractExchanges(list: List<ListingStocks>): MutableList<ListingStocks> {
//            val exchanges =  mutableListOf<String>()
//
//            list.forEach {
//                if(!exchanges.contains(it.exchange)){
//                    exchanges.add(it.exchange)
//                }
//            }
//            exchanges.forEach { println(it) }

            val nyse = mutableListOf<ListingStocks>()

            list.forEach{
                if(it.exchange == "NASDAQ"){
                    nyse.add(it)
                }
            }

            return nyse
        }
    }
}