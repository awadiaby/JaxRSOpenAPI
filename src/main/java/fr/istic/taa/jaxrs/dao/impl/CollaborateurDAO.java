package fr.istic.taa.jaxrs.dao.impl;


import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.dao.generic.EntityManagerHelper;
import fr.istic.taa.jaxrs.domain.Collaborateur;


import javax.persistence.EntityTransaction;
import java.util.List;

public class CollaborateurDAO extends AbstractJpaDao <Long, Collaborateur> {
    public CollaborateurDAO() {
        super();
        this.setClazz(Collaborateur.class);
    }

    public void saveCollaborateur(Collaborateur clb) {
        EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
        t.begin();
        EntityManagerHelper.getEntityManager().persist(clb);
        t.commit();
    }
    public List<Collaborateur> getAllCollaborateur() {
        String query = "select c from Collaborateur as c";
        return EntityManagerHelper.getEntityManager().createQuery(query, Collaborateur.class).getResultList();
    }

}