package org.makechtec.financial.financialutils.factor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FactorTest {
    
    @Test
    void testOf() {
        double rate = 0.1;
        double expected = rate + 1;
        double finalRate = Factor.of(rate);
        assertEquals(expected, finalRate, 0.00001);
    }
}
