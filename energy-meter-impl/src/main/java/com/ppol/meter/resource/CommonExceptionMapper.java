package com.ppol.meter.resource;

import com.ppol.meter.api.exception.MeterException;
import com.ppol.meter.api.exception.ExceptionDto;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CommonExceptionMapper implements ExceptionMapper<MeterException> {
    @Override
    public Response toResponse(final MeterException ex) {
        Response response =  Response.status(500)
            .entity(new ExceptionDto(ex.getMessage(), ex.getClass().getName()))
            .type(MediaType.APPLICATION_JSON_TYPE)
            .build();
        return response;
    }


}