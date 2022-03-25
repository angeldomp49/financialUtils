package org.makechtec.financial.financialutils;

public class TextStorage {
    public static final String SELECT_COMPONENT_LABEL = "Seleccione el componente: ";
    public static final String INSERT_PARAMETERS_LABEL = "coloque los parámetros correspondientes: ";
    public static final String RESULT = "El resultado es: ";
    
    public static final String[] COMPONENT_NAMES = {
        "0. Rate",
        "1. Money",
        "2. Annuity",
        "3. Perpetuity"
    };
    
    public static final String[][] COMPONENT_METHODS = {
        {
            "0. double compoundedFactor(double rate, int periods)",
            "1. double effectiveInterestRate(double stateRate, int periods)",
            "2. double effectiveInterestRate(double stateRate, int periods, int newPeriods)",
            "3. double effectiveContinuousInterestRate(double stateRate)"
        },
        {
            "0. double futureValue(double initialValue, double rate, int periods)",
            "1. double futureValueWithStatedRate(double initialValue, double statedRate, int periods)",
            "2. double futureValueWithStatedRate(double initialValue, double statedRate, int periods, int newPeriods)",
            "3. double presentValue(double finalValue, double rate, int periods)"
        },
        {
            "0. double futureValue(double payment, double rate, int periods)",
            "1. double paymentAmount(double goal, double rate, int periods)",
            "2. double presentValue(double payment, double rate, int periods)",
            "3. double loanPayment(double totalLoan, double rate, int periods )",
            "4. double acf(double rate, int periods)",
            "5. double adf(double rate, int periods)"
        },
        {
            "0. double presentValue(double payment, double rate)",
            "1. double presentValue(double payment, double rate, double growth)",
            "2. double adf(double rate, double growth, int periods)",
            "3. double acf(double rate, double growth, int periods)"
        }
    };

}
