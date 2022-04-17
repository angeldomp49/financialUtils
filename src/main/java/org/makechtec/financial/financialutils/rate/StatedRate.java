package org.makechtec.financial.financialutils.rate;

public class StatedRate extends CompoundRate {

    private long newPeriod;

    public StatedRate(double initRate, long period, long newPeriod, double finalRate) {
        super(initRate, period, finalRate);
        this.newPeriod = period;
    }

    public long getNewPeriod() {
        return newPeriod;
    }

}
