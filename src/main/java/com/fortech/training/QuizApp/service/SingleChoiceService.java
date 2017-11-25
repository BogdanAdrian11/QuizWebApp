package com.fortech.training.QuizApp.service;

import com.fortech.training.QuizApp.entity.SingleChoice;

public interface SingleChoiceService {

	/**
	 * Checks if we have one and only one correct choice
	 * @return if the single choice question is valid
	 */
	boolean isValid(SingleChoice singleChoice);
}
