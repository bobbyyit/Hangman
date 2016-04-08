package Core;

import Constants.Drawer;
import Constants.ErrorMessages;
import Constants.Messages;
import i18n.I18n;

import java.util.*;

public class Hangman {
    private static final int ATTEMPTS_ALLOWED = 10;
    private String word;
    private List<String> lettersUsed;
    private StringBuilder displayWord;
    private Scanner scanner;
    private Locale locale = null;
    HangmanLocal hangmanLocal ;

    public void start() {
        word = new WordGenerator().generate();
        lettersUsed = new ArrayList<>();
        initializeDisplayWord();
        hangmanLocal = new HangmanBean();

        begin();
        verifyWord();
    }

    private void verifyWord() {
        if (word.equals(displayWord.toString())) {
            HangmanDrawer.getInstance().display(Drawer.WINNER);
            hangmanLocal.display(Messages.YOU_WIN, locale);
        } else {
            hangmanLocal.display(Messages.YOU_LOSE, locale);
        }
    }

    private void begin() {
        int attempts = 1;
        hangmanLocal.display(Messages.BEGIN_GAME, locale);
        HangmanDrawer.getInstance().display(Drawer.ZERO_ATTEMPT);
        while (attempts <= ATTEMPTS_ALLOWED) {
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

                if (word.equals(displayWord)) {
                    break;
                }

                hangmanLocal.display(Messages.CORRECT_CHARACTER, locale, displayWord.toString().replaceAll("", " "));
            } else if (wordGuessedCorrectly) {
                break;
            } else {
                lettersUsed.add(userInput);
                HangmanDrawer.getInstance().draw(attempts);
                attempts++;
                hangmanLocal.display(Messages.INCORRECT_CHARACTER, locale, displayWord.toString().replaceAll("", " "));
            }
        }
    }

    private void updateDisplayWord(int indexOfCharacter, char character) {
        displayWord.setCharAt(indexOfCharacter, character);
    }



    private void initializeDisplayWord() {
        displayWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            displayWord.append("_");
        }
    }
}