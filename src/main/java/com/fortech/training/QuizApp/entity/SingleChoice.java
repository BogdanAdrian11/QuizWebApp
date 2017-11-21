package com.fortech.training.QuizApp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fortech.training.QuizApp.AutoCorrect;

@Entity
@DiscriminatorValue("SingleChoice")
public class SingleChoice extends Question implements AutoCorrect{
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="question_id")
	private List<Choice> choices;
	
	public SingleChoice() {
		
	}
	
	public SingleChoice(String content) {
		super(content);
		choices = new ArrayList<Choice>();
	}
	/**
	 * Adds a choice to our list of choices if the choice is not null
	 * or empty, or we haven't reached the maximum number of choices,
	 * or if this choice is the correct one and none other are correct
	 * @param choice
	 * @param correct
	 * @return true is the choice was added
	 */
	public boolean addChoice(String choice, boolean correct) {
		if (choice == null || choice == "") {
			return false;
		}
		if (choices.size() > MAX_NR_CHOICES) {
			return false;
		}
		if (correct) {
			for (Choice c : choices) {
				if (c.isCorrect()) {
					return false;
				}
			}
		}
		choices.add(new Choice(choice, correct));
		return true;
	}
	
	public boolean addChoice(Choice choice) {
		if (choice == null || choice.getContent() == "") {
			return false;
		}
		if (choices.size() > MAX_NR_CHOICES) {
			return false;
		}
		choices.add(choice);
		return true;
	}
	
	/**
	 * Checks if we have one and only one correct choice
	 * @return if the single choice question is valid
	 */
	public boolean isValid() {
		boolean valid = false;
		
		for (Choice c : choices) {
			if (c.isCorrect()) {
				if (!valid) {
					valid = true;
				} else {
					return false;
				}
				
			}
		}
		return valid;
	}

	public boolean checkSolution(String solution) {
		if (solution.length() != 1) {
			return false;
		}
		int index = Integer.valueOf(solution.substring(0, 1));
		if (index < 0 || index >= choices.size()) {
			return false;
		}
		if (choices.get(index).isCorrect()) {
			return true;
		}
		return false;
	}
	
	
	
	public List<Choice> getChoices() {
		return choices;
	}

	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SingleChoice " + super.toString() + " [choices=" + choices + "]";
	}
}
