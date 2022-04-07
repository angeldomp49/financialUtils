package org.makechtec.financial.financialutils2.cashflow;

public class SimpleCashFlow implements CashFlow{
    private CashFlowFactor factor;
    private double initialAmount;
    private double finalAmount;

    public SimpleCashFlow(double initialAmount, CashFlowFactor factor){
        this.initialAmount = initialAmount;
        this.factor = factor;
        this.generateFinalAmount();
    }

    private void generateFinalAmount(){
        this.finalAmount = this.initialAmount * this.factor.getValue();
    }

    public double getPresentValue(){
        return this.initialAmount;
    }

    public double getFutureValue(){
        return this.finalAmount;
    }

    public CashFlowFactor getFactor(){
        return this.factor;
    }
}
