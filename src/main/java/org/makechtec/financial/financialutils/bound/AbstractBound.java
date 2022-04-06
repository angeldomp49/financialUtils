package org.makechtec.financial.financialutils.bound;

public class AbstractBound {
    private double discountFactor;
    private double currentValue;

    private long maturityPeriods;
    private double annuityRate;
    private double maturityValue;


    public AbstractBound(double currentValue, double maturityValue){
        this.currentValue = currentValue;
        this.maturityValue = maturityValue;
        this.discountFactor = BoundFactory.calculateDiscountFactor(currentValue, maturityValue);
    }

    public AbstractBound(double currentValue, double maturityValue, long maturityPeriods){
        this.currentValue = currentValue;
        this.maturityValue = maturityValue;
        this.maturityPeriods = maturityPeriods;
        this.discountFactor = BoundFactory.calculateDiscountFactor(currentValue, maturityValue);
        this.annuityRate = BoundFactory.calculateAnnuityRate(this.discountFactor, maturityPeriods);
    }

    public double getDiscountFactor() {
        return discountFactor;
    }

    public void setDiscountFactor(double discountFactor) {
        this.discountFactor = discountFactor;
    }

    public double getMaturityValue() {
        return maturityValue;
    }

    public void setMaturityValue(double maturityValue) {
        this.maturityValue = maturityValue;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public long getMaturityPeriods() {
        return maturityPeriods;
    }

    public void setMaturityPeriods(long maturityPeriods) {
        this.maturityPeriods = maturityPeriods;
    }

    public double getAnnuityRate() {
        return annuityRate;
    }

    public void setAnnuityRate(double annuityRate) {
        this.annuityRate = annuityRate;
    }
}
