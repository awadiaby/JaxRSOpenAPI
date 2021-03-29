package fr.istic.taa.jaxrs.dao.impl;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Tableau;


public class TableauDao extends AbstractJpaDao<Long, Tableau> {
    public TableauDao() {
        super();
        this.setClazz(Tableau.class);
    }


}
