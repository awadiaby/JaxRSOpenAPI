package fr.istic.taa.jaxrs.rest;


import fr.istic.taa.jaxrs.dao.impl.FicheDao;
import fr.istic.taa.jaxrs.domain.Fiche;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/fiche")
@Produces({"application/json", "application/xml"})

public class FicheResource {

    @GET
    @Path("/{ficheId}")
    public Fiche getFicheById(@PathParam("ficheId") Long ficheId) {
        FicheDao dao = new FicheDao();
        return dao.findOne(ficheId);
    }

    @GET
    @Path("/all")
    public List<Fiche> getAllFiches() {
        FicheDao dao = new FicheDao();
        return dao.findAll();
    }

    @POST
    @Consumes("application/json")
    public Response addFiche(
            @Parameter(description = "Add in the fiche", required = true) Fiche fiche) {
        FicheDao dao = new FicheDao();
        dao.save(fiche);
        return Response.ok().entity("SUCCESS").build();
    }

    @DELETE()
    @Path("/{ficheId}")
    public Response deleteFiche(@PathParam("ficheId") Long ficheId) {
        FicheDao dao = new FicheDao();
        Fiche fiche = dao.findOne(ficheId);
        dao.delete(fiche);
        return Response.ok().entity("SUCCESS: La fiche a été supprimé :-)").build();
    }

    @PUT()
    @Path("/{ficheId}")
    public Response updateFiche(
            @Parameter(description = "Update a fiche", required = true) Fiche fiche,
            @PathParam("ficheId") Long ficheId) {
        FicheDao dao = new FicheDao();
        Fiche ficheToUpdate = dao.findOne(ficheId);
        ficheToUpdate.setDate(fiche.getDate());
        ficheToUpdate.setCollaborateur(fiche.getCollaborateur());
        ficheToUpdate.setCommit(fiche.getCommit());
        ficheToUpdate.setDureeTache(fiche.getDureeTache());
        ficheToUpdate.setUrl(fiche.getUrl());
        ficheToUpdate.setLieu(fiche.getLieu());
        ficheToUpdate.setNote(fiche.getNote());
        ficheToUpdate.setLibelle(fiche.getLibelle());

        dao.update(ficheToUpdate);
        return Response.ok().entity("SUCCESS: La fiche a été mise à jour :-)").build();
    }
}