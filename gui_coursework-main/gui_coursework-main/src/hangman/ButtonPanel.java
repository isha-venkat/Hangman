package hangman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//ButtonPanel class to display the alphabet buttons in the game. 
public class ButtonPanel extends JPanel {
	
	// Variables set to private to reduce coupling.
	private WordPanel wordPanel; // Reference to the wordPanel for its functions. 
    private JButton[] letterButtons; // Array to hold alphabet buttons. 

    //Constructor to initialize the ButtonPanel. 
    public ButtonPanel(WordPanel wordPanel) {
        this.wordPanel = wordPanel; 

        setLayout(new GridLayout(3, 9)); // Set layout for the GUI. 
        letterButtons = new JButton[26]; // Initialize array for alphabet buttons. 

        // Loop for creating and adding alphabet buttons to the panel. 
        for (int i = 0; i < 26; i++) {
            char letter = (char) ('A' + i); // Calculate letter dynamically based on ASCII value. 

            JButton button = new JButton(String.valueOf(letter)); // Create button with letter label. 
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    guessedLetter(letter); // Calling guessedLetter() method when button is clicked. 
                    button.setEnabled(false); // Disable the button after it has been clicked.
                }
            });

            letterButtons[i] = button;  
            add(button); 
        }
    }

    // Method to guess a letter when a button is clicked.
    // Method exhibits high cohesion - Processing guessed letters. 
    private void guessedLetter(char letter) {
        
    	// Guess the letter and check if guessed correctly. 
    	boolean guessedCorrectly = wordPanel.guess(String.valueOf(letter));
        if (guessedCorrectly) {
        	// If word is guessed completely, handleGameWon() method is triggered in the MainWindow. 
        	if(wordPanel.isWordGuessed()) {
        		((MainWindow) SwingUtilities.getWindowAncestor(this)).handleGameWon();
        	}  
        } 	
        // If the guess is incorrect, handleIncorrectGuess()method is triggered in the MainWindow. 
        else {
                ((MainWindow) SwingUtilities.getWindowAncestor(this)).handleIncorrectGuess();            
        }
    }

    // Method to enable all buttons.
    // Method exhibits high cohesion - Managing button state. 
    public void enableAllButtons() {
        for (JButton button : letterButtons) {
            button.setEnabled(true); 
        }
    }

	// Method to reset all buttons to enabled state. 
    // Method exhibits high cohesion - Managing button state. 
    public void resetButtons() {
		for (JButton button : letterButtons) {
            button.setEnabled(true); 
        }
    }		
}
