package org.makechtec.financial.financialutils;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;

import org.junit.jupiter.api.BeforeEach;

public class FinancialUtilsTest {

    @InjectMocks
    private CashFlow cashFlow = new CashFlow();

    @Mock
    private Rate rate = Mockito.mock(Rate.class);
    @Mock
    private CompoundFactor factor = Mockito.mock(CompoundFactor.class);

    private final Rate realRate = new Rate();
    private final CompoundFactor realFactor = new CompoundFactor();

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test 
    public void testCashFlowFutureValue(){
        this.cashFlow
            .futureValue(1000, 0.5, 10);

        Mockito.verify(this.factor)
                .compoundedFactor(anyDouble(), anyInt());
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
