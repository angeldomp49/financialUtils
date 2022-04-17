package org.makechtec.financial.financialutils.bound;

import org.makechtec.financial.financialutils.cashflow.SimpleCashFlow;
import org.makechtec.financial.financialutils.cashflow.SimpleCashFlowFactory;

public class CouponBoundFactory {

    private SimpleCashFlowFactory simpleCashFlowFactory = new SimpleCashFlowFactory();

    public ZeroCouponBound create( double initialAmount, double finalAmount, long period){
        return new ZeroCouponBound(this.simpleCashFlowFactory.create(initialAmount, finalAmount, period));
    }
}
