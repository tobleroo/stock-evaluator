package com.finance.stocksimulator.financials.calculations

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class KeyFiguresCalcsTest{

    @Test
    fun `earnings per share calculation with small numbers`(){
        val result = KeyFiguresCalcs.earningsPerShare("hej", "100")
        assertEquals(null, result)
//        assertEquals(2.0, result)
    }


    @Test
    fun ` assert that pe calc is right`(){
        val calcValue = KeyFiguresCalcs.priceEarningsRatio("20.0", "100", "100")
        assertEquals(20.0, calcValue)
    }

    @Test
    fun ` assert that pe calc is null`(){
        val calcValue = KeyFiguresCalcs.priceEarningsRatio("20.0", "hello", "100")
        assertEquals(null, calcValue)
    }

    @Test
    fun `revenue growth calculation with medium numbers`(){
        val result = KeyFiguresCalcs.revenueGrowthPercentage("1200000", "1000000")
        assertEquals(20.0, result)
    }

    @Test
    fun `dept to equity calculation with small numbers`(){
        val result = KeyFiguresCalcs.deptToEquity("500000", "1000000")
        assertEquals(0.5, result)
    }

    @Test
    fun `assert ROE dupont model works with real number size math`(){
        val result = KeyFiguresCalcs.returnOnEquityDupont("2000000.0", "20000000",
            "10000000.0")

        assertEquals(4, result)
    }

    @Test
    fun `test gross margin calculation with small numbers`(){
        val result = KeyFiguresCalcs.grossMarginPercentage("100", "70")

        assertEquals(30.0, result)
    }

    @Test
    fun `operation margin calculation with small numbers`(){
        val result = KeyFiguresCalcs.operationMarginPercentage("400000", "200000", "1000000")
        assertEquals(20.0, result)
    }

    @Test
    fun `market capitalization calculation with medium numbers`(){
        val result = KeyFiguresCalcs.marketCapitalization("50.0", "10000000")
        assertEquals(500000000, result)
    }

    @Test
    fun `dividend yield calculation with small numbers`(){
        val result = KeyFiguresCalcs.dividendYieldPercentage("2.0", "50.0")
        assertEquals(4.0, result)
    }
}