package org.makechtec.financial.financialutils2.streamofcashflow;

import org.makechtec.financial.financialutils2.cashflow.CashFlowFactor;
import org.makechtec.financial.financialutils2.cashflow.CashFlowRate;
import org.makechtec.financial.financialutils2.cashflow.SimpleCashFlow;

public class StreamOfCashFlow{
    private StreamFactor factor;
    private double initialAmount;
    private double finalAmount;
    private double fixedPayment;

    public StreamOfCashFlow(double initialAmount, double fixedPayment, StreamFactor factor){
        this.initialAmount = initialAmount;
        this.fixedPayment = fixedPayment;
        this.factor = factor;
        this.generateFinalAmount();
    }

    public StreamOfCashFlow(double fixedPayment, StreamFactor factor){
        this.initialAmount = 0;
        this.fixedPayment = fixedPayment;
        this.factor = factor;
        this.generateFinalAmount();
    }

    public StreamOfCashFlow(StreamFactor factor, double finalAmount){
        this.initialAmount = 0;
        this.factor = factor;
        this.finalAmount = finalAmount;
        this.generateFixedPayment();
    }

    public StreamOfCashFlow(double fixedPayment, StreamFactor factor, double finalAmount){
        this.initialAmount = 0;
        this.fixedPayment = fixedPayment;
        this.factor = factor;
        this.generateInitialAmount();
    }

    public StreamOfCashFlow(StreamFactor factor, double finalAmount, double initialAmount){
        this.initialAmount = 0;
        this.factor = factor;
        this.finalAmount = finalAmount;
        this.generateFixedPayment();
    }


    

    private void generateFinalAmount(){
        SimpleCashFlow initCashFlow = new SimpleCashFlow(new CashFlowFactor(new CashFlowRate(this.factor.getCompoundRate().getInitRate().getValue(), compoundRate)), finalAmount)
    }

    private void generateFixedPayment(){
        //implement this method
    }

    private void generateInitialAmount(){
        //implement this method
    }


    public StreamFactor getFactor() {
        return factor;
    }

    @Override
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
