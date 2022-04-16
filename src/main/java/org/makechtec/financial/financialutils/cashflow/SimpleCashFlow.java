package org.makechtec.financial.financialutils.cashflow;

import org.makechtec.financial.financialutils.rate.CompoundRate;

public class SimpleCashFlow{
    private CompoundRate compoundRate;
    private double initialAmount;
    private double finalAmount;

    public SimpleCashFlow(double initialAmount, CompoundRate compoundRate, double finalAmount){
        this.initialAmount = initialAmount;
        this.compoundRate = compoundRate;
        this.finalAmount = finalAmount;
    }

    public double getPresentValue(){
        return this.initialAmount;
    }

    public double getFutureValue(){
        return this.finalAmount;
    }

    public CompoundRate getFactor(){
        return this.compoundRate;
    }

}
