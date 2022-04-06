package org.makechtec.financial.financialutils.factor;

import org.makechtec.financial.financialutils.rate.CompoundRate;
import org.makechtec.financial.financialutils.rate.StatedRate;

public class SimpleFactor {
    private double value;

    private CompoundRate compoundRate;

    public SimpleFactor(CompoundRate rate){
        this.compoundRate = rate;
        this.generateValue();
    }

    public SimpleFactor(StatedRate statedRate){
        this.compoundRate = statedRate.toCompoundRate();
        this.generateValue();
    }

    private void generateValue(){
        this.value = this.compoundRate.getValue() + 1;
    }

    public double getValue() {
        return value;
    }

    public CompoundRate getRate() {
        return compoundRate;
    }
}
