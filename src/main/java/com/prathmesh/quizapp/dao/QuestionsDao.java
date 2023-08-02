package com.prathmesh.quizapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prathmesh.quizapp.dto.Quetions;
import com.prathmesh.quizapp.repo.QuetionsRepo;

@Repository
public class QuestionsDao {
	@Autowired
	private QuetionsRepo quetionsRepo;

	public Quetions saveQuestion(Quetions quetions) {
		return quetionsRepo.save(quetions);
	}

	public List<Quetions> getAllQuestions() {
		return quetionsRepo.findAll();
	}

	public List<Quetions> getQueByCategory(String category) {
		
		return quetionsRepo.getQueByCategory(category);
	}

	public Quetions updateQueById(int id, Quetions quetions) {
		Optional<Quetions> quetions2 = quetionsRepo.findById(id);
		if(quetions2.isPresent()) {
			quetions.setId(id);
			return quetionsRepo.save(quetions);
		}
		return null;
		
		
	}
	public Quetions deleteById(int id) {
		 Optional<Quetions> optional= quetionsRepo.findById(id);
		 if
		 (optional.isPresent()) {
			 Quetions quetions = optional.get();
			 quetionsRepo.delete(quetions);
			 return quetions;
		 }
		 return null;
		 
	}

}
