package com.app.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.app.dao.UserDao;
import com.app.menu.StudentMenu;

public class UserService {
	public void adminLogin(Scanner sc) {
		
	}
	
	public void studentRegister(Scanner sc) {
		
	}
	
	public void studentLogin(Scanner sc) {
		System.out.print("Enter email : ");
		String email = sc.next();
		System.out.print("Enter password : ");
		String password = sc.next();
		try(UserDao userDao = new UserDao()) {
			String name = userDao.selectStudent(email, password);
			if(name == null) {
				System.out.println("Login Failed ! You may have entered wrong details");
				
			} else
				System.out.println("Login successful! Welcome " + name);
				StudentMenu.studentMenu(sc);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	
	}
}
