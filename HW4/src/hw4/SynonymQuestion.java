package hw4;

public class SynonymQuestion {

	private String word;
	private String[] choices;
	private String answer;

	public SynonymQuestion(String word, String[] options, String answer) {
		this.word = word;
		this.choices = options;
		this.answer = answer;
	}

	public String getWord() {
		return word;
	}

	public String[] getChoices() {
		return choices;
	}

	public String getAnswer() {
		return answer;
	}
	
}