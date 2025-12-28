package com.app.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.app.dao.QuestionDao;
import com.app.dao.QuizDao;
import com.app.model.Question;
import com.app.model.Quiz;
import com.app.util.QuestionFileParser;

public class QuizService {

	public void createQuiz(Scanner sc, int adminId) {
		System.out.print("Enter quiz title :");
		String title = sc.next();
		sc.nextLine();
		System.out.print("Enter question file path :");
		String filePath = sc.next();
		
		File file = new File(filePath);
		
		try (QuizDao quizDao = new QuizDao()){
			List<Question> questionList = QuestionFileParser.parse(file);
			try(QuestionDao questionDao = new QuestionDao()){
				int quizId = quizDao.insertQuiz(title,adminId);
				for (Question question : questionList) {
					question.quizId = quizId;
					questionDao.insertQuestion(question);
				}
			}
			System.out.println("Quiz created successfully...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void listQuiz() {
		try(QuizDao quizDao = new QuizDao()){
			
			List<Quiz> quizList = quizDao.viewQuiz();
			if(quizList.isEmpty() == false) {
				System.out.println("--------- Available quizzes ------");
				for(Quiz quiz : quizList) {
					System.out.println("Quiz ID : "+quiz.getId()+"Quiz Title : " + quiz.getTitle());
				}
			} else
				System.out.println("No any quizes available");
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
		
	public void deleteQuiz(Scanner sc)  {
		listQuiz();
		System.out.print("Enter quiz id :");
		int quiz = sc.nextInt();
		try(QuizDao quizDao = new QuizDao()){
			int result = quizDao.removeQuiz(quiz);
			if(result > 0) 
				System.out.println("Quiz deleted successfully...");
			else 
				System.out.println("No such quiz available...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

