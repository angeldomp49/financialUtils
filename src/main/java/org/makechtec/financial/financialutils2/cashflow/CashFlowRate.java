package org.makechtec.financial.financialutils2.cashflow;

import org.makechtec.financial.financialutils2.rate.CompoundRate;
import org.makechtec.financial.financialutils2.rate.Rate;

public class CashFlowRate implements CompoundRate{

    private Rate initRate;
    private long period;
    private Rate finalRate;

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
        this.initRate = new Rate(0); //implement this
    }

    private void generatePeriod(){
        //implement this
    }

    public Rate getInitRate() {
        return this.initRate;
    }

    @Override
    public Rate getFinalRate() {
        return this.finalRate;
    }

    
}
