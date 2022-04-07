package org.makechtec.financial.financialutils2.rate;

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
