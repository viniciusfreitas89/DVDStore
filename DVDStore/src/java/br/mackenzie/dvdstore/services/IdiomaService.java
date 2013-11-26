/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.mackenzie.dvdstore.services;

import br.mackenzie.dvdstore.dao.IdiomaDAO;
import br.mackenzie.dvdstore.dao.exceptions.NonexistentEntityException;
import br.mackenzie.dvdstore.entity.IdiomaVO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Antonio
 */
@Stateless
public class IdiomaService {
    @PersistenceContext
    private EntityManager em;
    
    public void inserir(IdiomaVO vo){
        IdiomaDAO dao = new IdiomaDAO(em);
        dao.create(vo);
    }
    public void atualizar(IdiomaVO vo){
        IdiomaDAO dao = new IdiomaDAO(em);
        dao.update(vo);
    }
    public void remover(Long id) throws NonexistentEntityException{
        IdiomaDAO dao = new IdiomaDAO(em);
        dao.delete(id);
    }
    public void remover(IdiomaVO vo){
        IdiomaDAO dao = new IdiomaDAO(em);
        dao.delete(vo);
    }
    public List<IdiomaVO> listar(){
        IdiomaDAO dao = new IdiomaDAO(em);
        return dao.findAll();
    }
    public IdiomaVO procurar(Long id){
        IdiomaDAO dao = new IdiomaDAO(em);
        return (IdiomaVO) dao.find(id);
    }
    
}
