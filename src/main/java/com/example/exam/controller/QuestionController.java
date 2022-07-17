package com.example.exam.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

import com.example.exam.entity.Question;
import com.example.exam.entity.Quiz;
import com.example.exam.service.QuestionService;
import com.example.exam.service.QuizService;


@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	//add question
	@PostMapping("/")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question)
	{
		return ResponseEntity.ok(this.questionService.addQuestion(question));
	}
	
	//update question
	@PutMapping("/")
	public ResponseEntity<Question> updateQuestion(@RequestBody Question question)
	{
		return ResponseEntity.ok(this.questionService.updateQuestion(question));
	}
	
	//get all Question of any quiz
	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("quizId")long quizId)
	{
/*		Quiz quiz = new Quiz();
		quiz.setqId(quizId);
		Set<Question> questionOfQuiz = this.questionService.getQuestionOfQuiz(quiz);
		return ResponseEntity.ok(questionOfQuiz);*/
		
		Quiz quiz = this.quizService.getQuiz(quizId);
		Set<Question> questions = quiz.getQuestions();
		List list=new ArrayList(questions);
		if(list.size()>Integer.parseInt(quiz.getNumberOfQuestions()))
		{
			list=list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions()+1));
		}
		
		Collections.shuffle(list);
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/quiz/all/{quizId}")
	public ResponseEntity<?> getQuestionOfQuizAdmin(@PathVariable("quizId")long quizId)
	{
		Quiz quiz = new Quiz();
		quiz.setqId(quizId);
		Set<Question> questionOfQuiz = this.questionService.getQuestionOfQuiz(quiz);
		return ResponseEntity.ok(questionOfQuiz);
		
	}
	
	//get single question
	@GetMapping("/{quesId}")
	public Question getQuestion(@PathVariable("quesId")long quesId)
	{
		return this.questionService.getQuestion(quesId);
	}
	//delete
	@DeleteMapping("/{quesId}")
	public void deleteQuestion(@PathVariable("quesId")long quesId)
	{
		this.questionService.deleteQuestion(quesId);
	}
	
	//eval Quiz
	@PostMapping("/eval-quiz")
	public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions)
	{
		double marksGot=0;
		Integer correctAnswer=0;
		Integer attempted=0;
		for(Question q:questions){
			Question question = this.questionService.get(q.getQuestionId());
			if(question.getAnswer().equals(q.getGivenAnswer()))
			{
				//correct
				correctAnswer++;
				double marksSingle=Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
				marksGot +=marksSingle;
			}
			
			if(q.getGivenAnswer()!=null)
			{
				attempted++;
			}
			else {
				
			}
		}
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("marksGot", marksGot);
		map.put("correctAnswer", correctAnswer);
		map.put("attempted", attempted);
		
		return ResponseEntity.ok(map);
	}
	
}
