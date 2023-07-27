package org.example.onetomany.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    private int questionId;

    private String question;

    @OneToMany(mappedBy = "question")
    private List<Answer> answerList;
}
