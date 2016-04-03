package Constants;

public enum ErrorMessages {
    INCORRECT_LENGTH("Incorrect length"),
    INCORRECT_CHARACTERS("Contains invalid characters");

    String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
