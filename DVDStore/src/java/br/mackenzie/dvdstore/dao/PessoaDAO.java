/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.dao;

import br.mackenzie.dvdstore.vo.MidiaVO;
import br.mackenzie.dvdstore.vo.PessoaVO;
import javax.persistence.EntityManager;

/**
 *
 * @author Vinicius
 */
public class PessoaDAO extends DAO{
    EntityManager em;
    private PessoaDAO(Class type, EntityManager em) {
        super(type, em);
        this.em = em;
    }
    public PessoaDAO(EntityManager em) {
        this(PessoaVO.class, em);
    }
}
