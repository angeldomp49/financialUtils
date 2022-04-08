package org.makechtec.financial.financialutils2.cashflow;

import org.makechtec.financial.financialutils2.Log;
import org.makechtec.financial.financialutils2.rate.BasicRate;

public class CashFlowRate extends BasicRate{

    private final Log log = new Log();

    public CashFlowRate(final double rate, final long period){
        super(rate, period);
        this.generateFinalRate();
    }

    public CashFlowRate(final long period, final double compoundRate){
        super(0, period, compoundRate);
        this.generateInitRate();
    }

    public CashFlowRate(final double rate, final double compoundRate){
        super(rate, 0, compoundRate);
        this.generatePeriod();
    }

    public CashFlowRate(BasicRate rate){
        super(rate.getInitRate(), rate.getPeriod(), rate.getFinalRate());
    }

    private void generateFinalRate(){
        this.finalRate = (Math.pow((1+this.initRate), period)) -1;
    }

    private void generateInitRate(){
        double exponent = 1/this.period;

        double rate = this.finalRate +1;
        rate = Math.pow(rate, exponent);
        this.initRate = rate -1;
    }

    private void generatePeriod(){
        double y = this.finalRate +1;
        double x = this.initRate +1;

        double periods = this.log.customBase(x, y);
        this.period = Math.round(periods);
    }

}
