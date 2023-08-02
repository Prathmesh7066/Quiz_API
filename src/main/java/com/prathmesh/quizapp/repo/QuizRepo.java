package com.prathmesh.quizapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prathmesh.quizapp.dto.Quiz;

public interface QuizRepo extends JpaRepository<Quiz, Integer> {

}
