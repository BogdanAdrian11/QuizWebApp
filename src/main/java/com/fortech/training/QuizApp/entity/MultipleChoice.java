package com.fortech.training.QuizApp.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fortech.training.QuizApp.AutoCorrect;

@Entity
@DiscriminatorValue("MultipleChoice")
public class MultipleChoice extends Question implements AutoCorrect{
	
	public MultipleChoice() {
		this.setType("MultipleChoice");
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
	
	public boolean checkSolution(String solution) {
		for (int i = 0; i < solution.length(); i++) {
			int index = Integer.valueOf(solution.substring(i, i + 1));
			if (index < 0 || index >= this.getChoices().size()) {
				return false;
			}
			if (!this.getChoices().get(index).isCorrect()) {
				return false;
			}
		}
		for (int i = 0; i < this.getChoices().size(); i++) {
			if (this.getChoices().get(i).isCorrect() && !solution.contains(String.valueOf(i))) {
				return false;
			}
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Multiple Choice " + super.toString() + " [choices=" + this.getChoices() + "]";
	}
}
