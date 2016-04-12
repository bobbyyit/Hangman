package Core;

import mockit.NonStrictExpectations;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

import mockit.Injectable;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HangmanBeanTest {

    HangmanLocal instance;
    String A_WORD = "aword";
    @Injectable
    private Scanner scanner;

    @Before
    public void initialize() {
        instance = new HangmanBean();
    }

    @Test
    public void givenPlayersTurn_WhenAskedForUserInput_ShouldReturnCorrectInput() {
        final String inputFromUser = "p";
        new NonStrictExpectations() {{
            scanner.next();
            result = inputFromUser;
        }};

        String userInput = instance.getUserInput(A_WORD, new ArrayList<>(), scanner, null);

        assertThat(userInput, is("p"));
    }
}
