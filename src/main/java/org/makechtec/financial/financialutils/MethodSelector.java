
package org.makechtec.financial.financialutils;

import java.util.Scanner;

import org.makechtec.financial.financialutils.FinancialUtils.Annuity;
import org.makechtec.financial.financialutils.FinancialUtils.MoneysTimeValue;
import org.makechtec.financial.financialutils.FinancialUtils.Perpetuity;
import org.makechtec.financial.financialutils.FinancialUtils.Rate;

public class MethodSelector {

    private final Scanner scanner = new Scanner(System.in);
    private final MethodRunner methodRunner = new MethodRunner();
    private int componentIndex;
    private int methodIndex;

    public void selectMethod(){
        this.showComponents();
        this.componentIndex = this.scanner.nextInt();
        this.showComponentMethods();
        this.methodIndex = this.scanner.nextInt();
        this.output(TextStorage.INSERT_PARAMETERS_LABEL);
        double result = this.methodRunner.run();
        this.output(TextStorage.RESULT);
        this.output(result);
    }
    
    public void showComponents(){
        this.output(TextStorage.SELECT_COMPONENT_LABEL);
        
        for(String name : TextStorage.COMPONENT_NAMES){
            this.output(name);
        }
    }

    public void showComponentMethods(){
        String[] methods = TextStorage.COMPONENT_METHODS[this.componentIndex];
        
        for(String method : methods){
            this.output(method);
        }
    }
    
    public void output(Object str){
        System.out.println(str);
    }

    public class MethodRunner{

        public double run(){
            double result = 0.0;

            switch(componentIndex){
                case 0: 
                    final Rate rate = new Rate();
                    
                    switch(methodIndex){
                        case 0:
                            result = rate.compoundedFactor(scanner.nextDouble(), scanner.nextInt());
                            break;
                        case 1:
                            result = rate.effectiveInterestRate(scanner.nextDouble(), scanner.nextInt());
                            break;
                        case 2:
                            result = rate.effectiveInterestRate(scanner.nextDouble(), scanner.nextInt(), scanner.nextInt());
                            break;
                        case 3:
                            result = rate.effectiveContinuousInterestRate(scanner.nextDouble());
                            break;
                    }
                break;

                case 1:
                    final MoneysTimeValue moneysTimeValue = new MoneysTimeValue();

                    switch(methodIndex){
                        case 0:
                            result = moneysTimeValue.futureValue(scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());
                            break;
                        case 1:
                            result = moneysTimeValue.futureValueWithStatedRate(scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());
                            break;
                        case 2:
                            result = moneysTimeValue.futureValueWithStatedRate(scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt(), scanner.nextInt());
                            break;
                        case 3:
                            result = moneysTimeValue.presentValue(scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());
                            break;
                    }
                break;

                case 2:
                    final Annuity annuity = new Annuity();

                    switch(methodIndex){
                        case 0:
                            result = annuity.futureValue(scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());
                            break;
                        case 1:
                            result = annuity.paymentAmount(scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());
                            break;
                        case 2:
                            result = annuity.presentValue(scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());
                            break;
                        case 3:
                            result = annuity.loanPayment(scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());
                            break;
                        case 4:
                            result = annuity.acf(scanner.nextDouble(), scanner.nextInt());
                            break;
                        case 5:
                            result = annuity.adf(scanner.nextDouble(), scanner.nextInt());
                            break;
                    }
                break;

                case 3:
                    final Perpetuity perpetuity = new Perpetuity();

                    switch(methodIndex){
                        case 0:
                            result = perpetuity.presentValue(scanner.nextDouble(), scanner.nextDouble());
                            break;
                        case 1:
                            result = perpetuity.presentValue(scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());
                            break;
                        case 2:
                            result = perpetuity.adf(scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());
                            break;
                        case 3:
                            result = perpetuity.acf(scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());
                            break;
                    }
                break;
            }

            return result;
        }
        
    }
}
