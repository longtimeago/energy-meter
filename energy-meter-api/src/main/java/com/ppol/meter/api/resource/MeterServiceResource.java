package com.ppol.meter.api.resource;


import com.ppol.meter.api.domain.Meter;
import com.ppol.meter.api.domain.MeterRequest;
import com.ppol.meter.api.exception.MeterUpdateException;
import java.util.Collection;
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

/**
 * In fact, we don't need this API to be imported to the client
 * (we don't need this interface at all), because client don't use it.
 * Much better approach was implemented by SQ in sqa-soa-platform module,
 * where web client creation and configuration performed behind the scene
 * and API part is really used by client application.
 */
public interface MeterServiceResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Meter> getMeters();

    /**
     * Returns {@code Meter} by id.
     * Receive query param 'locations'
     *
     * @param id
     * @param uriInfo
     * @return Meter
     */
    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN })
    public Meter getMeter(@PathParam("id") Long id, @Context UriInfo uriInfo);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Meter createMeter(final MeterRequest meterRequest);

    /**
     * Update existing {@code Meter}
     * @param id
     * @throws MeterUpdateException if no meter were found by id
     * @return Meter
     */
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Meter updateMeter(@PathParam("id") final Long id,
        final MeterRequest meterRequest);

    @DELETE
    @Path("{id}")
    public void removeMeter(@PathParam("id") final Long id);
}
