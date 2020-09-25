package business;

import business.Transcript;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-24T01:16:14")
@StaticMetamodel(Holds.class)
public class Holds_ { 

    public static volatile SingularAttribute<Holds, String> holdDesc;
    public static volatile SingularAttribute<Holds, String> holdId;
    public static volatile CollectionAttribute<Holds, Transcript> transcriptCollection;

}