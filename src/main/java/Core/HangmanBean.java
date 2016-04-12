package Core;

import Constants.ErrorMessages;
import Constants.Messages;
import i18n.I18n;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class HangmanBean implements HangmanLocal {

    @Override
    public String getUserInput(String word, List<String> lettersUsed, Scanner scanner, Locale locale) {
        display(Messages.CHOSEN_CHARACTERS_WORDS, locale, lettersUsed.toString());
        display(Messages.ASK_USER_FOR_INPUT, locale);
        String input;

        do {
            input = scanner.next();
        } while (!validateInputCharacter(word, input.toLowerCase(), locale));

        return input.toLowerCase();
    }

    @Override
    public void display(Enum message, Locale locale, Object... stringsToReplace) {
        System.out.println(I18n.getLocalizedLabelFallbackEnglish(message, locale, stringsToReplace));
    }

    @Override
    public boolean validateInputCharacter(String word, String input, Locale locale) {
        List<ErrorMessages> errorMessages = new ArrayList<>();
        if (input.length() != 1 && input.length() != word.length()) {
            errorMessages.add(ErrorMessages.INCORRECT_LENGTH);
        }
        if (!input.matches("[a-z]+")) {
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
}
