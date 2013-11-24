/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.dao;

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
    public List<MidiaVO> filtrarPorTitulo(String titulo){
        Query q = em.createNamedQuery("Midia.filtrar.titulo");
        q.setParameter("titulo", "%"+titulo+"%");
        return q.getResultList();
    }
}
