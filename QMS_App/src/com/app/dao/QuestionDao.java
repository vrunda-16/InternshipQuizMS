package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.model.Question;
import com.app.util.DbUtil;

public class QuestionDao implements AutoCloseable {
	Connection connection = null ;
	
	public QuestionDao() throws SQLException {
		connection = DbUtil.getConnection();
	}
	
	public void insertQuestion(Question question) throws SQLException {
		
		String sql = "insert into questions(quiz_id , question_text , option_a , option_b , option_c ,option_d , correct_option) values(? ,? ,? ,? ,? ,? ,?)";
		
		try(PreparedStatement insertStatement = connection.prepareStatement(sql)){
			insertStatement.setInt(1, question.getQuizId());
			insertStatement.setString(2, question.getText());
			insertStatement.setString(3, question.getA());
			insertStatement.setString(4, question.getB());
			insertStatement.setString(5, question.getC());
			insertStatement.setString(6, question.getD());
			insertStatement.setString(7, String.valueOf(question.getCorrect()));
			insertStatement.executeUpdate();
		}
	}

	@Override
	public void close() throws Exception {
		if(connection != null) {
			connection.close();
			connection = null;
		}
		
	}
	
}