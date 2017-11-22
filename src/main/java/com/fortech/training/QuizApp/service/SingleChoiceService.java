package com.fortech.training.QuizApp.service;

import java.util.List;

import com.fortech.training.QuizApp.entity.SingleChoice;

public interface SingleChoiceService {
	int save(SingleChoice question);
	
	SingleChoice get(int id);
	
	List<SingleChoice> getAll();
	
	List<SingleChoice> getForIndex();
	
	List<SingleChoice> getByQuizId();
	
	void update(int id, SingleChoice question);
	
	void delete(int id);
}
