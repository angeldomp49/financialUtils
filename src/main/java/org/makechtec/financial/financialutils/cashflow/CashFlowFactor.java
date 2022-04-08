package org.makechtec.financial.financialutils.cashflow;

import org.makechtec.financial.financialutils.factor.CompoundFactor;
import org.makechtec.financial.financialutils.rate.BasicRate;

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
