package hangman;

import java.awt.FlowLayout;
import javax.swing.*;

//WordPanel class to display the word to be guessed in the game. 
public class WordPanel extends JPanel {
	
	// Variables set to private to reduce coupling.
	private JLabel wordLabel; // Label to display the word. 
	private String word; // Word to the guessed. 

	// Constructor to initialize the WordPanel. 
	public WordPanel(String targetWord) {
		setLayout(new FlowLayout()); // Set layout as FlowLayout.

		this.word = targetWord; // Set the target word.
		wordLabel = new JLabel(maskWord(targetWord));
		add(wordLabel); // Add label to the panel. 
	}

	// Method to generate a masked version of the word to be guessed with underscores. 
	// Method exhibits high cohesion - masking the word to be guessed. 
	String maskWord(String word) {
		StringBuilder maskedWord = new StringBuilder();
		
		// Loop to append underscores and space for each letter in the word except last one. 
		for (int i = 0; i < word.length()-1; i++) {
			maskedWord.append("_ ");
		}
		
		if (word.length() > 0) { // Add last character without appending an underscore
	        maskedWord.append("_");
	    }

		return maskedWord.toString(); // Return masked word. 
	}
	
	// Method to set displayed word with masking. 
	public void setWord(String randomWord) {
        wordLabel.setText(maskWord(randomWord));
    }


	// Method to process a guessed letter. 
	// Method exhibits high cohesion - processing guessed letters. 
	public boolean guess(String letter) {
		boolean guessedCorrectly = false;
		StringBuilder updatedWord = new StringBuilder(wordLabel.getText());

		// Loop to check if the guessed letter is present in the word. 
		for (int i = 0; i < word.length(); i++) {
			if (Character.toLowerCase(letter.charAt(0)) == Character.toLowerCase(word.charAt(i))) {
				updatedWord.setCharAt(i * 2, word.charAt(i)); // Replace underscore with the guessed letter. 
				guessedCorrectly = true; // Setting guessed correctly to true. 
			}
		}

		wordLabel.setText(updatedWord.toString()); 
		return guessedCorrectly; // Return whether the guess was correct. 
	}

	// Method to check if the word is completely guessed. 
	// Method exhibits high cohesion - checking if word is guessed completely or not. 
	public boolean isWordGuessed() {
		return !wordLabel.getText().contains("_");
	}

	// Method to get the original word. 
	public String getWord() {
		return word;
	}

}
