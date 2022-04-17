# cashflow #
### package org.makechtec.financial.financialutils.cashflow ###

## SimpleCashFlow ## 

Description:

Contain initial value, final value and a __CompoundRate__ object.
The initial value is the money invested and it increments until becomes the final value passed
the period.

Members:

    private CompoundRate compoundRate;
    private double initialAmount;
    private double finalAmount;

Constructors:

    public SimpleCashFlow(double initialAmount, CompoundRate compoundRate, double finalAmount)

Getters and Setters:

    public double getPresentValue();

    public double getFutureValue();

    public CompoundRate getFactor();


## SimpleCashFlowFactory ## 

Description:

Create a SimpleCashFlow using different parameters when not all members are knewed.

Members:

    private final CashFlowRate cashFlowRate = new CashFlowRate();

Constructors:

    public SimpleCashFlowFactory();

Methods:

    public SimpleCashFlow create(double initialAmount, CompoundRate compoundRate);

    public SimpleCashFlow create(CompoundRate compoundRate, double finalAmount);

    public SimpleCashFlow create(double initialAmount, double finalAmount, long period);

    public double generateFinalAmount(double initialAmount, double factor);

    public double generateInitialAmount(double finalAmount, double factor);

    public CompoundRate generateCompoundRate(double initialAmount, double finalAmount, long period);



## SimpleCashFlowFactory.CashFlowRate ##

Description:

Utility for calculate some rate operations related with a simple cash flow.
The object __CompoundRate__ is a full filled bean, then is better use this methods instead of 
manually construct it. This is because all his members are calculated and next the object is created.

Members:

    private final Log log = new Log();

Constructors:

    public CashFlowRate();

Methods:

    public CompoundRate create(double initRate, long period);

    public CompoundRate create(long period, double finalRate);

    public CompoundRate create(double initRate, double finalRate);

    public double generateFinalRate(double initRate, long period);

    public double generateInitRate(long period, double finalRate);

    public long generatePeriod(double initRate, double finalRate);