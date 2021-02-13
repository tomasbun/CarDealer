package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Sales;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-01T10:30:50")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile CollectionAttribute<Customer, Sales> salesCollection;
    public static volatile SingularAttribute<Customer, String> address;
    public static volatile SingularAttribute<Customer, String> phone;
    public static volatile SingularAttribute<Customer, Integer> customerID;
    public static volatile SingularAttribute<Customer, String> fullname;

}