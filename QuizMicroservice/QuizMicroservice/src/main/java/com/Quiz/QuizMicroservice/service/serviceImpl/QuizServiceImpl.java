package com.Quiz.QuizMicroservice.service.serviceImpl;

import java.util.Optional;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Quiz.QuizMicroservice.client.QuestionServiceClient;
import com.Quiz.QuizMicroservice.model.entity.Quiz;
import com.Quiz.QuizMicroservice.model.entity.request.QuizRequest;
import com.Quiz.QuizMicroservice.model.response.QuestionResponse;
import com.Quiz.QuizMicroservice.model.response.QuizResponse;
import com.Quiz.QuizMicroservice.repository.QuizRepository;
import com.Quiz.QuizMicroservice.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService{

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionServiceClient client;

    @Override
    public QuizResponse saveQuiz(QuizRequest quizRequest) {

        Quiz QuizEntity =new Quiz();

        QuizResponse quizResponse = new QuizResponse();
        QuizEntity.setId(quizRequest.getId());
        QuizEntity.setTitle(quizRequest.getTitle());
        //save entity in db
        Quiz saveEntity = quizRepository.save(QuizEntity);

        quizResponse.setId(saveEntity.getId());
        quizResponse.setTitle(saveEntity.getTitle());
        //return response
        return quizResponse;

    }

    @Override
    public QuizResponse getQuiz(Long id) {
        QuizResponse quizResponse = new QuizResponse();

        Quiz quiz = quizRepository.findById(id).get();

        quizResponse.setId(quiz.getId());
        quizResponse.setTitle(quiz.getTitle());

        ResponseEntity<QuestionResponse> question = client.getQuestionByQuizId(quiz.getId());
        quizResponse.setQuestionResponse(question.getBody());

        return quizResponse;

    }

}
