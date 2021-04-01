package fr.istic.taa.jaxrs.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fr.istic.taa.jaxrs.dto.TableauDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Tableau implements Serializable {
    private Long id;
    private String nom;
    private Date dateCreation;
    private List<Section> sections = new ArrayList<>();

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
        this.dateCreation = new Date();
    }

    @JsonIgnore
    @OneToMany(mappedBy = "tableau",cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
