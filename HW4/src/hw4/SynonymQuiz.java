package hw4;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;

public class SynonymQuiz {

	private List<SynonymQuestion> questions;

	public SynonymQuiz(String filename) {
		questions = new ArrayList<SynonymQuestion>();
		TextGenerator fileText = new TextGenerator(filename);
		String[] text = null;
		try {
			text = fileText.getText().split("\n");
		} catch (FileNotFoundException e) {
			System.out.print("A file with the name " + filename + " does not exist.");
			System.exit(0);
		}
		for (String line : text) {
			List<String> words = new WordGenerator(line).getWords();
			List<String> choices = new ArrayList<String>();
			String word = words.get(0);
			String answer = words.get(1);
			for (int i = 2; i < words.size(); i++)
				choices.add(words.get(i));
			questions.add(new SynonymQuestion(word, choices.toArray(new String[choices.size()]), answer));
		}
	}

	public static double runSimilarityTest(String filename,
			HashMap<String, HashMap<String, Integer>> semantic_descriptors) {
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileOutputStream("Answers.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Error opening the file Answers.txt.");
			System.exit(0);
		}
		SynonymQuiz quiz = new SynonymQuiz(filename);
		int counter = 0;
		for (int i = 0; i < quiz.getQuestionCount(); i++) {
			SynonymQuestion question = quiz.getQueston(i);
			String answer = MostSimilarWord.mostSimilarWord(question.getWord(), question.getChoices(),
					semantic_descriptors);
			outputStream.println("Answer for question " + (i + 1) + " : " + answer);
			if (answer.equals(question.getAnswer()))
				counter++;
		}
		outputStream.close();
		double percentage = (double) counter / quiz.getQuestionCount();
		return percentage;
	}

	public SynonymQuestion getQueston(int index) {
		return questions.get(index);
	}

	public int getQuestionCount() {
		return questions.size();
	}

}