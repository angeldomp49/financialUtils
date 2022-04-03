package org.makechtec.financial.financialutils.cashflow;

import org.makechtec.financial.financialutils.CompoundFactor;
import org.makechtec.financial.financialutils.Rate;

public class CashFlow{

    private Rate rate = new Rate();
    private CompoundFactor factor = new CompoundFactor();

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
