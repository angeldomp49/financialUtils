package org.makechtec.financial.financialutils2.rate;

import org.makechtec.financial.financialutils2.cashflow.CashFlowRate;

public class StatedRate extends BasicRate{
    
    private long newPeriod;

    public StatedRate(double value, long period){
        this.initRate = value;
        this.period = period;
        this.newPeriod = period;
    }

    public StatedRate(double value, long period, long newPeriod){
        this.initRate = value;
        this.period = period;
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
