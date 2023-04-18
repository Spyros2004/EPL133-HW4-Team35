package hw4;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SynonymQuiz {

	private List<SynonymQuestion> questions;

	public SynonymQuiz(String filename) {
		questions = new ArrayList<SynonymQuestion>();
		TextGenerator text = new TextGenerator(filename);
		StringTokenizer textTokenizer = null;
		try {
			textTokenizer = new StringTokenizer(text.getText(), "\n");
		} catch (FileNotFoundException e) {
			System.out.print("A file with the name " + filename + " does not exist.");
			System.exit(0);
		}
		while (textTokenizer.hasMoreTokens()) {
			String line = textTokenizer.nextToken();
			StringTokenizer lineTokenizer = new StringTokenizer(line, " ");
			String word = lineTokenizer.nextToken();
			String answer = lineTokenizer.nextToken();
			String[] options = { lineTokenizer.nextToken(), lineTokenizer.nextToken(), lineTokenizer.nextToken() };
			questions.add(new SynonymQuestion(word, options, answer));
		}
	}

	public SynonymQuestion getQueston(int index) {
		return questions.get(index);
	}

	public int getQuestionCount() {
		return questions.size();
	}

	public static void main(String[] args) {
		SynonymQuiz quiz = new SynonymQuiz("C:\\Users\\spyro\\Desktop\\Test.txt");
		for (int i = 0; i < quiz.getQuestionCount(); i++) {
			System.out.print(quiz.getQueston(i).getWord() + " " + quiz.getQueston(i).getAnswer() + " ");
			for (String word : quiz.getQueston(i).getOptions())
				System.out.print(word + " ");
			System.out.println();
		}
	}
}