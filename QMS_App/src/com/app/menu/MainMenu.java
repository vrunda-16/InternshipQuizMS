package com.app.menu;

import java.util.Scanner;

import com.app.service.UserService;

enum EMainMenu {
	AdminLogin , StudentRegister , StudentLogin , Exit
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
			
			case AdminLogin:
				userService.adminLogin(sc);
				break;
				
			case StudentRegister:
				userService.studentRegister(sc);
				break;
				
			case StudentLogin:
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
