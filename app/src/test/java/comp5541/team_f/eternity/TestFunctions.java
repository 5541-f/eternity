package comp5541.team_f.eternity;

import org.junit.Test;

import java.lang.Exception;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class TestFunctions {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(Math.PI, Functions.pi_2(), 0.000000000001);
        System.out.println(Math.PI);
      System.out.println(Functions.pi_1());
    }

    @Test
    public void symbol_test() throws Exception {
        System.out.println(Pattern.quote(Tokens.MULTIPLICATION.build()));
    }
}