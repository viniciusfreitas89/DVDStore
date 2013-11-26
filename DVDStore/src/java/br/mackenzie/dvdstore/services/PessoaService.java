/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.services;

import br.mackenzie.dvdstore.dao.PessoaDAO;
import br.mackenzie.dvdstore.entity.PessoaVO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Vinicius
 */
@Stateless
public class PessoaService {
    @PersistenceContext
    private EntityManager em;
    
    public List<PessoaVO> listar(){
       PessoaDAO dao = new PessoaDAO(em);
       return dao.findAll();
    }
    
    public void inserir(PessoaVO obj){
        PessoaDAO dao = new PessoaDAO(em);
        dao.create(obj);
    }
    
    public List<PessoaVO> consultarLogin(String email, String senha){
        PessoaDAO dao = new PessoaDAO(em);
        return dao.consultarLogin(email, senha);
    }
    
    public List<PessoaVO> consultarLogin(String email){
        PessoaDAO dao = new PessoaDAO(em);
        return dao.consultarLogin(email);
    }
    
    public PessoaVO procurar(Long id){
        PessoaDAO dao = new PessoaDAO(em);
        return (PessoaVO) dao.find(id);
    }
}
