package hw4;

public class SynonymQuestion {

	private String word;
	private String[] options;
	private String answer;

	public SynonymQuestion(String word, String[] options, String answer) {
		this.word = word;
		this.options = options;
		this.answer = answer;
	}

	public String getWord() {
		return word;
	}

	public String[] getOptions() {
		return options;
	}
	
	public String getAnswer() {
		return answer;
	}
}