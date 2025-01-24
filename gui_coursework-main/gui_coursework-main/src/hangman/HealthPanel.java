package hangman;

import javax.swing.*;
import java.awt.*;

// HealthPanel class to display the remaining lives of the player. 
public class HealthPanel extends JPanel{
	
	// Variables set to private to reduce coupling.
	private JLabel[] healthLabels;// Array to hold the labels of each life. 
	private int maxHealth; // Maximum lives. 
	private int currentHealth; // Current remaining lives. 

	// Constructor to initialize the HealthPanel.
	public HealthPanel(int maxLives) {
		maxHealth = maxLives;
		currentHealth = maxHealth;
		setLayout(new FlowLayout());
		healthLabels = new JLabel[maxHealth];// Initialize array for health labels. 
		
		Font emojiFontsize = new Font(Font.SANS_SERIF, Font.PLAIN,24);// Size for the health label emoji. 
		
		// Loop to add health labels to the panel. 
		for(int i=0; i<maxHealth; i++) {
			// Creating label with emoji and set font size and adding it to panel.
			healthLabels[i]= new JLabel("🔋️");
			healthLabels[i].setFont(emojiFontsize);
			add(healthLabels[i]);
		}	
	}
	
	// Method to remove a life from panel.
	// Method exhibits high cohesion - managing health label and GUI. 
	public void removeLife() {
		//Condition to check if there are remaining lives. 
		if (currentHealth>0) { 
			healthLabels[currentHealth-1].setText("🪫"); // Change icon when a life is lost. 
			currentHealth= currentHealth - 1; // Decrease current health count. 
		}
	}
	
	// Method to return current health. 
	// Method exhibits high cohesion.
	public int getCurrentHealth() {
		return currentHealth;
	}
	
	// Method to return max health.  
	// Method exhibits high cohesion.
	public int getMaxHealth() {
		return maxHealth;
	}
}
