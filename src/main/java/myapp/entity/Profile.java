package myapp.entity;
import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table (name="profiles")
public class Profile {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="profile_id")
    private int person_id;

    
    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    @NotNull(message="is require")
    @Min(value=1, message="wrong age")
    @Max(value=99, message="wrong age")
    @Column (name="age")
    @Pattern(regexp="[0-9]+",message="incorrect input")
    private int age;


    @NotNull(message="is require")
    @Column (name="education")
    private String education;

    @NotNull(message="is require")
    @Size(min = 1,max=25,message="incorrect size")
    @Pattern(regexp = "[a-zA-Z\\s]+",message="incorrect input")
    @Column (name="other")
    private String other;

    transient private String tempPerson;

    public String getTempPerson() {
        return tempPerson;
    }

    public void setTempPerson(String tempPerson) {
        this.tempPerson = tempPerson;
    }

    public Profile() {
    }

    public Profile(int age, String education, String other) {
        this.age = age;
        this.education = education;
        this.other = other;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return
                "age=" + age +
                ", education='" + education + '\'' +
                ", other='" + other + '\'';
    }
}
