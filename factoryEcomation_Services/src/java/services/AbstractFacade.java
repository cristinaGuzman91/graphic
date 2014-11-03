/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;


import entities.Sensorlist;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author cguzman
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }
    

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
        
    public List<T> getData(String nameQuery){
         Query query= getEntityManager().createNamedQuery(nameQuery);
         List<T> result = (List<T>) query.getResultList();
         return result;
     
    }
    public List<T> getData(String nameQuery, String parametro, Object obj){
         Query query= getEntityManager().createNamedQuery(nameQuery);
         
         query.setParameter(parametro, obj);
         List<T> result = (List<T>) query.getResultList();
         return result;
     
    }
    
     public List<T> getData(String nameQuery, String parametro1, Object obj1,  String parametro2, Object obj2){
         Query query= getEntityManager().createNamedQuery(nameQuery);
         
         query.setParameter(parametro1, obj1);
         query.setParameter(parametro2, obj2);
         List<T> result = (List<T>) query.getResultList();
         return result;
     
    }
    
}
