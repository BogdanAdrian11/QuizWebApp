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
import com.fortech.training.QuizApp.entity.SingleChoice;

@Service
@Transactional
public class QuizServiceImpl implements QuizService {

	@Autowired private QuizRepository quizRepo;
	
	@Override
	public Quiz save(Quiz quiz) {
		if (quiz == null || quiz.getName() == null || quiz.getName() == ""
				|| quiz.getQuestions().size() == 0) {
			return null;
		}
		for (Question question : quiz.getQuestions()) {
			if (question.getContent() == null || question.getContent() == "" ||
					question.getType() == null || question.getType() == "") {
				return null;
			}
			if (question.getType().equals("SingleChoice")) {
				SingleChoiceService serv = new SingleChoiceServiceImpl();
				if (!serv.isValid((SingleChoice) question)) {
					return null;
				}
			}
			for (Choice choice : question.getChoices()) {
				if (choice.getContent() == null || question.getContent() == "") {
					return null;
				}
			}
		}
		return quizRepo.save(quiz);
	}

	@Override
	public Quiz get(int id) {
		return quizRepo.findOne(id);
	}

	@Override
	public List<Quiz> getAll() {
		return quizRepo.findAll();
	}

	@Override
	public Quiz update(int id, Quiz quiz) {
		if (quiz == null || quiz.getName() == null || quiz.getName() == ""
				|| quiz.getQuestions().size() == 0) {
			return null;
		}
		for (Question question : quiz.getQuestions()) {
			if (question.getContent() == null || question.getContent() == "" ||
					question.getType() == null || question.getType() == "") {
				return null;
			}
			if (question.getType().equals("SingleChoice")) {
				SingleChoiceService serv = new SingleChoiceServiceImpl();
				if (!serv.isValid((SingleChoice) question)) {
					return null;
				}
			}
			for (Choice choice : question.getChoices()) {
				if (choice.getContent() == null || question.getContent() == "") {
					return null;
				}
			}
		}
		quiz.setId(id);
		return quizRepo.save(quiz);
	}

	@Override
	public void delete(int id) {
		quizRepo.delete(id);
	}

	@Override
	public List<Quiz> getForIndex() {
		List<Quiz> quizzes = quizRepo.findAll();
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
		
		Quiz quiz = quizRepo.findOne(quizId);
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
