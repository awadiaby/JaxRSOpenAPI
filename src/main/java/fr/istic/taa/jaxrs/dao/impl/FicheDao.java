package fr.istic.taa.jaxrs.dao.impl;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Collaborateur;
import fr.istic.taa.jaxrs.domain.Fiche;

import java.util.List;

public class FicheDao extends AbstractJpaDao<Long, Fiche> {
    public FicheDao() {
        super();
        this.setClazz(Fiche.class);
    }

    public List<Fiche> getFichesByTableauId(Long id) {
        return this.entityManager
                .createQuery("SELECT f from Fiche f WHERE f.section.tableau.id =:id", Fiche.class)
                .setParameter("id", id)
                .getResultList();
    }
}
