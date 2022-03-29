package org.makechtec.financial.financialutils;

public class CashFlow{

    private final Rate rate = new Rate();
    public final CompoundFactor factor = new CompoundFactor();

    public double futureValue(double initialValue, double rate, int periods){
        return initialValue * this.factor.compoundedFactor(rate, periods);
    }

    public double futureValueWithStatedRate(double initialValue, double statedRate, int periods){
        double effectiveRate = this.rate.effectiveInterestRate(statedRate, periods);
        return initialValue * (effectiveRate + 1);
    }

    public double futureValueWithStatedRate(double initialValue, double statedRate, int periods, int newPeriods){
        double effectiveRate = this.rate.effectiveInterestRate(statedRate, periods, newPeriods);
        return initialValue * (effectiveRate + 1);
    }

    public double presentValue(double finalValue, double rate, int periods){
        return finalValue/this.factor.compoundedFactor(rate, periods);
    }

}
