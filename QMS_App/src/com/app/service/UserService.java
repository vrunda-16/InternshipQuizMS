package com.app.service;

import java.util.Scanner;
import java.sql.SQLException;
import java.util.Scanner;

import com.app.dao.UserDao;
import com.app.menu.AdminMenu;
import com.app.menu.StudentMenu;
import com.app.model.User;

public class UserService {
	
	public void adminLogin(Scanner sc) {
		System.out.print("Enter email : ");
		String email = sc.next();
		System.out.print("Enter password : ");
		String password = sc.next();
		try(UserDao userDao = new UserDao()) {
			int adminId = userDao.selectAdmin(email, password);
			if(adminId == 0) {
				System.out.println("Login Failed ! You may have entered wrong details");
				
			} else {
				System.out.println("Login successfull ! Welcome Admin");
				AdminMenu.adminMenu(sc , adminId);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}	
	
	public void studentRegister(Scanner sc) {
		User user = new User();
		System.out.print("Enter name :");
		user.setName(sc.next());
		System.out.print("Enter email :");
		user.setEmail(sc.next());
		System.out.print("Enter password :");
		user.setPassword(sc.next());
		try(UserDao userDao = new UserDao()){
			userDao.insertStudent(user);
			System.out.println("Student registered successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void studentLogin(Scanner sc) {
		User student = null;
		System.out.print("Enter email : ");
		String email = sc.next();
		System.out.print("Enter password : ");
		String password = sc.next();
		try(UserDao userDao = new UserDao()) {
			student = userDao.selectStudent(email, password);
			if(student == null) {
				System.out.println("Login Failed ! You may have entered wrong details");
				
			} else {
				System.out.println("Login successfull ! Welcome student...");
				StudentMenu.studentMenu(sc , student);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} 

	}
}
