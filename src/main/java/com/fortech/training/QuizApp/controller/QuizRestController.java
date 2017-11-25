package com.fortech.training.QuizApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fortech.training.QuizApp.entity.Quiz;
import com.fortech.training.QuizApp.service.QuizService;

@RestController
@RequestMapping(value="/rest")
public class QuizRestController {
	
	@Autowired private QuizService quizService;
	
	//create a new quiz
	@PostMapping("/quiz/create")
	public ResponseEntity<?> create(@RequestBody Quiz newQuiz) {

		Quiz quiz = quizService.save(newQuiz);
		if ( quiz == null)
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok().body("New Quiz has been saved with ID: " + quiz.getId());
	}
	
	//get a quiz by id
	@GetMapping("/quiz/get/{id}")
	public Quiz get(@PathVariable("id") int id) {
		return quizService.get(id);
	}

	//get the list of quizzes
	@GetMapping("/quiz/get")
	public List<Quiz> getAll() {
		return quizService.getAll();
	}
	
	//update a quiz
	@PutMapping("/quiz/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Quiz quiz) {
		quizService.update(id, quiz);
	    return ResponseEntity.ok().body("Quiz has been updated successfully.");
	}
	
	//delete a quiz 
	@DeleteMapping("/quiz/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		quizService.delete(id);
		return ResponseEntity.ok().body("Quiz has been deleted successfully.");
   }
}
