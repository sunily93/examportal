package com.example.exam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exam.entity.Category;
import com.example.exam.entity.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long>{

	public List<Quiz> findByCategory(Category category);
	
	public List<Quiz> findByActive(Boolean b);
	
	public List<Quiz> findByCategoryAndActive(Category category , Boolean b);
}
