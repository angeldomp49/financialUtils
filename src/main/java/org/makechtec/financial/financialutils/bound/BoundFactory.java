package org.makechtec.financial.financialutils.bound;

import org.makechtec.financial.financialutils.Rate;

public class BoundFactory {

    public static ZeroCouponBound zeroCouponBoundCurrentMaturityValue(double currentValue, double maturityValue){
        return new ZeroCouponBound(currentValue, maturityValue);
    }

    public static ZeroCouponBound zeroCouponBoundCurrentValueDiscountFactor(double currentValue, double discountFactor){
        double maturityValue = BoundFactory.calculateMaturityValue(currentValue, discountFactor);
        return new ZeroCouponBound(currentValue, maturityValue);
    }

    public static ZeroCouponBound zeroCouponBoundDiscountFactorMaturityValue(double discountFactor, double maturityValue){
        double currentValue = BoundFactory.calculateCurrentValue(discountFactor, maturityValue);
        return new ZeroCouponBound(currentValue, maturityValue);
    }

    public static CouponBound couponBoundCurrentMaturityValue(double currentValue, double maturityValue){
        return new CouponBound(currentValue, maturityValue);
    }

    public static CouponBound couponBoundCurrentValueDiscountFactor(double currentValue, double discountFactor){
        double maturityValue = BoundFactory.calculateMaturityValue(currentValue, discountFactor);
        return new CouponBound(currentValue, maturityValue);
    }

    public static CouponBound couponBoundDiscountFactorMaturityValue(double discountFactor, double maturityValue){
        double currentValue = BoundFactory.calculateCurrentValue(discountFactor, maturityValue);
        return new CouponBound(currentValue, maturityValue);
    }




    public static double calculateDiscountFactor(double currentValue, double maturityValue){
        return (maturityValue/currentValue)*100;
    }

    public static double calculateMaturityValue(double currentValue, double discountFactor){
        return currentValue*discountFactor;
    }

    public static double calculateCurrentValue(double maturityValue, double discountFactor){
        return maturityValue/discountFactor;
    }

    public static double calculateAnnuityRate(double discountFactor, long maturityPeriods){
        return new Rate().rateFromCompound(discountFactor, maturityPeriods);
    }
}
