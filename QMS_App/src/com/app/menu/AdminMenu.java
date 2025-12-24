package com.app.menu;

import java.util.Scanner;

<<<<<<< HEAD
enum EAdminMenu {
	Createquiz , ListQuizzes ,ViewResults , DeleteQuiz , Logout 
=======
import com.app.service.QuizService;

enum EAdminMenu {
	Create_Quiz , List_Quizzes ,View_Results , Delete_Quiz , Logout 
>>>>>>> 3add7a3f2db59df9a28091ceddfd766c11491826
}

public class AdminMenu {	
	
<<<<<<< HEAD
	public static void adminMenuWithEnum (Scanner sc){
=======
	public static void adminMenu (Scanner sc , int adminId){
>>>>>>> 3add7a3f2db59df9a28091ceddfd766c11491826
		EAdminMenu[] arr = EAdminMenu.values();
		EAdminMenu enumchoice;
		
		do {
<<<<<<< HEAD
=======
			QuizService quizService = new QuizService();
>>>>>>> 3add7a3f2db59df9a28091ceddfd766c11491826
			
			System.out.println("----------------- Admin Menu ------------------");
			for ( EAdminMenu ele : arr) 
				System.out.println(ele.ordinal()+1 + "." + ele.name());
			System.out.println("Enter your choice :");
			
			int choice = sc.nextInt();
			enumchoice = arr[choice-1];
			
			switch (enumchoice) {
			
<<<<<<< HEAD
			case Createquiz:
				System.out.println("You have selected create quiz case.");
				break;
				
			case ListQuizzes:
				System.out.println("You have selected list quizzes case.");
				break;
				
			case ViewResults:
				System.out.println("You have selected view result case.");
				break;
				
			case DeleteQuiz:
=======
			case Create_Quiz:
				quizService.createQuiz(sc, adminId);
				break;
				
			case List_Quizzes:
				quizService.listQuiz();
				break;
				
			case View_Results:
				System.out.println("You have selected view result case.");
				break;
				
			case Delete_Quiz:
>>>>>>> 3add7a3f2db59df9a28091ceddfd766c11491826
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
