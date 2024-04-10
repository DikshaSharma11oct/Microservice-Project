package com.Question.QuestionMicroservice.service;

import java.util.List;

import com.Question.QuestionMicroservice.model.entity.QuestionEntity;
import com.Question.QuestionMicroservice.model.request.QuestionRequest;
import com.Question.QuestionMicroservice.response.QuestionResponse;

public interface QuestionService {

    public QuestionResponse saveQuestions(QuestionRequest request);

    public QuestionResponse getQuestion(Long id);

    //to get quiz id
    // QuestionResponse getQuestionByQuizId(Long quizId);
    List<QuestionResponse> getQuestionByQuizId(Long quizId);


}
