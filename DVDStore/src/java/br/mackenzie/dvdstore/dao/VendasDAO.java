/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.dao;

import br.mackenzie.dvdstore.entity.VendasVO;
import javax.persistence.EntityManager;

/**
 *
 * @author 71306552
 */
public class VendasDAO extends DAO{
    EntityManager em;
    private VendasDAO(Class type, EntityManager em) {
        super(type, em);
        this.em = em;
    }
    public VendasDAO(EntityManager em) {
        this(VendasVO.class, em);
    }
}
