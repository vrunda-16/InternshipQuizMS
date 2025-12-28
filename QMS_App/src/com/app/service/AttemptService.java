package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.app.dao.AttemptDao;
import com.app.model.Quiz;
import com.app.model.User;
import com.app.model.Question;

public class AttemptService {
	//Display quizzes to student
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
	//Take quiz(Attempt quiz)
	public void attemptQuiz(Scanner sc,User student) {
		List<Question> question=new ArrayList<>();
		System.out.println("Enter quiz title to start quiz:");
		String title=sc.next();
		char ans=0;
		int final_score=0,quiz_id=0,total_questions=0;
		try(AttemptDao attemptDao=new AttemptDao()){
			question=attemptDao.takeQuiz(title);
			if(question.isEmpty()) 
			{
				System.out.println("Quiz Not Found!!");
			}else {
			for(Question q:question) {
			
				System.out.println("Q."+q.getText());
				System.out.println("A)"+q.getA());
				System.out.println("B)"+q.getB());
				System.out.println("C)"+q.getC());
				System.out.println("D)"+q.getD());
				quiz_id=q.getQuizId();
				System.out.println("Enter Answer:");
				ans=(sc.next().charAt(0));
			
				if(Character.compare(Character.toLowerCase(ans),Character.toLowerCase(q.getCorrect()))==0) {
					
					final_score=final_score+1;
				}
				total_questions=total_questions+1;
			}
			attemptDao.insertQuizAttempts(quiz_id,student.getId(),final_score,total_questions);
			System.out.println("-----QUIZ END----");
			}
		}catch (Exception e) {
	
			e.printStackTrace();
		}
	}
	//Display Quiz Score to Student
	public void showScoreToStudent(Scanner sc,User student) {
		List<Object[]> arr=new ArrayList<>();
		try(AttemptDao attemptDao=new AttemptDao()){
			arr=attemptDao.displayScoreToStudent(student.getId());
			if(arr.isEmpty())
			{
				System.out.println(" You have not yet attempted any quiz!!");
			}else {
			for(Object[] obj:arr) {
				System.out.println("----QuizName:"+obj[0]+"----");
				System.out.println("Score:"+obj[1]);
				System.out.println("Total Questions:"+obj[2]);
			}}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
