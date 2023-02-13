package com.finance.stocksimulator.financials.calculations

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class KeyFiguresCalcsTest{


    @Test
    fun ` assert that pe calc is right`(){
        val calcValue = KeyFiguresCalcs.priceEarningsRatio(20.0, 100.0, 100)
        val shouldBe = 20.0

        assertEquals(calcValue, shouldBe)
    }


}