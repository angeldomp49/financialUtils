
# Bound #
### package org.makechtec.financial.financialutils.bound ###

Classes:

- CouponBound
- CouponBoundFactory
- ZeroCouponBound


## CouponBound ##

Description:

A Coupon bound with simple cash flow and stream of cash flow.
The simple cashflow represents the yield between the value and face value.
The stream of cash flow is the fixed payment received multiple times.

Members:

    private SimpleCashFlow cashFlow;
    private StreamOfCashFlow streamOfCashFlow;

Constructors:

    public CouponBound(SimpleCashFlow cashFlow , StreamOfCashFlow streamOfCashFlow);

## CouponBoundFactory ##

Description:

Create multiple types of bounds.

Members:

    private SimpleCashFlowFactory simpleCashFlowFactory = new SimpleCashFlowFactory();

Constructors:

    public CouponBoundFactory();

Methods:

    public ZeroCouponBound create( double initialAmount, double finalAmount, long period);



Method Details:

    public ZeroCouponBound create( double initialAmount, double finalAmount, long period);

Create a ZeroCouponBound which has a SimpleCashFlow with initial amount, final amount and period. Internally the compound rate is calculated for the SimpleCashFlow.


## ZeroCouponBound ##

Description:

This class represent a zero coupon bound, it has a simple cash flow produced by the face value.
The zero coupon bounds have not stream of cash flows.

Members:

    private SimpleCashFlow cashFlow;

Constructors:

    public ZeroCouponBound(SimpleCashFlow cashFlow);

Getters and Setters:

    public SimpleCashFlow getCashFlow();

Methods: