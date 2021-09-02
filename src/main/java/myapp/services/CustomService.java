package myapp.services;

import myapp.entity.Person;
import myapp.entity.Position;
import myapp.entity.Profile;

import java.util.List;

public interface CustomService {
    public List <Person> getListOfPersons();
    public List <Position> getListOfPositions();
    public void addPerson(Person person);
    public Position getPosition(int id);
    public Person getPerson(int id);
    public void deletePerson (int id);
    public void addProfile(Person person, Profile profile);
}
