package com.example.exam.service;

import java.util.Set;

import com.example.exam.entity.Question;
import com.example.exam.entity.Quiz;

public interface QuestionService {

	public Question addQuestion(Question question);
	
	public Question updateQuestion(Question question);
	
	public Set<Question> getAllQuestion();
	
	public Question getQuestion(long questionId);
	
	public Set<Question> getQuestionOfQuiz(Quiz quiz);

	public void deleteQuestion(long questionId);
	
	public Question get(long questionId);
}
