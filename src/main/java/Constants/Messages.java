package Constants;

public enum Messages {
    BEGIN_GAME("You have 10 tries to guess the mystery word, you can guess a letter or the whole word. Good luck!"),
    ASK_USER_FOR_INPUT("Enter a letter or word:"),
    YOU_WIN("You figured out the word. Congratulations, You win!"),
    YOU_LOSE("You've exhausted your number of tries :( Try again."),
    CORRECT_CHARACTER("Progress: %s"),
    INCORRECT_CHARACTER("Try again, Progress: %s"),
    CHOSEN_CHARACTERS_WORDS("Chosen letter/words: %s"),
    ATTEMPTS("Attempts: %s");

    String message;

    Messages(String message) {
        this.message = message;
    }

}
