package com.app.menu;

import java.util.Scanner;

import com.app.service.UserService;

enum EMainMenu {
<<<<<<< HEAD
	AdminLogin , StudentRegister , StudentLogin , Exit
=======
	Admin_Login , Student_Register , Student_Login , Exit
>>>>>>> 3add7a3f2db59df9a28091ceddfd766c11491826
}

public class MainMenu {	
	
	public static void mainMenu (Scanner sc){
		
		UserService userService = new UserService();
		
		EMainMenu[] arr = EMainMenu.values();
		EMainMenu enumchoice;
		
		do {
			
			System.out.println("----------------- Main Menu ------------------");
			for (EMainMenu ele : arr) 
				System.out.println(ele.ordinal()+1 + "." + ele.name());
			
			System.out.println("Enter your choice :");
			int choice = sc.nextInt();
			enumchoice = arr[choice-1];
			
			switch (enumchoice) {
			
<<<<<<< HEAD
			case AdminLogin:
				userService.adminLogin(sc);
				break;
				
			case StudentRegister:
				userService.studentRegister(sc);
				break;
				
			case StudentLogin:
=======
			case Admin_Login:
				userService.adminLogin(sc);
				break;
				
			case Student_Register:
				userService.studentRegister(sc);
				break;
				
			case Student_Login:
>>>>>>> 3add7a3f2db59df9a28091ceddfd766c11491826
				userService.studentLogin(sc);
				break;
				
			case Exit:
				System.out.println("Thank you for visiting application.");
				break;
				
			default:
				System.out.println("Wrong choice....");
				break;
			}
		}while(enumchoice != EMainMenu.Exit);
		
		
	}
}
