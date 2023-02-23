package com.finance.stocksimulator.financials.calculations

class BackTestCalculations {

    companion object{

        fun calcDifferenceInPercentage(latestValue: Double?, earlierValue: Double?): Double?{

            return if(latestValue != null && earlierValue != null){
                (latestValue.minus(earlierValue)).div(earlierValue).times(100)
            } else null
        }
    }
}