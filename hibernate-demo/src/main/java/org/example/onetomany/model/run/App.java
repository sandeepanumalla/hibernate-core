package org.example.onetomany.model.run;


import org.example.onetomany.model.Answer;
import org.example.onetomany.model.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.*;

public class App {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();


        Answer a1 = Answer.builder()
                .answerId(235)
                .answer("Java is a programming language.")
                .build();

        Answer a2 = Answer.builder()
                .answerId(12)
                .answer("Java is used in Enterprise software development")
                .build();

        Answer a3 = Answer.builder()
                .answerId(1223)
                .answer("Java is an Object oriented language")
                .build();

        List<Answer> answers = new ArrayList<>();

        answers.add(a1);
        answers.add(a2);
        answers.add(a3);

        Question q1 = Question.builder()
                .questionId(1)
                .question("What is java?")
                .answerList(answers)
                .build();

        session.save(a1);
        session.save(a2);
        session.save(a3);
        session.save(q1);

        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}
