package org.makechtec.financial.financialutils.streamofcashflow;

import org.makechtec.financial.financialutils.Log;
import org.makechtec.financial.financialutils.cashflow.SimpleCashFlow;
import org.makechtec.financial.financialutils.cashflow.SimpleCashFlowFactory;
import org.makechtec.financial.financialutils.cashflow.SimpleCashFlowFactory.CashFlowRate;
import org.makechtec.financial.financialutils.factor.Factor;
import org.makechtec.financial.financialutils.rate.CompoundRate;

public class StreamOfCashFlowFactory {
    
    private final SimpleCashFlowFactory cashFlowFactory = new SimpleCashFlowFactory();




    public StreamOfCashFlow create(double initialAmount, double fixedPayment, CompoundRate compoundRate){
        return new StreamOfCashFlow(initialAmount, fixedPayment, compoundRate, compoundRate, this.generateFinalAmountWithInitalAmount(initialAmount, compoundRate));
    }

    public StreamOfCashFlow create(double fixedPayment, CompoundRate compoundRate){
        return new StreamOfCashFlow(0, fixedPayment, compoundRate, null, this.generateFinalAmount(fixedPayment, compoundRate));
    }

    public StreamOfCashFlow create(CompoundRate compoundRate, double finalAmount){
        return new StreamOfCashFlow(0, this.generateFixedPayment(finalAmount, compoundRate), compoundRate, null, finalAmount);
    }

    public StreamOfCashFlow createWithInitialAmount(double fixedPayment, CompoundRate compoundRate, double finalAmount){
        return new StreamOfCashFlow(this.generateInitialAmount(fixedPayment, compoundRate, finalAmount), fixedPayment, compoundRate, compoundRate, finalAmount);
    }

    public StreamOfCashFlow create(CompoundRate compoundRate, double finalAmount, double initialAmount){
        return new StreamOfCashFlow(initialAmount, this.generateFixedPaymentWithInitialAmount(initialAmount, compoundRate, finalAmount), compoundRate, compoundRate,finalAmount);
    }

    public double generateFinalAmount(double fixedPayment, CompoundRate streamRate){
        return fixedPayment * Factor.of(streamRate.getFinalRate()); 
    }

    public double generateFinalAmountWithInitalAmount(double initialAmount, CompoundRate compoundRate){
        SimpleCashFlow initCashFlow = this.cashFlowFactory.create(initialAmount, compoundRate);
        double f = initialAmount * Factor.of(compoundRate.getFinalRate());
        return initCashFlow.getFutureValue() + f;
    }

    public double generateFixedPayment(double finalAmount, CompoundRate compoundRate){
        return finalAmount/Factor.of(compoundRate.getFinalRate());
    }

    public double generateFixedPaymentWithInitialAmount(double initialAmount, CompoundRate compoundRate, double finalAmount){
        double initCashFlowFinalValue = this.cashFlowFactory.create(initialAmount, compoundRate).getFutureValue();
        return (finalAmount - initCashFlowFinalValue)/Factor.of(compoundRate.getFinalRate());
    }

    public double generateInitialAmount(double fixedPayment, CompoundRate compoundRate, double finalAmount){
        double fixedPaymentFutureValue = fixedPayment * Factor.of(compoundRate.getFinalRate());
        double initAmountFutureValue = finalAmount - fixedPaymentFutureValue;
        SimpleCashFlow initCashFlow = this.cashFlowFactory.create(compoundRate, initAmountFutureValue);
        return initCashFlow.getPresentValue();
    }




    
    public static class StreamRate{

        private final Log log = new Log();
        private final CashFlowRate cashFlowRate = new CashFlowRate();




        public CompoundRate create(double initRate, long period){
            return new CompoundRate(initRate, period, this.generateFinalRate(initRate, period));
        }

        public CompoundRate create(long period, double finalRate){
            return new CompoundRate(this.generateInitRate(period, finalRate), period, finalRate);
        }

        public CompoundRate create(double initRate, double finalRate){
            return new CompoundRate(initRate, this.generatePeriod(initRate, finalRate), finalRate);
        }

        private double generateFinalRate(double initRate, long period){
            double dividend = this.cashFlowRate.create(initRate, period).getFinalRate();
            return (dividend/initRate)-1;
        }
    
        private double generateInitRate(long period, double finalRate){
            return 0;
        }
    
        private long generatePeriod(double initRate, double finalRate){
            double r = initRate * (finalRate+1);
            r = r+1;
            double base = 1+initRate;
            r = this.log.customBase(base, r);
            return Math.round(r);
        }
    }
}
