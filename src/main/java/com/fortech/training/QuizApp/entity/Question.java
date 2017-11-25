package com.fortech.training.QuizApp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
	      use = JsonTypeInfo.Id.NAME, 
	      include = JsonTypeInfo.As.PROPERTY, 
	      property = "type")
	    @JsonSubTypes({
	        @JsonSubTypes.Type(value = SingleChoice.class, name = "SingleChoice"),
	        @JsonSubTypes.Type(value = MultipleChoice.class, name = "MultipleChoice")
	    })
@Entity
@Table(name = "question")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "content")
	private String content;
	
	@Column(name = "type", insertable=false, updatable=false)
	private String type;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "question_id")
	private List<Choice> choices;
	
	public static final int MAX_NR_CHOICES = 8;

	public Question() {
		choices = new ArrayList<Choice>();
	}

	/**
	 * @param content
	 */
	public Question(String content) {
		this.content = content;
		choices = new ArrayList<Choice>();
	}

	/**
	 * @param id
	 * @param content
	 * @param choices
	 */
	public Question(int id, String content, List<Choice> choices) {
		this.id = id;
		this.content = content;
		this.choices = choices;
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
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	

	/**
	 * @return the choices
	 */
	public List<Choice> getChoices() {
		return choices;
	}

	/**
	 * @param choices the choices to set
	 */
	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Adds a choice to our list of choices if the choice is not null
	 * or empty, or we haven't reached the maximum number of choices,
	 * @param choice
	 * @param correct
	 * @return true is the choice was added
	 */
	public boolean addChoice(Choice choice) {
		if (choice == null || choice.getContent() == "") {
			return false;
		}
		if (this.getChoices().size() > MAX_NR_CHOICES) {
			return false;
		}
		this.getChoices().add(choice);
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Question [id=" + id + ", content=" + content + ", type=" + type + ", choices=" + choices + "]";
	}
	


}
