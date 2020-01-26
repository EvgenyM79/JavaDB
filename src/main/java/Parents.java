import org.dom4j.tree.AbstractEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "parents")

public class Parents implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int parent_id;

    @Column(name = "first_name", nullable = false)
    private String first_name;

    @Column(name = "last_Name", nullable = false)
    private String last_name;

    @Column(name = "age", nullable = false)
    private int age;

    @ManyToMany(cascade = { CascadeType.ALL})
    @JoinTable(name = "parents_has_children",
            joinColumns = { @JoinColumn(name = "idParent") },
            inverseJoinColumns = { @JoinColumn(name = "idChild") })
    private Set<Children> children = new HashSet<>();

    @OneToOne
    @JoinColumn(name = "passport_id", nullable = false)
    private Passport passport;

    public Parents(String first_name, String last_name, Integer age) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
    }

    public Parents(){};

    public int getId() {
        return parent_id;
    }

    public void setId(int id) {
        this.parent_id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastname) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //public Set<Children> getChild() {
    public Set<Children> getChildren() {
        return children;
    }
    //public void setChild(Set<Children> children ) {
    public void setChild(Set<Children> children ) {
        this.children = children;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public String toString(){
        return "{" + parent_id + "} {" + first_name + "} {" + last_name + "} {" + age + "}\n";
    }
}