package hangman;
	
import javax.swing.SwingUtilities;
		
// Main class.
public class Run {	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(MainWindow::new);			
	}	
}
