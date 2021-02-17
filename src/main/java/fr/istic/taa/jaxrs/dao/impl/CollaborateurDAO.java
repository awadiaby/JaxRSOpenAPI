package fr.istic.taa.jaxrs.dao.impl;


import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.dao.generic.EntityManagerHelper;
import fr.istic.taa.jaxrs.domain.Collaborateur;


import javax.persistence.EntityTransaction;
import java.util.List;

public class CollaborateurDAO extends AbstractJpaDao<Long, Collaborateur> {
    public CollaborateurDAO() {
        super();
        this.setClazz(Collaborateur.class);
    }

    public List<Collaborateur> getCollaborateurByName(String name) {
        return this.entityManager
                .createQuery("SELECT c from Collaborateur c WHERE c.nom =:name", Collaborateur.class)
                .setParameter("name", name)
                .getResultList();
    }
}