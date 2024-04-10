package com.Quiz.QuizMicroservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Quiz.QuizMicroservice.model.entity.Quiz;


@Repository
public interface QuizRepository extends CrudRepository<Quiz,Long>{

}
