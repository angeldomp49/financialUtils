package org.makechtec.financial.financialutils;

public class CompoundFactor{

    public Rate rate = new Rate();

    public double compoundFactor(double rate, int periods){
        return this.rate.compoundRate(rate, periods)+1;
    }

    public double effectiveInterestFactor(double statedRate, int periods){
        return this.rate.effectiveInterestRate(statedRate, periods)+1;
    }

    public double effectiveInterestFactor(double statedRate, int periods, int newPeriods){
        return this.rate.effectiveInterestRate(statedRate, periods, newPeriods)+1;
    }

    public double streamFactor(double rate, int periods){
        double dividend = this.rate.compoundRate(rate, periods);
        return dividend/rate;
    }

    public double streamFactor(double rate, double growth, int periods){
        double dividend = this.compoundFactor(rate, periods) - this.compoundFactor(growth, periods);
        return dividend/(rate-growth);
    }

    public double discountFactor(double rate, int periods){
        double dividend = 1 - (1 / this.compoundFactor(rate, periods));
        return dividend/rate;
    }

    public double discountFactor(double rate, double growth, int periods){
        double ratio = this.compoundFactor(growth, periods)/this.compoundFactor(rate, periods);
        return (1- ratio)/(rate-growth);
    }

}
