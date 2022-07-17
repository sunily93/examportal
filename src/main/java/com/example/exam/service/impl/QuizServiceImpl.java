package com.example.exam.service.impl;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exam.entity.Category;
import com.example.exam.entity.Quiz;
import com.example.exam.repository.QuizRepository;
import com.example.exam.service.QuizService;
@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepository quizRepository;
	
	@Override
	public Quiz addQuiz(Quiz quiz) {
		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		return this.quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizes() {
		return new HashSet<>(this.quizRepository.findAll());
	}

	@Override
	public Quiz getQuiz(long quizId) {
		return this.quizRepository.findById(quizId).get();
	}

	@Override
	public void deleteQuiz(long quizId) {
	/*	Quiz quiz = new Quiz();
		quiz.setqId(quizId);*/
		this.quizRepository.deleteById(quizId);
		
	}

	@Override
	public List<Quiz> getQuizOfCategory(Category category) {
		
		return this.quizRepository.findByCategory(category);
	}

	//get active quizzes
	@Override
	public List<Quiz> getActiveQuiz() {
		return this.quizRepository.findByActive(true);
	}

	@Override
	public List<Quiz> getActiveQuizOfCategory(Category category) {
		// TODO Auto-generated method stub
		return this.quizRepository.findByCategoryAndActive(category, true);
	}

}
