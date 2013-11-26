/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.dao;

import br.mackenzie.dvdstore.enumpack.OrdemBuscaEnum;
import br.mackenzie.dvdstore.entity.GenerosVO;
import br.mackenzie.dvdstore.entity.MidiaVO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author 71306552
 */
public class MidiaDAO extends DAO{
    EntityManager em;
    private MidiaDAO(Class type, EntityManager em) {
        super(type, em);
        this.em = em;
    }
    public MidiaDAO(EntityManager em) {
        this(MidiaVO.class, em);
    }
    
    @Transactional
    public List<MidiaVO> filtrarPorTitulo(String titulo, OrdemBuscaEnum order, GenerosVO genero){
        System.out.println(order);
        Query q = null;
        switch (order){
            case TITULO: {
                if (genero==null){
                    q = em.createNamedQuery("Midia.filtrar.titulo.ordenado.titulo");
                }else{
                    q = em.createNamedQuery("Midia.filtrar.titulo-genero.ordenado.titulo");
                    q.setParameter("param2", genero);
                }
                break;
            }
            case MAIOR_PRECO:{
                if (genero==null){
                    q = em.createNamedQuery("Midia.filtrar.titulo.ordenado.maior-preco");
                }else{
                    q = em.createNamedQuery("Midia.filtrar.titulo-genero.ordenado.maior-preco");
                    q.setParameter("param2", genero);
                }
                break;
            }
            case MENOR_PRECO:{
                if (genero==null){
                    q = em.createNamedQuery("Midia.filtrar.titulo.ordenado.menor-preco");
                }else{
                    q = em.createNamedQuery("Midia.filtrar.titulo-genero.ordenado.menor-preco");
                    q.setParameter("param2", genero);
                }
                break;
            }
            default: {
                if (genero==null){
                    q = em.createNamedQuery("Midia.filtrar.titulo");
                }else{
                    q = em.createNamedQuery("Midia.filtrar.titulo-genero");
                    q.setParameter("param2", genero);
                }
                break;
            } 
        }
        q.setParameter("param1", ("%"+titulo+"%").toLowerCase());
        
        return q.getResultList();
    }
}
