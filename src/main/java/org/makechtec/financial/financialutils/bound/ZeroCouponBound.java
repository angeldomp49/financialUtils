package org.makechtec.financial.financialutils.bound;

import org.makechtec.financial.financialutils.cashflow.SimpleCashFlow;

public class ZeroCouponBound {
    private SimpleCashFlow cashFlow;

    public ZeroCouponBound(SimpleCashFlow cashFlow) {
        this.cashFlow = cashFlow;
    }

}
