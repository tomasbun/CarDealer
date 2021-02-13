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
public class CarDBTest {
    
    public CarDBTest() {
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
     * Test of getall method, of class CarDB.
     */
      @Ignore
//    @Test
    public void testGetall() {
        CarDB instance = new CarDB();
        int expResult = 1;
        List<Car> list1 = instance.getall();
        
        Car myCar = new Car(123456, "carReg", "year", "make", 
            "model", "colour", 100000, "fuel", "transmision",
            "body", (short)0, 5, 2500, (short)1);
        
        instance.add(myCar);
        List<Car> list2 = instance.getall();
//        instance.delete(myCar);
        
        int result = list2.size() - list1.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getByID method, of class CarDB.
     */
        @Ignore
//    @Test
    public void testGetByID() {
        System.out.println("getByID");
        int id = 0;
        CarDB instance = new CarDB();
        Optional<Car> expResult = null;
        Optional<Car> result = instance.getByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class CarDB.
     */
       @Ignore
//    @Test
    public void testAdd() {
        System.out.println("add");
        Car t = null;
        CarDB instance = new CarDB();
        instance.add(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class CarDB.
     */
        @Ignore
//    @Test
    public void testDelete() {
        System.out.println("delete");
        Car t = null;
        CarDB instance = new CarDB();
        instance.delete(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class CarDB.
     */
    @Ignore
//    @Test
    public void testUpdate() {
        System.out.println("update");
        Car t = null;
        CarDB instance = new CarDB();
        instance.update(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCarsByBody method, of class CarDB.
     */
    @Ignore
//    @Test
    public void testGetCarsByBody() {
        System.out.println("getCarsByBody");
        String body = "";
        CarDB instance = new CarDB();
        List<Car> expResult = null;
        List<Car> result = instance.getCarsByBody(body);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCarsByMake method, of class CarDB.
     */
    @Ignore
//    @Test
    public void testGetCarsByMake() {
        System.out.println("getCarsByMake");
        String make = "";
        CarDB instance = new CarDB();
        List<Car> expResult = null;
        List<Car> result = instance.getCarsByMake(make);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCarsByYear method, of class CarDB.
     */
    @Ignore
//    @Test
    public void testGetCarsByYear() {
        System.out.println("getCarsByYear");
        String year = "";
        CarDB instance = new CarDB();
        List<Car> expResult = null;
        List<Car> result = instance.getCarsByYear(year);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCarsByPriceRange method, of class CarDB.
     */
    
    @Ignore
//    @Test
    public void testGetCarsByPriceRange() {
        System.out.println("getCarsByPriceRange");
        int min = 0;
        int max = 0;
        CarDB instance = new CarDB();
        List<Car> expResult = null;
        List<Car> result = instance.getCarsByPriceRange(min, max);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RefineSearch method, of class CarDB.
     */
    @Ignore
//    @Test    
    public void testRefineSearch() {
        System.out.println("RefineSearch");
        String make = "";
        String body = "";
        String year = "";
        int minPrice = 0;
        int maxPrice = 0;
        List<Car> expResult = null;
        List<Car> result = CarDB.RefineSearch(make, body, year, minPrice, maxPrice);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
