
package org.makechtec.financial.financialutils;

import java.util.Scanner;

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
                    final CashFlow cashFlow = new CashFlow();
                    
                    switch(methodIndex){
                        case 0:
                            result = cashFlow.futureValue(scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());
                            break;
                        case 1:
                            result = cashFlow.futureValueWithStatedRate(scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());
                            break;
                        case 2:
                            result = cashFlow.futureValueWithStatedRate(scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt(), scanner.nextInt());
                            break;
                        case 3:
                            result = cashFlow.presentValue(scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());
                            break;
                    }
                break;

                case 1:
                    final StreamOfCashFlow stream = new StreamOfCashFlow();

                    switch(methodIndex){
                        case 0:
                            result = stream.futureValue(scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());
                            break;
                        case 1:
                            result = stream.fixedPaymentAmount(scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());
                            break;
                        case 2:
                            result = stream.presentValue(scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());
                            break;
                        case 3:
                            result = stream.fixedLoanPaymentAmount(scanner.nextDouble(), scanner.nextDouble(), scanner.nextInt());
                            break;
                    }
                break;

                case 2:
                    final PerpetuityFixedCashFlow perpetuity = new PerpetuityFixedCashFlow();

                    switch(methodIndex){
                        case 0:
                            result = perpetuity.presentValue(scanner.nextDouble(), scanner.nextDouble());
                            break;
                        case 1:
                            result = perpetuity.presentValue(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
                            break;
                    }
                break;

            }

            return result;
        }
        
    }
}
