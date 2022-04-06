package org.makechtec.financial.financialutils;

public class Rate{

    private Log log = new Log();

    public double compoundRate(double rate, int periods){
        return (Math.pow((1+rate), periods)) -1;
    }

    public double rateFromCompound(double compoundRate, long periods){
        double exponent = 1/periods;

        double rate = compoundRate +1;
        rate = Math.pow(rate, exponent);
        rate = rate -1;
        return rate;
    }

    public long periodsFromCompound(double compound, double rate){
        double y = compound +1;
        double x = rate +1;

        double periods = this.log.customBase(x, y);
        return Math.round(periods);
    }

    public double effectiveInterestRate(double stateRate, int periods){
        double dividedRate = stateRate/periods;
        return this.compoundRate(dividedRate, periods);
    }

    public double effectiveInterestRate(double stateRate, int periods, int newPeriods){
        double dividedRate = stateRate/periods;
        return this.compoundRate(dividedRate, newPeriods);
    }

    public double effectiveContinuousInterestRate(double stateRate){
        return Math.pow(Math.E, stateRate) - 1;
    }
}
