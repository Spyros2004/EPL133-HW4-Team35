package hw4;

import java.util.ArrayList;
import java.util.List;

public class WordGenerator {

	private String sentence;

	public WordGenerator(String sentence) {
		this.sentence = sentence;
	}

	public List<String> getWords() {
		String[] words = sentence.split("[\\s,-:;!?'.\"]+");
		List<String> wordList = new ArrayList<String>();
		for (String word : words)
			if (!word.equals(""))
				wordList.add(word.toLowerCase());
		return wordList;
	}
}