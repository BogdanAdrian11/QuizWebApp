package com.fortech.training.QuizApp.dao;

import org.springframework.transaction.annotation.Transactional;

import com.fortech.training.QuizApp.entity.Question;

@Transactional
public interface QuestionRepository extends QuestionBaseRepository<Question>{

}
