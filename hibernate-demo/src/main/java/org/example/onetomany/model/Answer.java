package org.example.onetomany.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Answer {

    @Id
    private int answerId;

    private String answer;


    @ManyToOne()
    @JoinColumn(name = "question_id")
    private Question question;
}
