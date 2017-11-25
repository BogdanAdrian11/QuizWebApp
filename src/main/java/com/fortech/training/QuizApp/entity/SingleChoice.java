package com.fortech.training.QuizApp.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SingleChoice")
public class SingleChoice extends Question {
	
	public SingleChoice() {
		this.setType("MultipleChoice");
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SingleChoice " + super.toString() + " [choices=" + this.getChoices() + "]";
	}
}
