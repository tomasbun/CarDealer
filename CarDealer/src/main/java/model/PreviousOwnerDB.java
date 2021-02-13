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
public class PreviousOwnerDB implements CarDealerRepository<PreviousOwner>{

    @Override
    public List<PreviousOwner> getall() {
        EntityManager em = DBUtil.getEMF().createEntityManager();
        
        TypedQuery<PreviousOwner> tq = em.createNamedQuery("PreviousOwner.findAll", PreviousOwner.class);
        List<PreviousOwner> list = null;
        
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
    public Optional<PreviousOwner> getByID(int id) {
        EntityManager em = DBUtil.getEMF().createEntityManager();       
        Optional<PreviousOwner> po = null;
        try{
            po = Optional.ofNullable(em.find(model.PreviousOwner.class, id));
        }catch (Exception ex){
            System.out.println(ex);
        }finally{
            em.close();
        }
        
        return po;
    }

    @Override
    public void add(PreviousOwner t) {
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
    public void delete(PreviousOwner t) {
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
    public void update(PreviousOwner t) {
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
