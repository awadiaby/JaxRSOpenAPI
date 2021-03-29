package fr.istic.taa.jaxrs.dao.impl;

import fr.istic.taa.jaxrs.dao.generic.AbstractJpaDao;
import fr.istic.taa.jaxrs.domain.Section;


public class SectionDao extends AbstractJpaDao<Long, Section> {
    public SectionDao() {
        super();
        this.setClazz(Section.class);
    }


}
