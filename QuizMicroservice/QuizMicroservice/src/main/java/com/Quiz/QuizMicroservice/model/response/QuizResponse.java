package com.Quiz.QuizMicroservice.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizResponse {

    private Long id;
    private String title;
    private QuestionResponse questionResponse;

}
