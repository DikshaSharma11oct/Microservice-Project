package com.Quiz.QuizMicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/quiz")
@Slf4j
public class QuizController {


    @Autowired
    private QuizService quizService;

    @PostMapping("/save")
    public ResponseEntity<QuizResponse> saveQuiz(@RequestBody QuizRequest quizRequest){

        QuizResponse saveQuiz = quizService.saveQuiz(quizRequest);
        return  ResponseEntity.status(HttpStatus.CREATED).body(saveQuiz);
    }


    @GetMapping("/getQuiz/{id}")
    @CircuitBreaker(name="QuizServiceBreak",fallbackMethod = "QuizServiceFallback")
    @Retry(name = "quizServiceRetry", fallbackMethod = "QuizServiceFallback")
    @RateLimiter(name = "quizServiceRatelimiter", fallbackMethod = "QuizServiceFallback")
    public ResponseEntity<QuizResponse> getQuizByid(@PathVariable("id") Long id){
       QuizResponse quiz = quizService.getQuiz(id);
       return ResponseEntity.status(HttpStatus.OK).body(quiz);

    }

    //create a fallbackmethod for quizService=>if question serive is not responding then quiz service will also not work
    //return type should be same
    public ResponseEntity<String> QuizServiceFallback(Long id,Exception exe){
        //fallabck is executed because service is down
        log.info("fallabck is executed beacuse service is down :", exe.getStackTrace());

        QuizResponse quizResponse = QuizResponse.builder().id(1L).title("quiz service is not responding").build();
        return ResponseEntity.status(HttpStatus.OK).body("Service is down for sometime!Thanks for having Patience");

    }








    /*
     * use circuit breaker with getmapping
     */
   /* {
        "title":"python programming"
    }
    *
    */




}
