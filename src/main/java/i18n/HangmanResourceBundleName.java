package i18n;


public enum HangmanResourceBundleName implements BundleName {
    MESSAGE("constants.messages.messages"),
    ERROR_MESSAGE("constants.error_messages.error_messages");

    private String name;

    HangmanResourceBundleName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
