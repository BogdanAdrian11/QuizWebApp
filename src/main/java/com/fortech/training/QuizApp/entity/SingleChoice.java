package com.fortech.training.QuizApp.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fortech.training.QuizApp.AutoCorrect;

@Entity
@DiscriminatorValue("SingleChoice")
public class SingleChoice extends Question implements AutoCorrect{
	
	public SingleChoice() {
		this.setType("MultipleChoice");
	}
	
	/**
	 * Adds a choice to our list of choices if the choice is not null
	 * or empty, or we haven't reached the maximum number of choices,
	 * or if this choice is the correct one and none other are correct
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
	
	/**
	 * Checks if we have one and only one correct choice
	 * @return if the single choice question is valid
	 */
	public boolean isValid() {
		boolean valid = false;
		
		for (Choice c : this.getChoices()) {
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
		if (index < 0 || index >= this.getChoices().size()) {
			return false;
		}
		if (this.getChoices().get(index).isCorrect()) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SingleChoice " + super.toString() + " [choices=" + this.getChoices() + "]";
	}
}
