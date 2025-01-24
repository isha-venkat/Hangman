### Hangman Game (GUI Version)
### Overview
This is a graphical user interface (GUI) version of the classic word-guessing game, Hangman. The player must guess a randomly selected word, one letter at a time, within a limited number of incorrect guesses. If the player guesses all the letters of the word before running out of guesses, they win the game. If they reach the maximum incorrect guesses allowed, they lose.

The game is implemented in Java, using the Swing framework for the GUI. The word list is loaded from a file, and the user interacts with the game through various panels and buttons.

### Features
### Mandatory Features:
. Word Selection: A random word is picked from a word list loaded at startup.
. Game Interface:
. Display of the word being guessed, with placeholders for unguessed letters (e.g., underscores or dashes).
. Letter buttons that players click to guess, which become disabled after being used.
. A visual indicator showing how many incorrect guesses remain before the player loses.
### Game Logic:
. A player wins by guessing the word correctly within the allowed number of incorrect guesses.
. If the player loses, the word is revealed.
. The player is prompted to play again after a win or loss.
### File Handling: The game reads a list of words from a file (one word per line).
### GUI Design: The interface consists of three main panels:
. HealthPanel: Displays the number of incorrect guesses and the remaining attempts.
. ButtonPanel: Contains buttons for all letters of the English alphabet, which become disabled after being guessed.
. WordPanel: Displays the word to be guessed, revealing correctly guessed letters.

### Optional Features:
. Allow the player to change the number of incorrect guesses allowed before losing.
. Support for multiple word lists.
. Language support for multiple languages.
. Multiplayer mode.

### Installation
1. Clone this repository to your local machine.
   ```bash
   git clone https://github.com/isha-venkat/Hangman
2. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA, Eclipse).
3. Build and run the Run class, which contains the main method for launching the application.

### Usage
. The game will start immediately when the program is run.
. The player will be presented with a word consisting of underscores (one for each letter).
. The player clicks on the letter buttons to make guesses.
. If a guess is correct, the corresponding underscores are replaced by the guessed letter.
. If a guess is incorrect, the number of remaining incorrect guesses decreases.
. The game ends when the player either guesses the word correctly or runs out of guesses.

### Win/Loss:
. Win: The player correctly guesses all the letters of the word before using up all incorrect guesses.
. Loss: The player reaches the limit of incorrect guesses without guessing the word.
After each round, the player will be asked if they want to play again.

### Code Structure
. MainWindow.java: The main game window where all components are displayed.
. HealthPanel.java: Displays the number of incorrect guesses and the remaining attempts.
. WordPanel.java: Displays the word to be guessed and handles updates when the player guesses a letter.
. ButtonPanel.java: Displays 26 buttons for each letter of the alphabet, which get disabled after being guessed.
. Run.java: The entry point for launching the game.

### Contributing
This is a coursework project, and contributions are not currently being accepted. If you wish to implement additional features or improvements, feel free to fork this repository.

### License
This project is for educational purposes and is not licensed for commercial use.

### Acknowledgments
. Word lists used in this project were sourced from eslgrammar.org and GitHub.
. Swing and JavaFX libraries were used for creating the graphical user interface.
