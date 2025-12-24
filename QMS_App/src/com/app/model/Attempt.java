package com.app.model;

import java.time.LocalDateTime;

<<<<<<< HEAD
//Attempt pojo class
=======
>>>>>>> 910c8ec (Attempt model added)
public class Attempt {
	
	public int id;
	public int quizId;
	public int studentId;
	public int score;
	public int total;
	public LocalDateTime attemptTime;
	
	
	public Attempt() {
		
	}

	public Attempt(int id, int quizId, int studentId, int score, int total, LocalDateTime attemptTime) {
		
		this.id = id;
		this.quizId = quizId;
		this.studentId = studentId;
		this.score = score;
		this.total = total;
		this.attemptTime = attemptTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public LocalDateTime getAttemptTime() {
		return attemptTime;
	}

	public void setAttemptTime(LocalDateTime attemptTime) {
		this.attemptTime = attemptTime;
	}

	@Override
	public String toString() {
		return "Attempt [id=" + id + ", quizId=" + quizId + ", studentId=" + studentId + ", score=" + score + ", total="
				+ total + ", attemptTime=" + attemptTime + "]";
	}

}
