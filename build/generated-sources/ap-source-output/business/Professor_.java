package business;

import business.Section;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-24T01:16:14")
@StaticMetamodel(Professor.class)
public class Professor_ { 

    public static volatile SingularAttribute<Professor, String> profEmail;
    public static volatile SingularAttribute<Professor, String> profLname;
    public static volatile CollectionAttribute<Professor, Section> sectionCollection;
    public static volatile SingularAttribute<Professor, String> profId;
    public static volatile SingularAttribute<Professor, String> profFname;

}