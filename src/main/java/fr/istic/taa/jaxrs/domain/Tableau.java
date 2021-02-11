package fr.istic.taa.jaxrs.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Tableau {
    private Long id;
    private String nom;
    private Date dateCreation;
    private Section section;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Temporal(TemporalType.DATE)
    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @ManyToOne
    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
