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

    public void start() {
        word = new WordGenerator().generate();
        lettersUsed = new ArrayList<>();
        initializeDisplayWord();

        begin();
        verifyWord();
    }

    private void verifyWord() {
        if (word.equals(displayWord.toString())) {
            HangmanDrawer.getInstance().display(Drawer.WINNER);
            display(Messages.YOU_WIN, locale);
        } else {
            display(Messages.YOU_LOSE, locale);
        }
    }

    private void begin() {
        int attempts = 1;
        display(Messages.BEGIN_GAME, locale);
        HangmanDrawer.getInstance().display(Drawer.ZERO_ATTEMPT);
        while (attempts <= ATTEMPTS_ALLOWED) {
            String userInput = getUserInput();

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

                display(Messages.CORRECT_CHARACTER, locale, displayWord.toString().replaceAll("", " "));
            } else if (wordGuessedCorrectly) {
                break;
            } else {
                lettersUsed.add(userInput);
                HangmanDrawer.getInstance().draw(attempts);
                attempts++;
                display(Messages.INCORRECT_CHARACTER, locale, displayWord.toString().replaceAll("", " "));
            }
        }
    }

    private void display(Enum message, Locale locale, Object... stringsToReplace) {
        System.out.println(I18n.getLocalizedLabelFallbackEnglish(message, locale, stringsToReplace));
    }

    private void updateDisplayWord(int indexOfCharacter, char character) {
        displayWord.setCharAt(indexOfCharacter, character);
    }

    private String getUserInput() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        display(Messages.CHOSEN_CHARACTERS_WORDS, locale, lettersUsed.toString());
        display(Messages.ASK_USER_FOR_INPUT, locale);
        String input = scanner.next();

        while (!validateInput(input)) {
            input = scanner.next();
        }

        return input;
    }

    private boolean validateInput(String input) {
        List<ErrorMessages> errorMessages = new ArrayList<>();
        if (input.length() != 1 && input.length() != word.length()) {
            errorMessages.add(ErrorMessages.INCORRECT_LENGTH);
        }
        if (!input.matches("[A-Za-z]+")) {
            errorMessages.add(ErrorMessages.INCORRECT_CHARACTERS);
        }

        if (errorMessages.size() != 0) {
            for (ErrorMessages errorMessage : errorMessages) {
                display(errorMessage, locale);
            }
            return false;
        }

        return true;
    }

    private void initializeDisplayWord() {
        displayWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            displayWord.append("_");
        }
    }
}