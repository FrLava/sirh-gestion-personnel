package dev.sgp.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ParameterNullException implements ExceptionMapper<Exception> {
	
	public Response toResponse(Exception e) {

		return Response.status(Response.Status.NO_CONTENT).build();

		}
}
