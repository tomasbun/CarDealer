package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.PreviousOwner;
import model.Sales;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-01T10:30:50")
@StaticMetamodel(Car.class)
public class Car_ { 

    public static volatile SingularAttribute<Car, Integer> buyPrice;
    public static volatile SingularAttribute<Car, Double> to62;
    public static volatile SingularAttribute<Car, Short> serviceHistory;
    public static volatile SingularAttribute<Car, Short> sold;
    public static volatile SingularAttribute<Car, String> note;
    public static volatile SingularAttribute<Car, Integer> odometer;
    public static volatile SingularAttribute<Car, String> year;
    public static volatile SingularAttribute<Car, Short> isofix;
    public static volatile SingularAttribute<Car, Integer> previousOwners;
    public static volatile SingularAttribute<Car, String> fuel;
    public static volatile SingularAttribute<Car, PreviousOwner> lastOwnerID;
    public static volatile SingularAttribute<Car, String> description;
    public static volatile SingularAttribute<Car, Integer> tax;
    public static volatile SingularAttribute<Car, String> body;
    public static volatile CollectionAttribute<Car, Sales> salesCollection;
    public static volatile SingularAttribute<Car, String> colour;
    public static volatile SingularAttribute<Car, Integer> listingNumber;
    public static volatile SingularAttribute<Car, Double> engine;
    public static volatile SingularAttribute<Car, String> transmision;
    public static volatile SingularAttribute<Car, String> model;
    public static volatile SingularAttribute<Car, String> carReg;
    public static volatile SingularAttribute<Car, String> make;
    public static volatile SingularAttribute<Car, Integer> listPrice;

}