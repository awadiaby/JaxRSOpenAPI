package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.impl.CollaborateurDAO;
import fr.istic.taa.jaxrs.dao.impl.FicheDao;
import fr.istic.taa.jaxrs.domain.Collaborateur;
import fr.istic.taa.jaxrs.domain.Fiche;
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
    public Response getCollaborateurById(@PathParam("collaborateurId") Long collaborateurId) {
        CollaborateurDAO dao = new CollaborateurDAO();
        Collaborateur dbCollaborateur = dao.findOne(collaborateurId);
        if (dbCollaborateur == null)
            return Response.ok().entity("Pas de collaborateur trouvé avec cet id").build();

        return Response.ok().entity(CollaborateurDTO.fromCollaborateur(dbCollaborateur)).build();
    }

    @GET
    @Path("/name={collaborateurName}")
    public Response getCollaborateurByName(@PathParam("collaborateurName") String collaborateurName) {
        CollaborateurDAO dao = new CollaborateurDAO();
        List<Collaborateur> dbCollaborateurs = dao.getCollaborateurByName(collaborateurName);
        if (dbCollaborateurs == null || dbCollaborateurs.isEmpty())
            return Response.ok().entity("Pas de collaborateur avec ce nom").build();

        List<CollaborateurDTO> jsonCollaborateurs = new ArrayList<>();
        for (Collaborateur clb : dbCollaborateurs) {
            jsonCollaborateurs.add(CollaborateurDTO.fromCollaborateur(clb));
        }
        return Response.ok().entity(jsonCollaborateurs).build();
    }

    @GET
    @Path("/all")
    public Response getAllCollaborateurs() {
        CollaborateurDAO dao = new CollaborateurDAO();
        List<Collaborateur> dbCollaborateurs = dao.findAll();

        if (dbCollaborateurs == null || dbCollaborateurs.isEmpty())
            return Response.ok().entity("Aucun collaborateur n'a été trouvé").build();

        List<CollaborateurDTO> jsonCollaborateurs = new ArrayList<>();
        for (Collaborateur clb : dbCollaborateurs) {
            jsonCollaborateurs.add(CollaborateurDTO.fromCollaborateur(clb));
        }
        return Response.ok().entity(jsonCollaborateurs).build();
    }


    @DELETE()
    @Path("/{collaborateurId}")
    public Response deleteFiche(@PathParam("collaborateurId") Long collaborateurId) {
        CollaborateurDAO dao = new CollaborateurDAO();
        Collaborateur collaborateur = dao.findOne(collaborateurId);
        dao.delete(collaborateur);
        return Response.ok().entity("SUCCESS: Le collaborateur  a été supprimé :-)").build();
    }
}