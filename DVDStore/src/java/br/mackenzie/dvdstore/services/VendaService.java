/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.services;

import br.mackenzie.dvdstore.dao.VendasDAO;
import br.mackenzie.dvdstore.dao.exceptions.NonexistentEntityException;
import br.mackenzie.dvdstore.entity.AtorVO;
import br.mackenzie.dvdstore.entity.VendasVO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Vinicius
 */
@Stateless
public class VendaService {
    @PersistenceContext
    private EntityManager em;
    
    public List<VendasVO> listar(){
       VendasDAO dao = new VendasDAO(em);
       return dao.findAll();
    }
    public void inserir(VendasVO obj){
        VendasDAO dao = new VendasDAO(em);
        dao.create(obj);
    }
    public void atualizar(VendasVO vo){
        VendasDAO dao = new VendasDAO(em);
        dao.update(vo);
    }
    public void remover(Long id) throws NonexistentEntityException{
        VendasDAO dao = new VendasDAO(em);
        dao.delete(id);
    }
    public void remover(VendasVO vo){
        VendasDAO dao = new VendasDAO(em);
        dao.delete(vo);
    }
    public AtorVO procurar(Long id){
        VendasDAO dao = new VendasDAO(em);
        return (AtorVO) dao.find(id);
    }
}
