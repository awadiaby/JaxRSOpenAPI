package fr.istic.taa.jaxrs.rest;

import fr.istic.taa.jaxrs.dao.impl.TableauDao;
import fr.istic.taa.jaxrs.domain.Tableau;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/tableau")
@Produces({"application/json", "application/xml"})
public class TableauResource {
    @GET
    @Path("/{tableauId}")
    public Tableau getTableauById(@PathParam("tableauId") Long tableauId) {
        TableauDao dao = new TableauDao();
        return dao.findOne(tableauId);
    }

    @GET
    @Path("/all")
    public List<Tableau> getAllTableaus() {
        TableauDao dao = new TableauDao();
        return dao.findAll();
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
