package org.makechtec.financial.financialutils2.rate;

public class BasicRate {
    protected double initRate = 0;
    protected double finalRate = 0;
    protected long period = 0;

    public BasicRate(double initRate, long period){
        this.initRate = initRate;
        this.period = period;
    }

    public BasicRate(double initRate, long period, double finalRate){
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
