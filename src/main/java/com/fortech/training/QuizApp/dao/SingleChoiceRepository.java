package com.fortech.training.QuizApp.dao;

import org.springframework.transaction.annotation.Transactional;

import com.fortech.training.QuizApp.entity.SingleChoice;

@Transactional
public interface SingleChoiceRepository extends QuestionBaseRepository<SingleChoice>{
	
}
