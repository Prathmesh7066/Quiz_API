package com.prathmesh.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prathmesh.quizapp.dto.Quetions;
import com.prathmesh.quizapp.dto.Quiz;
import com.prathmesh.quizapp.dto.QuizResponce;
import com.prathmesh.quizapp.repo.QuizRepo;

@Service
public class QuizService {
	@Autowired
	QuizRepo quizRepo;

	public ResponseEntity<Integer> calcuateResult(Integer id, List<QuizResponce> quizResponces) {
		Quiz quiz = quizRepo.findById(id).get();
		List<Quetions> quetions = quiz.getQuetions();
		int right = 0;
		int i = 0;

		for (QuizResponce responce : quizResponces) {
			if (responce.getResponse().equals(quetions.get(i).getCorrectAnswer())) {
				right++;
				i++;
			}

		}
		return new ResponseEntity<>(right, HttpStatus.OK);
	}

}
