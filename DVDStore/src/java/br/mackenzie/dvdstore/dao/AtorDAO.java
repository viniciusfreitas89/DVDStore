/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.dao;

import br.mackenzie.dvdstore.entity.AtorVO;
import javax.persistence.EntityManager;

/**
 *
 * @author 71306552
 */
public class AtorDAO extends DAO{
    EntityManager em;
    private AtorDAO(Class type, EntityManager em) {
        super(type, em);
        this.em = em;
    }
    public AtorDAO(EntityManager em) {
        this(AtorVO.class, em);
    }
}
