package com.Quiz.QuizMicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Quiz.QuizMicroservice.model.entity.request.QuizRequest;
import com.Quiz.QuizMicroservice.model.response.QuizResponse;
import com.Quiz.QuizMicroservice.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {


    @Autowired
    private QuizService quizService;

    @PostMapping("/save")
    public ResponseEntity<QuizResponse> saveQuiz(@RequestBody QuizRequest quizRequest){

        QuizResponse saveQuiz = quizService.saveQuiz(quizRequest);
        return  ResponseEntity.status(HttpStatus.CREATED).body(saveQuiz);
    }


    @GetMapping("/getQuiz/{id}")
    public ResponseEntity<QuizResponse> getQuizByid(@PathVariable("id") Long id){
       QuizResponse quiz = quizService.getQuiz(id);
       return ResponseEntity.status(HttpStatus.OK).body(quiz);

    }
   /* {
        "title":"python programming"
    }
    *
    */




}
