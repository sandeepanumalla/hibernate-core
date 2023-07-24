package org.example;

import org.example.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        System.out.println("project created!");
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

        System.out.println(sessionFactory.getCurrentSession());

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student student = Student.builder()
                .name("Sandeep")
                .address("Mumbai")
                .build();

        session.save(student);
        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}