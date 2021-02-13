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
public class CustomerDB implements CarDealerRepository<Customer>{

    @Override
    public List<Customer> getall() {
        EntityManager em = DBUtil.getEMF().createEntityManager();
        
        TypedQuery<Customer> tq = em.createNamedQuery("Customer.findAll", Customer.class);
        List<Customer> list = null;
        
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
    public Optional<Customer> getByID(int id) {
            EntityManager em = DBUtil.getEMF().createEntityManager();       
        Optional<Customer> c = null;
        try{
            c = Optional.ofNullable(em.find(model.Customer.class, id));
        }catch (Exception ex){
            System.out.println(ex);
        }finally{
            em.close();
        }
        
        return c;
    }

    @Override
    public void add(Customer t) {
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
    public void delete(Customer t) {
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
    public void update(Customer t) {
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
