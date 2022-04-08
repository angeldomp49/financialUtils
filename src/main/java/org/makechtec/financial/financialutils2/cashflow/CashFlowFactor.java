package org.makechtec.financial.financialutils2.cashflow;

import org.makechtec.financial.financialutils2.factor.CompoundFactor;
import org.makechtec.financial.financialutils2.rate.BasicRate;

public class CashFlowFactor implements CompoundFactor{

    private CashFlowRate compoundRate;

    public CashFlowFactor(final CashFlowRate compoundRate){
        this.compoundRate = compoundRate;
    }

    @Override
    public double getValue() {
        return this.compoundRate.getFinalRate()+1;
    }

    @Override
    public BasicRate getCompoundRate() {
        return this.compoundRate;
    }
    
}
