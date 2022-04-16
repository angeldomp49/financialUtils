package org.makechtec.financial.financialutils.rate;

import org.makechtec.financial.financialutils.cashflow.CashFlowRate;

public class StatedRate extends CompoundRate{
    
    private long newPeriod;

    public StatedRate(double value, long period){
        super(value, period);
        this.newPeriod = period;
    }

    public StatedRate(double value, long period, long newPeriod){
        super(value, period);
        this.newPeriod = newPeriod;
    }

    public CashFlowRate toCashFlowRate(){
        double r = this.initRate/this.period;
        return new CashFlowRate(r, this.newPeriod);
    }

    public double continuousRate(){
        return Math.pow(Math.E, this.initRate) - 1;
    }

}
