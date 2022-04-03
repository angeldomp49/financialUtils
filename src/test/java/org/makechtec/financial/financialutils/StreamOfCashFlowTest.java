package org.makechtec.financial.financialutils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.makechtec.financial.financialutils.cashflow.StreamOfCashFlow;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;

public class StreamOfCashFlowTest {

    @Mock 
    CompoundFactor factor;

    @InjectMocks
    StreamOfCashFlow streamOfCashFlow;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFutureValue() {
        Mockito.when(this.factor.annuityCompoundFactor(anyDouble(), anyInt())).thenReturn(1.0);

        this.streamOfCashFlow.futureValue(2000, 0.03, 12);
        Mockito.verify(this.factor).annuityCompoundFactor(anyDouble(), anyInt());
    }

    @Test
    public void testFixedPaymentAmount() {
        Mockito.when(this.factor.annuityCompoundFactor(anyDouble(), anyInt())).thenReturn(1.0);

        this.streamOfCashFlow.fixedPaymentAmount(2000, 0.03, 12);
        Mockito.verify(this.factor).annuityCompoundFactor(anyDouble(), anyInt());
    }

    @Test
    public void testPresentValue() {
        Mockito.when(this.factor.annuityDiscountFactor(anyDouble(), anyInt())).thenReturn(1.0);

        this.streamOfCashFlow.presentValue(2000, 0.03, 12);
        Mockito.verify(this.factor).annuityDiscountFactor(anyDouble(), anyInt());
    }

    @Test
    public void testFixedLoanPaymentAmount() {
        Mockito.when(this.factor.annuityDiscountFactor(anyDouble(), anyInt())).thenReturn(1.0);

        this.streamOfCashFlow.fixedLoanPaymentAmount(2000, 0.03, 12);
        Mockito.verify(this.factor).annuityDiscountFactor(anyDouble(), anyInt());
    }
    
}
