package myapp.dao;

import myapp.entity.Person;
import myapp.entity.Position;
import myapp.entity.Profile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TeamDAO implements CustomDAO {


    private SessionFactory sessionFactory;

    @Autowired
    private void setSessionFactory (SessionFactory sessionFactory) {
        this.sessionFactory=sessionFactory;
    }

    @Override
    public List<Person> getListOfPersons() {
        Session session = sessionFactory.openSession();
        List<Person> listOfPersons =
                session.createQuery("from Person", Person.class).getResultList();
        return listOfPersons;

    }

    @Override
    public List<Position> getListOfPositions() {
        Session session = sessionFactory.openSession();
        List <Position> listOfPositions = session.createQuery("from Position", Position.class)
                .getResultStream().collect(Collectors.toList());
        return listOfPositions;
    }

    @Override
    public void addPerson(Person person) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(person);
    }

    @Override
    public void addProfile(Person person, Profile profile) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        System.out.println(profile + "Profile ID...." + profile.getPerson_id());
        System.out.println("Before..." + person + " Person ID " + person.getId());
        Integer id = person.getId();
        Person tempPerson = session.load(Person.class,id);
        session.saveOrUpdate (profile);
        tempPerson.setProfile(profile);
        System.err.println("After..."+ tempPerson + " Person ID..." + tempPerson.getId() + " Profile ID " + profile.getPerson_id());
        session.getTransaction().commit();
    }
    @Transactional
    @Override
    public Position getPosition(int id) {
        return sessionFactory.openSession().get (Position.class, id);
    }
    @Transactional
    @Override
    public Person getPerson(int id) {
        return sessionFactory.openSession().get (Person.class, id);
    }

    @Override
    public void deletePerson(int id) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        var tempPerson = session.get(Person.class,id);
        session.delete(tempPerson);
        session.getTransaction().commit();
    }
}
