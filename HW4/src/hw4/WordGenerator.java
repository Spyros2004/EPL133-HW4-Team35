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
			wordList.add(word.toLowerCase());
		return wordList;
	}

	public static void main(String[] args) {
		WordGenerator wg = new WordGenerator("He,llo   \"---th.is\" 	isn't!: a Test. sent;ence?");
		List<String> words = wg.getWords();
		System.out.println("He,llo   \"---th.is\" 	isn't!: a Test. sent;ence?\n");
		for (String word : words)
			System.out.println(word);
	}

}
