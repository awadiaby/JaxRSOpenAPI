package fr.istic.taa.jaxrs.rest;


import fr.istic.taa.jaxrs.dao.impl.SectionDao;
import fr.istic.taa.jaxrs.domain.Section;
import fr.istic.taa.jaxrs.dto.SectionDTO;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/section")
@Produces({"application/json", "application/xml"})
public class SectionResource {
    @GET
    @Path("/{sectionId}")
    public Response getSectionById(@PathParam("sectionId") Long sectionId) {
        SectionDao dao = new SectionDao();
        Section section = dao.findOne(sectionId);
        if (section == null)
            return Response.ok().entity("Aucune section n'a été trouvée").build();

        return Response.ok().entity(SectionDTO.fromSection(section)).build();
    }

    @GET
    @Path("/all")
    public Response getAllSections() {
        SectionDao dao = new SectionDao();
        List<Section> sectionList = dao.findAll();
        List<SectionDTO> sections = new ArrayList<>();
        if (sectionList == null || sectionList.isEmpty())
            return Response.ok().entity("Aucune section n'a été trouvée").build();

        for (Section section : dao.findAll()) {
            sections.add(SectionDTO.fromSection(section));
        }
        return Response.ok().entity(sections).build();
    }

    @POST
    @Consumes("application/json")
    public Response addSection(
            @Parameter(description = "Add in the section", required = true) Section section) {
        SectionDao dao = new SectionDao();
        dao.save(section);
        return Response.ok().entity("SUCCESS: La section a été ajoutée").build();
    }

    @DELETE()
    @Path("/{sectionId}")
    public Response deleteSection(@PathParam("sectionId") Long sectionId) {
        SectionDao dao = new SectionDao();
        Section section = dao.findOne(sectionId);
        dao.delete(section);
        return Response.ok().entity("SUCCESS: La section a été supprimée :-)").build();
    }
/*
 Pas utile dans notre cas
     @PUT()
     @Path("/{sectionId}") public Response updateSection(
     @Parameter(description = "Update a section", required = true) Section section,
     @PathParam("sectionId") Long sectionId) {
     SectionDao dao = new SectionDao();
     Section sectionToUpdate = dao.findOne(sectionId);
     sectionToUpdate.setStatus(section.getStatus());
     sectionToUpdate.getTableaux().addAll(section.getTableaux());

     dao.update(sectionToUpdate);
     return Response.ok().entity("SUCCESS: La section a été mise à jour :-)").build();
     }
 */
}
