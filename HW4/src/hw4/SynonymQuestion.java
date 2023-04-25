package hw4;

import java.util.List;

/**
 * This Class represents a Synonym Question.
 * 
 * The question consist of a word , a correct answer , and a list of choices.
 * 
 * @author ssachm02
 * @version 1.0
 * @since 24/04/23
 */

public class SynonymQuestion {

	/**
	 * This String is the word in the question.
	 * 
	 * @since 1.0
	 */
	private String word;
	/**
	 * The Strings in this String array are the choices in the question.
	 * 
	 * @since 1.0
	 */
	private String[] choices;
	/**
	 * This String is the answer to the question.
	 * 
	 * @since 1.0
	 */
	private String answer;

	/**
	 * This is the constructor for the SynonymQuestion Class.
	 *
	 * This constructor creates a new Synonym Question with the given Strings.
	 * 
	 * @param word    The word in the question
	 * @param choices The choices in the question
	 * @param answer  The answer to the question
	 * 
	 * @since 1.0
	 */
	public SynonymQuestion(String word, String[] choices, String answer) {
		this.word = word;
		this.choices = choices;
		this.answer = answer;
	}

	/**
	 * This method returns the word of the question
	 *
	 * @return The word.
	 *
	 * @since 1.0
	 */
	public String getWord() {
		return word;
	}

	/**
	 * This method returns the choices of the question
	 *
	 * @return The choices.
	 *
	 * @since 1.0
	 */
	public String[] getChoices() {
		return choices;
	}

	/**
	 * This method returns the answer to the question
	 *
	 * @return The answer.
	 *
	 * @since 1.0
	 */
	public String getAnswer() {
		return answer;
	}

}