package com.ppol.meter.resource;

import com.ppol.meter.api.domain.Measurement;
import com.ppol.meter.api.resource.MeterResource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * (c) Swissquote 6/6/14
 *
 * @author ppolishchuk
 */
public class PowerMeterResourceImpl implements MeterResource {

	@GET
	@Path("/power")
	public Measurement getMeasurement() {
		return new Measurement(1.234);
	}
}
