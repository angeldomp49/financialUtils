package org.makechtec.financial.financialutils.bound;

import org.makechtec.financial.financialutils.cashflow.SimpleCashFlow;
import org.makechtec.financial.financialutils.cashflow.SimpleCashFlowFactory;
import org.makechtec.financial.financialutils.cashflow.SimpleCashFlowFactory.CashFlowRate;
import org.makechtec.financial.financialutils.rate.CompoundRate;

public class CouponBoundFactory {

    private SimpleCashFlowFactory simpleCashFlowFactory = new SimpleCashFlowFactory();
    private CashFlowRate cashFlowRate = new CashFlowRate();

    // public ZeroCouponBound create( double initialAmount, double finalAmount, long period){
    //     return new ZeroCouponBound(this.simpleCashFlowFactory.create(initialAmount, finalAmount, period));
    // }

    public ZeroCouponBound create(double faceValue, double discountRate, long period){
        CompoundRate compoundRate = this.cashFlowRate.create(discountRate, period);
        SimpleCashFlow cashFlow = this.simpleCashFlowFactory.create(compoundRate, faceValue);
        return new ZeroCouponBound(cashFlow);
    }
}
