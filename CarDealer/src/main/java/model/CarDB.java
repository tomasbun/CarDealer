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
public class CarDB implements CarDealerRepository<Car>{

    @Override
    public List<Car> getall() {
        EntityManager em = DBUtil.getEMF().createEntityManager();
        
        TypedQuery<Car> tq = em.createNamedQuery("Car.findAll", Car.class);
        List<Car> list = null;
        
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
    public Optional<Car> getByID(int id) {
        EntityManager em = DBUtil.getEMF().createEntityManager();       
        Optional<Car> c = null;
        try{
            c = Optional.ofNullable(em.find(model.Car.class, id));
        }catch (Exception ex){
            System.out.println(ex);
        }finally{
            em.close();
        }
        
        return c;
    }

    @Override
    public void add(Car t) {
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
    public void delete(Car t) {
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
    public void update(Car t) {
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
    
    public List<Car> getCarsByBody (String body){
        EntityManager em = DBUtil.getEMF().createEntityManager();

        TypedQuery<Car> tq = em.createNamedQuery("Car.findByBody", Car.class);
        tq.setParameter("body", body);
        List<Car> list = null;
        try {
            list = tq.getResultList();
            if(list ==null|| list.isEmpty())
               list = null;
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }
        
        return list;
    }
    
    public List<Car> getCarsByMake (String make){
        EntityManager em = DBUtil.getEMF().createEntityManager();

        TypedQuery<Car> tq = em.createNamedQuery("Car.findByMake", Car.class);
        tq.setParameter("make", make);
        List<Car> list = null;
        try {
            list = tq.getResultList();
            if(list ==null|| list.isEmpty())
               list = null;
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }
        
        return list;
    }
    
    public List<Car> getCarsByYear (String year){
        EntityManager em = DBUtil.getEMF().createEntityManager();

        TypedQuery<Car> tq = em.createNamedQuery("Car.findByYear", Car.class);
        tq.setParameter("year", year);
        List<Car> list = null;
        try {
            list = tq.getResultList();
            if(list ==null|| list.isEmpty())
               list = null;
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }
        
        return list;
    }
    
    public List<Car> getCarsByPriceRange (int min, int max){
        EntityManager em = DBUtil.getEMF().createEntityManager();

        TypedQuery<Car> tq = em.createNamedQuery("Car.findByPriceRange", Car.class);
        tq.setParameter("minPrice", min);
        tq.setParameter("maxPrice", max);
        List<Car> list = null;
        try {
            list = tq.getResultList();
            if(list ==null|| list.isEmpty())
               list = null;
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }
        
        return list;
    }
    
    public static List<Car> RefineSearch(String make, String body,String year, int minPrice, int maxPrice) {
        EntityManager em = DBUtil.getEMF().createEntityManager();
        List<Car> list =null;
                    
        try {
            list = em.createNamedQuery("Car.findByMakeModelYearPrice")
                    .setParameter("body", body)
                    .setParameter("make", make)
                    .setParameter("year", year)
                    .setParameter("minPrice", minPrice)
                    .setParameter("maxPrice", maxPrice)
                    .getResultList();
            if (list == null || list.isEmpty()) {
                list = null;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.clear();
        }
        return list;
    }
    
}
