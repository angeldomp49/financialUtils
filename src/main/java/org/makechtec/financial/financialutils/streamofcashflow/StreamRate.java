package org.makechtec.financial.financialutils.streamofcashflow;

import org.makechtec.financial.financialutils.Log;
import org.makechtec.financial.financialutils.cashflow.CashFlowRate;
import org.makechtec.financial.financialutils.rate.BasicRate;

public class StreamRate extends BasicRate{

    private final Log log = new Log();

    public StreamRate(final double initRate, final long period){
        super(initRate, period);
        this.generateFinalRate();
    }

    public StreamRate(final long period, final double finalRate){
        super(0, period, finalRate);
        this.generateRate();
    }

    public StreamRate(final double initRate, final double finalRate){
        super(initRate, 0, finalRate);
        this.generatePeriod();
    }

    public StreamRate(BasicRate rate){
        super(rate.getInitRate(), rate.getPeriod(), rate.getFinalRate());
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
