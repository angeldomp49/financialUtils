package org.makechtec.financial.financialutils2.cashflow;

import org.makechtec.financial.financialutils2.Log;
import org.makechtec.financial.financialutils2.rate.CompoundRate;
import org.makechtec.financial.financialutils2.rate.Rate;

public class CashFlowRate implements CompoundRate{

    private Rate initRate;
    private long period;
    private Rate finalRate;

    private final Log log = new Log();

    public CashFlowRate(final Rate rate, final long period){
        this.initRate = rate;
        this.period = period;
        this.generateValue();
    }

    public CashFlowRate(final long period, final Rate compoundRate){
        this.period = period;
        this.finalRate = compoundRate;
        this.generateRate();
    }

    public CashFlowRate(final Rate rate, final Rate compoundRate){
        this.initRate = rate;
        this.finalRate = compoundRate;
        this.generatePeriod();
    }

    private void generateValue(){
        final double r = (Math.pow((1+this.initRate.getValue()), period)) -1;
        this.finalRate = new Rate(r);
    }

    private void generateRate(){
        double exponent = 1/this.period;

        double rate = this.finalRate.getValue() +1;
        rate = Math.pow(rate, exponent);
        rate = rate -1;
        this.initRate = new Rate(rate);
    }

    private void generatePeriod(){
        double y = this.finalRate.getValue() +1;
        double x = this.initRate.getValue() +1;

        double periods = this.log.customBase(x, y);
        this.period = Math.round(periods);
    }

    public Rate getInitRate() {
        return this.initRate;
    }

    @Override
    public Rate getFinalRate() {
        return this.finalRate;
    }

    
}
