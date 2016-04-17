package Constants;

public enum ErrorMessages {

    /**
     * The messages is only used as a quick reference, the message used is located in the resource folder.
     * Be sure to update the resource files if any new messages are added.
     */
    INCORRECT_LENGTH("Incorrect length"),
    INCORRECT_CHARACTERS("Contains invalid characters");

    String message;

    ErrorMessages(String message) {
        this.message = message;
    }
}
