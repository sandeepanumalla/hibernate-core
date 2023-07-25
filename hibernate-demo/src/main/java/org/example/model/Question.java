package org.example.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Question {

    @Id
    @Column(name = "question_id")
    private long questionId;

    private String question;

    @OneToOne
    private Answer answer;

}
