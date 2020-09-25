package business;

import business.Course;
import business.Holds;
import business.Semester;
import business.Students;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-24T01:16:14")
@StaticMetamodel(Transcript.class)
public class Transcript_ { 

    public static volatile SingularAttribute<Transcript, String> courseName;
    public static volatile SingularAttribute<Transcript, Semester> semId;
    public static volatile SingularAttribute<Transcript, Students> stuId;
    public static volatile SingularAttribute<Transcript, String> transId;
    public static volatile SingularAttribute<Transcript, Holds> holdId;
    public static volatile SingularAttribute<Transcript, Course> courseId;
    public static volatile SingularAttribute<Transcript, String> enrollGrade;

}