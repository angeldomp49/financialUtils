package org.makechtec.financial.financialutils.perpetuity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PerpetuityFactoryTest {

    private static final double MATCH = 0.00001;
    PerpetuityFactory factory = new PerpetuityFactory();

    @Test
    void testCreate() {
        PerpetuityFactory spyFactory = Mockito.spy(PerpetuityFactory.class);
        Mockito.when(spyFactory.generatePresentValue(anyDouble(), anyDouble())).thenReturn(0.1);

        spyFactory.create(0.1, 0.1);

        Mockito.verify(spyFactory, Mockito.times(1)).generatePresentValue(anyDouble(), anyDouble());
    }

    @Test
    void testCreate_growth() {
        PerpetuityFactory spyFactory = Mockito.spy(PerpetuityFactory.class);
        Mockito.when(spyFactory.generatePresentValueWithGrowth(anyDouble(), anyDouble(), anyDouble())).thenReturn(0.1);

        spyFactory.create(0.1, 0.1, 0.1);

        Mockito.verify(spyFactory, Mockito.times(1)).generatePresentValueWithGrowth(anyDouble(), anyDouble(), anyDouble());
    }

    @Test
    void testGeneratePresentValue() {
        double payment = 100;
        double interest = 0.1;
        double expected = payment/interest;

        double actual = factory.generatePresentValue(payment, interest);

        assertEquals(expected, actual, MATCH);
    }

    @Test
    void testGeneratePresentValueWithGrowth() {
        double payment = 100;
        double interest = 0.1;
        double growth = 0.05;
        double expected = payment/(interest - growth);

        double actual = factory.generatePresentValueWithGrowth(payment, interest, growth);

        assertEquals(expected, actual, MATCH);
    }
}
