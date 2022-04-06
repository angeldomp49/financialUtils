package org.makechtec.financial.financialutils.factor;

import org.makechtec.financial.financialutils.rate.CompoundRate;
import org.makechtec.financial.financialutils.rate.Rate;

public class DiscountFactor {

    private double value;
    private Rate growth;
    private CompoundRate compoundRate;

    public DiscountFactor(CompoundRate compoundRate){
        this.compoundRate = compoundRate;
        this.generateValue();
    }

    public DiscountFactor(CompoundRate compoundRate, Rate growth){
        this.compoundRate = compoundRate;
        this.growth = growth;
        this.generateValue(growth);
    }

    public void generateValue(){
        double dividend = 1 - (1 / this.compoundRate.getValue());
        this.value = dividend/this.compoundRate.getRate().getValue();
    }

    public void generateValue(Rate growth){
        SimpleFactor rateFactor = new SimpleFactor(this.compoundRate);
        SimpleFactor growthFactor = new SimpleFactor(new CompoundRate(growth, this.compoundRate.getPeriod()));
        double ratio = growthFactor.getValue()/rateFactor.getValue();
        this.value = (1- ratio)/(this.compoundRate.getRate().getValue() - growth.getValue());
    }

}
