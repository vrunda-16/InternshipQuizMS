package com.app.dao;
import com.app.model.*;
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
	//Display quizzes to student
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
	//Take quiz(Attempt quiz)
	public List<Question> takeQuiz(String title) throws SQLException{
		List<Question> questionList=new ArrayList<>();
		
		String sql="select * from questions where quiz_id=(select quiz_id from quizzes where title=?)";
		try(PreparedStatement selectPreparedStatement=connection.prepareStatement(sql)){
			selectPreparedStatement.setString(1, title);
			ResultSet rs=selectPreparedStatement.executeQuery();
			while(rs.next()) {
				
				Question q=new Question();
				q.setQuizId(rs.getInt(2));
				q.setText(rs.getString(3));
				q.setA(rs.getString(4));
				q.setB(rs.getString(5));
				q.setC(rs.getString(6));
				q.setD(rs.getString(7));
				q.setCorrect(rs.getString(8).charAt(0));
				questionList.add(q);
			}
		}
		return questionList;
	}
	//Insert Attempted quiz to QuizAttempt table
	public void insertQuizAttempts(int quiz_id,int student_id,int final_score,int total_questions) throws SQLException {
		
		String sql="insert into quiz_attempts (quiz_id,student_id,final_score,total_questions) values(?,?,?,?)";
		try(PreparedStatement insertStatement=connection.prepareStatement(sql)){
			insertStatement.setInt(1,quiz_id);
			insertStatement.setInt(2,student_id);
			insertStatement.setInt(3,final_score);
			insertStatement.setInt(4,total_questions);
			insertStatement.executeUpdate();		
		}
		
	}
	//Display Quiz Score to Student
	public List<Object[]> displayScoreToStudent(int student_id) throws SQLException {
		
		List<Object[]> obj=new ArrayList<>();
		String sql="select qz.title,a.final_score,a.total_questions from quizzes qz inner join quiz_attempts a on qz.quiz_id=a.quiz_id where student_id=?";
		try(PreparedStatement selectPreparedStatement=connection.prepareStatement(sql)){
			selectPreparedStatement.setInt(1,student_id);
			ResultSet rs =selectPreparedStatement.executeQuery();
			while(rs.next()) {
				String title=rs.getString(1);
				int score=rs.getInt(2);
				int total_q=rs.getInt(3);
				obj.add(new Object[] {title,score,total_q});
			}
		}
		return obj;
	}
	
	//Display score to admin
	public List<Object[]> displayScoreToAdmin() throws SQLException{
		List<Object[]> obj=new ArrayList();
		String sql="select qz.title,a.student_id,a.final_score from quizzes qz inner join quiz_attempts a on qz.quiz_id=a.quiz_id";
		try(PreparedStatement selectsPreparedStatement = connection.prepareStatement(sql)){
			ResultSet rs = selectsPreparedStatement.executeQuery();
			
			while(rs.next()) {
				String title = rs.getString(1);
				int stud_id=rs.getInt(2);
				int score=rs.getInt(3);
				obj.add(new Object[] {title,stud_id,score});
			}
		}
		return obj;
	}
	
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
