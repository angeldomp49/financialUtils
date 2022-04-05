package org.makechtec.financial.financialutils.cashflow;

import org.makechtec.financial.financialutils.CompoundFactor;

public class CashFlow{

    private CompoundFactor factor = new CompoundFactor();

    public double futureValue(double initialValue, double rate, int periods){
        return initialValue * this.factor.compoundFactor(rate, periods);
    }

    public double futureValueWithStatedRate(double initialValue, double statedRate, int periods){
        return initialValue * this.factor.effectiveInterestFactor(statedRate, periods);
    }

    public double futureValueWithStatedRate(double initialValue, double statedRate, int periods, int newPeriods){
        return initialValue * this.factor.effectiveInterestFactor(statedRate, periods, newPeriods);
    }

    public double presentValue(double finalValue, double rate, int periods){
        return finalValue/this.factor.compoundFactor(rate, periods);
    }

}
