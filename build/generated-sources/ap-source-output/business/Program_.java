package business;

import business.Course;
import business.Students;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-24T01:16:14")
@StaticMetamodel(Program.class)
public class Program_ { 

    public static volatile SingularAttribute<Program, String> deptName;
    public static volatile CollectionAttribute<Program, Students> studentsCollection;
    public static volatile CollectionAttribute<Program, Course> courseCollection;
    public static volatile SingularAttribute<Program, String> progId;

}