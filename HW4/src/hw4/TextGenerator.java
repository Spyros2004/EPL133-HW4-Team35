package hw4;

import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * This Class is a Text Generator.
 * 
 * The generator returns a String that contains all the text inside the given
 * file.The file is read line by line and it is accessed by its name.
 * 
 * @author ssachm02
 * @version 1.0
 * @since 24/04/23
 */
public class TextGenerator {

	/**
	 * This String is the name of the file that the text will be generated from.
	 * 
	 * @since 1.0
	 */
	private String fileName;

	/**
	 * This is the constructor for the TextGenerator Class.
	 *
	 * This constructor creates a new Text Generator.
	 * 
	 * @param filename The name of the file that the text will be generated from.
	 * 
	 * @since 1.0
	 */
	public TextGenerator(String filename) {
		fileName = filename;
	}

	/**
	 * This method returns the a String that contains all the text inside the given
	 * file.
	 * 
	 * The text is read line by line.
	 * 
	 * @return The text from the given file.
	 * 
	 * @throws FileNotFoundException If the file cannot be found.
	 *
	 * @since 1.0
	 */
	public String getText() throws FileNotFoundException {
		Scanner inputStream = new Scanner(new FileInputStream(fileName));
		StringBuilder text = new StringBuilder();
		while (inputStream.hasNextLine()) {
			String line = inputStream.nextLine();
			text.append(line);
			text.append("\n");
		}
		inputStream.close();
		return text.toString();
	}

}
