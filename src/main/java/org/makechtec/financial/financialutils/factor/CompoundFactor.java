package org.makechtec.financial.financialutils.factor;

import org.makechtec.financial.financialutils.rate.BasicRate;

public interface CompoundFactor {
    public double getValue();
    public BasicRate getCompoundRate();
}
