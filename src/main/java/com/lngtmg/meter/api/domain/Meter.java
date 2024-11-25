package com.lngtmg.meter.api.domain;

public class Meter {

    private long id;
    private String name;
    private MeterType meterType;

    public Meter() {
    }

    public Meter(final long id, final String name, final MeterType meterType) {
        this.id = id;
        this.name = name;
        this.meterType = meterType;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Meter{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", meterType=" + meterType +
            '}';
    }
}
