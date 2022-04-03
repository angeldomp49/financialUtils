package org.makechtec.financial.financialutils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompoundFactorTest {

    @Test
    public void testCompoundedFactor() {
        System.out.println("compoundedFactor");
        double rate = 0.08;
        int periods = 10;
        CompoundFactor instance = new CompoundFactor();
        double expResult = 2.15892;
        double result = instance.compoundedFactor(rate, periods);
        assertEquals(expResult, result, 0.000001);
    }

    @Test
    public void testAnnuityCompoundFactor_double_int() {
        System.out.println("annuityCompoundFactor");
        double rate = 0.05;
        int periods = 2;
        CompoundFactor instance = new CompoundFactor();
        double expResult = 0.05062;
        double result = instance.annuityCompoundFactor(rate, periods);
        assertEquals(expResult, result, 0.000001);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAnnuityCompoundFactor_3args() {
        System.out.println("annuityCompoundFactor");
        double rate = 0.05;
        double growth = 0.03;
        int periods = 10;
        CompoundFactor instance = new CompoundFactor();
        double expResult = 0.0;
        double result = instance.annuityCompoundFactor(rate, growth, periods);
        assertEquals(expResult, result, 0.000001);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAnnuityDiscountFactor_double_int() {
        System.out.println("annuityDiscountFactor");
        double rate = 0.0;
        int periods = 0;
        CompoundFactor instance = new CompoundFactor();
        double expResult = 0.0;
        double result = instance.annuityDiscountFactor(rate, periods);
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAnnuityDiscountFactor_3args() {
        System.out.println("annuityDiscountFactor");
        double rate = 0.0;
        double growth = 0.0;
        int periods = 0;
        CompoundFactor instance = new CompoundFactor();
        double expResult = 0.0;
        double result = instance.annuityDiscountFactor(rate, growth, periods);
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }
    
}
