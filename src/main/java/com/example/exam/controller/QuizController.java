package com.example.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exam.entity.Category;
import com.example.exam.entity.Quiz;
import com.example.exam.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	//add quiz
	@PostMapping("/")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz)
	{
		return ResponseEntity.ok(this.quizService.addQuiz(quiz));
	}
	
	//update quiz
	@PutMapping("/")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz)
	{
		return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
	}
	
	//get quiz
	@GetMapping("/")
	public ResponseEntity<?> getQuizes()
	{
		return ResponseEntity.ok(this.quizService.getQuizes());
	}
	
	//get single quiZ
	@GetMapping("/{quizId}")
	public Quiz getQuiz(@PathVariable("quizId")Long quizId)
	{
		return this.quizService.getQuiz(quizId);
	}
	
	//delete
	@DeleteMapping("/{qId}")
	public void deleteQuiz(@PathVariable("qId")long qId)	
	{
		this.quizService.deleteQuiz(qId);
	}
	
	@GetMapping("/category/{cid}")
	public List<Quiz> getQuizeOfCategory(@PathVariable("cid") long cid)
	{
		Category category = new Category();
		category.setcId(cid);
		return this.quizService.getQuizOfCategory(category);
	}
	
	//get Active quize
	@GetMapping("/active")
	public List<Quiz> getActiveQuiz()
	{
		return this.quizService.getActiveQuiz();
	}
	
	//get Active quiz of category
	@GetMapping("/category/active/{cid}")
	public List<Quiz> getActiveQuiz(@PathVariable("cid")long cid)
	{
		Category category = new Category();
		category.setcId(cid);
		return this.quizService.getActiveQuizOfCategory(category);
	}
}
