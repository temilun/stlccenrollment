package business;

import business.Campus;
import business.Room;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-24T01:16:14")
@StaticMetamodel(Building.class)
public class Building_ { 

    public static volatile SingularAttribute<Building, String> buildName;
    public static volatile SingularAttribute<Building, Campus> campId;
    public static volatile CollectionAttribute<Building, Room> roomCollection;
    public static volatile SingularAttribute<Building, String> buildId;

}