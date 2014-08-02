package com.ppol.meter.service;

import com.ppol.meter.api.domain.Meter;
import com.ppol.meter.api.domain.MeterRequest;

import java.util.Collection;

public interface MeterService {

    Collection<Meter> getAll();

    Meter get(long id);

    Meter create(MeterRequest meterRequest);

    Meter update(Long id, MeterRequest meterRequest);

    void remove(Long id);
}
