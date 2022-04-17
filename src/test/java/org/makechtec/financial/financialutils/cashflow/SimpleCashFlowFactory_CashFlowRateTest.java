package org.makechtec.financial.financialutils.cashflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyLong;

import org.junit.jupiter.api.Test;
import org.makechtec.financial.financialutils.Log;
import org.makechtec.financial.financialutils.cashflow.SimpleCashFlowFactory.CashFlowRate;
import org.mockito.Mockito;

public class SimpleCashFlowFactory_CashFlowRateTest {


    private static final double MATCH = 0.00001;

    @Test
    void testCreate() {
        CashFlowRate rate = Mockito.spy(CashFlowRate.class);
        Mockito.when(rate.generateFinalRate(anyDouble(), anyLong())).thenReturn(0.1);

        rate.create(0.2, 10);

        Mockito.verify(rate, Mockito.times(1)).generateFinalRate(anyDouble(), anyLong());
    }

    @Test
    void testCreate_noInitRate() {
        CashFlowRate rate = Mockito.spy(CashFlowRate.class);
        Mockito.when(rate.generateInitRate(anyLong(), anyDouble())).thenReturn(0.2);

        rate.create(10, 0.2);

        Mockito.verify(rate, Mockito.times(1)).generateInitRate(anyLong(), anyDouble());
    }

    @Test
    void testCreate_noPeriod() {
        CashFlowRate rate = Mockito.spy(CashFlowRate.class);
        Mockito.when(rate.generatePeriod(anyDouble(), anyDouble())).thenReturn((long)10);

        rate.create(0.2, 0.1);

        Mockito.verify(rate, Mockito.times(1)).generatePeriod(anyDouble(), anyDouble());
    }

    @Test
    void testGenerateFinalRate() {
        double initRate = 0.1;
        long period = 1;
        double expected = (Math.pow((1+initRate), period)) -1;
        CashFlowRate cashFlowRate = new CashFlowRate();
        double finalRate = cashFlowRate.generateFinalRate(initRate, period);

        assertEquals(expected, finalRate, MATCH);
    }

    @Test
    void testGenerateInitRate() {
        double finalRate = 0.1;
        long period = 1;
        double exponent = 1/period;
        double rate = finalRate +1;
        rate = Math.pow(rate, exponent);
        double expected = rate -1;
        CashFlowRate cashFlowRate = new CashFlowRate();

        double initRate = cashFlowRate.generateInitRate(period, finalRate);

        assertEquals(expected, initRate, MATCH);
    }

    @Test
    void testGenerateInitRate_periodEqualToZero() {
        double finalRate = 0.1;
        long period = 0;
        double expected = finalRate;
        CashFlowRate cashFlowRate = new CashFlowRate();

        double initRate = cashFlowRate.generateInitRate(period, finalRate);

        assertEquals(expected, initRate, MATCH);
    }

    @Test
    void testGeneratePeriod() {
        double initRate = 0.1;
        double finalRate = 0.1;
        double y = finalRate +1;
        double x = initRate +1;

        double periods = new Log().customBase(x, y);
        double expected = Math.round(periods);

        CashFlowRate cashFlowRate = new CashFlowRate();

        long period = cashFlowRate.generatePeriod(initRate, finalRate);

        assertEquals(expected, period, MATCH);
    }
}
