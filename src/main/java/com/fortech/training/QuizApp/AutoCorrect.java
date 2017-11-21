package com.fortech.training.QuizApp;

public interface AutoCorrect {
	public static final int MAX_NR_CHOICES = 8;
	
	/**
	 * Checks if the given solution is the right one
	 * The solution to be checked is given as a list of chars
	 * representing choices
	 * @param solution
	 * @return true if the solution is correct
	 */
	public boolean checkSolution(String solution);
}
