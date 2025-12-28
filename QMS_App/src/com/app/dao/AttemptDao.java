package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.util.DbUtil;
import com.app.model.Quiz;
import com.app.model.User;

public class AttemptDao implements AutoCloseable{
	Connection connection = null;
	
	public AttemptDao() throws SQLException {
		connection = DbUtil.getConnection();
	}
	
	public List<Quiz> selectQuiz(User student) throws SQLException{
		List<Quiz> quizList = new ArrayList<>();
		String sql = "select title from quizzes where quiz_id not in (select q.quiz_id from quizzes q inner join quiz_attempts a on q.quiz_id=a.quiz_id where a.student_id = ?)";
		try(PreparedStatement selectStatement = connection.prepareStatement(sql)){
			selectStatement.setInt(1, student.getId());
			ResultSet rs = selectStatement.executeQuery();
			while(rs.next()) {
				Quiz quiz = new Quiz();
				quiz.setTitle(rs.getString(1));
				quizList.add(quiz);
			}
			return quizList;
		}
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
