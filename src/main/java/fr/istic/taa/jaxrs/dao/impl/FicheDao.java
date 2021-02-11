package fr.istic.taa.jaxrs.dao.impl;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Fiche;

public class FicheDao extends AbstractJpaDao<Long, Fiche> {
    public FicheDao() {
        super();
        this.setClazz(Fiche.class);
    }

}
