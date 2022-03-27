package org.makechtec.financial.financialutils;

public class StreamOfCashFlow{

        private final CompoundFactor factor = new CompoundFactor();
        
        public double futureValue(double payment, double rate, int periods){
            return payment * this.factor.annuityCompoundFactor(rate, periods);
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
