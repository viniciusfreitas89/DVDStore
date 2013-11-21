/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.dao;

import br.mackenzie.dvdstore.vo.GenerosVO;
import javax.persistence.EntityManager;

/**
 *
 * @author 71306552
 */
public class GenerosDAO extends DAO{
    EntityManager em;
    private GenerosDAO(Class type, EntityManager em) {
        super(type, em);
        this.em = em;
    }
    public GenerosDAO(EntityManager em) {
        this(GenerosVO.class, em);
    }
}
