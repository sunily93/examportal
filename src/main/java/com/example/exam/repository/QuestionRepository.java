package com.example.exam.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exam.entity.Question;
import com.example.exam.entity.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long>{

	Set<Question> findByQuiz(Quiz quiz);

}
