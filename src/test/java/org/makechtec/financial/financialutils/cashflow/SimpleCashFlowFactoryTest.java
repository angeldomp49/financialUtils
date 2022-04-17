package org.makechtec.financial.financialutils.cashflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyLong;

import org.junit.jupiter.api.Test;
import org.makechtec.financial.financialutils.cashflow.SimpleCashFlowFactory.CashFlowRate;
import org.makechtec.financial.financialutils.rate.CompoundRate;
import org.mockito.Mockito;

public class SimpleCashFlowFactoryTest {
    private static final double MATCH = 0.00001;

    @Test
    void testCreate() {
        SimpleCashFlowFactory factory = Mockito.spy(SimpleCashFlowFactory.class);

        double initialAmount = 100;
        CompoundRate rate = Mockito.mock(CompoundRate.class);

        Mockito.when(factory.generateFinalAmount(anyDouble(), anyDouble())).thenReturn(100.0);

        factory.create(initialAmount, rate);

        Mockito.verify(factory, Mockito.times(1)).generateFinalAmount(anyDouble(), anyDouble());
    }

    @Test
    void testCreate_noInitialAmount() {
        SimpleCashFlowFactory factory = Mockito.spy(SimpleCashFlowFactory.class);

        CompoundRate rate = Mockito.mock(CompoundRate.class);

        Mockito.when(factory.generateInitialAmount(anyDouble(), anyDouble())).thenReturn(100.0);

        factory.create(rate, 100);

        Mockito.verify(factory, Mockito.times(1)).generateInitialAmount(anyDouble(), anyDouble());
    }

    @Test
    void testCreate_noCompoundRate() {

        SimpleCashFlowFactory factory = Mockito.spy(SimpleCashFlowFactory.class);

        double initialAmount = 100;
        double finalAmount = 100;

        Mockito.when(factory.generateCompoundRate(anyDouble(), anyDouble(), anyLong())).thenReturn(Mockito.mock(CompoundRate.class));

        factory.create(initialAmount, finalAmount,100);

        Mockito.verify(factory, Mockito.times(1)).generateCompoundRate(anyDouble(), anyDouble(), anyLong());
    }

    @Test
    void testGenerateCompoundRate() {
        double initialAmount = 100;
        double finalAmount = 200;
        long period = 10;
        SimpleCashFlowFactory simpleCashFlowFactory = new SimpleCashFlowFactory();
        CashFlowRate cashFlowRate = new CashFlowRate();
        double difference = finalAmount - initialAmount;
        double differencePercentage = difference / finalAmount;
        double initRate = cashFlowRate.generateInitRate(period, differencePercentage);

        CompoundRate expected = new CompoundRate(initRate, period, differencePercentage);

        CompoundRate actual = simpleCashFlowFactory.generateCompoundRate(initialAmount, finalAmount, period);

        assertEquals(expected.getInitRate(), actual.getInitRate(), MATCH);
        assertEquals(expected.getPeriod(), actual.getPeriod(), MATCH);
        assertEquals(expected.getFinalRate(), actual.getFinalRate(), MATCH);
    }

    @Test
    void testGenerateFinalAmount() {
        double initialAmount = 0.1;
        double factor = 0.2;

        double expected = initialAmount * factor;

        SimpleCashFlowFactory simpleCashFlowFactory = new SimpleCashFlowFactory();

        double actual = simpleCashFlowFactory.generateFinalAmount(initialAmount, factor);

        assertEquals(expected, actual, MATCH);
    }

    @Test
    void testGenerateInitialAmount() {
        double finalAmount = 0.1;
        double factor = 0.2;

        double expected = finalAmount / factor;

        SimpleCashFlowFactory simpleCashFlowFactory = new SimpleCashFlowFactory();

        double actual = simpleCashFlowFactory.generateInitialAmount(finalAmount, factor);

        assertEquals(expected, actual, MATCH);
    }
}
