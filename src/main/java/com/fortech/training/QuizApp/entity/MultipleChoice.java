package com.fortech.training.QuizApp.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MultipleChoice")
public class MultipleChoice extends Question {
	
	public MultipleChoice() {
		this.setType("MultipleChoice");
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Multiple Choice " + super.toString() + " [choices=" + this.getChoices() + "]";
	}
}
