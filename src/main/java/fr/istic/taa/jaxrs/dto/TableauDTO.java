package fr.istic.taa.jaxrs.dto;

import fr.istic.taa.jaxrs.domain.Section;
import fr.istic.taa.jaxrs.domain.Tableau;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static fr.istic.taa.jaxrs.dto.SectionDTO.fromSection;

public class TableauDTO {
    private long id;
    private String nom;
    private String dateCreation;
    private String description;
    private List<SectionDTO> sections;


    public String getNom() {
        return nom;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public List<SectionDTO> getSections() {
        return sections;
    }

    public void setSections(List<SectionDTO> sections) {
        this.sections = sections;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static TableauDTO fromTableau(Tableau tableau) {
        TableauDTO dto = new TableauDTO();
        dto.setId(tableau.getId());
        dto.setNom(tableau.getNom());
        dto.setDateCreation(tableau.getDateCreation().toString());
        dto.setDescription(tableau.getDescription());
        List<SectionDTO> sections = new ArrayList<>();
        for (Section section : tableau.getSections()) {
            sections.add(fromSection(section));
        }
        dto.setSections(sections);
        return dto;
    }
}
