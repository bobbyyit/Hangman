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

    private static final String AN_INPUT = "b";
    private static final String AN_INCORRECT_INPUT = "3E";
    private static final String A_WORD = "aword";
    @Injectable
    private Scanner scanner;
    HangmanLocal instance;

    @Before
    public void initialize() {
        instance = new HangmanBean();
    }

    @Test
    public void givenUsersTurn_WhenInputtingCorrectValues_ShouldReturnCorrectInput() {
        new NonStrictExpectations() {
            {
                scanner.next();
                result = AN_INPUT;
            }
        };

        String userInput = instance.getUserInput(A_WORD, new ArrayList<>(), scanner, null);

        assertThat(userInput, is(AN_INPUT));
    }

    @Test
    public void givenUsersTurn_WhenInputtingIncorrectValues_ShouldReturnCorrectInput() {
        new NonStrictExpectations() {
            {
                scanner.next();
                result = AN_INCORRECT_INPUT;

                scanner.next();
                result = AN_INPUT;
            }
        };

        String userInput = instance.getUserInput(A_WORD, new ArrayList<>(), scanner, null);

        assertThat(userInput, is(AN_INPUT));
    }

    @Test
    public void givenInput_WhenValidating_ShouldValidate() {
        boolean result = instance.validateInputCharacter(A_WORD, AN_INPUT, null);

        assertThat(result, is(true));
    }

    @Test
    public void givenInput_WhenValidating_ShouldDisplayMessage() {
        boolean result = instance.validateInputCharacter(A_WORD, AN_INCORRECT_INPUT, null);

        assertThat(result, is(false));
    }
}
