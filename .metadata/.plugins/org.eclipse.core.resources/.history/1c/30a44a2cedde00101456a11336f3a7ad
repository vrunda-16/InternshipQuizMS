package com.app.menu;

import java.util.Scanner;

import com.app.service.QuizService;

enum EAdminMenu {
	Create_Quiz , List_Quizzes ,View_Results , Delete_Quiz , Logout 
}

public class AdminMenu {	
	
	public static void adminMenu (Scanner sc , int adminId){
		EAdminMenu[] arr = EAdminMenu.values();
		EAdminMenu enumchoice;
		
		do {
			QuizService quizService = new QuizService();
			
			System.out.println("----------------- Admin Menu ------------------");
			for ( EAdminMenu ele : arr) 
				System.out.println(ele.ordinal()+1 + "." + ele.name());
			System.out.println("Enter your choice :");
			
			int choice = sc.nextInt();
			enumchoice = arr[choice-1];
			
			switch (enumchoice) {
			
			case Create_Quiz:
				quizService.createQuiz(sc, adminId);
				break;
				
			case List_Quizzes:
				System.out.println("You have selected list quizzes case.");
				break;
				
			case View_Results:
				System.out.println("You have selected view result case.");
				break;
				
			case Delete_Quiz:
				System.out.println("You have selected delete quiz case.");
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
