package org.makechtec.financial.financialutils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RateTest {

    private Rate rate = new Rate();

    @Test
    public void testCompoundRate(){
        double expResult = 0.15762;
        double result = rate.compoundRate(0.05, 3);
        assertEquals(expResult, result, 0.00001);
    }

    @Test
    public void testRateFromCompound(){
        double expResult = 0.05;
        double result = rate.rateFromCompound(0.15762, 3);
        assertEquals(expResult, result, 0.00001);
    }

    @Test 
    public void testEffectiveInterestRate(){
        double expResult = 0.06120;
        double result = rate.effectiveInterestRate(0.06, 3);
        assertEquals(expResult, result, 0.00001);
    }

    @Test
    public void testEffectiveInterestRate_newPeriods(){
        double expResult = 0.12616;
        double result = rate.effectiveInterestRate(0.06, 3, 6);
        assertEquals(expResult, result, 0.00001);
    }

    @Test
    public void testEffectiveContiuousInterestRate(){
        double expResult = 0.06183;
        double result = rate.effectiveContinuousInterestRate(0.06);
        assertEquals(expResult, result, 0.00001);
    }
}
