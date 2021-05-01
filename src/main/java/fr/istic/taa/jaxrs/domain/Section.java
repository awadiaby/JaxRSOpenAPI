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
    private List<Fiche> fiches = new ArrayList<>();
    private Tableau tableau;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    public TypeSection getStatus() {
        return status;
    }

    public void setStatus(TypeSection status) {
        this.status = status;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "section", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    public List<Fiche> getFiches() {
        return fiches;
    }

    public void setFiches(List<Fiche> fiches) {
        this.fiches = fiches;
    }

    @ManyToOne
    public Tableau getTableau() {
        return tableau;
    }

    public void setTableau(Tableau tableau) {
        this.tableau = tableau;
    }
}
