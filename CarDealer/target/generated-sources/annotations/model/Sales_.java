package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Car;
import model.Customer;
import model.Staff;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-01T10:30:50")
@StaticMetamodel(Sales.class)
public class Sales_ { 

    public static volatile SingularAttribute<Sales, Integer> tradeinValue;
    public static volatile SingularAttribute<Sales, Integer> salesID;
    public static volatile SingularAttribute<Sales, Integer> amountPaid;
    public static volatile SingularAttribute<Sales, Car> listingNumber;
    public static volatile SingularAttribute<Sales, String> tradein;
    public static volatile SingularAttribute<Sales, Customer> customerID;
    public static volatile SingularAttribute<Sales, Staff> staffID;

}