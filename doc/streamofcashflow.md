# streamofcashflow #
### org.makechtec.financial.financialutils.streamofcashflow ###

Classes:

- StreamOfCashFlow
- StreamOfCashFlowFactory

## StreamOfCashFlow ##

Description:

This class representa a stream of cashflow, it may have an inital value, in this case a simple cash flow is 
added to the final amount.

Members:

    private CompoundRate streamRate;
    private CompoundRate cashFlowRate;
    private double initialAmount;
    private double finalAmount;
    private double fixedPayment;

Constructors:

    public StreamOfCashFlow(double initialAmount, double fixedPayment, CompoundRate streamRate, CompoundRate cashFlowRate, double finalAmount);

Getters and Setters:

    public CompoundRate getStreamRate();

    public CompoundRate getCashFlowRate();

    public double getPresentValue();

    public double getFutureValue();

    public double getFixedPayment();


## StreamOfCashFlowFactory ##

Description:

Multiple ways to create a StreamOfCashFlow object.

Members:

    private final SimpleCashFlowFactory cashFlowFactory = new SimpleCashFlowFactory();

Methods:

    public StreamOfCashFlow create(double initialAmount, double fixedPayment, CompoundRate compoundRate){

    public StreamOfCashFlow create(double fixedPayment, CompoundRate compoundRate){

    public StreamOfCashFlow create(CompoundRate compoundRate, double finalAmount){

    public StreamOfCashFlow createWithInitialAmount(double fixedPayment, CompoundRate compoundRate, double finalAmount){

    public StreamOfCashFlow create(CompoundRate compoundRate, double finalAmount, double initialAmount){

    public double generateFinalAmount(double fixedPayment, CompoundRate streamRate){

    public double generateFinalAmountWithInitalAmount(double initialAmount, CompoundRate compoundRate){

    public double generateFixedPayment(double finalAmount, CompoundRate compoundRate){

    public double generateFixedPaymentWithInitialAmount(double initialAmount, CompoundRate compoundRate, double finalAmount){

    public double generateInitialAmount(double fixedPayment, CompoundRate compoundRate, double finalAmount){


## StreamOfCashFlowFactory.StreamRate ##

Description:

Utility for some operations related with a stream of cash flow.

Members:

        private final Log log = new Log();
        private final CashFlowRate cashFlowRate = new CashFlowRate();

Methods:

        public CompoundRate create(double initRate, long period){

        public CompoundRate create(long period, double finalRate){

        public CompoundRate create(double initRate, double finalRate){

        private double generateFinalRate(double initRate, long period){

        private double generateInitRate(long period, double finalRate){

        private long generatePeriod(double initRate, double finalRate){
