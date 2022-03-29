
package org.makechtec.financial.financialutils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;


public class CashFlowTest {

    @Mock
    Rate rate;

    @Mock
    CompoundFactor factor;

    @InjectMocks
    CashFlow cashFlow;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFutureValue() {
        Mockito.when(this.factor.compoundedFactor(anyDouble(), anyInt())).thenReturn(1.0);

        this.cashFlow.futureValue(2000, 0.03, 12);
        Mockito.verify(this.factor).compoundedFactor(anyDouble(), anyInt());
    }

    @Test
    public void testFutureValueWithStatedRate_3args() {
        Mockito.when(this.rate.effectiveInterestRate(anyDouble(), anyInt())).thenReturn(0.03);

        this.cashFlow.futureValueWithStatedRate(2000, 0.03, 12);
        Mockito.verify(this.rate).effectiveInterestRate(anyDouble(), anyInt());
    }

    @Test
    public void testFutureValueWithStatedRate_4args() {
        Mockito.when(this.rate.effectiveInterestRate(anyDouble(), anyInt(), anyInt())).thenReturn(0.03);

        this.cashFlow.futureValueWithStatedRate(2000, 0.03, 12, 24);
        Mockito.verify(this.rate).effectiveInterestRate(anyDouble(), anyInt(), anyInt());
    }

    @Test
    public void testPresentValue() {
        Mockito.when(factor.compoundedFactor(anyDouble(), anyInt())).thenReturn(1.0);

        this.cashFlow.presentValue(30000, 0.03, 12);
        Mockito.verify(this.factor).compoundedFactor(anyDouble(), anyInt());
    }

}
