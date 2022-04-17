package org.makechtec.financial.financialutils.bound;

import org.makechtec.financial.financialutils.cashflow.SimpleCashFlow;
import org.makechtec.financial.financialutils.streamofcashflow.StreamOfCashFlow;

public class CouponBound {
    private SimpleCashFlow cashFlow;
    private StreamOfCashFlow streamOfCashFlow;

    public CouponBound(SimpleCashFlow cashFlow , StreamOfCashFlow streamOfCashFlow) {
        this.cashFlow = cashFlow;
        this.streamOfCashFlow = streamOfCashFlow;
    }
}
