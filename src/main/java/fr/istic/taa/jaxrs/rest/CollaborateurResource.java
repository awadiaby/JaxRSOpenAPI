package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.impl.CollaborateurDAO;
import fr.istic.taa.jaxrs.domain.Collaborateur;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/collaborateur")
@Produces({"application/json", "application/xml"})

public class CollaborateurResource {
    @GET
    @Path("/{collaborateurId}")
    public Collaborateur getCollaborateurById(@PathParam("collaborateurId") Long collaborateurId) {
        CollaborateurDAO dao = new CollaborateurDAO();
        return dao.findOne(collaborateurId);
    }

    @GET
    @Path("/{collaborateurName}")
    public List<Collaborateur> getCollaborateurByName(@PathParam("collaborateurName") String collaborateurName) {
        CollaborateurDAO dao = new CollaborateurDAO();
        return dao.getCollaborateurByName(collaborateurName);
    }

    @GET
    @Path("/all")
    public List<Collaborateur> getAllCollaborateurs() {
        CollaborateurDAO dao = new CollaborateurDAO();
        return dao.findAll();
    }

    @POST
    @Consumes("application/json")
    public Response addCollaborateur(
            @Parameter(description = "Add in the collaborator", required = true) Collaborateur clb) {
        CollaborateurDAO dao = new CollaborateurDAO();
        dao.save(clb);
        return Response.ok().entity("SUCCESS").build();
    }
}