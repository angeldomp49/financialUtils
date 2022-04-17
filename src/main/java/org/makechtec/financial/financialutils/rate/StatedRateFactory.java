package org.makechtec.financial.financialutils.rate;

public class StatedRateFactory {

    public StatedRate create(double initRate, long period){
        double finalRate = this.generateFinalRate(initRate, period);
        return new StatedRate(initRate, period, period, finalRate);
    }

    public StatedRate create(double initRate, long period, long newPeriod){
        double finalRate = this.generateFinalRate(initRate, newPeriod);
        return new StatedRate(initRate, period, newPeriod, finalRate);
    }

    public StatedRate createContinuousRate(double initRate){
        return new StatedRate(initRate, 0,0, this.continuousRate(initRate));
    }

    public double generateFinalRate(double initRate, long period){
        return (Math.pow((1+initRate), period)) -1;
    }

    public double continuousRate(double initRate){
        return Math.pow(Math.E, initRate) - 1;
    }
}
