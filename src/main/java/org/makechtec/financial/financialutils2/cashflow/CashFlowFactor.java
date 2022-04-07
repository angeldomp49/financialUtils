package org.makechtec.financial.financialutils2.cashflow;

import org.makechtec.financial.financialutils2.factor.CompoundFactor;

public class CashFlowFactor implements CompoundFactor{

    private CashFlowRate compoundRate;

    public CashFlowFactor(final CashFlowRate compoundRate){
        this.compoundRate = compoundRate;
    }

    @Override
    public double getValue() {
        return this.compoundRate.getFinalRate().getValue()+1;
    }

    @Override
    public CashFlowRate getCompoundRate() {
        return this.compoundRate;
    }
    
}
