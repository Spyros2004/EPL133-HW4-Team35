package hw4;

import java.util.ArrayList;
import java.util.List;

public class SentenceGenerator {

	private String text;

	public SentenceGenerator(String text) {
		this.text = text;
	}

	public static List<List<String>> getSentenceLists(String text) {
		SentenceGenerator sentences = new SentenceGenerator(text);
		return sentences.getSentenceLists();
	}

	public List<List<String>> getSentenceLists() {
		String[] sentences = text.split(".");
		List<List<String>> sentenceList = new ArrayList<List<String>>();
		for (String sentence : sentences) {
			sentenceList.add(WordGenerator.getWords(sentence));
		}
		return sentenceList;
	}
}
