/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.services;

import br.mackenzie.dvdstore.dao.GenerosDAO;
import br.mackenzie.dvdstore.dao.exceptions.NonexistentEntityException;
import br.mackenzie.dvdstore.entity.GenerosVO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 71306552
 */
@Stateless
public class GeneroService {
    @PersistenceContext
    private EntityManager em;
    
    public void inserir(GenerosVO vo){
        GenerosDAO dao = new GenerosDAO(em);
        dao.create(vo);
    }
    public void atualizar(GenerosVO vo){
        GenerosDAO dao = new GenerosDAO(em);
        dao.update(vo);
    }
    
    public void remover(Long id) throws NonexistentEntityException{
        GenerosDAO dao = new GenerosDAO(em);
        dao.delete(id);
    }
    
    public void remover(GenerosVO vo){
        GenerosDAO dao = new GenerosDAO(em);
        dao.delete(vo);
    }
    
    public List<GenerosVO> listar(){
       GenerosDAO dao = new GenerosDAO(em);
       return dao.findAll();
    }
    
    public GenerosVO procurar(Long id){
        GenerosDAO dao = new GenerosDAO(em);
        return (GenerosVO) dao.find(id);
    }
    
    
}
