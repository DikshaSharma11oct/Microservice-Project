package com.Quiz.QuizMicroservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.Quiz.QuizMicroservice.model.response.QuestionResponse;


@FeignClient(value="QUESTION-MICROSERVICE",url="${QuestionService.api.url}")
// @FeignClient(value="QUESTION-MICROSERVICE")
public interface QuestionServiceClient {

    @GetMapping("/getQuestion/{id}")
    public ResponseEntity<QuestionResponse> getQuestion(@PathVariable("id") Long id);

    @GetMapping("/getQuiz/{quizId}")
    public ResponseEntity<QuestionResponse> getQuestionByQuizId(@PathVariable Long quizId);


}
