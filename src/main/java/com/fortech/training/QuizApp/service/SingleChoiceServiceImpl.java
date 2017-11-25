package com.fortech.training.QuizApp.service;

import com.fortech.training.QuizApp.entity.Choice;
import com.fortech.training.QuizApp.entity.SingleChoice;

public class SingleChoiceServiceImpl implements SingleChoiceService {

	@Override
	/**
	 * Checks if we have one and only one correct choice
	 * @return if the single choice question is valid
	 */
	public boolean isValid(SingleChoice singleChoice) {
		boolean valid = false;
		
		for (Choice c : singleChoice.getChoices()) {
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

}
