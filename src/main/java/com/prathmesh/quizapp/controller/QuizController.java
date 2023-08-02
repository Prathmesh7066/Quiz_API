package com.prathmesh.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prathmesh.quizapp.dao.QuizDao;
import com.prathmesh.quizapp.dto.QuetionWrapper;
import com.prathmesh.quizapp.dto.QuizResponce;
import com.prathmesh.quizapp.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuizService quizService;
	
	@PostMapping("/createQuiz")
	public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam  int numQ,@RequestParam  String title){
		quizDao.createQuiz(category, numQ, title);
		
		return new ResponseEntity<>("sucsess", HttpStatus.CREATED);
	}
	
	@GetMapping("/getQFromQuiz/{id}")
	public ResponseEntity<List<QuetionWrapper>> getQuetionsFromQuiz(@PathVariable Integer id){
		return quizDao.getQuestionFromQuiz(id);
	}
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<QuizResponce> quizResponces){
		return quizService.calcuateResult(id, quizResponces);
	}
	
	

}
