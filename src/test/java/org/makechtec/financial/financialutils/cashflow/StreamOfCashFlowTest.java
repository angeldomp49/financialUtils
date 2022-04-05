package org.makechtec.financial.financialutils.cashflow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.makechtec.financial.financialutils.CompoundFactor;
import org.makechtec.financial.financialutils.Log;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;

public class StreamOfCashFlowTest {

    @Mock 
    CompoundFactor factor;

    @Mock
    CashFlow cashFlow;

    @Mock
    Log log;

    @InjectMocks
    StreamOfCashFlow streamOfCashFlow;

    @Spy
    StreamOfCashFlow spyStreamOfCashFlow;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFutureValue() {
        Mockito.when(this.factor.streamFactor(anyDouble(), anyInt())).thenReturn(1.0);

        this.streamOfCashFlow.futureValue(2000, 0.03, 12);
        Mockito.verify(this.factor).streamFactor(anyDouble(), anyInt());
    }

    @Test
    public void testFutureValueWithInitialValue(){
        Mockito.when(this.spyStreamOfCashFlow.futureValue(anyDouble(), anyDouble(), anyInt())).thenReturn(1.0);

        this.spyStreamOfCashFlow.futureValueWithInitialValue(2000, 0.03, 12, 1000);

        Mockito.verify(this.spyStreamOfCashFlow).futureValue(anyDouble(), anyDouble(), anyInt());
    }

    @Test
    public void testPeriodsForGoal(){
        this.streamOfCashFlow.periodsForGoal(1000, 0.03, 12);

        Mockito.verify(this.log).customBase(anyDouble(), anyDouble());
    }

    @Test
    public void testPeriodsForGoalWithInitialValue(){
        this.streamOfCashFlow.periodsForGoalWithInitialValue(100000, 10000, 0.04, 20000);

        Mockito.verify(this.log).customBase(anyDouble(), anyDouble());
    }

    @Test
    public void testFixedPaymentAmount() {
        Mockito.when(this.factor.streamFactor(anyDouble(), anyInt())).thenReturn(1.0);

        this.streamOfCashFlow.fixedPaymentAmount(2000, 0.03, 12);
        Mockito.verify(this.factor).streamFactor(anyDouble(), anyInt());
    }

    @Test
    public void testPresentValue() {
        Mockito.when(this.factor.discountFactor(anyDouble(), anyInt())).thenReturn(1.0);

        this.streamOfCashFlow.presentValue(2000, 0.03, 12);
        Mockito.verify(this.factor).discountFactor(anyDouble(), anyInt());
    }

    @Test
    public void testFixedLoanPaymentAmount() {
        Mockito.when(this.factor.discountFactor(anyDouble(), anyInt())).thenReturn(1.0);

        this.streamOfCashFlow.fixedLoanPaymentAmount(2000, 0.03, 12);
        Mockito.verify(this.factor).discountFactor(anyDouble(), anyInt());
    }
    
}
