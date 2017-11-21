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
@DiscriminatorValue("MultipleChoice")
public class MultipleChoice extends Question implements AutoCorrect{
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="question_id")
	private List<Choice> choices;

	public MultipleChoice() {
		
	}
	
	public MultipleChoice(String content) {
		super(content);
		choices = new ArrayList<Choice>();
	}
	
	/**
	 * Adds a choice to our list of choices if the choice is not null
	 * or empty, or we haven't reached the maximum number of choices,
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
	
	public boolean checkSolution(String solution) {
		for (int i = 0; i < solution.length(); i++) {
			int index = Integer.valueOf(solution.substring(i, i + 1));
			if (index < 0 || index >= choices.size()) {
				return false;
			}
			if (!choices.get(index).isCorrect()) {
				return false;
			}
		}
		for (int i = 0; i < choices.size(); i++) {
			if (choices.get(i).isCorrect() && !solution.contains(String.valueOf(i))) {
				return false;
			}
		}
		return true;
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
		return "Multiple Choice " + super.toString() + " [choices=" + choices + "]";
	}
}
