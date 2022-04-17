package org.makechtec.financial.financialutils.perpetuity;

public class PerpetuityFactory {
    
    public Perpetuity create(double payment, double interest){
        return new Perpetuity(this.generatePresentValue(payment, interest), payment, interest, 0);
    }

    public Perpetuity create(double payment, double interest, double growth){
        return new Perpetuity(this.generatePresentValueWithGrowth(payment, interest, growth), payment, interest, growth);
    }

    private double generatePresentValue(double payment, double interest){
        return payment/interest;
    }

    private double generatePresentValueWithGrowth( double payment, double interest, double growth){
        return payment/(interest - growth);
    }
}
