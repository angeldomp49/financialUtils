package org.makechtec.financial.financialutils.cashflow.factory;

import org.makechtec.financial.financialutils.Log;
import org.makechtec.financial.financialutils.cashflow.SimpleCashFlow;
import org.makechtec.financial.financialutils.factor.Factor;
import org.makechtec.financial.financialutils.rate.CompoundRate;

public class SimpleCashFlowFactory {

    private final Log log = new Log();

    public SimpleCashFlow create(double initialAmount, CompoundRate compoundRate){
        double finalAmount = this.generateFinalAmount(initialAmount, Factor.of(compoundRate.getFinalRate()));
        return new SimpleCashFlow(initialAmount, compoundRate, finalAmount);
    }

    public SimpleCashFlow create(CompoundRate compoundRate, double finalAmount){
        double initialAmount = this.generateInitialAmount(finalAmount, Factor.of(compoundRate.getFinalRate()));
        return new SimpleCashFlow(initialAmount, compoundRate, finalAmount);
    }

    public SimpleCashFlow create(double initialAmount, double finalAmount, long period){
        return new SimpleCashFlow(initialAmount, this.generateCompoundRate(initialAmount, finalAmount, period), finalAmount);
    }

    private double generateFinalAmount(double initialAmount, double factor){
        return initialAmount * factor;
    }

    private double generateInitialAmount(double finalAmount, double factor){
        return finalAmount / factor;
    }

    private CompoundRate generateCompoundRate(double initialAmount, double finalAmount, long period){
        double difference = finalAmount - initialAmount;
        double differencePercentage = difference / finalAmount;
        double initRate = this.generateInitRate(period, differencePercentage);

        return new CompoundRate(initRate, period, differencePercentage);
    }

    private double generateFinalRate(double initRate, long period){
        return (Math.pow((1+initRate), period)) -1;
    }

    private double generateInitRate(long period, double finalRate){
        double exponent = 1/period;

        double rate = finalRate +1;
        rate = Math.pow(rate, exponent);
        return rate -1;
    }

    private long generatePeriod(double initRate, double finalRate){
        double y = finalRate +1;
        double x = initRate +1;

        double periods = this.log.customBase(x, y);
        return Math.round(periods);
    }
}
