package com.finance.stocksimulator.financials.calculations

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BackTestCalculationsTest{

    @Test
    fun `check pe ratio diff`(){
        val shouldBeMinus50 = BackTestCalculations.calcDifferenceInPercentage(50.0, 100.0)
        assertEquals(-50.0, shouldBeMinus50)

        val shouldBeNull = BackTestCalculations.calcDifferenceInPercentage(null, 5.0)
        assertEquals(null, shouldBeNull)
    }
}