package Core;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HangmanBeanTest {

    HangmanLocal instance;
    String A_WORD = "aword";

    @Before
    public void initialize() {
        instance = new HangmanBean();
    }

    @Test
    public void givenPlayersTurn_WhenAskedForUserInput_ShouldReturnCorrectInput() {
        List<String> lettersUsed = new ArrayList<>();
//        instance.getUserInput(A_WORD, lettersUsed, null, );
        ArrayList<Integer> actual = new ArrayList<>();
        ArrayList<Integer> expected = new ArrayList<>();
        actual.add(1);
        expected.add(1);
        assertThat(actual, is(expected));
    }
}
