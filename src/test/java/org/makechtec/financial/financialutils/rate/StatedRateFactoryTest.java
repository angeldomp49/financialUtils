package org.makechtec.financial.financialutils.rate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyLong;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class StatedRateFactoryTest {

    StatedRateFactory factory = new StatedRateFactory();
    private static final double MATCH = 0.00001;

    @Test
    void testContinuousRate() {
        double initRate = 0.1;
        double expected = Math.pow(Math.E, initRate) - 1;
        double finalRate = factory.continuousRate(initRate);
        assertEquals(expected, finalRate, MATCH);
    }

    @Test
    void testCreate() {
        StatedRateFactory spyFactory = Mockito.spy(StatedRateFactory.class);
        Mockito.when(spyFactory.generateFinalRate(anyDouble(), anyLong())).thenReturn(0.1);

        spyFactory.create(0.1, 10);

        Mockito.verify(spyFactory, Mockito.times(1) ).generateFinalRate(anyDouble(), anyLong());
    }

    @Test
    void testCreate_newPeriod() {
        StatedRateFactory spyFactory = Mockito.spy(StatedRateFactory.class);
        Mockito.when(spyFactory.generateFinalRate(anyDouble(), anyLong())).thenReturn(0.1);

        spyFactory.create(0.1, 10, 20);

        Mockito.verify(spyFactory, Mockito.times(1) ).generateFinalRate(anyDouble(), anyLong());
    }

    @Test
    void testCreateContinuousRate() {
        StatedRateFactory spyFactory = Mockito.spy(StatedRateFactory.class);
        Mockito.when(spyFactory.continuousRate(anyDouble())).thenReturn(0.1);

        spyFactory.createContinuousRate(0.1);

        Mockito.verify(spyFactory, Mockito.times(1)).continuousRate(anyDouble());
    }

    @Test
    void testGenerateFinalRate() {
        double initRate = 0.1;
        long period = 10;
        double expected = Math.pow((1+initRate), period) -1;
        double finalRate = factory.generateFinalRate( initRate, period);
        assertEquals(expected, finalRate, MATCH);
    }
}
