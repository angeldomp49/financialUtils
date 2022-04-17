# rate #
### org.makechtec.financial.financialutils.rate ###

Classes:

- CompoundRate
- StatedRate
- StatedRateFactory

## CompoundRate ##

A bean that it's the core of other packages because it's used to transport information like the initial rate,
period and final accumulated rate. The period is a long number which is refered to the number of times the rate 
is calculated with the before quantity.

Members:

    protected double initRate = 0;
    protected double finalRate = 0;
    protected long period = 0;

Constructors:

    public CompoundRate(double initRate, long period);

    public CompoundRate(double initRate, long period, double finalRate);

Getters and Setters:

    public double getInitRate();

    public double getFinalRate();

    public long getPeriod();

    public void setInitRate(double initRate);

    public void setFinalRate(double finalRate);

    public void setPeriod(long period);


## StatedRate extends CompoundRate ##

Description:

An special case of CompoundedRate. It adds a member __newPeriod__, it's useful when the rate is declared
for a specific period like annually and the situation require other period like more years or some months.

For example when the stated rate is 12% annually and you need to calculate the compound rate for six months,
then you should set period = 12 and newPeriod = 6. If the declared period is equal to the situation period the 
period and newPeriod both are equals.

Members:

    private long newPeriod;

Constructors:

    public StatedRate(double initRate, long period, long newPeriod, double finalRate);

Getters and Setters:

    public long getNewPeriod() {


## StatedRateFactory ##

Description:

Multiple times to create an StatedRate object. It's useful in the situations when not all parameters are
present.

Methods:

    public StatedRate create(double initRate, long period){

    public StatedRate create(double initRate, long period, long newPeriod){

    public StatedRate createContinuousRate(double initRate){

    public double generateFinalRate(double initRate, long period){

    public double continuousRate(double initRate){
