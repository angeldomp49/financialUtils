package org.makechtec.financial.financialutils2.streamofcashflow;

import org.makechtec.financial.financialutils2.Log;
import org.makechtec.financial.financialutils2.cashflow.CashFlowRate;
import org.makechtec.financial.financialutils2.rate.BasicRate;

public class StreamRate extends BasicRate{

    private final Log log = new Log();

    public StreamRate(final double initRate, final long period){
        this.initRate = initRate;
        this.period = period;
        this.generateFinalRate();
    }

    public StreamRate(final long period, final double finalRate){
        this.period = period;
        this.finalRate = finalRate;
        this.generateRate();
    }

    public StreamRate(final double initRate, final double finalRate){
        this.initRate = initRate;
        this.finalRate = finalRate;
        this.generatePeriod();
    }

    private void generateFinalRate(){
        double dividend = new CashFlowRate(this.initRate, this.period)
                            .getFinalRate();
        
        this.finalRate = (dividend/this.initRate)-1;
    }

    private void generateRate(){
        this.initRate = 0;
    }

    private void generatePeriod(){
        double r = this.initRate * (this.finalRate+1);
        r = r+1;
        double base = 1+this.initRate;
        r = this.log.customBase(base, r);
        this.period = Math.round(r);
    }
    
}
