package fr.istic.taa.jaxrs.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type_Collaborateur")
public class Collaborateur implements Serializable {
    private Long id;
    private String email;
    private String nom;
    private String prenom;
    private String role;
    private List<Fiche> fiches = new ArrayList<>();

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "collaborateur", cascade = CascadeType.PERSIST)
    public List<Fiche> getFiches() {
        return fiches;
    }

    public void setFiches(List<Fiche> fiches) {
        this.fiches = fiches;
    }

//    @Override
//    public String toString() {
//        return "Collaborateur{" +
//                "id=" + id +
//                ", email='" + email + '\'' +
//                ", nom='" + nom + '\'' +
//                ", prenom='" + prenom + '\'' +
//                ", fiches=" + fiches +
//                '}';
//    }
}
