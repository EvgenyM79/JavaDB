import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Children.class)
public abstract class Children_ {

	public static volatile SingularAttribute<Children, Integer> eb_id;
	public static volatile SingularAttribute<Children, EducateBuilding> educateBuilding;
	public static volatile SingularAttribute<Children, Integer> child_id;
	public static volatile SingularAttribute<Children, String> last_name;
	public static volatile SingularAttribute<Children, String> first_name;
	public static volatile SingularAttribute<Children, Integer> age;
	public static volatile ListAttribute<Children, Parents> parents;

	public static final String EB_ID = "eb_id";
	public static final String EDUCATE_BUILDING = "educateBuilding";
	public static final String CHILD_ID = "child_id";
	public static final String LAST_NAME = "last_name";
	public static final String FIRST_NAME = "first_name";
	public static final String AGE = "age";
	public static final String PARENTS = "parents";

}

