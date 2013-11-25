/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.services;

import br.mackenzie.dvdstore.dao.AtorDAO;
import br.mackenzie.dvdstore.dao.exceptions.NonexistentEntityException;
import br.mackenzie.dvdstore.vo.AtorVO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Vinicius
 */
@Stateless
public class AtorService {
    @PersistenceContext
    private EntityManager em;
    
    public List<AtorVO> listar(){
       AtorDAO dao = new AtorDAO(em);
       return dao.findAll();
    }
    public void inserir(AtorVO obj){
        AtorDAO dao = new AtorDAO(em);
        dao.create(obj);
    }
    public void atualizar(AtorVO vo){
        AtorDAO dao = new AtorDAO(em);
        dao.update(vo);
    }
    public void remover(Long id) throws NonexistentEntityException{
        AtorDAO dao = new AtorDAO(em);
        dao.delete(id);
    }
    public void remover(AtorVO vo){
        AtorDAO dao = new AtorDAO(em);
        dao.delete(vo);
    }
    public AtorVO procurar(Long id){
        AtorDAO dao = new AtorDAO(em);
        return (AtorVO) dao.find(id);
    }
}
