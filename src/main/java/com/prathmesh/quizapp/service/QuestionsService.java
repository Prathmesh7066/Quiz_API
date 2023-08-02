package com.prathmesh.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prathmesh.quizapp.dao.QuestionsDao;
import com.prathmesh.quizapp.dto.Quetions;

@Service
public class QuestionsService {
	@Autowired
	private QuestionsDao questionsDao;

	public ResponseEntity<Quetions> saveQuestion(Quetions quetions) {
		try {
			return new ResponseEntity<>(questionsDao.saveQuestion(quetions), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(questionsDao.saveQuestion(quetions), HttpStatus.CREATED);

	}

	public ResponseEntity<List<Quetions>> getAllQuestion() {
		try {
			return new ResponseEntity<>(questionsDao.getAllQuestions(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(questionsDao.getAllQuestions(), HttpStatus.OK);

	}

	public ResponseEntity<List<Quetions>> getQueByCategory(String category) {
		try {
			return new ResponseEntity<>(questionsDao.getQueByCategory(category), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(questionsDao.getQueByCategory(category), HttpStatus.OK);

	}

	public ResponseEntity<Quetions> updateQuestionById(int id, Quetions quetions) {
		try {
			return new ResponseEntity<>(questionsDao.updateQueById(id, quetions), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(questionsDao.updateQueById(id, quetions), HttpStatus.ACCEPTED);

	}

	public ResponseEntity<Quetions> deleteById(int id) {
		try {
			return new ResponseEntity<>(questionsDao.deleteById(id), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(questionsDao.deleteById(id), HttpStatus.ACCEPTED);

	}

}
