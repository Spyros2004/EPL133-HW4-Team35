package hw4;

import java.util.ArrayList;
import java.util.List;

/**
 * This Class is a Word Generator.
 * 
 * The generator returns a {@link List} of Strings from a given sentence. The
 * list consist of all the words inside the sentence.
 * 
 * @author ssachm02
 * @version 1.1
 * @since 24/04/23
 */
public class WordGenerator {

	/**
	 * This String is the sentence that the words are generated from.
	 * 
	 * @since 1.0
	 */
	private String sentence;

	/**
	 * This is the constructor for the WordGenerator Class.
	 *
	 * This constructor creates a new Word Generator.
	 * 
	 * @param sentence The sentence that will be split.
	 * 
	 * @since 1.0
	 */
	public WordGenerator(String sentence) {
		this.sentence = sentence;
	}

	/**
	 * This method returns the {@link List} of Strings that contains the words
	 * inside the the given sentence.
	 * 
	 * The method splits the sentence into words. A. The words are lower case and
	 * special characters are excluded.
	 * 
	 * The sentence is split into words using these as a delimiter : any white
	 * space,"-",":",";",",","\".
	 *
	 * @return The sentence lists from the given text.
	 *
	 * @since 1.0
	 */
	public List<String> getWords() {
		String[] words = sentence.split("[\\s,-:;'.\"]+");
		List<String> wordList = new ArrayList<String>();
		for (String word : words)
			if (!word.isBlank() && !word.isEmpty())
				wordList.add(word.toLowerCase());
		return wordList;
	}

}