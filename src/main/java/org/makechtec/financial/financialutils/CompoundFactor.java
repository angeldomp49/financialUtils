package org.makechtec.financial.financialutils;

public class CompoundFactor{

    public double compoundedFactor(double rate, int periods){
        return Math.pow((1+rate), periods);
    }

    public double annuityCompoundFactor(double rate, int periods){
        double dividend = this.compoundedFactor(rate, periods) - 1;
        return dividend/rate;
    }

    public double annuityCompoundFactor(double rate, double growth, int periods){
        double dividend = this.compoundedFactor(rate, periods) - this.compoundedFactor(growth, periods);
        return dividend/(rate-growth);
    }

    public double annuityDiscountFactor(double rate, int periods){
        double dividend = 1 - (1 / this.compoundedFactor(rate, periods));
        return dividend/rate;
    }

    public double annuityDiscountFactor(double rate, double growth, int periods){
        double ratio = this.compoundedFactor(growth, periods)/this.compoundedFactor(rate, periods);
        return (1- ratio)/(rate-growth);
    }

}
