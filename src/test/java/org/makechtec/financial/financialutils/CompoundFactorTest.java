package org.makechtec.financial.financialutils;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;

public class CompoundFactorTest {

    @Mock
    private Rate rate;

    @InjectMocks
    private CompoundFactor factor;

    @Spy
    private CompoundFactor spyFactor;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCompoundFactor() {
        this.factor.compoundFactor(0.06, 2);
        verify(this.rate,times(1)).compoundRate(anyDouble(), anyInt());
    }

    @Test
    public void testStreamFactor() {
        this.factor.streamFactor(0.06, 10);
        verify(this.rate,times(1)).compoundRate(anyDouble(), anyInt());
    }

    @Test
    public void testStreamFactor_growth() {
        Mockito.when(spyFactor.compoundFactor(anyDouble(), anyInt())).thenReturn(1.0);
        spyFactor.streamFactor(0.03, 0.01, 10);
        verify(spyFactor,times(2)).compoundFactor(anyDouble(), anyInt());
    }

    @Test
    public void testDiscountFactor() {
        Mockito.when(spyFactor.compoundFactor(anyDouble(), anyInt())).thenReturn(1.0);
        spyFactor.discountFactor(0.03, 10);
        verify(spyFactor,times(1)).compoundFactor(anyDouble(), anyInt());
    }

    @Test
    public void testAnnuityDiscountFactor_3args() {
        Mockito.when(spyFactor.compoundFactor(anyDouble(), anyInt())).thenReturn(1.0);
        spyFactor.discountFactor(0.03,0.02, 10);
        verify(spyFactor,times(2)).compoundFactor(anyDouble(), anyInt());
    }
    
}
