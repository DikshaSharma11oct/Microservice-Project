package com.Question.QuestionMicroservice.model.entity;

import java.util.ArrayList;
import java.util.List;

import com.Question.QuestionMicroservice.response.QuestionResponse;
import com.Question.QuestionMicroservice.response.QuestionResponse.QuestionResponseBuilder;
import com.Question.QuestionMicroservice.response.QuestionResponseList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="question_table")
@Data
public class QuestionEntity {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long questionId;
    private String questionName;
    private String questionTitle;
    private Long quizId;

    // public QuestionResponse getASObject(){

    // QuestionResponseBuilder builder =QuestionResponse.builder()
    //                                             .questionId(this.questionId)
    //                                             .questionName(this.questionName)
    //                                             .questionTitle(this.questionTitle)
    //                                             .quizId(this.quizId);
    // return builder.build();

    // }

    public QuestionResponse getASObjects(){
        // Create a list and add QuizReponseList instances to it
        List<QuestionResponse> quizReponseList = new ArrayList<>();
        QuestionResponseList quizResponse = QuestionResponseList.builder()
                                                .questionId(this.questionId)
                                                .questionName(this.questionName)
                                                .questionTitle(this.questionTitle)
                                                .build();


        QuestionResponse builder =QuestionResponse.builder()
                                                    .quizId(this.quizId)
                                                    .questionResponseList(quizResponse)
                                                    .build();
        quizReponseList.add(builder);
        return builder;

    }



}


