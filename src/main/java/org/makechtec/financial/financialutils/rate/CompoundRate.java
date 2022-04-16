package org.makechtec.financial.financialutils.rate;

public class CompoundRate {
    protected double initRate = 0;
    protected double finalRate = 0;
    protected long period = 0;

    public CompoundRate(double initRate, long period){
        this.initRate = initRate;
        this.period = period;
    }

    public CompoundRate(double initRate, long period, double finalRate){
        this.initRate = initRate;
        this.period = period;
        this.finalRate = finalRate;
    }
    
    public double getInitRate() {
        return initRate;
    }

    public double getFinalRate() {
        return finalRate;
    }

    public long getPeriod() {
        return period;
    }

    public void setInitRate(double initRate) {
        this.initRate = initRate;
    }

    public void setFinalRate(double finalRate) {
        this.finalRate = finalRate;
    }

    public void setPeriod(long period) {
        this.period = period;
    }

}
