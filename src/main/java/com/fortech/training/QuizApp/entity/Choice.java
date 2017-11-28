package com.fortech.training.QuizApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Choice")
public class Choice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="content")
	private String content;
	
	@Column(name="correct")
	private boolean correct;
	
	public Choice() {
		
	}
	/**
	 * @param content
	 * @param correct
	 */
	public Choice(String content, boolean correct) {
		super();
		this.content = content;
		this.correct = correct;
	}
	
	/**
	 * @return the correct
	 */
	public boolean isCorrect() {
		return correct;
	}
	
	/**
	 * @param correct the correct to set
	 */
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Choice [id=" + id + ", content=" + content + ", correct=" + correct + "]";
	}
	
}
