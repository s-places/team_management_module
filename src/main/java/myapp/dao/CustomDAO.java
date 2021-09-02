package myapp.dao;

import myapp.entity.Person;
import myapp.entity.Position;
import myapp.entity.Profile;

import java.util.List;

public interface CustomDAO {
    List <Person> getListOfPersons();
    List <Position> getListOfPositions();
    public void addPerson (Person person);
    public void addProfile (Person person, Profile profile);
    public Position getPosition(int id);
    public Person getPerson (int id);
    public void deletePerson (int id);
}
