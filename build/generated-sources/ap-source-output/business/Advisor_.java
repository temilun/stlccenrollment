package business;

import business.Students;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-24T01:16:14")
@StaticMetamodel(Advisor.class)
public class Advisor_ { 

    public static volatile SingularAttribute<Advisor, String> advFname;
    public static volatile SingularAttribute<Advisor, String> advEmail;
    public static volatile CollectionAttribute<Advisor, Students> studentsCollection;
    public static volatile SingularAttribute<Advisor, Integer> advId;
    public static volatile SingularAttribute<Advisor, String> advLname;
    public static volatile SingularAttribute<Advisor, Integer> advPhone;

}