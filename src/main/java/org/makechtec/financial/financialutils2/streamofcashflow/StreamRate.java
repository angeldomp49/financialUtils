package org.makechtec.financial.financialutils2.streamofcashflow;

import org.makechtec.financial.financialutils2.rate.CompoundRate;
import org.makechtec.financial.financialutils2.rate.Rate;

public class StreamRate implements CompoundRate{

    private Rate initRate;
    private long period;
    private Rate finalRate;

    public StreamRate(final Rate initRate, final long period){
        this.initRate = initRate;
        this.period = period;
        this.generateValue();
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

    private void generateValue(){
        //implement this
    }

    private void generateRate(){
//implement this
    }

    private void generatePeriod(){
//implement this
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
