import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AreaStreet.class)
public abstract class AreaStreet_ {

	public static volatile SingularAttribute<AreaStreet, Integer> as_id;
	public static volatile SetAttribute<AreaStreet, Passport> passport;
	public static volatile SingularAttribute<AreaStreet, String> street;
	public static volatile SingularAttribute<AreaStreet, String> as_area;

	public static final String AS_ID = "as_id";
	public static final String PASSPORT = "passport";
	public static final String STREET = "street";
	public static final String AS_AREA = "as_area";

}

