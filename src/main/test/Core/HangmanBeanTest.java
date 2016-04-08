package Core;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.hasItems;

/**
 * Created by bobbyyit on 2016-04-07.
 */
public class HangmanBeanTest {

    @Test
    public void hellwowrd() {
        ArrayList<Integer> actual = new ArrayList<Integer>();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        actual.add(1);
        expected.add(2);
        assertThat(actual, hasItems(expected));
    }

}
