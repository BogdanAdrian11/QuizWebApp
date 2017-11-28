package com.fortech.training.QuizApp.service;

import java.util.List;

import com.fortech.training.QuizApp.entity.Quiz;

public interface QuizService {

	Quiz save(Quiz quiz);
	
	Quiz get(int id);
			
	List<Quiz> getAll();
	
	List<Quiz> getForIndex();
	
	Quiz update(int id, Quiz quiz);
	
	boolean addQuestion(int quizId, String type, String content, List<String> choices, List<Integer> correct);
	
	void delete(int id);
	
	double getResult(int quizId, List<Integer> results);
}
