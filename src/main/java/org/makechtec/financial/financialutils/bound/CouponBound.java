package org.makechtec.financial.financialutils.bound;

public class CouponBound extends AbstractBound{

    double couponPayment = 0;

    public CouponBound(double currentValue, double maturityValue){
        super(currentValue, maturityValue);
    }

}
