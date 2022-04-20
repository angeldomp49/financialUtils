package org.makechtec.financial.financialutils.streamofcashflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.makechtec.financial.financialutils.cashflow.SimpleCashFlow;
import org.makechtec.financial.financialutils.cashflow.SimpleCashFlowFactory;
import org.makechtec.financial.financialutils.factor.Factor;
import org.makechtec.financial.financialutils.rate.CompoundRate;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class StreamOfCashFlowFactoryTest {

    @Mock
    private SimpleCashFlowFactory cashFlowFactory;

    @InjectMocks
    private StreamOfCashFlowFactory streamOfCashFlowFactory;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() {
        StreamOfCashFlowFactory factory = Mockito.spy(StreamOfCashFlowFactory.class);
        Mockito.when(factory.generateFinalAmountWithInitalAmount(anyDouble(), Mockito.any(CompoundRate.class))).thenReturn(100.0);

        CompoundRate compoundRate = Mockito.mock(CompoundRate.class);
        double finalAmount = 200.0;

        factory.create(compoundRate, finalAmount);

        Mockito.verify(factory, Mockito.times(1)).generateFinalAmountWithInitalAmount(anyDouble(), Mockito.any(CompoundRate.class));
    }

    @Test
    void testCreate_noInitialAmount() {
        StreamOfCashFlowFactory factory = Mockito.spy(StreamOfCashFlowFactory.class);
        Mockito.when(factory.generateFinalAmount(anyDouble(), Mockito.any(CompoundRate.class))).thenReturn(100.0);

        CompoundRate compoundRate = Mockito.mock(CompoundRate.class);
        double initialAmount = 0.1;

        factory.create(initialAmount, compoundRate);

        Mockito.verify(factory, Mockito.times(1)).generateFinalAmount(anyDouble(), Mockito.any(CompoundRate.class));
    }

    @Test
    void testCreate_noFixedPayment() {
        StreamOfCashFlowFactory factory = Mockito.spy(StreamOfCashFlowFactory.class);
        Mockito.when(factory.generateFixedPayment(anyDouble(), Mockito.any(CompoundRate.class))).thenReturn(100.0);

        CompoundRate compoundRate = Mockito.mock(CompoundRate.class);
        double finalAmount = 200.0;

        factory.create(compoundRate, finalAmount);

        Mockito.verify(factory, Mockito.times(1)).generateFixedPayment(anyDouble(), Mockito.any(CompoundRate.class));
    }

    @Test
    void testCreate_noFixedPayment_withInitialAmount() {
        StreamOfCashFlowFactory factory = Mockito.spy(StreamOfCashFlowFactory.class);
        Mockito.when(factory.generateFixedPaymentWithInitialAmount(anyDouble(), Mockito.any(CompoundRate.class), anyDouble())).thenReturn(100.0);

        CompoundRate compoundRate = Mockito.mock(CompoundRate.class);
        double finalAmount = 200.0;

        factory.create(compoundRate, finalAmount);

        Mockito.verify(factory, Mockito.times(1)).generateFixedPaymentWithInitialAmount(anyDouble(), Mockito.any(CompoundRate.class), anyDouble());
    }

    @Test
    void testCreateWithInitialAmount() {
        StreamOfCashFlowFactory factory = Mockito.spy(StreamOfCashFlowFactory.class);

        Mockito.when(factory.generateInitialAmount(anyDouble(), Mockito.any(CompoundRate.class), anyDouble()))
                .thenReturn(100.0);

        double fixedPayment = 100.0;
        double finalAmount = 200.0;
        CompoundRate compoundRate = Mockito.mock(CompoundRate.class);

        factory.createWithInitialAmount(fixedPayment, compoundRate, finalAmount);

        Mockito.verify(factory)
                .generateInitialAmount(anyDouble(), Mockito.any(CompoundRate.class), anyDouble());
    }

    @Test
    void testGenerateFinalAmount() {
        double fixedPayment = 100;
        CompoundRate streamRate = Mockito.mock(CompoundRate.class);
        double expected = fixedPayment * Factor.of(streamRate.getFinalRate()); 

        StreamOfCashFlowFactory factory = new StreamOfCashFlowFactory();

        double actual = factory.generateFinalAmount(fixedPayment, streamRate);

        assertEquals(expected, actual);
    }

    @Test
    void testGenerateFinalAmountWithInitalAmount() {

        double initialAmount = 100;
        CompoundRate compoundRate = Mockito.mock(CompoundRate.class);
        SimpleCashFlowFactory cashFlowFactory = new SimpleCashFlowFactory();

        SimpleCashFlow initCashFlow = cashFlowFactory.create(initialAmount, compoundRate);
        double f = initialAmount * Factor.of(compoundRate.getFinalRate());
        double expected = initCashFlow.getFutureValue() + f;

        StreamOfCashFlowFactory streamOfCashFlowFactory = new StreamOfCashFlowFactory();

        double actual = streamOfCashFlowFactory.generateFinalAmountWithInitalAmount(initialAmount, compoundRate);

        assertEquals(expected, actual);
    }

    @Test
    void testGenerateFixedPayment() {
        double finalAmount = 100;
        CompoundRate compoundRate = Mockito.mock(CompoundRate.class);
        double expected = finalAmount/Factor.of(compoundRate.getFinalRate());

        StreamOfCashFlowFactory streamOfCashFlowFactory = new StreamOfCashFlowFactory();

        double actual = streamOfCashFlowFactory.generateFixedPayment(finalAmount, compoundRate);

        assertEquals(expected, actual);
    }

    @Test
    void testGenerateFixedPaymentWithInitialAmount() {

        SimpleCashFlow initCashFlow = Mockito.mock(SimpleCashFlow.class);
        Mockito.when(initCashFlow.getFutureValue()).thenReturn(100.0);
        Mockito.when(this.cashFlowFactory.create(anyDouble(), Mockito.any(CompoundRate.class))).thenReturn(initCashFlow);

        double initialAmount = 100;
        double finalAmount = 200;
        CompoundRate compoundRate = Mockito.mock(CompoundRate.class);

        streamOfCashFlowFactory.generateFixedPaymentWithInitialAmount(initialAmount, compoundRate, finalAmount);

        Mockito.verify(this.cashFlowFactory).create(anyDouble(), Mockito.any(CompoundRate.class));
        Mockito.verify(initCashFlow).getFutureValue();
    }

    @Test
    void testGenerateInitialAmount() {

        double fixedPayment = 100.0;
        CompoundRate compoundRate = Mockito.mock(CompoundRate.class);
        double finalAmount = 100.0;
        SimpleCashFlowFactory cashFlowFactory = new SimpleCashFlowFactory();

        double fixedPaymentFutureValue = fixedPayment * Factor.of(compoundRate.getFinalRate());
        double initAmountFutureValue = finalAmount - fixedPaymentFutureValue;
        SimpleCashFlow initCashFlow = cashFlowFactory.create(compoundRate, initAmountFutureValue);
        double expected = initCashFlow.getPresentValue();

        StreamOfCashFlowFactory streamOfCashFlowFactory = new StreamOfCashFlowFactory();

        double actual = streamOfCashFlowFactory.generateInitialAmount(fixedPayment, compoundRate, finalAmount);

        assertEquals(expected, actual);

    }
}
