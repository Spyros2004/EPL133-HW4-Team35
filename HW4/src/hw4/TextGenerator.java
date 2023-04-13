package hw4;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TextGenerator {

	private String fileName;

	public TextGenerator(String filename) {
		fileName = filename;
	}

	public String getText() throws FileNotFoundException {
		Scanner inputStream = new Scanner(new FileInputStream(fileName));
		StringBuilder text = new StringBuilder();
		while (inputStream.hasNextLine()) {
			String line = inputStream.nextLine();
			text.append(line);
		}
		return text.toString();
	}
}