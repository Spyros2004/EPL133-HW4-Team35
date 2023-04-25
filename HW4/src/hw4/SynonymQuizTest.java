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
		filenames.add("C:\\users\\spyro\\Desktop\\pg2600.txt");
		filenames.add("C:\\users\\spyro\\Desktop\\pg7178.txt");
		filenames.add("C:\\users\\spyro\\Desktop\\brown-train-sentences.txt");
		List<List<String>> sentences = SentenceGenerator.getSentenceListsFromFiles(filenames);
		HashMap<String, HashMap<String, Integer>> semanticDescriptors = SemanticDescriptors
				.createSemanticDescriptors(sentences);
		double a = SynonymQuiz.runSimilarityTest("C:\\users\\spyro\\Desktop\\questions.txt", semanticDescriptors);
		System.out.println("Success rate: " + a);
	}

}
