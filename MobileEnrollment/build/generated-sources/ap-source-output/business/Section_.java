package business;

import business.Professor;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-24T01:16:14")
@StaticMetamodel(Section.class)
public class Section_ { 

    public static volatile SingularAttribute<Section, String> enrollAvail;
    public static volatile SingularAttribute<Section, String> enrollTot;
    public static volatile SingularAttribute<Section, String> termType;
    public static volatile SingularAttribute<Section, String> days;
    public static volatile SingularAttribute<Section, String> secType;
    public static volatile SingularAttribute<Section, Date> time;
    public static volatile SingularAttribute<Section, Professor> profId;
    public static volatile SingularAttribute<Section, String> crn;
    public static volatile SingularAttribute<Section, String> status;
    public static volatile SingularAttribute<Section, String> prereq;

}