package org.makechtec.financial.financialutils;

public class Rate{

    public double compoundRate(double rate, int periods){
        return (Math.pow((1+rate), periods)) -1;
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
