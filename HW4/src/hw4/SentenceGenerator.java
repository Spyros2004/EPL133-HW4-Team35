package hw4;

import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;

public class SentenceGenerator {

	private String text;

	public SentenceGenerator(String text) {
		this.text = text;
	}

	public static List<List<String>> getSentenceLists(String text) {
		SentenceGenerator sentences = new SentenceGenerator(text);
		return sentences.getSentenceLists();
	}

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