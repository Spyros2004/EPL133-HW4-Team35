package hw4;

import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;

/**
 * This Class is a Sentence Generator.
 * 
 * The generator returns a 2D {@link List} of Strings from a given text. The
 * lists consist of all the sentences with all of their words form the text.
 * 
 * @author ssachm02
 * @version 1.1
 * @since 24/04/23
 */
public class SentenceGenerator {

	/**
	 * This String is the text that the sentences are generated from.
	 * 
	 * @since 1.0
	 */
	private String text;

	/**
	 * This is the constructor for the SentenceGenerator Class.
	 *
	 * This constructor creates a new Sentence Generator.
	 * 
	 * @param text The text that will be split.
	 * 
	 * @since 1.0
	 */
	public SentenceGenerator(String text) {
		this.text = text;
	}

	/**
	 * This method is a static version of the {@link getSentenceLists()} method and
	 * it does the same thing.
	 *
	 * @param text The text that will be split into sentences.
	 *
	 * @return The sentence lists from the given text.
	 *
	 * @since 1.0
	 */
	public static List<List<String>> getSentenceLists(String text) {
		SentenceGenerator sentences = new SentenceGenerator(text);
		return sentences.getSentenceLists();
	}

	/**
	 * This method returns the 2D {@link List} of Strings that contains the
	 * sentences from the all of the text inside the given files.
	 * 
	 * The method gets a {@link List} of file names and then splits all of the text
	 * inside the files into sentence lists.
	 * 
	 * @param filenames A {@link List} with the name of the files.
	 *
	 * @return The sentence lists from the given text.
	 *
	 * @since 1.0
	 */
	public static List<List<String>> getSentenceListsFromFiles(List<String> filenames) {
		StringBuilder finalText = new StringBuilder();
		for (String filename : filenames) {
			try {
				TextGenerator text = new TextGenerator(filename);
				finalText.append(text.getText());
			} catch (FileNotFoundException e) {
				System.out.print("A file with the name " + filename + " does not exist.");
				System.exit(0);
			}
		}
		SentenceGenerator sentences = new SentenceGenerator(finalText.toString());
		return sentences.getSentenceLists();
	}

	/**
	 * This method returns the 2D {@link List} of Strings that contains the
	 * sentences from the given text.
	 * 
	 * The method firstly splits the text into sentences and then into words. A
	 * sentence is considered to ends only with "." or "!" or "?". The words are
	 * lower case and special characters are excluded.
	 *
	 * @return The word list from the given sentence.
	 *
	 * @since 1.0
	 */
	public List<List<String>> getSentenceLists() {
		String[] sentences = text.split("[.?!]+");
		List<List<String>> sentenceList = new ArrayList<List<String>>();
		for (String sentence : sentences) {
			if (!sentence.isBlank() && !sentence.isEmpty()) {
				WordGenerator words = new WordGenerator(sentence.trim());
				sentenceList.add(words.getWords());
			}
		}
		return sentenceList;
	}

}