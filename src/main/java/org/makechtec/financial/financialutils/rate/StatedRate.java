package org.makechtec.financial.financialutils.rate;

public class StatedRate {
    
    private long declaredPeriod;
    private long actualPeriod;
    private double value;

    public StatedRate(double value, long declaredPeriod){
        this.value = value;
        this.declaredPeriod = declaredPeriod;
        this.actualPeriod = declaredPeriod;
    }

    public StatedRate(double value, long declaredPeriod, long actualPeriod){
        this.value = value;
        this.declaredPeriod = declaredPeriod;
        this.actualPeriod = actualPeriod;
    }

    public CompoundRate toCompoundRate(){
        double rateValue = (this.value/this.declaredPeriod);
        return new CompoundRate(new Rate(rateValue), this.actualPeriod);
    }

    public ContinuousRate toContinuousRate(){
        return new ContinuousRate(this.value);
    }
}
