package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        //Creating Configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Song.class);

        //To create data source initializing Session Factory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Session gives you a save method to save objects into the database
        Session session = sessionFactory.openSession();

        Song song1 = new Song();
        song1.setId(2);
        song1.setSongName("Beautiful");
        song1.setArtist("Akon");

        session.beginTransaction();
        session.save(song1);
        session.getTransaction().commit();
        System.out.println("Song saved successfully");
        session.close();

//        Session session1 = sessionFactory.openSession();
//        session1.beginTransaction();
//        session1.save(new Song(3, "Numb", "LP"));
//        session1.getTransaction().commit();
//        System.out.println("Song saved successfully");
//        session1.close();

    }
}
