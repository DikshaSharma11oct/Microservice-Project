package com.Question.QuestionMicroservice.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Question.QuestionMicroservice.model.entity.QuestionEntity;
import com.Question.QuestionMicroservice.model.request.QuestionRequest;
import com.Question.QuestionMicroservice.repository.QuestionRepository;
import com.Question.QuestionMicroservice.response.QuestionResponse;
import com.Question.QuestionMicroservice.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    QuestionRepository questionRepo;


    @Override
    public QuestionResponse saveQuestions(QuestionRequest request) {
        // QuestionEntity entity = null; can't define otherwise entity set will be as null
        QuestionEntity entity = new QuestionEntity();

        entity.setQuestionId(request.getQuestionId());
        entity.setQuestionName(request.getQuestionName());
        entity.setQuestionTitle(request.getQuestionTitle());
        entity.setQuizId(request.getQuizId());


        QuestionEntity savedEntity = questionRepo.save(entity);
        QuestionResponse response = savedEntity.getASObjects();

        return response;

    }

    @Override
    public QuestionResponse getQuestion(Long id) {

        QuestionEntity questionEntity = questionRepo.findById(id).get();
        QuestionResponse response = questionEntity.getASObjects();

        return response;


    }

    @Override
    public List<QuestionResponse>  getQuestionByQuizId(Long quizId) {
        QuestionResponse response=null;
        List<QuestionResponse> responseList = new ArrayList<>();
        List<QuestionEntity> quizList = questionRepo.findByQuizId(quizId);


        for(QuestionEntity quiz:quizList){
            response = quiz.getASObjects();
            responseList.add(response);

        }
        return responseList;
    }

}
