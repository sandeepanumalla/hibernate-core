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

        // Create the SessionFactory (only do this once in your application)
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        // Create a new session
        Session session = sessionFactory.openSession();

        // Begin the transaction
        Transaction transaction = session.beginTransaction();

        // Create a new Question
        Question q1 = Question.builder()
                .questionId(1)
                .question("What is java?")
                .build();

        // Create new Answer objects
        Answer a1 = Answer.builder()
                .answerId(235)
                .answer("Java is a programming language.")
                .question(q1)
                .build();

        Answer a2 = Answer.builder()
                .answerId(12)
                .answer("Java is used in Enterprise software development")
                .question(q1)
                .build();

        Answer a3 = Answer.builder()
                .answerId(1223)
                .answer("Java is an Object-oriented language")
                .question(q1)
                .build();

        // Create a list to hold the answers
        List<Answer> answers = new ArrayList<>();
        answers.add(a1);
        answers.add(a2);
        answers.add(a3);

        // Set the list of answers for the question
        q1.setAnswerList(answers);

        // Save the Question object, which cascades the save operation to the associated Answer objects
        session.save(q1);

        // Commit the transaction
        transaction.commit();

        // Close the session and the SessionFactory
        session.close();
        sessionFactory.close();
    }
}
