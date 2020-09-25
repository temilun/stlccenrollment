package business;

import business.Transcript;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-24T01:16:14")
@StaticMetamodel(Semester.class)
public class Semester_ { 

    public static volatile SingularAttribute<Semester, String> semId;
    public static volatile SingularAttribute<Semester, Date> semStart;
    public static volatile SingularAttribute<Semester, String> semYear;
    public static volatile SingularAttribute<Semester, String> semTerm;
    public static volatile SingularAttribute<Semester, Date> semEnd;
    public static volatile CollectionAttribute<Semester, Transcript> transcriptCollection;

}