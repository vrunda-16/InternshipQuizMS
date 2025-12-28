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
	public int removeQuiz(int quizId) throws SQLException {
		int result = 0;
		String sql = "delete q from questions q inner join quizzes qz on q.quiz_id = qz.quiz_id where q.quiz_id = ?";
		try(PreparedStatement removeStatement = connection.prepareStatement(sql)){
			removeStatement.setInt(1, quizId);
			removeStatement.executeUpdate();
			String sql1 = "delete from quizzes where quiz_id = ?";
			try(PreparedStatement removeStatement2 = connection.prepareStatement(sql1 , java.sql.Statement.RETURN_GENERATED_KEYS)){
				removeStatement2.setInt(1, quizId);
				result = removeStatement2.executeUpdate();
			}
		}
		return result;
	}
	public List<Quiz> viewQuiz() throws SQLException{
		
		List<Quiz> quizList = new ArrayList<>();
		String sql = "SELECT * FROM quizzes";
		try(PreparedStatement selectStatement = connection.prepareStatement(sql)){
			ResultSet rs = selectStatement.executeQuery();
			while(rs.next()) {
				Quiz quiz = new Quiz();
				quiz.setId(rs.getInt(1));
				quiz.setTitle(rs.getString(2));
				quiz.setCreaterId(rs.getInt(3));
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
