package Core;

import Constants.Drawer;
import Constants.Messages;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Hangman {
    private static final int ATTEMPTS_ALLOWED = 10;
    private String word;
    private List<String> lettersUsed;
    private StringBuilder displayWord;
    private Scanner scanner;
    private Locale locale = null;
    HangmanLocal hangmanLocal;

    /**
     * Initialize the variables.
     */
    public void start() {
        word = new WordGenerator().generate();
        lettersUsed = new ArrayList<>();
        scanner = BeanFactory.getScanner();
        initializeDisplayWord();
        hangmanLocal = BeanFactory.getHangmanBean();

        begin();
        verifyWord();
    }

    /**
     * Verify if user guessed the word correctly and display appropriate message.
     */
    private void verifyWord() {
        if (word.equals(displayWord.toString())) {
            HangmanDrawer.getInstance().display(Drawer.WINNER);
            hangmanLocal.display(Messages.YOU_WIN, locale);
        } else {
            hangmanLocal.display(Messages.YOU_LOSE, locale);
        }
    }

    /**
     * Begin Hangman game.
     */
    private void begin() {
        int attempts = 1;
        hangmanLocal.display(Messages.BEGIN_GAME, locale);
        HangmanDrawer.getInstance().display(Drawer.ZERO_ATTEMPT);
        hangmanLocal.display(Messages.CORRECT_CHARACTER, locale, getPrettyDisplayWord());
        while (attempts <= ATTEMPTS_ALLOWED) {
            hangmanLocal.display(Messages.ATTEMPTS, locale, attempts);
            String userInput = hangmanLocal.getUserInput(word, lettersUsed, scanner, locale);

            boolean characterGuessedCorrectly = userInput.length() == 1 && word.contains(userInput);
            boolean wordGuessedCorrectly = word.equals(userInput);
            if (characterGuessedCorrectly) {
                char c = userInput.charAt(0);

                int indexOfCharacter = word.indexOf(c);
                while (indexOfCharacter >= 0) {
                    updateDisplayWord(indexOfCharacter, c);
                    indexOfCharacter = word.indexOf(c, indexOfCharacter + 1);
                }

                if (word.equals(displayWord.toString())) {
                    break;
                }

                hangmanLocal.display(Messages.CORRECT_CHARACTER, locale, getPrettyDisplayWord());
            } else if (wordGuessedCorrectly) {
                break;
            } else {
                lettersUsed.add(userInput);
                HangmanDrawer.getInstance().draw(attempts);
                attempts++;
                hangmanLocal.display(Messages.INCORRECT_CHARACTER, locale, getPrettyDisplayWord());
            }
        }
    }

    /**
     * Formats the mystery word. Add spaces between underscores
     *
     * @return display separated by spaces.
     */
    private String getPrettyDisplayWord() {
        return displayWord.toString().replaceAll("", " ");
    }

    /**
     * Updates the display word, by replacing the given character at the index.
     *
     * @param indexOfCharacter index of the word to replace
     * @param character        the character to replace it with.
     */
    private void updateDisplayWord(int indexOfCharacter, char character) {
        displayWord.setCharAt(indexOfCharacter, character);
    }

    /**
     * Creates the display word and fill it with underscores.
     */
    private void initializeDisplayWord() {
        displayWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            displayWord.append("_");
        }
    }
}