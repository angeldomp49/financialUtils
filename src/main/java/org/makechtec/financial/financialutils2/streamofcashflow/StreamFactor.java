package org.makechtec.financial.financialutils2.streamofcashflow;

import org.makechtec.financial.financialutils2.factor.CompoundFactor;

public class StreamFactor implements CompoundFactor{

    private StreamRate streamRate;

    public StreamFactor(final StreamRate streamRate){
        this.streamRate = streamRate;
    }

    @Override
    public double getValue() {
        // implement this
        return 0;
    }

    @Override
    public StreamRate getCompoundRate() {
        return this.streamRate;
    }
    
}
