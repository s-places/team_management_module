package myapp.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "persons")
public class Person {

    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column (name="person_id")
    private int id;

    @OneToOne (cascade = {CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn (name="position_id")
    private Position position;

    @NotNull(message="is require")
    @Size(min = 1,max=25,message="incorrect size")
    @Pattern(regexp = "[a-zA-Z]+",message="incorrect input")
    @Column (name="first_name")
    private String firstName;

    @NotNull (message="is require")
    @Size (min = 1,max=25,message="incorrect size")
    @Pattern(regexp = "[a-zA-Z]+",message="incorrect input")
    @Column (name="last_name")
    private String lastName;



    transient private String tempPosition;

    public String getTempPosition() {
        return tempPosition;
    }

    public void setTempPosition(String tempPosition) {
        this.tempPosition = tempPosition;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person() {
    }

    public Person(Profile profile) {
        this.profile = profile;
    }

    public Person(Position position) {
        this.position = position;
    }





public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }


    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }



    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }



    @Override
    public String toString() {
        return "First Name='" + firstName + '\'' +
                ", Last Name='" + lastName + '\'' +
                " Profile=" + this.getProfile() + " " + this.getPosition();
    }
}



