import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "areastreet")
public class AreaStreet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int as_id;

    @Column(name = "street", nullable = false, unique = true)
    private String street;

    @Column(name = "as_area", nullable = false)
    private String as_area;


    @OneToMany (mappedBy = "street_id", fetch = FetchType.LAZY)
    private Set<Passport> passport = new HashSet<>();

    public AreaStreet() {
    }

    public AreaStreet(String street, String as_area) {
        this.street = street;
        this.as_area = as_area;
    }

    public int getAs_id() {
        return as_id;
    }

    public void setAs_id(int as_id) {
        this.as_id = as_id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAs_area() {
        return as_area;
    }

    public void setAs_area(String as_area) {
        this.as_area = as_area;
    }

    public Set<Passport> getPassport() {
        return passport;
    }

    public void setPassports(Set<Passport> passport) {
        this.passport = passport;
    }

    @Override
    public String toString(){
        return "{" + as_id + "} {" + street + "} {" + as_area + "}\n";
    }
}
