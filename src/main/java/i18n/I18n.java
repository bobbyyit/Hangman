package i18n;

import Constants.ErrorMessages;
import Constants.Messages;

import java.util.*;

public class I18n {

    public static String getLocalizedLabelFallbackEnglish(Enum enumValue, Locale locale, Object... stringsToReplace) {
        String message;
        BundleName resourceBundleName = getBundleName(enumValue);
        String keyPrefix = getKeyPrefix(enumValue);

        if (locale == null) {
            locale = Locale.ENGLISH;
        }

        message = getText(resourceBundleName, locale, keyPrefix + enumValue.toString());

        return String.format(message, stringsToReplace);
    }

    private static String getText(BundleName resourceBundleName, Locale locale, String key) {
        ResourceBundle bundleResource = ResourceBundle.getBundle(resourceBundleName.getName(), locale);
        String message = bundleResource.getString(key);
        return message;
    }

    private static BundleName getBundleName(Enum enumKey) {
        HangmanResourceBundleName resourceBundleName = null;
        if (enumKey instanceof Messages) {
            resourceBundleName = HangmanResourceBundleName.MESSAGE;
        } else if (enumKey instanceof ErrorMessages) {
            resourceBundleName = HangmanResourceBundleName.ERROR_MESSAGE;
        }
        return resourceBundleName;
    }

    private static String getKeyPrefix(Enum enumKey) {
        String resourceBundleName = null;
        if (enumKey instanceof Messages) {
            resourceBundleName = "messages.";
        } else if (enumKey instanceof ErrorMessages) {
            resourceBundleName = "error_messages.";
        }
        return resourceBundleName;
    }

    public static Map<String, String> getAllTexts(BundleName bundle) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(bundle.getName());
        Enumeration<String> keys = resourceBundle.getKeys();
        Map<String, String> keyValues = new HashMap<>();

        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            keyValues.put(key, resourceBundle.getString(key));
        }

        return keyValues;
    }
}
