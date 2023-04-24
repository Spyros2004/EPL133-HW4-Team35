package hw4;

import java.util.HashMap;
import java.util.List;

public class SemanticDescriptors {

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
