package org.example;

import org.example.model.Address;
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

//        session.save(student);
//        transaction.commit();

        Address ad = Address.builder()
                .street("statestreet")
                .city("lamington")
                .isOpen(true)
                .x(123.23)
                .build();



//        session.save(ad);
        Address address = (Address) session.get(Address.class, 1L);
        Address address2 = (Address) session.get(Address.class, 2L);
        System.out.println(address);
        System.out.println(address2);
//        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}