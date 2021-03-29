package fr.istic.taa.jaxrs.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Section implements Serializable {
    private Long id;
    private TypeSection status;
    private List<Tableau> tableaux = new ArrayList<>();
    private List<Fiche> fiches = new ArrayList<>();

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    public TypeSection getStatus() {
        return status;
    }

    public void setStatus(TypeSection status) {
        this.status = status;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "section", cascade = CascadeType.PERSIST)
    public List<Fiche> getFiches() {
        return fiches;
    }

    public void setFiches(List<Fiche> fiches) {
        this.fiches = fiches;
    }


    @JsonIgnore
    @ManyToMany()
    public List<Tableau> getTableaux() {
        return tableaux;
    }

    public void setTableaux(List<Tableau> tableaux) {
        this.tableaux = tableaux;
    }
}
