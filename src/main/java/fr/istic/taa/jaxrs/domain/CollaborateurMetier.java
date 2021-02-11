package fr.istic.taa.jaxrs.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Metier")
public class CollaborateurMetier extends Collaborateur{
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "CollaborateurMetier{" +
                "role='" + role + '\'' +
                '}';
    }
}
