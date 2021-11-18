package com.entities;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notes")
public class NoteTaker {
	@Id
	private int id;
	@Column(length = 200)
	private String title;
	@Column(length = 3000)
	private String content;
	private Date addedDate;
	
	
	public NoteTaker() {
		super();
		// TODO Auto-generated constructor stub
	}


	public NoteTaker( String title, String content, Date addedDate) {
		super();
		this.id = new Random().nextInt(1000000);
		this.title = title;
		this.content = content;
		this.addedDate = addedDate;
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


	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}


	public Date getAddedDate() {
		return addedDate;
	}
	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}
	
	

}
