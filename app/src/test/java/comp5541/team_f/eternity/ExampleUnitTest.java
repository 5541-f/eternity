package comp5541.team_f.eternity;

import org.junit.Test;

import java.lang.Exception;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void symbol_test() throws Exception {
        System.out.println(Pattern.quote(Tokens.MULTIPLICATION.build()));
    }
}