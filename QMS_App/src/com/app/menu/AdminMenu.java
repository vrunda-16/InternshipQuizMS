package com.app.menu;

import java.util.Scanner;

import com.app.service.AttemptService;
import com.app.service.QuizService;

enum EAdminMenu {
	Create_Quiz , List_Quizzes ,View_Results , Delete_Quiz , Logout 
}

public class AdminMenu {	

	public static void adminMenu (Scanner sc , int adminId){

		EAdminMenu[] arr = EAdminMenu.values();
		EAdminMenu enumchoice;
		
		do {
			AttemptService attemptService = new AttemptService();

			QuizService quizService = new QuizService();
			
			System.out.println("----------------- Admin Menu ------------------");
			for ( EAdminMenu ele : arr) 
				System.out.println(ele.ordinal()+1 + "." + ele.name());
			System.out.print("Enter your choice :");
			
			int choice = sc.nextInt();
			enumchoice = arr[choice-1];
			
			switch (enumchoice) {

			case Create_Quiz:
				quizService.createQuiz(sc, adminId);
				break;
				
			case List_Quizzes:
				quizService.listQuiz();
				break;
				
			case View_Results:
				attemptService.showScoreToAdmin(sc);
				break;
				
			case Delete_Quiz:
				quizService.deleteQuiz(sc);
				break;
				
			case Logout:
				System.out.println("Admin Logout successfully.");
				break;
				
			default:
				System.out.println("Wrong choice.");
				break;
			}
		}while(enumchoice != EAdminMenu.Logout);
		
		
	}
}
