package com.app.menu;

import java.util.Scanner;

import com.app.model.User;
import com.app.service.AttemptService;

enum EStudentMenu {

	View_Quizes , Take_Quiz , View_Scores , Logout
}

public class StudentMenu {	
	

	public static void studentMenu (Scanner sc , User student){

		EStudentMenu[] arr = EStudentMenu.values();
		EStudentMenu enumchoice;
		
		do {
			AttemptService attemptService = new AttemptService();
			
			System.out.println("----------------- Student Menu ------------------");

			for (EStudentMenu ele : arr) 
				System.out.println(ele.ordinal()+1 + "." + ele.name());
			System.out.print("Enter your choice :");
			
			int choice = sc.nextInt();
			enumchoice = arr[choice - 1];
			
			switch (enumchoice) {
			
			case View_Quizes:
				attemptService.viewQuiz(student);
				break;
				
			case Take_Quiz:
				System.out.println("You have selected take quiz case.");
				break;
				
			case View_Scores:
				System.out.println("You have selected view score case.");
				break;
				
			case Logout:
				System.out.println("Thank you for visiting application.");
				break;
				
			default:
				System.out.println("Wrong choice.");
				break;
			}
		}while(enumchoice != EStudentMenu.Logout);
		
		
	}
}
