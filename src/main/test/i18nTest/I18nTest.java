package i18nTest;

import Constants.ErrorMessages;
import Constants.Messages;
import com.google.common.collect.Sets;
import i18n.BundleName;
import i18n.HangmanResourceBundleName;
import i18n.I18n;
import org.junit.Before;
import org.junit.Rule;

import java.util.*;

import org.junit.Test;

import static org.hamcrest.core.Is.is;

import org.junit.rules.ErrorCollector;


public class I18nTest {

    @Rule
    public ErrorCollector collector = new ErrorCollector();
    private List<Locale> supportedLocales;

    @Before
    public void setUp() {
        supportedLocales = new ArrayList<>();
        supportedLocales.add(Locale.ENGLISH);
    }

    @Test
    public void givenMessages_WhenLocalizing_ShouldNotHaveMissingKeys() {
        List<String> enumValuesAsString = new ArrayList<>();
        for (Messages messages : Messages.values()) {
            enumValuesAsString.add(messages.name());
        }
        Set<String> expectedResult = Sets.newHashSet(enumValuesAsString);

        verifyExistenceOfKeys(HangmanResourceBundleName.MESSAGE, "messages.", expectedResult);
    }

    @Test
    public void givenErrorMessages_WhenLocalizing_ShouldNotHaveMissingKeys() {
        List<String> enumValuesAsString = new ArrayList<>();
        for (ErrorMessages messages : ErrorMessages.values()) {
            enumValuesAsString.add(messages.name());
        }
        Set<String> expectedResult = Sets.newHashSet(enumValuesAsString);

        verifyExistenceOfKeys(HangmanResourceBundleName.ERROR_MESSAGE, "error_messages.", expectedResult);
    }

    public void verifyExistenceOfKeys(BundleName searchConstants, String prefix, Set<String> expectedKeys) {
        for (Locale locale : supportedLocales) {
            Map<String, String> keyValuePairs = I18n.getAllTexts(searchConstants, locale);
            for (String expectedKey : expectedKeys) {
                String key = prefix + expectedKey;
                collector.checkThat("No translation for: " + expectedKey + " for: " + locale.getLanguage(), keyValuePairs.containsKey(key), is(true));
            }
        }
    }
}
