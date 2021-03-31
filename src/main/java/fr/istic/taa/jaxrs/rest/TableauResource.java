package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.impl.TableauDao;
import fr.istic.taa.jaxrs.domain.Fiche;
import fr.istic.taa.jaxrs.domain.Section;
import fr.istic.taa.jaxrs.domain.Tableau;
import fr.istic.taa.jaxrs.dto.FicheDTO;
import fr.istic.taa.jaxrs.dto.SectionDTO;
import fr.istic.taa.jaxrs.dto.TableauDTO;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/tableau")
@Produces({"application/json", "application/xml"})
public class TableauResource {
    @GET
    @Path("/{tableauId}")
    public TableauDTO getTableauById(@PathParam("tableauId") Long tableauId) {
        TableauDao dao = new TableauDao();
        return TableauDTO.fromTableau(dao.findOne(tableauId));
    }

    @GET
    @Path("/all")
    public List<TableauDTO> getAllTableaux() {
        TableauDao dao = new TableauDao();
        List<Tableau> dbTableaux = dao.findAll();
        List<TableauDTO> tableaux = new ArrayList<>();
        for (Tableau t: dbTableaux) {
            tableaux.add(TableauDTO.fromTableau(t));
        }
        return tableaux;
    }

    @POST
    @Consumes("application/json")
    public Response addTableau(
            @Parameter(description = "Add in the tableau", required = true) Tableau tableau) {
        TableauDao dao = new TableauDao();
        dao.save(tableau);
        return Response.ok().entity("SUCCESS: Le tableau a été ajoutée").build();
    }

    @DELETE()
    @Path("/{tableauId}")
    public Response deleteTableau(@PathParam("tableauId") Long tableauId) {
        TableauDao dao = new TableauDao();
        Tableau tableau = dao.findOne(tableauId);
        dao.delete(tableau);
        return Response.ok().entity("SUCCESS: La tableau a été supprimée :-)").build();
    }

    @PUT()
    @Path("/{tableauId}")
    public Response updateTableau(
            @Parameter(description = "Update a tableau", required = true) Tableau tableau,
            @PathParam("tableauId") Long tableauId) {
        TableauDao dao = new TableauDao();
        Tableau tableauToUpdate = dao.findOne(tableauId);
        tableauToUpdate.setNom(tableau.getNom());
        tableauToUpdate.setDateCreation(tableau.getDateCreation());

        dao.update(tableauToUpdate);
        return Response.ok().entity("SUCCESS: La tableau a été mise à jour :-)").build();
    }
}
