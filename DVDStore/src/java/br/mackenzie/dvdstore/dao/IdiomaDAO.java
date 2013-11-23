/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.mackenzie.dvdstore.dao;

import br.mackenzie.dvdstore.vo.IdiomaVO;
import javax.persistence.EntityManager;

/**
 *
 * @author Antonio
 */
public class IdiomaDAO extends DAO{
    EntityManager em;
    public IdiomaDAO(Class type, EntityManager em) {
        super(type, em);
        this.em = em;
    }
    public IdiomaDAO(EntityManager em){
        this(IdiomaVO.class, em);
    }
}
