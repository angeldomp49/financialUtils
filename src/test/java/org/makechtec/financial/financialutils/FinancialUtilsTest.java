package org.makechtec.financial.financialutils;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FinancialUtilsTest {

    @Mock
    CompoundFactor f;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFutureValue() {
        
        this.f.compoundedFactor(4, 4);
    }


    // @Test 
    // public void testPerpetuityFixedCashFlowPresentValue(){
    //     double payment = 100;
    //     double rate = 0.1;
    //     double expected = payment/rate;
    //     double actual = this.financialUtils.new PerpetuityFixedCashFlow().presentValue(payment, rate);
    //     assertEquals(expected, actual);
    // }

    // @Test 
    // public void testPerpetuityFixedCashFlowPresentValue_grow(){
    //     double payment = 100;
    //     double rate = 0.1;
    //     double growth = 0.05;
    //     double expected = payment/(rate - growth);
    //     double actual = this.financialUtils.new PerpetuityFixedCashFlow().presentValue(payment, rate, growth);
    //     assertEquals(expected, actual);
    // }



    // @Test
    // public void testRateEffectiveInterestRate(){
    //     double effectiveInterestRate = this.realRate.effectiveInterestRate(0.05, 12);
    //     assertEquals(0.05116, effectiveInterestRate, 0.00001);
    // }

    // @Test
    // public void testRateEffectiveInterestRate_newPeriods(){
    //     double effectiveInterestRate = this.realRate.effectiveInterestRate(0.05, 12, 24);
    //     assertEquals(0.10494, effectiveInterestRate, 0.00001);
    // }

    // @Test
    // public void testRateEffectiveContinuousInterestRate(){
    //     double effectiveInterestRate = this.realRate.effectiveContinuousInterestRate(0.05);
    //     assertEquals(0.05127, effectiveInterestRate, 0.00001);
    // }

}
