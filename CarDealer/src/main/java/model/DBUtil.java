/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Tomas
 */
public class DBUtil {
    private static final EntityManagerFactory EMF = 
        Persistence.createEntityManagerFactory("com.mycompany_Assignment2_war_1.0-SNAPSHOTPU");
                                                
    public static EntityManagerFactory getEMF() {
        return EMF; }
}
