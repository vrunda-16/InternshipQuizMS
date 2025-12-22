package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.model.Quiz;
import com.app.util.DbUtil;

public class QuizDao implements AutoCloseable {
	
	Connection connection = null;
	
	public QuizDao() throws SQLException {
		connection = DbUtil.getConnection();
	}
	
	public int insertQuiz(String title , int adminId) throws SQLException {
		int quizId = 0;
		String sql = "insert into quizzes(title , creator_id) values(? , ?)";
		try(PreparedStatement insertStatement = connection.prepareStatement(sql , java.sql.Statement.RETURN_GENERATED_KEYS)){
			insertStatement.setString(1, title);
			insertStatement.setInt(2, adminId);
			insertStatement.executeUpdate();
			
			ResultSet rs = insertStatement.getGeneratedKeys();
			if(rs.next()) {
				quizId = rs.getInt(1);
			}
		}
		return quizId;
	}
	
	public List<Quiz> viewQuiz() throws SQLException{
		
		List<Quiz> quizList = new ArrayList<>();
		String sql = "SELECT title FROM quizzes";
		try(PreparedStatement selectStatement = connection.prepareStatement(sql)){
			ResultSet rs = selectStatement.executeQuery();
			while(rs.next()) {
				Quiz quiz = new Quiz();
				quiz.setTitle(rs.getString(1));
				quizList.add(quiz);
			}
		}
		return quizList;
			
	}

	@Override
	public void close() throws Exception {
		if(connection != null) {
			connection.close();
			connection = null;
		}
		
	}

}
