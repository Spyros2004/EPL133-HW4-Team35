package hw4;

import java.util.HashMap;

public class MostSimilarWord {

	public static String most_similar_word(String word, String[] choices,
			HashMap<String, HashMap<String, Integer>> semantic_descriptors) {

		double sim = 0.0;
		double max = 0.0;
		int asnwer_i = 0;

		HashMap<String, Integer> wordVector = semantic_descriptors.get(word);

		if (wordVector == null)
			return "-1";

		for (int i = 0; i < choices.length; i++) {

			HashMap<String, Integer> choiceVector = semantic_descriptors.get(choices[i]);

			if (choiceVector == null)
				return "-1";

			for (String simWord : wordVector.keySet()) {
				if (choiceVector.containsKey(simWord)) {
					int n = wordVector.get(simWord);
					int m = choiceVector.get(simWord);
					sim += m * n;

				}
			}
			sim = sim / (norm(wordVector) * norm(choiceVector));
			if (sim > max) {
				max = sim;
				asnwer_i = i;
			}

		}
		return choices[asnwer_i];
	}

	private static double norm(HashMap<String, Integer> vector) {
		double sum_of_squares = 0.0;

		for (String simWord : vector.keySet()) {
			int x = vector.get(simWord);
			sum_of_squares += x * x;
		}
		return Math.sqrt(sum_of_squares);
	}
}
