/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import java.util.Optional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Tomas
 */
public class StaffDBTest {
    
    public StaffDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getall method, of class StaffDB.
     */
    
//    @Ignore
    @Test
    public void testGetall() {
        
        StaffDB instance = new StaffDB();
        int expResult = 1;
        List<Staff> list1 = instance.getall();
        
        Staff mystaff = new Staff(9999,"john.doe@exaple.com", "065 896523", "John Doe","021 895623",  "password", (short)0);
        instance.add(mystaff);
        List<Staff> list2 = instance.getall();
        instance.delete(mystaff);
        
        int result = list2.size() - list1.size();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getByID method, of class StaffDB.
     */
//    @Ignore
    @Test
    public void testGetByID() {
        
        int id = 9999;
        String name = "John Doe";
        StaffDB instance = new StaffDB();
        Staff mystaff = new Staff(id,"john.doe@exaple.com", "065 896523", name,"021 895623",  "password", (short)0);
        instance.add(mystaff);
        
        Optional<Staff> s = instance.getByID(id);
        Staff result = s.orElse(new Staff());
        instance.delete(mystaff);
        
        assertEquals(name, result.getFullName());
    }

    /**
     * Test of add method, of class StaffDB.
     */
//    @Ignore
    @Test
    public void testAdd() {
          StaffDB instance = new StaffDB();
        int expResult = 1;
        List<Staff> list1 = instance.getall();
        
        Staff mystaff = new Staff(9999,"john.doe@exaple.com", "065 896523", "John Doe","021 895623",  "password", (short)0);
        instance.add(mystaff);
        List<Staff> list2 = instance.getall();
        instance.delete(mystaff);
        
        int result = list2.size() - list1.size();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class StaffDB.
     */
//    @Ignore
    @Test
    public void testDelete() {
        StaffDB instance = new StaffDB();
        int expResult = 0;
        List<Staff> list1 = instance.getall();
        
        Staff mystaff = new Staff(9999,"john.doe@exaple.com", "065 896523", "John Doe","021 895623",  "password", (short)0);
        instance.add(mystaff);
        instance.delete(mystaff);
        
        List<Staff> list2 = instance.getall();      
        int result = list2.size() - list1.size();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of update method, of class StaffDB.
     */
//    @Ignore
    @Test
    public void testUpdate() {
       int id = 9999;
        String newName = "John Donovan";
        StaffDB instance = new StaffDB();
        Staff mystaff = new Staff(id,"john.doe@exaple.com", "065 896523", "John Doe","021 895623",  "password", (short)0);
        instance.add(mystaff);
        
        Optional<Staff> s = instance.getByID(id);
        Staff mystaff2 = s.orElse(new Staff());
        mystaff2.setFullName(newName);
        instance.update(mystaff2);
        
        Optional<Staff> s2 = instance.getByID(id);
        Staff result = s2.orElse(new Staff());
        
        instance.delete(mystaff);
        
        assertEquals(newName, result.getFullName());
    }

    /**
     * Test of getStaffByEmail method, of class StaffDB.
     */
//    @Ignore
    @Test
    public void testGetStaffByEmail() {
        int id = 9999;
        String email = "john.doe@exaple.com";
        StaffDB instance = new StaffDB();
        Staff mystaff = new Staff(id,email, "065 896523", "John Doe","021 895623",  "password", (short)0);
        instance.add(mystaff);
        
        Staff s = StaffDB.getStaffByEmail(email);
                
        instance.delete(mystaff);
        
        assertEquals(email, s.getEmail());
    }
    
}
