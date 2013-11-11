/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.dao;

import br.mackenzie.dvdstore.vo.MidiaVO;
import javax.persistence.EntityManager;

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
    
     public void insert(MidiaVO t) {
        this.create(t);
    }
}
