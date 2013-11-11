/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.dao;

import br.mackenzie.dvdstore.vo.MidiaVO;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 *
 * @author 71306552
 */
public class MidiaDAO extends DAO{
    EntityManager em;
    private MidiaDAO(Class type, EntityManager em) {
        super(type, em);
        this.em = em;
    }
    public MidiaDAO(EntityManager em) {
        this(MidiaVO.class, em);
    }
    
    @Transactional
     public void create(MidiaVO t) {
        em.persist(t);
    }
}
