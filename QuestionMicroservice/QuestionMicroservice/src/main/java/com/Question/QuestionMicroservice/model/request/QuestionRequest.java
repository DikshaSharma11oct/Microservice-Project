package com.Question.QuestionMicroservice.model.request;

import lombok.Data;

@Data
public class QuestionRequest {

    private Long questionId;
    private String questionName;
    private String questionTitle;
    private Long quizId;

}
