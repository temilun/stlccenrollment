package business;

import business.Advisor;
import business.Program;
import business.Transcript;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-24T01:16:14")
@StaticMetamodel(Students.class)
public class Students_ { 

    public static volatile SingularAttribute<Students, String> stuLname;
    public static volatile SingularAttribute<Students, Date> birthdate;
    public static volatile SingularAttribute<Students, String> address;
    public static volatile SingularAttribute<Students, String> stuId;
    public static volatile SingularAttribute<Students, String> city;
    public static volatile SingularAttribute<Students, String> stuEmail;
    public static volatile SingularAttribute<Students, Advisor> advId;
    public static volatile SingularAttribute<Students, Program> progId;
    public static volatile CollectionAttribute<Students, Transcript> transcriptCollection;
    public static volatile SingularAttribute<Students, Integer> zipcode;
    public static volatile SingularAttribute<Students, String> password;
    public static volatile SingularAttribute<Students, String> stuFname;
    public static volatile SingularAttribute<Students, Character> stuInitial;
    public static volatile SingularAttribute<Students, Integer> phone;
    public static volatile SingularAttribute<Students, String> state;
    public static volatile SingularAttribute<Students, String> username;

}