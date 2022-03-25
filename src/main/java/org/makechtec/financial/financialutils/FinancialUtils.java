package org.makechtec.financial.financialutils;


public class FinancialUtils {

    public static class Rate{
        
        public double compoundedFactor(double rate, int periods){
            return Math.pow((1+rate), periods);
        }
        
        public double effectiveInterestRate(double stateRate, int periods){
            double dividedRate = stateRate/periods;
            return this.compoundedFactor(dividedRate, periods) - 1;
        }
        
        public double effectiveInterestRate(double stateRate, int periods, int newPeriods){
            double dividedRate = stateRate/periods;
            return this.compoundedFactor(dividedRate, newPeriods) - 1;
        }
        
        public double effectiveContinuousInterestRate(double stateRate){
            return Math.pow(Math.E, stateRate) - 1;
        }
    }
    
    public static class MoneysTimeValue{
        
        private final Rate rate = new Rate();
        
        public double futureValue(double initialValue, double rate, int periods){
            return initialValue * this.rate.compoundedFactor(rate, periods);
        }
        
        public double futureValueWithStatedRate(double initialValue, double statedRate, int periods){
            double effectiveRate = this.rate.effectiveInterestRate(statedRate, periods);
            return initialValue * (effectiveRate + 1);
        }
        
        public double futureValueWithStatedRate(double initialValue, double statedRate, int periods, int newPeriods){
            double effectiveRate = this.rate.effectiveInterestRate(statedRate, periods, newPeriods);
            return initialValue * (effectiveRate + 1);
        }
        
        public double presentValue(double finalValue, double rate, int periods){
            return finalValue/this.rate.compoundedFactor(rate, periods);
        }
        
    }
    
    public static class Annuity{
        
        private final Rate rate = new Rate();
        
        public double futureValue(double payment, double rate, int periods){
            return payment * this.acf(rate, periods);
        }
        
        public double paymentAmount(double goal, double rate, int periods){
            return goal/this.acf(rate, periods);
        }
        
        public double presentValue(double payment, double rate, int periods){
            return payment * this.adf(rate, periods);
        }
        
        public double loanPayment(double totalLoan, double rate, int periods ){
            return totalLoan/this.adf(rate, periods);
        }
        
        public double acf(double rate, int periods){
            double dividend = this.rate.compoundedFactor(rate, periods) - 1;
            return dividend/rate;
        }
        
        public double adf(double rate, int periods){
            double dividend = 1 - (1 / this.rate.compoundedFactor(rate, periods));
            return dividend/rate;
        }
    }
    
    public static class Perpetuity{
        
        private final Rate rate = new Rate();
        
        public double presentValue(double payment, double rate){
            return payment/rate;
        }
        
        public double presentValue(double payment, double rate, double growth){
            return payment/(rate - growth);
        }
        
        public double adf(double rate, double growth, int periods){
            double ratio = this.rate.compoundedFactor(growth, periods)/this.rate.compoundedFactor(rate, periods);
            return (1- ratio)/(rate-growth);
        }
        
        public double acf(double rate, double growth, int periods){
            double dividend = this.rate.compoundedFactor(rate, periods) - this.rate.compoundedFactor(growth, periods);
            return dividend/(rate-growth);
        }
    }
}
