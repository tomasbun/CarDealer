package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Car;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-12-01T10:30:50")
@StaticMetamodel(PreviousOwner.class)
public class PreviousOwner_ { 

    public static volatile SingularAttribute<PreviousOwner, String> address;
    public static volatile SingularAttribute<PreviousOwner, String> phone;
    public static volatile CollectionAttribute<PreviousOwner, Car> carCollection;
    public static volatile SingularAttribute<PreviousOwner, String> fullName;
    public static volatile SingularAttribute<PreviousOwner, Integer> id;

}