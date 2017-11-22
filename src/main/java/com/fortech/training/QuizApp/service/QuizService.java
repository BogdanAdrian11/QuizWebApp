package com.fortech.training.QuizApp.service;

import java.util.List;

import com.fortech.training.QuizApp.entity.Quiz;

public interface QuizService {

	int save(Quiz quiz);
	
	Quiz get(int id);
	
	List<Quiz> getAll();
	
	List<Quiz> getForIndex();
	
	void update(int id, Quiz quiz);
	
	void delete(int id);
}