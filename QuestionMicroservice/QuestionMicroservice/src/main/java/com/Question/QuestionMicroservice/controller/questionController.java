package com.Question.QuestionMicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Question.QuestionMicroservice.model.entity.QuestionEntity;
import com.Question.QuestionMicroservice.model.request.QuestionRequest;
import com.Question.QuestionMicroservice.response.QuestionResponse;
import com.Question.QuestionMicroservice.service.QuestionService;

@RestController
@RequestMapping("/question")
public class questionController {

    @Autowired
    private QuestionService questionService;

   @PostMapping("/save")
    public ResponseEntity<QuestionResponse> saveQuestion(@RequestBody QuestionRequest request){

        QuestionResponse saveQuestions = questionService.saveQuestions(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveQuestions);

    }

    @GetMapping("/getQuestion/{id}")
    public ResponseEntity<QuestionResponse> getQuestion(@PathVariable("id") Long id){

        QuestionResponse response = questionService.getQuestion(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @GetMapping("/getQuiz/{quizId}")
    public ResponseEntity<List<QuestionResponse>> getQuestionByQuizId(@PathVariable Long quizId){

        List<QuestionResponse> response = questionService.getQuestionByQuizId(quizId);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



}
