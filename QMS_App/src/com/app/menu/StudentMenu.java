package com.app.menu;

import java.util.Scanner;

enum EStudentMenu {
	View_Quizes , Take_Quiz , View_Scores , Logout
}

public class StudentMenu {	
	
	public static void studentMenu (Scanner sc){
		EStudentMenu[] arr = EStudentMenu.values();
		EStudentMenu enumchoice;
		
		do {
			System.out.println("----------------- Student Menu ------------------");

			for (EStudentMenu ele : arr) 
				System.out.println(ele.ordinal()+1 + "." + ele.name());
			System.out.println("Enter your choice :");
			
			int choice = sc.nextInt();
			enumchoice = arr[choice - 1];
			
			switch (enumchoice) {
			
			case View_Quizes:
				System.out.println("You have selected view quiz case.");
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
