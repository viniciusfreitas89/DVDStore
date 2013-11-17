/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.services;

import br.mackenzie.dvdstore.dao.PessoaDAO;
import br.mackenzie.dvdstore.vo.MidiaVO;
import br.mackenzie.dvdstore.vo.PessoaVO;
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
    
    public List<MidiaVO> listar(){
       PessoaDAO dao = new PessoaDAO(em);
       return dao.findAll();
    }
    
    public void inserir(PessoaVO obj){
        PessoaDAO dao = new PessoaDAO(em);
        dao.create(obj);
    }
}
