package fr.istic.taa.jaxrs.domain;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Technique")
public class CollaborateurTechnique extends Collaborateur {
    private String roleTech;

    public String getRoleTech() {
        return roleTech;
    }

    public void setRoleTech(String roleTech) {
        this.roleTech = roleTech;
    }

    @Override
    public String toString() {
        return "CollaborateurTechnique{" +
                "roleTech='" + roleTech + '\'' +
                '}';
    }
}
