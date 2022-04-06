package org.makechtec.financial.financialutils.rate;

public class CompoundRate {
    private long period;
    private Rate rate;
    private double value;

    public CompoundRate(long period, double value){
        this.period = period;
        this.value = value;
    }

    public CompoundRate(double rate, long period) {
        this.rate = new Rate(rate);
        this.period = period;
        this.generateValue();
    }

    public CompoundRate(Rate rate, long period) {
        this.rate = rate;
        this.period = period;
        this.generateValue();
    }

    public StatedRate toStatedRate(){
        return new StatedRate(this.value, this.period);
    }

    public StatedRate toStatedRate(long actualPeriod){
        return new StatedRate(this.value, this.period, actualPeriod);
    }

    public void generateValue(){
        this.value = (Math.pow((1+rate.getValue()), period)) -1;
    }

    public double getPeriod() {
        return period;
    }

    public Rate getRate() {
        return rate;
    }
    
    public double getValue() {
        return this.value;
    }

}
