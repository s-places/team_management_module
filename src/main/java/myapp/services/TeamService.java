package myapp.services;

import myapp.dao.CustomDAO;
import myapp.entity.Person;
import myapp.entity.Position;
import myapp.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamService implements CustomService {

    @Autowired
    CustomDAO customDAO;


    @Transactional
    @Override
    public List<Person> getListOfPersons() {
       return customDAO.getListOfPersons();
    }

    @Transactional
    @Override
    public List<Position> getListOfPositions() {
        return customDAO.getListOfPositions();
    }


    @Transactional
    @Override
    public void addPerson(Person person) {
        customDAO.addPerson(person);
    }

    @Transactional
    @Override
    public void addProfile(Person person, Profile profile) {
        customDAO.addProfile(person, profile);
    }

    @Transactional
    @Override
    public Position getPosition(int id) {
        return customDAO.getPosition(id);
    }

    @Transactional
    @Override
    public Person getPerson(int id) {
        return customDAO.getPerson(id);
    }

    @Transactional
    @Override
    public void deletePerson(int id) {
        customDAO.deletePerson(id);
    }
}
