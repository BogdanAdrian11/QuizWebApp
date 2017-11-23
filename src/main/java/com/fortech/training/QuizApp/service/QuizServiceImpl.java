package com.fortech.training.QuizApp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortech.training.QuizApp.dao.QuizRepository;
import com.fortech.training.QuizApp.entity.Choice;
import com.fortech.training.QuizApp.entity.Question;
import com.fortech.training.QuizApp.entity.Quiz;

@Service
@Transactional
public class QuizServiceImpl implements QuizService {

	@Autowired QuizRepository repo;
	
	@Override
	public int save(Quiz quiz) {
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

	}

	@Override
	public void delete(int id) {

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

	@Override
	public double getResult(int quizId, List<Integer> results) {
		if (results == null || results.size() == 0) {
			return 0;
		}
		
		int countCorrect = 0;
		
		Quiz quiz = repo.findOne(quizId);
		for (Question question : quiz.getQuestions()) {
			boolean correct = true;
			for (Choice choice : question.getChoices()) {
				if (choice.isCorrect() && !results.contains(choice.getId())) {
					correct = false;
					break;
				}
				if (!choice.isCorrect() && results.contains(choice.getId())) {
					correct = false;
					break;
				}
			}
			if (correct) {
				countCorrect++;
			}
		}
		return (double)countCorrect / quiz.getQuestions().size() * 100;
	}
}
