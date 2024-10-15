package com.lngtmg.meter.api.domain;

public class Measurement {

    private Double lastValue;

    public Measurement(Double value) {
        this.lastValue = value;
    }

    public Double getLastValue() {
        return lastValue;
    }

    public void setLastValue(Double lastValue) {
        this.lastValue = lastValue;
    }

    @Override
    public String toString() {
        return "Measurement{" +
            "lastValue=" + lastValue +
            '}';
    }
}
