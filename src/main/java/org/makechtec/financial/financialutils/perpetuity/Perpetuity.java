package org.makechtec.financial.financialutils.perpetuity;

public class Perpetuity{

    private double presentValue;
    private double payment;
    private double interest;
    private double growth;

    public Perpetuity(double presentValue, double payment, double interest, double growth){
        this.presentValue = presentValue;
        this.payment = payment;
        this.interest = interest;
        this.growth = growth;
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
