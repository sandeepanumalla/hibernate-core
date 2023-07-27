package org.example.map;

import org.example.model.Answer;
import org.example.model.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Example {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().
                configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = factory.openSession();

        Question q1 = Question.builder()
                .questionId(1212L)
                .question("what is java ?")
                .build();

        Answer answer = Answer.builder()
                .id(343)
                .answer("Java is programming Language")
                .build();


        session.save(q1);

        session.close();
        factory.close();
    }
}
