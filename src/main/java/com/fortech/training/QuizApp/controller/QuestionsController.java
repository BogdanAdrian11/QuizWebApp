package com.fortech.training.QuizApp.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fortech.training.QuizApp.QuizResult;
import com.fortech.training.QuizApp.entity.MultipleChoice;
import com.fortech.training.QuizApp.entity.Question;
import com.fortech.training.QuizApp.entity.Quiz;
import com.fortech.training.QuizApp.entity.SingleChoice;
import com.fortech.training.QuizApp.service.QuizService;

@Controller
@RequestMapping(value="/questions")
public class QuestionsController {

	@Autowired QuizService quizServ;

	@RequestMapping(value="/{quizId}", method=RequestMethod.GET)
	public String showQuestions(ModelMap model, @PathVariable("quizId") int quizId) {
		Quiz quiz = quizServ.get(quizId);
		List<MultipleChoice> mc = new ArrayList<>();
		List<SingleChoice> sc = new ArrayList<>();
		Iterator<Question> it = quiz.getQuestions().iterator();
		while (it.hasNext()) {
			Question q = it.next();
			if (q instanceof MultipleChoice) {
				mc.add((MultipleChoice) q);
				System.out.println(mc.get(mc.size()-1).getChoices());
			}
			if (q instanceof SingleChoice) {
				sc.add((SingleChoice) q);
				System.out.println(sc.get(sc.size()-1).getChoices());

			}
		}
		QuizResult quizResult = new QuizResult();
		model.put("quizResult", quizResult);
		model.put("quiz", quiz.getName());
		model.put("mcQuestions", mc);
		model.put("scQuestions", sc);

		return "questions";
	}
	
	@RequestMapping(value="/{quizId}", method=RequestMethod.POST)
	public String showResult(Model model, @RequestBody QuizResult quizResult) {
		
		System.out.println("quizResult" + quizResult.getQuestionResults().get(0).getQuestion());
		return "welcome";
	}

	
}
