package hw4;

import java.util.HashMap;
import java.util.List;

/**
 * The SemanticDescriptors class have one static method for creating semantic descriptors hashMap
 * for a given list of sentences.
 * @author kkypri06
 * @version 1.1
 * @since 20/04/23
 */
public class SemanticDescriptors {

	
	/**
	 * Creates semantic descriptors for a given list of sentences.
	 *
	 * @param sentences the list of sentences to create semantic descriptors for
	 * @return a hashMap of words that represents semantic descriptors
	 * @since 1.0
	 */
	public static HashMap<String, HashMap<String, Integer>> createSemanticDescriptors(List<List<String>> sentences) {
		HashMap<String, HashMap<String, Integer>> semanticDescriptors = new HashMap<String, HashMap<String, Integer>>();
		for (List<String> sentence : sentences) {
			for (String word : sentence) {
				// HashMap<String, Integer> innerHashMap = semanticDescriptors.getOrDefault(word, new HashMap<>());
				HashMap<String, Integer> innerHashMap = null;
				if (semanticDescriptors.containsKey(word))
					innerHashMap = semanticDescriptors.get(word);
				else
					innerHashMap = new HashMap<String, Integer>();
				for (String word2 : sentence) {
					if (!word2.equals(word)) {
						// innerHashMap.put(word2, innerHashMap.getOrDefault(word2, 0) + 1);
						if (innerHashMap.containsKey(word2))
							innerHashMap.put(word2, innerHashMap.get(word2) + 1);
						else
							innerHashMap.put(word2, 1);
					}
					semanticDescriptors.put(word, innerHashMap);
				}
			}
		}
		return semanticDescriptors;
	}

}
