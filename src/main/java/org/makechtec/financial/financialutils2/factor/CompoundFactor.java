package org.makechtec.financial.financialutils2.factor;

import org.makechtec.financial.financialutils2.rate.BasicRate;

public interface CompoundFactor {
    public double getValue();
    public BasicRate getCompoundRate();
}
