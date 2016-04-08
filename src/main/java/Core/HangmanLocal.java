package Core;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public interface HangmanLocal {

    String getUserInput(String word, List<String> lettersUsed, Scanner scanner, Locale locale);

    void display(Enum message, Locale locale, Object... stringsToReplace);

    boolean validateInput(String word, String input, Locale locale);
}
