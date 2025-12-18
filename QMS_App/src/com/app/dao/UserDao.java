package com.app.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.app.util.DbUtil;

public class UserDao implements AutoCloseable{
	Connection connection = null;
	
	public UserDao() throws SQLException {
		connection = DbUtil.getConnection();
	}
	
	public String selectAdmin(String email , String password) {
		String name = null ;
		
		
		return name;
	}
	
	public void insertStudent(String name ,String email , String password) {
		
	}
	
	public String selectStudent(String email , String password) {
		String name = null ;
		
		
		return name;
	}

	@Override
	public void close() throws Exception {
		if(connection != null) {
			connection.close();
			connection = null;
		}
		
	}

}
