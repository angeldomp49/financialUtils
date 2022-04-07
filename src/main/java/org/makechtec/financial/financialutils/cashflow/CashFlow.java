package org.makechtec.financial.financialutils.cashflow;

import org.makechtec.financial.financialutils.CompoundFactor;
import org.makechtec.financial.financialutils.rate.CompoundRate;

public class CashFlow{

    private double futureValue;
    private double initialValue;
    private double yieldValue;
    private CompoundRate compoundRate;

    public CashFlow(){}

    public CashFlow(double initialValue, CompoundRate compoundRate){
        this.initialValue = initialValue;
        this.compoundRate = compoundRate;
        this.generateFutureValue();
        this.generateYieldValue();
    }

    public CashFlow(CompoundRate compoundRate, double futureValue){
        this.compoundRate = compoundRate;
        this.futureValue = futureValue;
        this.generateInitialValue();
        this.generateYieldValue();
    }

    private void generateYieldValue(){
        this.yieldValue = this.futureValue - this.initialValue;
    }

    private void generateFutureValue(){
        this.futureValue = this.initialValue * this.compoundRate.toCompoundFactor().getValue();
    }

    private void generateInitialValue(){
        this.initialValue = this.futureValue / this.compoundRate.toCompoundFactor().getValue();
    }





    

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






    public double getFutureValue() {
        return futureValue;
    }

    public void setFutureValue(double futureValue) {
        this.futureValue = futureValue;
    }

    public double getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(double initialValue) {
        this.initialValue = initialValue;
    }

    public double getYieldValue() {
        return yieldValue;
    }

    public void setYieldValue(double yieldValue) {
        this.yieldValue = yieldValue;
    }

    public CompoundRate getCompoundRate() {
        return compoundRate;
    }

    public void setCompoundRate(CompoundRate compoundRate) {
        this.compoundRate = compoundRate;
    }

    public CompoundFactor getFactor() {
        return factor;
    }

    public void setFactor(CompoundFactor factor) {
        this.factor = factor;
    }

}
