package com.lngtmg.meter.api.domain;

/**
 * Created by ppolishchuk on 5/31/14.
 */
public class MeterRequest {

    private String name;
    private MeterType meterType;

    public MeterRequest(final String name, final MeterType meterType) {
        this.name = name;
        this.meterType = meterType;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public MeterType getMeterType() {
        return meterType;
    }

    public void setMeterType(MeterType meterType) {
        this.meterType = meterType;
    }
}
