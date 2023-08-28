package pt.altice.labs.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class LabsExceptionHandler implements ExceptionMapper<NegativeNumberException> {

    @Override
    public Response toResponse(NegativeNumberException e) {
            return Response.status(Response.Status.BAD_REQUEST).
                    entity(new CustomErrorMessage(e.getMessage())).build();

    }
}
