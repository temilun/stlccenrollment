package business;

import business.Building;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-24T01:16:14")
@StaticMetamodel(Campus.class)
public class Campus_ { 

    public static volatile CollectionAttribute<Campus, Building> buildingCollection;
    public static volatile SingularAttribute<Campus, String> campId;
    public static volatile SingularAttribute<Campus, String> campName;

}