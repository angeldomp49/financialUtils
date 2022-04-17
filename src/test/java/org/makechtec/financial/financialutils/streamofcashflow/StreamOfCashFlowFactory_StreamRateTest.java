package org.makechtec.financial.financialutils.streamofcashflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyLong;

import org.junit.jupiter.api.Test;
import org.makechtec.financial.financialutils.Log;
import org.makechtec.financial.financialutils.cashflow.SimpleCashFlowFactory.CashFlowRate;
import org.makechtec.financial.financialutils.streamofcashflow.StreamOfCashFlowFactory.StreamRate;
import org.mockito.Mockito;

public class StreamOfCashFlowFactory_StreamRateTest {
    @Test
    void testCreate() {
        StreamRate streamRate = Mockito.spy(StreamRate.class);

        Mockito.when(streamRate.generateFinalRate(Mockito.anyDouble(), Mockito.anyLong())).thenReturn(100.0);

        streamRate.create(100.0, 10);

        Mockito.verify(streamRate, Mockito.times(1)).generateFinalRate(anyDouble(), anyLong());
    }

    @Test
    void testCreate_noInitRate() {
        StreamRate streamRate = Mockito.spy(StreamRate.class);

        Mockito.when(streamRate.generateInitRate(anyLong(), anyDouble())).thenReturn(100.0);

        streamRate.create(10, 100.0);

        Mockito.verify(streamRate, Mockito.times(1)).generateInitRate(anyLong(), anyDouble());
    }

    @Test
    void testCreate_noPeriod() {
        StreamRate streamRate = Mockito.spy(StreamRate.class);

        Mockito.when(streamRate.generatePeriod(anyDouble(), anyDouble())).thenReturn(10L);

        streamRate.create(100.0, 100.0);

        Mockito.verify(streamRate, Mockito.times(1)).generatePeriod(anyDouble(), anyDouble());
    }

    @Test
    void testGenerateFinalRate() {
        CashFlowRate cashFlowRate = new CashFlowRate();
        double initRate = 0.05;
        long period = 10;

        double dividend = cashFlowRate.create(initRate, period).getFinalRate();
        double expected = (dividend/initRate)-1;

        StreamRate streamRate = new StreamRate();

        double actual = streamRate.create(initRate, period).getFinalRate();

        assertEquals(expected, actual);
    }

    @Test
    void testGenerateInitRate() {
        
    }

    @Test
    void testGeneratePeriod() {
        double initRate = 0.05;
        double finalRate = 0.1;

        double r = initRate * (finalRate+1);
        r = r+1;
        double base = 1+initRate;
        r = new Log().customBase(base, r);
        double expected = Math.round(r);

        StreamRate streamRate = new StreamRate();

        double actual = streamRate.generatePeriod(initRate, finalRate);

        assertEquals(expected, actual);
    }
}
