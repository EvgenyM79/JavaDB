import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Passport.class)
public abstract class Passport_ {

	public static volatile SingularAttribute<Passport, Parents> parent;
	public static volatile SingularAttribute<Passport, String> ser_passport;
	public static volatile SingularAttribute<Passport, String> street;
	public static volatile SingularAttribute<Passport, Integer> n_building;
	public static volatile SingularAttribute<Passport, Integer> n_passport;
	public static volatile SingularAttribute<Passport, Integer> n_room;
	public static volatile SingularAttribute<Passport, AreaStreet> areaStreet;
	public static volatile SingularAttribute<Passport, Integer> street_id;
	public static volatile SingularAttribute<Passport, Integer> passport_id;

	public static final String PARENT = "parent";
	public static final String SER_PASSPORT = "ser_passport";
	public static final String STREET = "street";
	public static final String N_BUILDING = "n_building";
	public static final String N_PASSPORT = "n_passport";
	public static final String N_ROOM = "n_room";
	public static final String AREA_STREET = "areaStreet";
	public static final String STREET_ID = "street_id";
	public static final String PASSPORT_ID = "passport_id";

}

