package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.impl.FicheDao;
import fr.istic.taa.jaxrs.domain.Fiche;
import fr.istic.taa.jaxrs.dto.FicheDTO;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/fiche")
@Produces({"application/json", "application/xml"})

public class FicheResource {

    @POST
    @Consumes("application/json")
    public Response addFiche(
            @Parameter(description = "Add in the fiche", required = true) Fiche fiche) {
        if (fiche.getCollaborateur() == null || fiche.getSection() == null)
            return Response.serverError().entity("Le collaborateur ou la section ne doivent pas être nuls").build();

        FicheDao dao = new FicheDao();
        dao.save(fiche);
        return Response.ok().entity("SUCCESS").build();
    }

    @GET
    @Path("/{ficheId}")
    public Response getFicheById(@PathParam("ficheId") Long ficheId) {
        FicheDao dao = new FicheDao();
        Fiche dbFiche = dao.findOne(ficheId);
        if (dbFiche == null)
            return Response.ok().entity("Aucune fiche n'a été trouvée").build();

        return Response.ok().entity(FicheDTO.fromFiche(dbFiche)).build();
    }

    @GET
    @Path("/all")
    public Response getAllFiches() {
        FicheDao dao = new FicheDao();
        List<Fiche> dbFiches = dao.findAll();
        if (dbFiches == null || dbFiches.isEmpty())
            return Response.ok().entity("Aucune fiche n'a été trouvée").build();

        List<FicheDTO> fiches = new ArrayList<>();
        for (Fiche fiche : dao.findAll()) {
            fiches.add(FicheDTO.fromFiche(fiche));
        }

        return Response.ok().entity(fiches).build();
    }

    @GET
    @Path("/all/{tableauId}")
    public Response getFichesByTableauId(@PathParam("tableauId") Long tableauId) {
        FicheDao dao = new FicheDao();
        List<Fiche> dbFiches = dao.getFichesByTableauId(tableauId);
        if (dbFiches == null || dbFiches.isEmpty())
            return Response.ok().entity("Aucune fiche n'a été trouvée").build();

        List<FicheDTO> fiches = new ArrayList<>();
        for (Fiche fiche : dbFiches) {
            fiches.add(FicheDTO.fromFiche(fiche));
        }

        return Response.ok().entity(fiches).build();
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
        //ficheToUpdate.setCollaborateur(fiche.getCollaborateur());
        ficheToUpdate.setCommit(fiche.getCommit());
        ficheToUpdate.setDureeTache(fiche.getDureeTache());
        ficheToUpdate.setUrl(fiche.getUrl());
        ficheToUpdate.setLieu(fiche.getLieu());
        ficheToUpdate.setNote(fiche.getNote());
        ficheToUpdate.setLibelle(fiche.getLibelle());

        dao.update(ficheToUpdate);
        return Response.ok().entity("SUCCESS: La fiche a été mise à jour :-)").build();
    }

    //TODO recupérer les fiches d'un collaborateur
}
