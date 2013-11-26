/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.services;

import br.mackenzie.dvdstore.dao.MidiaDAO;
import br.mackenzie.dvdstore.enumpack.OrdemBuscaEnum;
import br.mackenzie.dvdstore.entity.GenerosVO;
import br.mackenzie.dvdstore.entity.MidiaVO;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 71306552
 */
@Stateless
public class MidiaService {
    @PersistenceContext
    private EntityManager em;

    public List<MidiaVO> listar(){
       MidiaDAO dao = new MidiaDAO(em);
       return dao.findAll();
    }
    
    public List<MidiaVO> listar(int numeroResultados){
       MidiaDAO dao = new MidiaDAO(em);
       return dao.findAll(numeroResultados, 0);
    }
    
    public List<MidiaVO> filtrarPorTitulo(String titulo, OrdemBuscaEnum order, GenerosVO genero){
       MidiaDAO dao = new MidiaDAO(em);
       return dao.filtrarPorTitulo(titulo, order, genero);
    }
    
    public MidiaVO procurar(Long id){
        MidiaDAO dao = new MidiaDAO(em);
        return (MidiaVO) dao.find(id);
    }
    
    public void inserir(MidiaVO obj){
        MidiaDAO dao = new MidiaDAO(em);
        dao.create(obj);
    }
    
    public byte[] loadImage(Long id){
        return em.find(MidiaVO.class, id).getArquivo();
    }
}
