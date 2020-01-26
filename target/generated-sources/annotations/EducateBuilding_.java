import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EducateBuilding.class)
public abstract class EducateBuilding_ {

	public static volatile SingularAttribute<EducateBuilding, String> eb_name;
	public static volatile SingularAttribute<EducateBuilding, Integer> eb_n;
	public static volatile SetAttribute<EducateBuilding, Children> children;
	public static volatile SingularAttribute<EducateBuilding, AreaStreet> areaStreet;
	public static volatile SingularAttribute<EducateBuilding, String> eb_street;
	public static volatile SingularAttribute<EducateBuilding, Integer> ebuilding_id;

	public static final String EB_NAME = "eb_name";
	public static final String EB_N = "eb_n";
	public static final String CHILDREN = "children";
	public static final String AREA_STREET = "areaStreet";
	public static final String EB_STREET = "eb_street";
	public static final String EBUILDING_ID = "ebuilding_id";

}

