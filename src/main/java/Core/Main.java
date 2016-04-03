package Core;

import Constants.ErrorMessages;
import Core.Hangman;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static String tracker = "";
    private static List<Character> tries = new ArrayList<>();
    private static boolean mysteryWordFound = false;
    private static String mysteryWord = "hello";

    public static void main(String[] args) {
        Hangman game = new Hangman();
        game.start();


//        tracker = buildTracker(mysteryWord);
//
//        int attempts = 0;
//        while (attempts < 10) {
//            Scanner sc = new Scanner(System.in);
//            System.out.println("Enter a letter or a word guess");
//            String i = sc.next();
//            List<ErrorMessages> errorValidationCodes = validateInput(i);
//            if (errorValidationCodes.size() == 0) {
//                attempts = parseAttempt(i, attempts);
//                System.out.println(attempts);
//            } else {
//                for (ErrorMessages errorValidationCode : errorValidationCodes) {
//                    System.out.println(errorValidationCode.getMessage());
//                }
//            }
//        }
    }

    /**
     * @param input
     * @return
     */
    private static List<ErrorMessages> validateInput(String input) {
        List<ErrorMessages> errorMessages = new ArrayList<>();
        if (input.length() != 1 && input.length() != mysteryWord.length()) {
            errorMessages.add(ErrorMessages.INCORRECT_LENGTH);
        }
        if (!input.matches("[A-Za-z]+")) {
            errorMessages.add(ErrorMessages.INCORRECT_CHARACTERS);
        }

        if (errorMessages.size() == 0) {
            tries.add(input.charAt(0));
        }

        return errorMessages;
    }

    /**
     * @param i
     * @param attempts
     * @return
     */
    private static int parseAttempt(String i, int attempts) {
        // Entered 1 character and it's found in the mystery word
        if (i.length() == 1 && mysteryWord.contains(i)) {
            char c = i.charAt(0);

            int index = mysteryWord.indexOf(c);
            while (index >= 0) {
                tracker = fillTracker(index, c);
                index = mysteryWord.indexOf(c, index + 1);
                System.out.println(tracker);
            }
            if (mysteryWord.equals(tracker)) {
                mysteryWordFound = true;
                return 10;
            }
            return attempts++;

        }
        // Entered a word and is the mystery word
        else if (i.length() == mysteryWord.length() && i.equals(mysteryWord)) {
            mysteryWordFound = true;
            System.out.println("you win.");
            return 10;
        }
        // Entered char or word but not found in or is not mystery word
        else {
            System.out.println("letter/word not in, pick another.");
            for (Character character : tries) {
                System.out.print(character + ",");
            }

            return attempts + 1;
        }

    }

    private static String fillTracker(int position, char character) {
        StringBuilder newTracker = new StringBuilder(tracker);
        newTracker.setCharAt(position, character);
        return newTracker.toString();
    }

    private static String buildTracker(String tracker) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tracker.length(); i++) {
            stringBuilder.append("_");
        }
        return stringBuilder.toString();
    }
}
