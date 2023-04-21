package hw4;

import java.util.HashMap;
import java.util.List;


public class SemanticDescriptors {

	
	public static HashMap<String, HashMap<String, Integer>> createSemanticDescriptors(List<List<String>> sentences) {

		HashMap<String, HashMap<String, Integer>> d = new HashMap<String, HashMap<String, Integer>>();
		for (List<String> sentence : sentences) {
			for (String word : sentence) {
			
//				HashMap<String, Integer> innerHashMap = d.getOrDefault(word, new HashMap<>());
				
				HashMap<String, Integer> innerHashMap = null;

				if (d.containsKey(word)) {
					innerHashMap = d.get(word);

				} else {
					innerHashMap = new HashMap<String, Integer>();
				}

				for (String word2 : sentence) {

					if(!word2.equals(word)) {	
					
//					innerHashMap.put(word2, innerHashMap.getOrDefault(word2, 0) + 1);

						if (innerHashMap.containsKey(word2)) {
							innerHashMap.put(word2, innerHashMap.get(word2) + 1);
						} 
						
						else
						innerHashMap.put(word2, 1);
					}
				}
				d.put(word, innerHashMap);
			}
		}
		
		return d;
	}
	 public static void main(String[] args) {
		 
		 System.out.println(createSemanticDescriptors(SentenceGenerator.getSentenceLists("I am a sick man. I am a spiteful man. I am an unattractive man. I believe my liver is diseased.However, I know nothing at all about my disease, and do not know for certain what ails me.")).toString());

	 }
}


