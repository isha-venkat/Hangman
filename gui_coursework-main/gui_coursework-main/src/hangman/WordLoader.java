package hangman;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// WordLoader class to load words from a file and provide a random word for the game. 
public class WordLoader {
	
	// Variable set to private to reduce coupling.
	private List<String> words_List; // List to store all the loaded words. 
	
	
	//Method to load words from the specified file. 
	private void loadWords(String filename) {
		
		// Try block attempts to read words from the specified file.
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words_List.add(line.trim());
            }
        } 
        
		// Catch block handles any IOException by printing the message. 
		catch (IOException e) {
            System.out.println("File does not exist.");
        }
    }
	
	
	// Constructor to initialize the WordLoader and load words from the file.
	public WordLoader(String filename) {
		words_List = new ArrayList<>(); // Initializing words_List as an ArrayList. 
		loadWords(filename); // Load words from the specified file. 
	}
	
	
	// Method to get a random word from the loaded words_List.
	// Method exhibits high cohesion - Retrieving random word. 
	public String getRandomWord() {
		
		// Condition to check if words_List is not empty or not.
		if (!words_List.isEmpty()) { 
            Random random = new Random(); 
            int index = random.nextInt(words_List.size()); // Generate a random index within the words_List size.
            return words_List.get(index); // Selects the word from the words_List with the random index.
        } 
        else { 
            return null; 
        }
    }
}
