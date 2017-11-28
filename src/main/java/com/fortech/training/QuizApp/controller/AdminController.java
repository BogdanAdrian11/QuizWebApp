package com.fortech.training.QuizApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fortech.training.QuizApp.entity.Quiz;
import com.fortech.training.QuizApp.service.QuizService;

@SessionAttributes(value="quiz")
@Controller
public class AdminController {

	@Autowired private QuizService quizService;
	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String showAdmin() {
		return "admin";
	}
	
	@RequestMapping(value="/admin", method=RequestMethod.POST)
	public String handleAdmin(@RequestParam String action) {
		
		if (action.equals("delete")) {
			return "delete";
		} else if (action.equals("create")) {
			return "create";
		} else if (action.equals("update")) {
			return "update";
		}
		return "index";
	}
	
	@RequestMapping(value="/admin/delete", method=RequestMethod.POST)
	public String handleDelete(ModelMap model, @RequestParam int id) {
		String message;
		if (quizService.get(id) != null) {
			quizService.delete(id);
			message = "Quiz has been deleted successfully.";
		} else {
			message = "Id not found.";
		}
		model.put("message", message);
		return "admin";
	}
	
	@RequestMapping(value="/admin/create", method=RequestMethod.POST)
	public String handleCreate(ModelMap model, 
			@RequestParam String name, @RequestParam int nrOfChoices) {
		Quiz quiz = new Quiz();
		quiz.setName(name);
		if (quizService.save(quiz) != null) {
			model.put("quizId", quiz.getId());
			model.put("nrOfChoices", nrOfChoices);
			return "newQuestion";
		}
		model.put("message", "Quiz not created");
		return "admin";
	}
	
	@RequestMapping(value="/admin/create/{quizId}/addQuestion", method=RequestMethod.POST)
	public String handleNewQuestion(ModelMap model,  @PathVariable int quizId,
			@RequestParam String content, @RequestParam List<String> choiceContent, 
			@RequestParam int nrOfChoices, @RequestParam String type, 
			@RequestParam(required=false) List<Integer> correct, @RequestParam String action) {

		if (quizService.addQuestion(quizId, type, content, choiceContent, correct) == false) {
			model.put("message", "Last question was not added, bad input");
		}
		if (action.equals("anotherQuestion")) {
			model.put("type", type);
			model.put("nrOfChoices", nrOfChoices);
			return "newQuestion";
		} else if (action.equals("finish")){
			Quiz quiz = quizService.get(quizId);
			if (quiz.getQuestions().size() > 0) {
				model.put("message", "Quiz successfully created");
			} else {
				quizService.delete(quizId);
				model.put("message", "Quiz not created");
			}
		}
		return "admin";
	}
	
	@RequestMapping(value="/admin/update", method=RequestMethod.POST)
	public String handleUpdate(ModelMap model, @RequestParam int id) {
		Quiz quiz = quizService.get(id);
		if (quiz == null) {
			model.put("message", "Id not found.");
			return "admin";
		} 
		model.put("quiz", quiz);
		return "updateQuiz";
	}
	
	@RequestMapping(value="/admin/update/quiz", method=RequestMethod.POST)
	public String handleQuizUpdate(ModelMap model, @ModelAttribute Quiz quiz) {
		model.put("message", "Quiz was not updated");
		return "admin";
	}
}
