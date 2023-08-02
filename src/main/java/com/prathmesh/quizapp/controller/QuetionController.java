package com.prathmesh.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prathmesh.quizapp.dto.Quetions;
import com.prathmesh.quizapp.service.QuestionsService;

@RestController
@RequestMapping("Quetion")
public class QuetionController {
	@Autowired
	private QuestionsService questionsService;

	@PostMapping("/addQuestion")
	public ResponseEntity<Quetions> saveQuestions(@RequestBody Quetions quetions) {
		return questionsService.saveQuestion(quetions);
	}
    
	@GetMapping("/getAllQuestions")
	public ResponseEntity<List<Quetions>> getAllQuestions(){
		return questionsService.getAllQuestion();
	}
	
	@GetMapping("/getQueByCategory/{category}")
	public ResponseEntity<List<Quetions>> getQuestionsByCategory(@PathVariable String category){
		return questionsService.getQueByCategory(category);
		
	}
	
	@PutMapping("/updateQuestion/{id}")
	public ResponseEntity<Quetions> updateQuestion(@PathVariable int id, @RequestBody Quetions quetions) {
		return questionsService.updateQuestionById(id,quetions);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Quetions> deleteById(@PathVariable int id) {
		return questionsService.deleteById(id);
	}
	

}
