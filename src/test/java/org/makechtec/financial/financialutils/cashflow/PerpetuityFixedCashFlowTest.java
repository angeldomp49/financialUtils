package org.makechtec.financial.financialutils.cashflow;

import org.junit.jupiter.api.Test;
import org.makechtec.financial.financialutils.cashflow.PerpetuityFixedCashFlow;

import static org.junit.jupiter.api.Assertions.*;

public class PerpetuityFixedCashFlowTest {

    @Test
    public void testPresentValue_double_double() {
        System.out.println("presentValue");
        double payment = 2000.0;
        double rate = 0.1;
        PerpetuityFixedCashFlow instance = new PerpetuityFixedCashFlow();
        double expResult = 20000.0;
        double result = instance.presentValue(payment, rate);
        assertEquals(expResult, result, 0.000001);
    }

    @Test
    public void testPresentValue_3args() {
        System.out.println("presentValue");
        double payment = 2000.0;
        double rate = 0.1;
        double growth = 0.05;
        PerpetuityFixedCashFlow instance = new PerpetuityFixedCashFlow();
        double expResult = 40000.0;
        double result = instance.presentValue(payment, rate, growth);
        assertEquals(expResult, result, 0.000001);
    }
    
}
