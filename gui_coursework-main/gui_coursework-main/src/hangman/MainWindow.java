package hangman;

import javax.swing.*;
import java.awt.*;

//MainWindow class where all the components of the game are shown. 
public class MainWindow extends JFrame {
	
	// Variables set to private to reduce coupling.
	// Reference to all panels for its operations. 
    private HealthPanel healthPanel;
    private WordLoader wordLoader;
    private WordPanel wordPanel;
    private ButtonPanel buttonPanel;
    
    // Maximum number of lives for the game.
    private static final int MAX_LIVES = 6;

    // Constructor to initialize the main window. 
    public MainWindow() {
        // Set methods for the game display. 
    	setTitle("Hangman"); 
        setSize(400, 300); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(new BorderLayout()); 
        newGame(); // Calling method to start new game.
        setVisible(true); 
    }

    
    // Method to start a new game.
    // Method exhibits high cohesion - Setting up a new game. 
    private void newGame() {
    	// Initializing the panels and their position in the GUI. 
    	healthPanel = new HealthPanel(MAX_LIVES);
    	add(healthPanel, BorderLayout.NORTH);  

        // Loading a word from a text file from the given directory. 
    	wordLoader = new WordLoader("/Users/ishavenkat/git/gui_coursework/src/hangman/wordlist.txt");
        String randomWord = wordLoader.getRandomWord();
        
        wordPanel = new WordPanel(randomWord);
        add(wordPanel, BorderLayout.CENTER);

        buttonPanel = new ButtonPanel(wordPanel);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true); // To make the window visible. 
    }

    
    //Method to handle incorrect guesses. 
    public void handleIncorrectGuess() {
        healthPanel.removeLife();// Remove a life from health panel. 

        //Condition to check if the remaining lives reaches zero, display message and call promptPlayAgain.
        if (healthPanel.getCurrentHealth() <= 0) {
            JOptionPane.showMessageDialog(this, "Oops, you ran out of lives. The word was: " + wordPanel.getWord(), "Game Over :(", JOptionPane.ERROR_MESSAGE);
            promptPlayAgain();
        }
    }
    
    
    // Method to handle game won. 
    // Method exhibits high cohesion- Managing game state and flow. 
    public void handleGameWon() {
        JOptionPane.showMessageDialog(this, "Yay! Congratulations! You guessed the word correctly!", "Victory :)", JOptionPane.INFORMATION_MESSAGE);
        buttonPanel.resetButtons(); // Reset button visibility from button panel. 
        promptPlayAgain(); // Calling prompt to play again.
    }

    
    // Method to prompt user to play again or not.
    private void promptPlayAgain() {
        int option = JOptionPane.showConfirmDialog(this, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);
        // If yes then reset game or exit the game.
        if (option == JOptionPane.YES_OPTION) {
            // Calling method to reset the game.
            resetGame();
        } 
        else {
            System.exit(0); // Exiting the game. 
        }
    }

    
    // Method to reset the game. 
    private void resetGame() {
        getContentPane().removeAll(); // Removes all the components from the content panel.
        newGame(); // To start a new game.  
    }

}
