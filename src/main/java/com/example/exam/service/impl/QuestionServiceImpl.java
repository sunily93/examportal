package com.example.exam.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exam.entity.Question;
import com.example.exam.entity.Quiz;
import com.example.exam.repository.QuestionRepository;
import com.example.exam.service.QuestionService;
@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public Question addQuestion(Question question) {
		return this.questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		return this.questionRepository.save(question);
	}

	@Override
	public Set<Question> getAllQuestion() {
		return new HashSet<>(this.questionRepository.findAll());
	}

	@Override
	public Question getQuestion(long questionId) {
		return this.questionRepository.findById(questionId).get();
	}

	@Override
	public Set<Question> getQuestionOfQuiz(Quiz quiz) {
		return this.questionRepository.findByQuiz(quiz);
	}

	@Override
	public void deleteQuestion(long questionId) {
		Question question = new Question();
		question.setQuestionId(questionId);
		this.questionRepository.delete(question);
	}

	@Override
	public Question get(long questionId) {
		return this.questionRepository.getOne(questionId);
	}

}
