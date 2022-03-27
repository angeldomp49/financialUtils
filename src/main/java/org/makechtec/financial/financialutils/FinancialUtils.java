package org.makechtec.financial.financialutils;


public class FinancialUtils {
    
    private final Rate rate = new Rate();
    private final CompoundFactor factor = new CompoundFactor();
    
    public class CashFlow{
        
        public double futureValue(double initialValue, double rate, int periods){
            return initialValue * factor.compoundedFactor(rate, periods);
        }
        
        public double futureValueWithStatedRate(double initialValue, double statedRate, int periods){
            double effectiveRate = rate.effectiveInterestRate(statedRate, periods);
            return initialValue * (effectiveRate + 1);
        }
        
        public double futureValueWithStatedRate(double initialValue, double statedRate, int periods, int newPeriods){
            double effectiveRate = rate.effectiveInterestRate(statedRate, periods, newPeriods);
            return initialValue * (effectiveRate + 1);
        }
        
        public double presentValue(double finalValue, double rate, int periods){
            return finalValue/factor.compoundedFactor(rate, periods);
        }
        
    }
    
    public class StreamOfCashFlow{
        
        public double futureValue(double payment, double rate, int periods){
            return payment * factor.annuityCompoundFactor(rate, periods);
        }
        
        public double fixedPaymentAmount(double goalQty, double rate, int periods){
            return goalQty/factor.annuityCompoundFactor(rate, periods);
        }
        
        public double presentValue(double payment, double rate, int periods){
            return payment * factor.annuityDiscountFactor(rate, periods);
        }
        
        public double fixedLoanPaymentAmount(double totalLoanToPay, double rate, int periods ){
            return totalLoanToPay/factor.annuityDiscountFactor(rate, periods);
        }
        
    }
    
    public class PerpetuityFixedCashFlow{
        
        public double presentValue(double payment, double rate){
            return payment/rate;
        }
        
        public double presentValue(double payment, double rate, double growth){
            return payment/(rate - growth);
        }
       
    }

    public class Rate{
        
        public double effectiveInterestRate(double stateRate, int periods){
            double dividedRate = stateRate/periods;
            return factor.compoundedFactor(dividedRate, periods) - 1;
        }
        
        public double effectiveInterestRate(double stateRate, int periods, int newPeriods){
            double dividedRate = stateRate/periods;
            return factor.compoundedFactor(dividedRate, newPeriods) - 1;
        }
        
        public double effectiveContinuousInterestRate(double stateRate){
            return Math.pow(Math.E, stateRate) - 1;
        }
    }
    
    public class CompoundFactor{
        
        public double compoundedFactor(double rate, int periods){
            return Math.pow((1+rate), periods);
        }
        
        public double annuityCompoundFactor(double rate, int periods){
            double dividend = factor.compoundedFactor(rate, periods) - 1;
            return dividend/rate;
        }
        
        public double annuityCompoundFactor(double rate, double growth, int periods){
            double dividend = factor.compoundedFactor(rate, periods) - factor.compoundedFactor(growth, periods);
            return dividend/(rate-growth);
        }
        
        public double annuityDiscountFactor(double rate, int periods){
            double dividend = 1 - (1 / factor.compoundedFactor(rate, periods));
            return dividend/rate;
        }
        
        public double annuityDiscountFactor(double rate, double growth, int periods){
            double ratio = factor.compoundedFactor(growth, periods)/factor.compoundedFactor(rate, periods);
            return (1- ratio)/(rate-growth);
        }
        
    }
}
