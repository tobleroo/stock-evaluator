package com.finance.stocksimulator.calculations.keyFigures

import com.google.gson.JsonObject
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class KeyFiguresCalcs() {

    fun priceEarningsRatio(sharePrice: Float, profitByStock: Float): Float = sharePrice/profitByStock




    fun priceEarningsGrowths(sharePrice: BigDecimal, eps: Float, epsGrowthRate: Float){
        // (share price / eps ) / eps growth rate


    }

    /*
    peg
    roc
    tillväxt
    vinst
    skulder
    soliditet
    marginal(er?) ex rörelse, vinst, brutto - marginal
    utdelning

     */

}