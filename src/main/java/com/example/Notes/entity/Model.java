package com.example.Notes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Store")
public class Model {
	@Id
	private int id;
	@Column
	private String title;
	@Column
    private String content;
	public Model() {
		super();
	}
	public Model(int ID,String Title,String Content)
	{
		this.id=ID;
		this.title=Title;
		this.content=Content;
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
	@Override
	public String toString() {
		return "Model [id=" + id + ", title=" + title + ", content=" + content + "]";
	}
}
