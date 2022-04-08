package org.makechtec.financial.financialutils.perpetuity;

public class Perpetuity{

    private double presentValue;
    private double payment;
    private double interest;
    private double growth;

    public Perpetuity(double payment, double interest){
        this.payment = payment;
        this.interest = interest;
        this.growth = 0;
        this.generatePresentValue();
    }

    public Perpetuity(double payment, double interest, double growth){
        this.payment = payment;
        this.interest = interest;
        this.growth = growth;
        this.generatePresentValueWithGrowth();
    }

    private void generatePresentValue(){
        this.presentValue = this.payment/this.interest;
    }

    private void generatePresentValueWithGrowth(){
        this.presentValue = this.payment/(this.interest - this.growth);
    }



    

    public double getPresentValue() {
        return presentValue;
    }

    public double getPayment() {
        return payment;
    }

    public double getInterest() {
        return interest;
    }

    public double getGrowth() {
        return growth;
    }


}
