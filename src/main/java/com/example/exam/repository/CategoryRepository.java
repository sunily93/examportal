package com.example.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exam.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
