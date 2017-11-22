package com.fortech.training.QuizApp.dao;

import org.springframework.transaction.annotation.Transactional;

import com.fortech.training.QuizApp.entity.MultipleChoice;

@Transactional
public interface MultipleChoiceRepository extends QuestionBaseRepository<MultipleChoice>{

//	public List<MultipleChoice> findAllByQuiz_Id(int quizId);
} 