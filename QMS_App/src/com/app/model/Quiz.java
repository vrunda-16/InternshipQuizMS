package com.app.model;

public class Quiz {
	public int id;
	public String title;
	public Integer createrId;
	
	public Quiz() {
		
	}

	public Quiz(int id, String title, Integer createrId) {
		super();
		this.id = id;
		this.title = title;
		this.createrId = createrId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getCreaterId() {
		return createrId;
	}

	public void setCreaterId(Integer createrId) {
		this.createrId = createrId;
	}

	@Override
	public String toString() {
		return "Quiz [id=" + id + ", title=" + title + ", createrId=" + createrId + "]";
	}
	
	
	
}
