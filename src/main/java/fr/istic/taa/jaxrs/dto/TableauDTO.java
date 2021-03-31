package fr.istic.taa.jaxrs.dto;

import fr.istic.taa.jaxrs.domain.Section;

import java.util.Date;
import java.util.List;

public class TableauDTO {
    private String nom;
    private String dateCreation;
    private List<Section> sections;

    public String getNom() {
        return nom;
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

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
