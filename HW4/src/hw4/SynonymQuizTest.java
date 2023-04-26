package hw4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This is a Test class for the {@link hw4} package.
 * 
 * @author ssachm02 , kkypri06
 * @version 1.0
 * @since 24/04/23
 */
public class SynonymQuizTest {

	/**
	 * This is the main class.
	 * 
	 * @param args Command line arguments.
	 */
	public static void main(String[] args) {
		List<String> filenames = new ArrayList<String>();
		filenames.add("pg2600.txt");
		filenames.add("pg7178.txt");
		filenames.add("brown-train-sentences.txt");
		List<List<String>> sentences = SentenceGenerator.getSentenceListsFromFiles(filenames);
		HashMap<String, HashMap<String, Integer>> semanticDescriptors = SemanticDescriptors
				.createSemanticDescriptors(sentences);
		SynonymQuiz.runSimilarityTest("questions.txt", semanticDescriptors);
	}

}
