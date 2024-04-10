package com.Question.QuestionMicroservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Question.QuestionMicroservice.model.entity.QuestionEntity;
import java.util.List;


@Repository
public interface QuestionRepository  extends CrudRepository<QuestionEntity,Long>{

    List<QuestionEntity> findByQuizId(Long quizId);

}
