/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author Tomas
 */
public class SalesDB implements CarDealerRepository<Sales>{

    @Override
    public List<Sales> getall() {
        EntityManager em = DBUtil.getEMF().createEntityManager();
        
        TypedQuery<Sales> tq = em.createNamedQuery("Sales.findAll", Sales.class);
        List<Sales> list = null;
        
        try {
            list = tq.getResultList();
            if(list ==null|| list.isEmpty())
               list = null;
       
        }  finally {
            em.close();
        }
        return list;
    }

    @Override
    public Optional<Sales> getByID(int id) {
          EntityManager em = DBUtil.getEMF().createEntityManager();       
        Optional<Sales> s = null;
        try{
            s = Optional.ofNullable(em.find(model.Sales.class, id));
        }catch (Exception ex){
            System.out.println(ex);
        }finally{
            em.close();
        }
        
        return s;
    }

    @Override
    public void add(Sales t) {
        EntityManager em = DBUtil.getEMF().createEntityManager();
        EntityTransaction trans = em.getTransaction();
     
        try {
            trans.begin();
            em.persist(t);
            trans.commit();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
        finally {
         em.close();
        }  
    }

    @Override
    public void delete(Sales t) {
        EntityManager em = DBUtil.getEMF().createEntityManager();
        EntityTransaction trans = em.getTransaction();
     
        try {
            trans.begin();
            em.remove(em.merge(t));
            trans.commit();
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
        finally {
         em.close();
        }  
    }

    @Override
    public void update(Sales t) {
      EntityManager em = DBUtil.getEMF().createEntityManager();
        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.merge(t);
            trans.commit();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }
    }
    
}
