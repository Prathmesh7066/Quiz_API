package com.prathmesh.quizapp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.prathmesh.quizapp.dto.QuetionWrapper;
import com.prathmesh.quizapp.dto.Quetions;
import com.prathmesh.quizapp.dto.Quiz;
import com.prathmesh.quizapp.repo.QuetionsRepo;
import com.prathmesh.quizapp.repo.QuizRepo;

@Repository
public class QuizDao {
	@Autowired
	QuetionsRepo quetionsRepo;
	
	@Autowired
	QuizRepo quizRepo;
	
	public ResponseEntity<String> createQuiz(String category, int numQ, String title){
		List<Quetions> quetions = quetionsRepo.findRandomQuestionsByCategory(category, numQ);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuetions(quetions);
		
		quizRepo.save(quiz);
		
		return new ResponseEntity<>("sucsess", HttpStatus.CREATED);
	}
	
	public ResponseEntity<List<QuetionWrapper>> getQuestionFromQuiz(Integer id){
		Optional<Quiz> quetions = quizRepo.findById(id);
		List<Quetions> dbQuetions = quetions.get().getQuetions();
		
		List<QuetionWrapper> quetionWrappers = new ArrayList<>();
		for (Quetions q: dbQuetions) {
			QuetionWrapper qw = new QuetionWrapper(q.getId(), q.getQuestion(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			quetionWrappers.add(qw);
		}
		return new ResponseEntity<>(quetionWrappers, HttpStatus.OK);
	}

}
