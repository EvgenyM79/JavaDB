import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ebuilding")
//@SecondaryTable(name="areastreet")
public class EducateBuilding {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ebuilding_id;

    @Column(name = "eb_name", nullable = false, unique = true)
    private String eb_name;

    @Column(name = "eb_street", nullable = false)
    private String eb_street;

   /* @Column(table = "as_id")
    private int as_id;

    @Column(table = "areastreet")
    private String as_area;*/

    @Column(name = "eb_n", nullable = false)
    private int eb_n;

    @OneToMany (mappedBy = "eb_id", fetch = FetchType.LAZY)
    private Set<Children> children = new HashSet<>();

    public EducateBuilding(){}

    public EducateBuilding(String eb_name, String eb_street, int eb_n) {
        this.eb_name = eb_name;
        this.eb_street = eb_street;
        this.eb_n = eb_n;
    }

    public int getEb_id() {
        return ebuilding_id;
    }

    public void setEb_id(int ebuilding_id) {
        this.ebuilding_id = ebuilding_id;
    }

    public String getEb_name() {
        return eb_name;
    }

    public void setEb_name(String eb_name) {
        this.eb_name = eb_name;
    }

    public String getEb_street() {
        return eb_street;
    }

    public void setEb_street(String eb_street) {
        this.eb_street = eb_street;
    }

   /* public String getAs_area() {
        return as_area;
    }

    public void setAs_area(String as_area) {
        this.as_area = as_area;
    }*/

    public int getEb_n() {
        return eb_n;
    }

    public void setEb_n(int eb_n) {
        this.eb_n = eb_n;
    }

    public Set<Children> getChildren() {
        return children;
    }

    public void setChildren(Set<Children> children) {
        this.children = children;
    }

    @Override
    public String toString(){
        return "{" + ebuilding_id+ "} {" + eb_name + "} {" + eb_street + "} {" + eb_n + "}\n";
    }

}
