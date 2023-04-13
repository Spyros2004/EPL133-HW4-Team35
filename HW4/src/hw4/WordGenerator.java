package hw4;

import java.util.ArrayList;
import java.util.List;

public class WordGenerator {

	private String sentence;

	public WordGenerator(String sentence) {
		this.sentence = sentence;
	}

	public static List<String> getWords(String sentence) {
		WordGenerator words = new WordGenerator(sentence);
		return words.getWords();
	}

	public List<String> getWords() {
		String[] words = sentence.split("\\s+");
		List<String> wordList = new ArrayList<String>();
		for (String word : words) {
			wordList.add(word);
		}
		return wordList;
	}

}
