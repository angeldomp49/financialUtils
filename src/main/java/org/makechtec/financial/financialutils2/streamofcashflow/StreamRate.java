package org.makechtec.financial.financialutils2.streamofcashflow;

import org.makechtec.financial.financialutils2.Log;
import org.makechtec.financial.financialutils2.cashflow.CashFlowRate;
import org.makechtec.financial.financialutils2.rate.CompoundRate;
import org.makechtec.financial.financialutils2.rate.Rate;

public class StreamRate implements CompoundRate{

    private Rate initRate;
    private long period;
    private Rate finalRate;

    private final Log log = new Log();

    public StreamRate(final Rate initRate, final long period){
        this.initRate = initRate;
        this.period = period;
        this.generateFinalRate();
    }

    public StreamRate(final long period, final Rate finalRate){
        this.period = period;
        this.finalRate = finalRate;
        this.generateRate();
    }

    public StreamRate(final Rate initRate, final Rate finalRate){
        this.initRate = initRate;
        this.finalRate = finalRate;
        this.generatePeriod();
    }

    private void generateFinalRate(){
        double dividend = new CashFlowRate(this.initRate, this.period)
                            .getFinalRate()
                            .getValue();
        
        double result = (dividend/this.initRate.getValue())-1;

        this.finalRate = new Rate(result);
    }

    private void generateRate(){
        this.initRate = new Rate(0);
    }

    private void generatePeriod(){
        double r = this.initRate.getValue() * (this.finalRate.getValue()+1);
        r = r+1;
        double base = 1+this.initRate.getValue();
        r = this.log.customBase(base, r);
        this.period = Math.round(r);
    }

    @Override
    public Rate getInitRate() {
        return this.initRate;
    }

    @Override
    public Rate getFinalRate() {
        return this.finalRate;
    }

    public long getPeriod(){
        return this.period;
    }
    
}
