package com.ppol.meter.service.impl;

import com.ppol.meter.api.domain.Meter;
import com.ppol.meter.api.domain.MeterRequest;
import com.ppol.meter.api.exception.MeterRemoveException;
import com.ppol.meter.api.exception.MeterUpdateException;
import com.ppol.meter.service.MeterService;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class MeterServiceImpl implements MeterService {

    private final Map<Long, Meter> meters = new ConcurrentHashMap<>(16);
    private final AtomicLong keyGenerator = new AtomicLong();

    @Override
    public Collection<Meter> getAll() {
        return this.meters.values();
    }

    @Override
    public Meter get(final long id) {
        return this.meters.get(id);
    }

    @Override
    public Meter create(final MeterRequest meterRequest) {
        final Long key = keyGenerator.incrementAndGet();
        final Meter newMeter = new Meter(key, "Some meter", meterRequest.getMeterType());
        meters.put(key, newMeter);
        return newMeter;
    }

    @Override
    public Meter update(final Long id, final MeterRequest meterRequest) {
        Meter meter = meters.get(id);
        if (meter == null) {
            throw new MeterUpdateException("Can't update entity. Not found by id " + id);
        }
        meter.setName(meterRequest.getName());
        return meter;
    }

    @Override
    public void remove(final Long id) {
        Meter removed = meters.remove(id);
        if (removed == null) {
            throw new MeterRemoveException("Can't remove entity. Not found by id " + id);
        }
    }
}
