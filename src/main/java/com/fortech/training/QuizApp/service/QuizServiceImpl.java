package com.fortech.training.QuizApp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortech.training.QuizApp.dao.QuizRepository;
import com.fortech.training.QuizApp.entity.Quiz;

@Service
@Transactional
public class QuizServiceImpl implements QuizService {

	@Autowired QuizRepository repo;
	
	@Override
	public int save(Quiz quiz) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Quiz get(int id) {
		return repo.findOne(id);
	}

	@Override
	public List<Quiz> getAll() {
		return repo.findAll();
	}

	@Override
	public void update(int id, Quiz quiz) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Quiz> getForIndex() {
		List<Quiz> quizzes = repo.findAll();
		List<Quiz> returnedQuizzes = new ArrayList<>();
		Iterator<Quiz> it = quizzes.iterator();
		for (int i = 0; i < 4; i++) {
			if (it.hasNext()) {
				returnedQuizzes.add(it.next());
			}
		}		
		return returnedQuizzes;
	}

}
