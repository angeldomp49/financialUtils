package org.makechtec.financial.financialutils2.perpetuity;

import org.makechtec.financial.financialutils2.features.WithPresentValue;
import org.makechtec.financial.financialutils2.rate.Rate;

public class Perpetuity implements WithPresentValue{

    private double presentValue;
    private double payment;
    private Rate interest;
    private Rate growth;

    public Perpetuity(double payment, Rate interest){
        this.payment = payment;
        this.interest = interest;
        this.growth = new Rate(0);
        this.generatePresentValue();
    }

    public Perpetuity(double payment, Rate interest, Rate growth){
        this.payment = payment;
        this.interest = interest;
        this.growth = growth;
        this.generatePresentValueWithGrowth();
    }

    private void generatePresentValue(){
        this.presentValue = this.payment/this.interest.getValue();
    }

    private void generatePresentValueWithGrowth(){
        this.presentValue = this.payment/(this.interest.getValue() - this.growth.getValue());
    }



    

    public double getPresentValue() {
        return presentValue;
    }

    public double getPayment() {
        return payment;
    }

    public Rate getInterest() {
        return interest;
    }

    public Rate getGrowth() {
        return growth;
    }


}
