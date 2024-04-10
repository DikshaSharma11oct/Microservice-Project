package com.Quiz.QuizMicroservice.service;

import com.Quiz.QuizMicroservice.model.entity.request.QuizRequest;
import com.Quiz.QuizMicroservice.model.response.QuizResponse;

public interface QuizService {

    public QuizResponse saveQuiz(QuizRequest quizRequest);
    public QuizResponse getQuiz(Long id);


}
