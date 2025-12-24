package com.app.menu;

import java.util.Scanner;

enum EStudentMenu {
<<<<<<< HEAD
	Viewquizes , Takequiz , Viewscores , Logout
=======
	View_Quizes , Take_Quiz , View_Scores , Logout
>>>>>>> 3add7a3f2db59df9a28091ceddfd766c11491826
}

public class StudentMenu {	
	
<<<<<<< HEAD
	public static void studentMenuWithEnum (Scanner sc){
=======
	public static void studentMenu (Scanner sc , int studentId){
>>>>>>> 3add7a3f2db59df9a28091ceddfd766c11491826
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
			
<<<<<<< HEAD
			case Viewquizes:
				System.out.println("You have selected view quiz case.");
				break;
				
			case Takequiz:
				System.out.println("You have selected take quiz case.");
				break;
				
			case Viewscores:
=======
			case View_Quizes:
				System.out.println("You have selected view quiz case.");
				break;
				
			case Take_Quiz:
				System.out.println("You have selected take quiz case.");
				break;
				
			case View_Scores:
>>>>>>> 3add7a3f2db59df9a28091ceddfd766c11491826
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
