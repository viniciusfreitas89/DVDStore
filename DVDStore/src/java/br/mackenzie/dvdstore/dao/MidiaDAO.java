/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.dao;

import br.mackenzie.dvdstore.enumpack.OrdemBuscaEnum;
import br.mackenzie.dvdstore.vo.MidiaVO;
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
    public List<MidiaVO> filtrarPorTitulo(String titulo, OrdemBuscaEnum order){
        System.out.println(order);
        Query q = null;
        if (order.equals(OrdemBuscaEnum.NONE)){
            q = em.createNamedQuery("Midia.filtrar.titulo");
        }else{
            switch (order){
                case TITULO: {
                    q = em.createNamedQuery("Midia.filtrar.titulo.ordenado.titulo"); break;
                }
                case MAIOR_PRECO:{
                    q = em.createNamedQuery("Midia.filtrar.titulo.ordenado.maior-preco"); break;
                }
                case MENOR_PRECO:{
                    q = em.createNamedQuery("Midia.filtrar.titulo.ordenado.menor-preco"); break;
                }
//                case MAIS_VENDIDOS:{
//                    q = em.createNamedQuery("Midia.filtrar.titulo.ordenado.mais-vendido"); break;
//                }
                default: q = em.createNamedQuery("Midia.filtrar.titulo"); break;
            }
        }
        q.setParameter("param1", ("%"+titulo+"%").toLowerCase());
        
        return q.getResultList();
    }
}
