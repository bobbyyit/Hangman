package Core;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public interface HangmanLocal {

    /**
     * Get the input from user and perform validation.
     *
     * @param word        the word user is trying to guess
     * @param lettersUsed the list of the letters/words guesses
     * @param scanner     scanner for input
     * @param locale      the locale of user, get appropriate message.
     * @return validated user input
     */
    String getUserInput(String word, List<String> lettersUsed, Scanner scanner, Locale locale);

    /**
     * @param message          the enum message
     * @param locale           the locale of user, get appropriate message.
     * @param stringsToReplace strings to insert into message
     */
    void display(Enum message, Locale locale, Object... stringsToReplace);

    /**
     * Validates the given string.
     *
     * @param word   the word the user is trying to guess
     * @param input  the word the user entered.
     * @param locale the locale of user, get appropriate message.
     * @return the validity of given string
     */
    boolean validateInput(String word, String input, Locale locale);
}
