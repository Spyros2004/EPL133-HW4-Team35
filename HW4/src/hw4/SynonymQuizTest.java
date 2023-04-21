package hw4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.FileNotFoundException;

public class SynonymQuizTest {

	public static void main(String[] args) throws FileNotFoundException {
		List<String> filenames = new ArrayList<String>();
		filenames.add("C:\\users\\spyro\\Desktop\\pg2600.txt");
		filenames.add("C:\\users\\spyro\\Desktop\\pg7178.txt");
		filenames.add("C:\\users\\spyro\\Desktop\\brown-train-sentences.txt");
		List<List<String>> sentences = SentenceGenerator.getSentenceListsFromFiles(filenames);
		HashMap<String, HashMap<String, Integer>> semantic_descriptors = SemanticDescriptors
				.createSemanticDescriptors(sentences);
		double a = SynonymQuiz.runSimilarityTest("C:\\users\\spyro\\Desktop\\Test.txt", semantic_descriptors);
		System.out.println(a);
		
	}

}
