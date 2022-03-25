package org.makechtec.financial.financialutils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FinancialUtilsTest {
    
    FinancialUtils.Rate rate = new FinancialUtils.Rate();
    FinancialUtils.MoneysTimeValue money = new FinancialUtils.MoneysTimeValue();
    FinancialUtils.Annuity annuity = new FinancialUtils.Annuity();
    FinancialUtils.Perpetuity perpetuity = new FinancialUtils.Perpetuity();

    
    
    @Test
    public void testCompoundedRate() {
        assertEquals(1.79084, this.rate.compoundedFactor(0.06, 10), 0.00001);
    }
    
    @Test
    public void testEffectiveInterestRate(){
        assertEquals( 0.06167, this.rate.effectiveInterestRate(0.06, 12), 0.00001);
    }
    
    @Test
    public void testEffectiveInterestRate_NewPeriods(){
        assertEquals( 0.12715, this.rate.effectiveInterestRate(0.06, 12, 24), 0.00001);
    }
    
    @Test
    public void testEffectiveContinuousInterestRate(){
        assertEquals(0.061836546, this.rate.effectiveContinuousInterestRate(0.06), 0.000000001);
    }
    
    
    
    @Test
    public void testMoneysTimeValueFutureValue(){
        assertEquals(2552.563125, this.money.futureValue(2000, 0.05, 5), 0.000001);
    }
    
    @Test
    public void testMoneysTimeValueFutureValueWithStatedRate(){
        assertEquals(2253.650060, this.money.futureValueWithStatedRate(2000, 0.12, 12), 0.000001);
    }
    
    @Test
    public void testMoneysTimeValueFutureValueWithStatedRate_NewPeriods(){
        assertEquals(2539.469297, this.money.futureValueWithStatedRate(2000, 0.12, 12, 24), 0.000001);
    }
    
    @Test
    public void testMoneysTimeValuePresentValue(){
        assertEquals(2000, this.money.presentValue(2552.563125, 0.05, 5), 0.000001);
    }
    
    
    
    @Test
    public void testAnnuitiesFutureValue(){
        assertEquals( 69827.909654, this.annuity.futureValue(3000, 0.06, 15), 0.000001);
    }
    
    @Test
    public void testAnnuityPaymentAmount(){
        assertEquals(3000, this.annuity.paymentAmount(69827.909654, 0.06, 15), 0.000001);
    }
    
    @Test
    public void testAnnuityPresentValue(){
        assertEquals( 29136.746963 ,this.annuity.presentValue(3000, 0.06, 15), 0.000001);
    }
    
    @Test
    public void testAnnuityLoanPayment(){
        assertEquals( 1757.302186 ,this.annuity.loanPayment(81000, 0.0016666, 48),0.000001);
    }
    
    @Test
    public void testAnnuityAcf(){
        assertEquals( 50.815577, this.annuity.acf(0.06, 24), 0.000001 );
    }
    
    @Test
    public void testAnnuityAdf(){
        assertEquals( 12.550357, this.annuity.adf(0.06, 24), 0.000001 );
    }
    
    
    
    @Test
    public void testPerpetuityPresentValue(){
        assertEquals( 37500, this.perpetuity.presentValue(3000, 0.08), 0.000001);
    }
    
    @Test
    public void testPerpetuityPresentValue_Growth(){
        assertEquals( 75000, this.perpetuity.presentValue(3000, 0.08, 0.04), 0.000001);
    }
    
    @Test
    public void testPerpetuityAcf(){
        assertEquals( 243.827636, this.perpetuity.acf(0.03, 0.04, 48), 0.000001);
    }
    
    @Test
    public void testPerpetuityAdf(){
        assertEquals( 59.005995,this.perpetuity.adf(0.03, 0.04, 48), 0.000001 );
    }
}
