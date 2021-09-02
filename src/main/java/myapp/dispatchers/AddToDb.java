package myapp.dispatchers;

import myapp.entity.Person;
import myapp.entity.Position;
import myapp.entity.Profile;
import myapp.entity.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddToDb {
    public static void main(String[] args) {
        Person person1 = new Person ("John","Black");
        Person person2 = new Person ("Jane","Doe");
        Person person3 = new Person ("Robert","Smith");
        Person person4 = new Person ("Mike","Master");
        Position position1 = new Position ("Manager", 1000);
        Position position2 = new Position ("Seller", 500);
        Position position3 = new Position ("Guard", 500);
        Task task1 = new Task ("Sell goods");
        Task task2 = new Task ("Clean workspace");
        Task task3 = new Task ("Watch the security");
        Task task4 = new Task ("Make reports");
        Task task5 = new Task ("Manage the personal");


        try (SessionFactory sessionFactory = new Configuration().
                configure("myapp/mysql/hibernate.cfg.xml").addAnnotatedClass(Person.class).addAnnotatedClass(Profile.class).addAnnotatedClass(Profile.class)
                .addAnnotatedClass(Position.class).addAnnotatedClass(Task.class).buildSessionFactory();
             Session session = sessionFactory.getCurrentSession();)
       {
          session.save(person1);
          session.save(person2);
          session.save(person3);
          session.save(person4);
//          session.save(position1);
//          session.save(position2);
//          session.save(position3);
//           session.save(task1);
//           session.save(task2);
//           session.save(task3);
//           session.save(task4);
//           session.save(task5);


          session.getTransaction().commit();


        }

        catch (Exception e) {
            System.out.println(e.getCause());
            e.printStackTrace();
        }

    }
}
