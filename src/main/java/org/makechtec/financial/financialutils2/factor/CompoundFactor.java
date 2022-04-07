package org.makechtec.financial.financialutils2.factor;

import org.makechtec.financial.financialutils2.rate.CompoundRate;

public interface CompoundFactor {
    public double getValue();
    public CompoundRate getCompoundRate();
}
