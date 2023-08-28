package pt.altice.labs.resource;

import lombok.RequiredArgsConstructor;
import pt.altice.labs.dto.LabseqResponseDTO;
import pt.altice.labs.service.LabseqService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
@Path("/labseq")
@RequiredArgsConstructor
public class LabseqResource {


    final LabseqService labseqService;

    @GET
    @Path("/{index}")
    @Produces(MediaType.APPLICATION_JSON)
    public LabseqResponseDTO labseq(@PathParam("index") Integer index) {
        return labseqService.labseqGenerator(index);
    }
}
