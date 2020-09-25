package business;

import business.Program;
import business.Transcript;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-24T01:16:14")
@StaticMetamodel(Course.class)
public class Course_ { 

    public static volatile SingularAttribute<Course, String> courseName;
    public static volatile SingularAttribute<Course, String> courseLevel;
    public static volatile SingularAttribute<Course, String> courseDesc;
    public static volatile SingularAttribute<Course, Integer> courseCredit;
    public static volatile SingularAttribute<Course, Program> progId;
    public static volatile SingularAttribute<Course, String> courseId;
    public static volatile CollectionAttribute<Course, Transcript> transcriptCollection;

}