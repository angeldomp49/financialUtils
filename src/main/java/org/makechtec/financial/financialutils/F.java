package org.makechtec.financial.financialutils;

import java.util.Scanner;

public class F {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("insert params: ");
        long periods = new StreamOfCashFlow().periodsForGoalWithInitialValue(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble()); 
        System.out.println("periods: " + periods);

        scanner.close();
    }
}
