package fr.istic.taa.jaxrs.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Section {
    private Long id;
    private TypeSection status;
    private List<Tableau> tableaux = new ArrayList<>();

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

    @OneToMany(mappedBy = "section")
    public List<Tableau> getTableaux() {
        return tableaux;
    }

    public void setTableaux(List<Tableau> tableaux) {
        this.tableaux = tableaux;
    }
}
