package org.makechtec.financial.financialutils.streamofcashflow;

import org.makechtec.financial.financialutils.cashflow.CashFlowFactor;
import org.makechtec.financial.financialutils.cashflow.CashFlowRate;
import org.makechtec.financial.financialutils.cashflow.SimpleCashFlow;
import org.makechtec.financial.financialutils.rate.BasicRate;

public class StreamOfCashFlow{
    private StreamFactor factor;
    private CashFlowFactor cashFlowFactor;
    private double initialAmount;
    private double finalAmount;
    private double fixedPayment;

    public StreamOfCashFlow(double initialAmount, double fixedPayment, BasicRate rate){
        this.initialAmount = initialAmount;
        this.fixedPayment = fixedPayment;
        this.factor = new StreamFactor(new StreamRate(rate));
        this.cashFlowFactor = new CashFlowFactor(new CashFlowRate(rate));
        this.generateFinalAmountWithInitalAmount();
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
        this.initialAmount = initialAmount;
        this.factor = factor;
        this.finalAmount = finalAmount;
        this.generateFixedPaymentWithInitialAmount();
    }


    

    private void generateFinalAmount(){
        this.finalAmount = this.fixedPayment * this.factor.getValue(); 
    }

    private void generateFinalAmountWithInitalAmount(){
        SimpleCashFlow initCashFlow = new SimpleCashFlow(this.initialAmount, this.cashFlowFactor);
        double f = this.initialAmount * this.factor.getValue();
        this.finalAmount = initCashFlow.getFutureValue() + f;
    }



    private void generateFixedPayment(){
        this.fixedPayment = this.finalAmount/this.factor.getValue();
    }

    private void generateFixedPaymentWithInitialAmount(){
        double initCashFlowFinalValue = new SimpleCashFlow(this.initialAmount, this.cashFlowFactor).getFutureValue();
        this.fixedPayment = (this.finalAmount - initCashFlowFinalValue)/this.factor.getValue();
    }

    private void generateInitialAmount(){
        double fixedPaymentFutureValue = this.fixedPayment * this.factor.getValue();
        double initAmountFutureValue = this.finalAmount - fixedPaymentFutureValue;
        SimpleCashFlow initCashFlow = new SimpleCashFlow(this.cashFlowFactor, initAmountFutureValue);
        this.initialAmount = initCashFlow.getPresentValue();
    }


    public StreamFactor getFactor() {
        return factor;
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
