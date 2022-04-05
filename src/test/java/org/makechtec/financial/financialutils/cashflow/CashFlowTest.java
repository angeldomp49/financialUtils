
package org.makechtec.financial.financialutils.cashflow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.makechtec.financial.financialutils.CompoundFactor;
import org.makechtec.financial.financialutils.Rate;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;


public class CashFlowTest {

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
        Mockito.when(this.factor.compoundFactor(anyDouble(), anyInt())).thenReturn(1.0);

        this.cashFlow.futureValue(2000, 0.03, 12);
        Mockito.verify(this.factor).compoundFactor(anyDouble(), anyInt());
    }

    @Test
    public void testFutureValueWithStatedRate() {
        Mockito.when(this.factor.effectiveInterestFactor(anyDouble(), anyInt())).thenReturn(1.0);

        this.cashFlow.futureValueWithStatedRate(2000, 0.03, 12);
        Mockito.verify(this.factor).effectiveInterestFactor(anyDouble(), anyInt());
    }

    @Test
    public void testFutureValueWithStatedRate_newPeriods() {
        Mockito.when(this.factor.effectiveInterestFactor(anyDouble(), anyInt(), anyInt())).thenReturn(0.03);

        this.cashFlow.futureValueWithStatedRate(2000, 0.03, 12, 24);
        Mockito.verify(this.factor).effectiveInterestFactor(anyDouble(), anyInt(), anyInt());
    }

    @Test
    public void testPresentValue() {
        Mockito.when(this.factor.compoundFactor(anyDouble(), anyInt())).thenReturn(1.0);

        this.cashFlow.presentValue(30000, 0.03, 12);
        Mockito.verify(this.factor).compoundFactor(anyDouble(), anyInt());
    }

}
