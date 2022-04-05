package org.makechtec.financial.financialutils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LogTest {
    @Test
    public void testCustomBase() {
        Log instance = new Log();
        double expResult = 3;
        double result = instance.customBase(3, 27);
        assertEquals(expResult, result, 0.00001);
    }
}
