package myapp.dispatchers;

import myapp.entity.Person;
import myapp.entity.Position;
import myapp.entity.Profile;
import myapp.entity.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*
            session.delete(tempPerson1);
            session.delete(tempPerson2);
            session.delete(tempPerson3);
            session.delete(tempPerson4);
            session.delete(tempPosition1);
            session.delete(tempPosition2);
            session.delete(tempPosition3);
*/

/*
            tempPerson1.addPosition(tempPosition2);
            tempPerson2.addPosition(tempPosition2);
            tempPerson3.addPosition(tempPosition1);
            tempPerson4.addPosition(tempPosition3);
*/


public class Dispatcher {
    public static void main(String[] args) {

        System.out.println(Dispatcher.class.getName());


        try (SessionFactory sessionFactory = new Configuration().
                configure("hibernate.cfg.xml").addAnnotatedClass(Person.class)
                .addAnnotatedClass(Position.class).addAnnotatedClass(Task.class).addAnnotatedClass(Profile.class).buildSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            System.out.println("Begin loading...");
            session.getTransaction().begin();
            Person tempPerson1 =  session.load(Person.class,1);
            Person tempPerson2 =  session.load(Person.class,2);
            Person tempPerson3 =  session.load(Person.class,3);
            Person tempPerson4 =  session.load(Person.class,4);
            Position tempPosition1 = session.load(Position.class,1);
            Position tempPosition2 = session.load(Position.class,2);
            Position tempPosition3 = session.load(Position.class,3);
            Task task1 = session.load (Task.class,1);
            Task task2 = session.load (Task.class,2);
            Task task3 = session.load (Task.class,3);
            Task task4 = session.load (Task.class,4);
            Task task5 = session.load (Task.class,5);

//            tempPerson1.getProfile().setAge(35);
            tempPerson2.setProfile(new Profile (25,"high school","Like to work"));
//            tempPerson3.setProfile(new Profile (19,"high school","Like to smoke"));
//            tempPerson4.setProfile(new Profile (42,"college","Playing football"));


            //Printing...
            System.out.println(tempPerson1);
            System.out.println(tempPerson2);
            System.out.println(tempPerson3);
            System.out.println(tempPerson4);

            session.getTransaction().commit();
            System.out.println("End loading...");
        }
        catch (Exception e) {
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }
}