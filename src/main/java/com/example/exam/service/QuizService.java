package com.example.exam.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.example.exam.entity.Category;
import com.example.exam.entity.Quiz;

public interface QuizService {

	public Quiz addQuiz(Quiz quiz);
	public Quiz updateQuiz(Quiz quiz);
	public Set<Quiz> getQuizes();
	public Quiz getQuiz(long quizId);
	public void deleteQuiz(long quizId);
	public List<Quiz> getQuizOfCategory(Category category);
	public List<Quiz> getActiveQuiz();
	public List<Quiz> getActiveQuizOfCategory(Category category);
	
}
