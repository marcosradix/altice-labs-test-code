package pt.altice.labs.resource;

import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import pt.altice.labs.dto.LabseqResponseDTO;
import pt.altice.labs.service.LabseqService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/labseq")
@RequiredArgsConstructor
public class LabseqResource {


    final LabseqService labseqService;

    @GET
    @Path("/{index}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get the LabSeq value at a specific index")
    @APIResponses(
            {@APIResponse(responseCode = "200", description = "Successful response"),
                    @APIResponse(responseCode = "400", description = "Bad request")}
    )
    public LabseqResponseDTO labseq(@PathParam("index") Integer index) {
        return labseqService.labseqGenerator(index);
    }
}
