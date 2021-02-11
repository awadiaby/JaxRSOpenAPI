package fr.istic.taa.jaxrs.rest;


import fr.istic.taa.jaxrs.dao.impl.FicheDao;
import fr.istic.taa.jaxrs.domain.Fiche;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/fiche")
@Produces({"application/json", "application/xml"})

public class FicheResource {

    @GET
    @Path("/{ficheId}")
    public Fiche getFicheById(@PathParam("ficheId") Long ficheId) {
        FicheDao dao = new FicheDao();
        return dao.findOne(ficheId);
    }

}
