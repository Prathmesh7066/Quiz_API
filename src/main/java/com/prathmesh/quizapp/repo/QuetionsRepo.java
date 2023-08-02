package com.prathmesh.quizapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.prathmesh.quizapp.dto.Quetions;

public interface QuetionsRepo extends JpaRepository<Quetions, Integer> {
	List<Quetions> getQueByCategory(String category);
	
	@Query(value = "SELECT * FROM question q where q.category=:category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
	List<Quetions> findRandomQuestionsByCategory(String category, int numQ);

}
