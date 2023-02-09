package com.finance.stocksimulator.financials.calculations

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class KeyFiguresCalcsTest{


    @Test
    fun ` assert that pe calc is right`(){
        val calcValue = KeyFiguresCalcs.priceEarningsRatio(BigDecimal(20.0), BigDecimal(100.0), BigDecimal(100))
        val shouldBe = 20.0

        assertEquals(calcValue, shouldBe)
    }

    @Test
    fun `assert peg ratio calcs right`(){
        val calcValue = KeyFiguresCalcs.priceEarningsGrowths(
            BigDecimal(10),
            BigDecimal(300), BigDecimal(100), BigDecimal(200)
        )

        assertEquals(0.06, calcValue)
    }

    @Test
    fun `return on capital calcs right`(){
        val calcValue =
            KeyFiguresCalcs.returnOnCapital(
                BigDecimal(11025000000),
                BigDecimal(217366000000),
                BigDecimal(217366000000)
            )

        assertEquals(2.500, calcValue.toDouble())
    }

    @Test
    fun `CAGR calcs right`(){
        val calcValue = KeyFiguresCalcs.compoundAnnualGrowthRate(BigDecimal(19000), BigDecimal(10000), 3)
        assertEquals(24, calcValue)
    }

    @Test
    fun `test intrinsic value returns the right amount`(){
        val result = KeyFiguresCalcs.discountedCashFlow(BigDecimal(16.5), BigDecimal(5),
            BigDecimal(100), BigDecimal(200), BigDecimal(10)
        )

        println(result)
    }

    @Test
    fun `demo `(){
        val sum = { x: Int, y: Int -> x + y }
        println(sum(1,4))
    }

}