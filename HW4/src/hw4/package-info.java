package hw4;

/**
 * This package contains the necessary classes to run make a program answer the
 * questions in a synonym quiz. The program first needs to get trained with a
 * lot of text. After that it can answer synonym questions based on an algorithm
 * that uses semantic descriptor vectors to find the most likely synonym.
 * 
 * The package contains 8 classes: {@link MostSimilarWord}
 * ,{@link SemanticDescriptors},
 * {@link SentenceGenerator},{@link SysnonymQueston},{@link SysnonymQuiz},{@link TextGenerator},{@link WordGenerator},
 * and the test class {@link SysnonymQuizTest}.
 *
 * The class {@link MostSimilarWord} uses semantic descriptors to find the
 * likely synonym of a word from a list of choices. The synonym is picked based
 * on what word from the choices appears in similar sentences with the question
 * word.
 * 
 * The class {@link SemanticDescriptors} creates a 2D Hash map with the semantic
 * descriptors from a a list of sentences.
 * 
 * The class {@link SentenceGenerator} creates a list of sentences, each of
 * which contains a list of the words inside the sentences.
 * 
 * The class {@link SysnonymQueston} represents a question in a synonym quiz and
 * contains a question word,the answer and the list of choices.
 * 
 * The class {@link SysnonymQuiz} represents a synonym quiz and contains synonym
 * questions.
 * 
 * The class {@link TexteGenerator} returns the text from inside a file.
 * 
 * The class {@link WordGenerator} creates a list of words form a sentence.
 * 
 */