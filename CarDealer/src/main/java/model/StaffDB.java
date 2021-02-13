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
public class StaffDB implements CarDealerRepository<Staff>{

    @Override
    public List<Staff> getall() {
        EntityManager em = DBUtil.getEMF().createEntityManager();
        
        TypedQuery<Staff> tq = em.createNamedQuery("Staff.findAll", Staff.class);
        List<Staff> list = null;
        
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
    public Optional<Staff> getByID(int id) {
        EntityManager em = DBUtil.getEMF().createEntityManager();       
        Optional<Staff> s = null;
        try{
            s = Optional.ofNullable(em.find(model.Staff.class, id));
        }catch (Exception ex){
            System.out.println(ex);
        }finally{
            em.close();
        }
        
        return s;
    }

    @Override
    public void add(Staff t) {
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
    public void delete(Staff t) {
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
    public void update(Staff t) {
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
    
    public static Staff getStaffByEmail(String email) {

        EntityManager em = DBUtil.getEMF().createEntityManager();
        Staff s = null;
        try {
            s = em.createNamedQuery("Staff.findByEmail", Staff.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.clear();
        }
        return s;
    }
    
    
}
