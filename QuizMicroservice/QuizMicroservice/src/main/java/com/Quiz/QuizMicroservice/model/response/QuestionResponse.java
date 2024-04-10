package com.Quiz.QuizMicroservice.model.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponse {
    private Long questionId;
    private String questionName;
    private String questionTitle;
    private Long quizId;
    //private  List<QuizReponseList> quizReponseList ;

}
