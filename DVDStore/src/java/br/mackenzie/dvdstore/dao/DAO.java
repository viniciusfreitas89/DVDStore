/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.mackenzie.dvdstore.dao;

import br.mackenzie.dvdstore.dao.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author 71306552
 */
public class DAO <T> implements Serializable {
    private EntityManager em = null;
    private Class type = null;
    
    public DAO(Class type, EntityManager emf) {
        this.type = type;
        this.em = emf;
    }

    public void create(T t) {
        em.persist(t);
    }

    public void update(T t) {
        t = em.merge(t);
    }

    public void delete(Long id) throws NonexistentEntityException{
        T t;
        try {
            t = (T) em.getReference(type, id);
        } catch (EntityNotFoundException enfe) {
            throw new NonexistentEntityException("O objeto com o id: " + id + " não existe.", enfe);
        }
        em.remove(t);
    }
    
    public void delete(T t){
        em.remove(t);
    }
    
    public List<T> findAll() {
        return findAll(true, -1, -1);
    }

    public List<T> findAll(int maxResults, int firstResult) {
        return findAll(false, maxResults, firstResult);
    }

    private List<T> findAll(boolean all, int maxResults, int firstResult) {
        try{
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(type));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }

    public T find(Long id) {
        return (T) em.find(type, id);
    }

    public int getCount() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<T> rt = cq.from(type);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
    public void close(){
         em.close();
    }
}
