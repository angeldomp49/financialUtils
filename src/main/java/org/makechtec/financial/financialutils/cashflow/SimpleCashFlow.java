package org.makechtec.financial.financialutils.cashflow;

public class SimpleCashFlow{
    private CashFlowFactor factor;
    private double initialAmount;
    private double finalAmount;

    public SimpleCashFlow(double initialAmount, CashFlowFactor factor){
        this.initialAmount = initialAmount;
        this.factor = factor;
        this.generateFinalAmount();
    }

    public SimpleCashFlow(CashFlowFactor factor, double finalAmount){
        this.finalAmount = finalAmount;
        this.factor = factor;
        this.generateInitialAmount();
    }

    private void generateFinalAmount(){
        this.finalAmount = this.initialAmount * this.factor.getValue();
    }

    private void generateInitialAmount(){
        this.initialAmount = this.finalAmount / this.factor.getValue();
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
