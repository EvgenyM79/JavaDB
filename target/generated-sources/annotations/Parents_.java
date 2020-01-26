import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Parents.class)
public abstract class Parents_ {

	public static volatile SingularAttribute<Parents, Passport> passport;
	public static volatile SetAttribute<Parents, Children> children;
	public static volatile SingularAttribute<Parents, Integer> parent_id;
	public static volatile SingularAttribute<Parents, String> last_name;
	public static volatile SingularAttribute<Parents, String> first_name;
	public static volatile SingularAttribute<Parents, Integer> age;

	public static final String PASSPORT = "passport";
	public static final String CHILDREN = "children";
	public static final String PARENT_ID = "parent_id";
	public static final String LAST_NAME = "last_name";
	public static final String FIRST_NAME = "first_name";
	public static final String AGE = "age";

}

