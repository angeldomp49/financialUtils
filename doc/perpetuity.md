# perpetuity # 
### org.makechtec.financial.financialutils.perpetuity ###

Classes:

- Perpetuity
- PerpetuityFactory

## Perpetuity ##

Description:

A perpetuity stream of cashflow. It contain also a growth case when the interest rate and the growth rate
is present.

Members:

    private double presentValue;
    private double payment;
    private double interest;
    private double growth;

Constructors:

    public Perpetuity(double presentValue, double payment, double interest, double growth);

Getters and Setters:

    public double getPresentValue() {

    public double getPayment() {

    public double getInterest() {

    public double getGrowth() {


## PerpetuityFactory ##

Description:

Several ways to create Perpetuities also when not all parameters are presents.

Constructors:

    public PerpetuityFactory();

Methods:

    public Perpetuity create(double payment, double interest){

    public Perpetuity create(double payment, double interest, double growth){

    private double generatePresentValue(double payment, double interest){

    private double generatePresentValueWithGrowth( double payment, double interest, double growth){
