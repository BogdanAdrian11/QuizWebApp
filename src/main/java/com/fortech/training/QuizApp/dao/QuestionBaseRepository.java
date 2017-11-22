package com.fortech.training.QuizApp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.fortech.training.QuizApp.entity.Question;

@NoRepositoryBean
public interface QuestionBaseRepository<T extends Question> extends CrudRepository<T, Integer> {

}
