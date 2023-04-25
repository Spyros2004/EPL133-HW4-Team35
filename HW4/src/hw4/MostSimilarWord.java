package hw4;

import java.util.HashMap;

/**
 * The MostSimilarWord class have two methods to find the most similar word to a
 * specific word for a hashMap with other words.
 * 
 * @author kkypri06
 * @version 1.1
 * @since 20/04/23
 */
public class MostSimilarWord {

	/**
	 * Finds the most similar word to the given word among a list of choices based
	 * on their semantic descriptors.
	 *
	 * @param word                the word to find the most similar word for
	 * @param choices             the list of words to choose from
	 * @param semanticDescriptors the map of semantic descriptors for each word
	 * @return the most similar word in the choices list, or "-1" if the given word
	 *         is not in the semantic descriptors map
	 * @since 1.0
	 */
	public static String mostSimilarWord(String word, String[] choices,
			HashMap<String, HashMap<String, Integer>> semanticDescriptors) {
		double max = 0;
		int asnwerIndex = 0;
		HashMap<String, Integer> wordVector = semanticDescriptors.get(word);
		if (wordVector == null)
			return "-1";
		for (int i = 0; i < choices.length; i++) {
			HashMap<String, Integer> choiceVector = semanticDescriptors.get(choices[i]);
			double sim = -1;
			if (choiceVector != null) {
				for (String simWord : wordVector.keySet()) {
					if (choiceVector.containsKey(simWord)) {
						int n = wordVector.get(simWord);
						int m = choiceVector.get(simWord);
						sim += m * n;
					}
				}
				sim /= norm(wordVector) * norm(choiceVector);
				if (sim > max) {
					max = sim;
					asnwerIndex = i;
				}
			}
		}
		return choices[asnwerIndex];
	}

	/**
	 * Calculates the norm of the given vector.
	 *
	 * @param vector the vector to calculate the norm for
	 * @return the norm of the vector
	 * @since 1.0
	 */
	private static double norm(HashMap<String, Integer> vector) {
		double sumOfSquares = 0;
		for (String simWord : vector.keySet()) {
			int x = vector.get(simWord);
			sumOfSquares += x * x;
		}
		return Math.sqrt(sumOfSquares);
	}

}
