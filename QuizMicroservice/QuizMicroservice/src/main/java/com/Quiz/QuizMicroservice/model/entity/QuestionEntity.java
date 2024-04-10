package com.Quiz.QuizMicroservice.model.entity;

import lombok.Data;


@Data
public class QuestionEntity {

    private Long questionId;
    private String questionName;
    private String questionTitle;
    private Long quizId;


}



