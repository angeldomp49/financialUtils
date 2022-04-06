package org.makechtec.financial.financialutils.rate;

public class ContinuousRate {
    private double statedRate;
    private double value;

    public ContinuousRate(double statedRate){
        this.statedRate = statedRate;
        this.generateValue();
    }

    private void generateValue(){
        this.value = Math.pow(Math.E, this.statedRate) - 1;
    }

    public double getStatedRate() {
        return statedRate;
    }

    public double getValue() {
        return value;
    }

}
