package org.makechtec.financial.financialutils;

public class Rate{

    private final CompoundFactor factor = new CompoundFactor();

    public double effectiveInterestRate(double stateRate, int periods){
        double dividedRate = stateRate/periods;
        return this.factor.compoundedFactor(dividedRate, periods) - 1;
    }

    public double effectiveInterestRate(double stateRate, int periods, int newPeriods){
        double dividedRate = stateRate/periods;
        return this.factor.compoundedFactor(dividedRate, newPeriods) - 1;
    }

    public double effectiveContinuousInterestRate(double stateRate){
        return Math.pow(Math.E, stateRate) - 1;
    }
}
