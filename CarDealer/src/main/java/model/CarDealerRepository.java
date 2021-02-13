/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Tomas
 */
public interface CarDealerRepository <T>{
    
    List<T> getall();
    
    Optional<T> getByID(int id);
    
    void add(T t);
    
    void delete (T t);
    
    void update (T t);
    
}
