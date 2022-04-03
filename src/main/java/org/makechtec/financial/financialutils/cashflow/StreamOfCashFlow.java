package org.makechtec.financial.financialutils.cashflow;

import org.makechtec.financial.financialutils.CompoundFactor;
import org.makechtec.financial.financialutils.Log;

public class StreamOfCashFlow{

        private CompoundFactor factor = new CompoundFactor();
        
        public double futureValue(double payment, double rate, int periods){
            return payment * this.factor.annuityCompoundFactor(rate, periods);
        }

        public double futureValueWithInitialValue(double payment, double rate, int periods, double initialValue){
            double futureInitialValue = new CashFlow().futureValue(initialValue, rate, periods);
            double futurePayment = this.futureValue(payment, rate, periods);

            return futurePayment + futureInitialValue;
        }

        public long periodsForGoal(double goal, double payment, double rate){
            double j = payment/rate;
            double k = goal/j;
            double l = k+1;
            double base = 1+rate;
            double m = new Log().customBase(base, l);
            return Math.round(m);
        }

        public long periodsForGoalWithInitialValue(double goal, double payment, double rate, double initialValue){
            double j = payment/rate;
            double k = goal+j;
            double l = initialValue+j;
            double base = 1+rate;

            double periodsDouble = new Log().customBase(base, (k/l));

            return Math.round(periodsDouble);
        }
        
        public double fixedPaymentAmount(double goalQty, double rate, int periods){
            return goalQty/this.factor.annuityCompoundFactor(rate, periods);
        }
        
        public double presentValue(double payment, double rate, int periods){
            return payment * this.factor.annuityDiscountFactor(rate, periods);
        }
        
        public double fixedLoanPaymentAmount(double totalLoanToPay, double rate, int periods ){
            return totalLoanToPay/this.factor.annuityDiscountFactor(rate, periods);
        }
        
    }
