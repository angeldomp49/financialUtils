package org.makechtec.financial.financialutils.bound;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class CouponBoundFactoryTest {

    @Test
    void testCreate() {
        CouponBoundFactory factory = new CouponBoundFactory();
        double initialAmount = 0.1;
        double finalAmount = 0.1;
        long period = 1;
        assertNotNull(factory.create(initialAmount, finalAmount, period));
    }
}
