package hw4;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
/**
 * The SynonymQuiz class represents a synonym quiz with a list of synonym questions.
 * @author kkypri06 Spyros...
 * @since 10/04/22
 *
 */
public class SynonymQuiz {

	private List<SynonymQuestion> questions;
	
	/**
	 * Constructs a new SynonymQuiz object from a given file. 
	 * Each line of the file contain a word followed by a list 
	 * of choices and then the answer (choices for the quiz). 
	 * @param filename the name of the file to read from
	 */
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

	
	/**
	 * Runs a similarity test on the quiz questions using MostSimilarWord and 
	 * the semantic descriptors we created at SemanticDescriptors.
	 * @param filename the name of the file to read the quiz questions from
	 * @param semantic_descriptors the HashMap of semantic descriptors to use in the similarity calculation
	 * @return the percentage of correct answers in the test
	 */
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
	
	
	/**
	 * Returns the SynonymQuestion object at the specified index in the quiz.
	 * @param index the index of the question to return
	 * @return the SynonymQuestion object at the specified index
	 */
	public SynonymQuestion getQueston(int index) {
		return questions.get(index);
	}

	
	/**
	 * Returns the number of questions in the quiz.
	 * @return the number of questions in the quiz
	 */
	public int getQuestionCount() {
		return questions.size();
	}

}