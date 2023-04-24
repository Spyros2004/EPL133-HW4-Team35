package hw4;

import java.util.HashMap;

public class MostSimilarWord {

	public static String mostSimilarWord(String word, String[] choices, HashMap<String, HashMap<String, Integer>> semanticDescriptors) {
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

	private static double norm(HashMap<String, Integer> vector) {
		double sumOfSquares = 0;
		for (String simWord : vector.keySet()) {
			int x = vector.get(simWord);
			sumOfSquares += x * x;
		}
		return Math.sqrt(sumOfSquares);
	}
	
}
