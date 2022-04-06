package org.makechtec.financial.financialutils.entries;

import org.makechtec.financial.financialutils.cashflow.StreamOfCashFlow;

public class F {

    public static void main(String[] args){
        StreamOfCashFlow streamOfCashFlow = new StreamOfCashFlow();
        double payment = streamOfCashFlow.presentValue(4000, 0.01, 24);

        System.out.println("Payment: " + payment);
    }
}
