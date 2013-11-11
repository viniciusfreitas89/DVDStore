/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.services;

import br.mackenzie.dvdstore.dao.MidiaDAO;
import br.mackenzie.dvdstore.vo.MidiaVO;
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
    
    public MidiaVO procurar(Long id){
        MidiaDAO dao = new MidiaDAO(em);
        return (MidiaVO) dao.find(id);
    }
}
