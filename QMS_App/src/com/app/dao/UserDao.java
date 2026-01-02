package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.model.User;
import com.app.util.DbUtil;

public class UserDao implements AutoCloseable{
	Connection connection = null;
	
	public UserDao() throws SQLException {
		connection = DbUtil.getConnection();
	}
	
	public int selectAdmin(String email , String password) throws SQLException {
		String sql = "SELECT * FROM users WHERE email = ? AND password_hash = ? AND role = ?";

		try(PreparedStatement selectStatement = connection.prepareStatement(sql)){
			selectStatement.setString(1, email);
			selectStatement.setString(2, password);
			selectStatement.setString(3, "ADMIN");
			ResultSet rs = selectStatement.executeQuery();
			
			if(rs.next()) {
				int adminId = rs.getInt(1);
				return adminId;
			}
		}
		return 0;
	}
	
	public void insertStudent(User user) throws SQLException {
		
		String sql="insert into users(name , email , password_hash , role) values(?,?,?,?)";
		try(PreparedStatement insertStatement = connection.prepareStatement(sql)){
			insertStatement.setString(1, user.getName());
			insertStatement.setString(2, user.getEmail());
			insertStatement.setString(3, user.getPassword());
			insertStatement.setString(4, "Student");
			insertStatement.executeUpdate();
			
			
		}
		
	}
	
	public int selectStudent(String email , String password) throws SQLException{
		String sql = "SELECT * FROM users WHERE email = ? AND password_hash = ? AND role = ?";

		try(PreparedStatement selectStatement = connection.prepareStatement(sql)){
			selectStatement.setString(1, email);
			selectStatement.setString(2, password);
			selectStatement.setString(3, "STUDENT");
			ResultSet rs = selectStatement.executeQuery();
			
			if(rs.next()) {
				int studentId = rs.getInt(1);
				return studentId;
			}
		}
		return 0;
	}

	@Override
	public void close() throws Exception {
		if(connection != null) {
			connection.close();
			connection = null;
		}
		
	}

}
