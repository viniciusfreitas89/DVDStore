/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.dao;

import br.mackenzie.dvdstore.entity.PessoaVO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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
    
    public List<PessoaVO> consultarLogin(String email, String senha){
        Query q = em.createNamedQuery("Pessoa.filtrar.login.senha");
        q.setParameter("param1", email);
        q.setParameter("param2", senha);
        
        List<PessoaVO> list = q.getResultList();
        return list;
    }
    
    public List<PessoaVO> consultarLogin(String email){
        Query q = em.createNamedQuery("Pessoa.filtrar.login");
        q.setParameter("param1", email);
        List<PessoaVO> list = q.getResultList();
        return list;
    }
}
