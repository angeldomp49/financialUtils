package org.makechtec.financial.financialutils.streamofcashflow;

import org.makechtec.financial.financialutils.rate.CompoundRate;

public class StreamOfCashFlow{
    private CompoundRate streamRate;
    private CompoundRate cashFlowRate;
    private double initialAmount;
    private double finalAmount;
    private double fixedPayment;

    public StreamOfCashFlow(double initialAmount, double fixedPayment, CompoundRate streamRate, CompoundRate cashFlowRate, double finalAmount){
        this.streamRate = streamRate;
        this.cashFlowRate = cashFlowRate;
        this.initialAmount = initialAmount;
        this.finalAmount = finalAmount;
        this.fixedPayment = fixedPayment;
    }

    public CompoundRate getStreamRate() {
        return this.streamRate;
    }

    public CompoundRate getCashFlowRate() {
        return this.cashFlowRate;
    }

    public double getPresentValue() {
        return initialAmount;
    }

    public double getFutureValue() {
        return finalAmount;
    }

    public double getFixedPayment() {
        return fixedPayment;
    }

}
