package org.makechtec.financial.financialutils.factor;

import org.makechtec.financial.financialutils.rate.CompoundRate;
import org.makechtec.financial.financialutils.rate.Rate;
import org.makechtec.financial.financialutils.rate.StatedRate;

public class CompoundFactor {
    private double value;
    private Rate growth;
    private CompoundRate compoundRate;

    public CompoundFactor(CompoundRate rate) {
        this.compoundRate = rate;
        this.generateValue();
    }

    public CompoundFactor(StatedRate statedRate){
        this.compoundRate = statedRate.toCompoundRate();
        this.generateValue();
    }

    public CompoundFactor(CompoundRate rate, Rate growth) {
        this.compoundRate = rate;
        this.growth = growth;
        this.generateValue(growth);
    }

    public CompoundFactor(StatedRate statedRate, Rate growth){
        this.compoundRate = statedRate.toCompoundRate();
        this.growth = growth;
        this.generateValue(growth);
    }

    private void generateValue(){
        double dividend = this.compoundRate.getValue();
        this.value = dividend/this.compoundRate.getRate().getValue();
    }

    private void generateValue(Rate growth){
        SimpleFactor rateFactor = new SimpleFactor(this.compoundRate);
        SimpleFactor growthFactor = new SimpleFactor(new CompoundRate(growth, this.compoundRate.getPeriod()));
        double dividend = rateFactor.getValue() - growthFactor.getValue();
        this.value = dividend/(this.compoundRate.getRate().getValue() - growth.getValue());
    }

    public double getValue() {
        return value;
    }

    public CompoundRate getRate() {
        return compoundRate;
    }

    public Rate getGrowth() {
        return growth;
    }

}
