package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.impl.CollaborateurDAO;
import fr.istic.taa.jaxrs.domain.Collaborateur;
import fr.istic.taa.jaxrs.dto.CollaborateurDTO;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/collaborateur")
@Produces({"application/json", "application/xml"})

public class CollaborateurResource {
    @POST
    @Consumes("application/json")
    public Response addCollaborateur(
            @Parameter(description = "Add in the collaborator", required = true) Collaborateur clb) {
        CollaborateurDAO dao = new CollaborateurDAO();
        dao.save(clb);
        return Response.ok().entity("SUCCESS").build();
    }

    @GET
    @Path("/{collaborateurId}")
    public CollaborateurDTO getCollaborateurById(@PathParam("collaborateurId") Long collaborateurId) {
        CollaborateurDAO dao = new CollaborateurDAO();
        Collaborateur dbCollaborateur = dao.findOne(collaborateurId);
        return CollaborateurDTO.fromCollaborateur(dbCollaborateur);
    }

    @GET
    @Path("/name={collaborateurName}")
    public List<CollaborateurDTO> getCollaborateurByName(@PathParam("collaborateurName") String collaborateurName) {
        CollaborateurDAO dao = new CollaborateurDAO();
        List<Collaborateur> dbCollaborateurs = dao.getCollaborateurByName(collaborateurName);
        List<CollaborateurDTO> jsonCollaborateurs = new ArrayList<>();
        for (Collaborateur clb : dbCollaborateurs) {
            jsonCollaborateurs.add(CollaborateurDTO.fromCollaborateur(clb));
        }
        return jsonCollaborateurs;
    }

    @GET
    @Path("/all")
    public List<CollaborateurDTO> getAllCollaborateurs() {
        CollaborateurDAO dao = new CollaborateurDAO();
        List<Collaborateur> dbCollaborateurs = dao.findAll();
        List<CollaborateurDTO> jsonCollaborateurs = new ArrayList<>();
        for (Collaborateur clb : dbCollaborateurs) {
            jsonCollaborateurs.add(CollaborateurDTO.fromCollaborateur(clb));
        }
        return jsonCollaborateurs;
    }
}