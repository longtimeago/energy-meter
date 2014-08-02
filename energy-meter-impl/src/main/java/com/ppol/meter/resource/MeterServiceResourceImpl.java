package com.ppol.meter.resource;

import com.ppol.meter.api.domain.Meter;
import com.ppol.meter.api.domain.MeterRequest;
import com.ppol.meter.api.domain.MeterType;
import com.ppol.meter.api.resource.MeterResource;
import com.ppol.meter.api.resource.MeterServiceResource;
import com.ppol.meter.service.MeterService;

import java.util.Collection;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("meters")
@PermitAll
public class MeterServiceResourceImpl implements MeterServiceResource {

    //private static final Logger LOGGER = LoggerFactory.getLogger(EnergyMeterResourceImpl.class.getName());

    @Inject
    private MeterService ems;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Meter> getMeters() {
        return ems.getAll();
    }

    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
    @RolesAllowed({"admin", "user"})
    public Meter getMeter(@PathParam("id") final Long id, @Context final UriInfo uriInfo) {
        final List<String> locations = uriInfo.getQueryParameters().get("locations");
        if (locations != null && !locations.isEmpty()) {
            return new Meter(id, "Another Electrical meter, located in " + locations.get(0), MeterType.POWER);
        }
        return ems.get(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Meter createMeter(final MeterRequest meterRequest) {
        return ems.create(meterRequest);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Meter updateMeter(@PathParam("id") final Long id,
        final MeterRequest meterRequest) {
        return ems.update(id, meterRequest);
    }

    @DELETE
    @Path("{id}")
    @RolesAllowed("admin")
    public void removeMeter(@PathParam("id") final Long id) {
        ems.remove(id);
    }

    @Path("{id}/measurement")
	public MeterResource getMeterResource(@PathParam("id") final Long id) {
		final Meter meter = ems.get(id);
		switch (meter.getMeterType()) {
			case POWER:
				return new PowerMeterResourceImpl();
			case WATER:
				return new WaterMeterResourceImpl();
			default:
				throw new IllegalArgumentException("Unknown Meter Type");
		}
	}

}
