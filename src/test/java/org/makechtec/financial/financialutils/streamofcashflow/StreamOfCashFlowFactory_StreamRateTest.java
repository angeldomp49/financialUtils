package org.makechtec.financial.financialutils.streamofcashflow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.makechtec.financial.financialutils.streamofcashflow.StreamOfCashFlowFactory.StreamRate;
import org.mockito.Mockito;

public class StreamOfCashFlowFactory_StreamRateTest {

    public static final double RATIO_ERROR = 0.00001;

    StreamRate streamRate;

    @BeforeEach
    public void setUp() {
        streamRate = new StreamRate();
    }

    @Test
    void testCreate_noFinalRate() {
        double initRate = 0.05;
        long period = 10;
        StreamRate spyRate = Mockito.spy(streamRate);

        spyRate.create(initRate, period);

        Mockito.verify(spyRate).create(initRate, period);
    }

    @Test
    void testCreate_noInitRate() {
        long period = 10;
        double finalRate = 0.05;

        StreamRate spyRate = Mockito.spy(streamRate);

        spyRate.create(period, finalRate);

        Mockito.verify(spyRate).create(period, finalRate);
    }

    @Test
    void testCreate_noPeriod() {
        double initRate = 0.05;
        double finalRate = 0.05;

        StreamRate spyRate = Mockito.spy(streamRate);

        spyRate.create(initRate, finalRate);

        Mockito.verify(spyRate).create(initRate, finalRate);
    }

    @Test
    void testGenerateFinalRate() {
        double initRate = 0.05;
        long period = 10;
        
        double expected = 0.05;

        double actual = this.streamRate.generateFinalRate(initRate, period);

        // assertEquals(expected, actual, RATIO_ERROR);
    }

    @Test
    void testGenerateInitRate() {
        double finalRate = 0.05;
        long period = 10;

        double expected = 0.05;

        double actual = this.streamRate.generateInitRate(period, finalRate);

        // assertEquals(expected, actual, RATIO_ERROR);
    }

    @Test
    void testGeneratePeriod() {
        double initRate = 0.05;
        double finalRate = 0.1;

        long expected = 10;

        double actual = this.streamRate.generatePeriod(initRate, finalRate);

        // assertEquals(expected, actual, RATIO_ERROR);
    }
}
