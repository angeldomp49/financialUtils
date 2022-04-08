package org.makechtec.financial.financialutils2.rate;

import org.makechtec.financial.financialutils2.cashflow.CashFlowRate;

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

    public CashFlowRate toCashFlowRate(){
        double r = this.value/this.declaredPeriod;
        return new CashFlowRate(new Rate(r), this.actualPeriod);
    }

    public double continuousRate(){
        return Math.pow(Math.E, this.getValue()) - 1;
    }
    
    public long getDeclaredPeriod() {
        return declaredPeriod;
    }

    public long getActualPeriod() {
        return actualPeriod;
    }

    public double getValue() {
        return value;
    }

}
