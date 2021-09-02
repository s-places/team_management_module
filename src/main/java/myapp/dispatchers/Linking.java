package myapp.dispatchers;

import myapp.entity.Person;
import myapp.entity.Position;
import myapp.entity.Profile;
import myapp.entity.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Linking {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = new Configuration().
                configure("myapp/mysql/hibernate.cfg.xml").addAnnotatedClass(Person.class)
                .addAnnotatedClass(Position.class).addAnnotatedClass(Task.class).addAnnotatedClass(Profile.class).buildSessionFactory();
             Session session = sessionFactory.getCurrentSession();)
        {

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



            //Set positions....
//            tempPerson1.setPosition(tempPosition1);
//            tempPerson2.setPosition(tempPosition2);
//            tempPerson3.setPosition(tempPosition2);
//            tempPerson4.setPosition(tempPosition3);

//            tempPosition1.addTask(task4);
//            tempPosition1.addTask(task5);
//            tempPosition2.addTask(task1);
//            tempPosition2.addTask(task2);
//            tempPosition3.addTask(task4);
//            tempPosition3.addTask(task3);


//            System.out.println(tempPerson1+ " "+ tempPerson1.getPosition().getTasksSet());
//            System.out.println(tempPerson1+ " "+ tempPerson1.getPosition().getTasksSet());
//            System.out.println(tempPerson1+ " "+ tempPerson1.getPosition().getTasksSet());


            //            System.out.println(tempPosition1 + "\n" + tempPosition2 + "\n"   + tempPosition3);
//            System.out.println(task1 + "\n" + task2 + "\n"  + task3 + "\n"  + task4 + "\n"  + task5);



            session.getTransaction().commit();
            System.out.println("End loading...");


        }

        catch (Exception e) {
            System.out.println(e.getCause());
            e.printStackTrace();
        }

    }
}
