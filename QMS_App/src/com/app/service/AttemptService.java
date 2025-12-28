package com.app.service;

import java.util.List;

import com.app.dao.AttemptDao;
import com.app.model.Quiz;
import com.app.model.User;

public class AttemptService {
	
	public void viewQuiz(User student) {
		try(AttemptDao attemptDao = new AttemptDao()){
			List<Quiz> quizlist = attemptDao.selectQuiz(student);
			System.out.println("Quize Title :");
			for (Quiz quiz : quizlist) {
				System.out.println(quiz.getTitle());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
