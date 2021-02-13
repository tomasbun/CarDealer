package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Sales;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-01T10:30:50")
@StaticMetamodel(Staff.class)
public class Staff_ { 

    public static volatile CollectionAttribute<Staff, Sales> salesCollection;
    public static volatile SingularAttribute<Staff, String> password;
    public static volatile SingularAttribute<Staff, String> phone;
    public static volatile SingularAttribute<Staff, String> fullName;
    public static volatile SingularAttribute<Staff, Short> admin;
    public static volatile SingularAttribute<Staff, String> fax;
    public static volatile SingularAttribute<Staff, Integer> staffID;
    public static volatile SingularAttribute<Staff, String> email;

}