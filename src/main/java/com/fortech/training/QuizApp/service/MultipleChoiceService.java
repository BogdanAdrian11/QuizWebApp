package com.fortech.training.QuizApp.service;

import java.util.List;

import com.fortech.training.QuizApp.entity.MultipleChoice;

public interface MultipleChoiceService {
	int save(MultipleChoice question);
	
	MultipleChoice get(int id);
	
	List<MultipleChoice> getAll();
	
	List<MultipleChoice> getForIndex();
	
	List<MultipleChoice> getByQuizId();
	
	void update(int id, MultipleChoice question);
	
	void delete(int id);
}
