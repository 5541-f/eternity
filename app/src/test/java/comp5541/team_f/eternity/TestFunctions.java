package comp5541.team_f.eternity;

import org.junit.Test;

import java.lang.Exception;
import java.util.Timer;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class TestFunctions {
  @Test
  public void test_pi_1() throws Exception {
    long startTime = System.currentTimeMillis();
    assertEquals(Math.PI, Functions.pi_1(), 0.000000000000001);
    System.out.println("Math.PI: " + Math.PI);
    System.out.println("Functions.pi_1(): " + Functions.pi_1());
    System.out.println(("Runtime in milliseconds: " + (System.currentTimeMillis() - startTime)));
  }

//  Math.PI: 3.141592653589793
//  Functions.pi_1(): 3.141592653589794
//  Runtime in milliseconds: 4
//  Math.PI: 3.141592653589793
//  Functions.pi_2(): 3.1415926545880506
//  Runtime in milliseconds: 18546
//  @Test
//  public void test_pi_2() throws Exception {
//    long startTime = System.currentTimeMillis();
//    assertEquals(Math.PI, Functions.pi_2(), 0.000000001);
//    System.out.println("Math.PI: " + Math.PI);
//    System.out.println("Functions.pi_2(): " + Functions.pi_2());
//    System.out.println(("Runtime in milliseconds: " + (System.currentTimeMillis() - startTime)));
//  }

  @Test
  public void test_exponent10() throws Exception {
    long startTime = System.currentTimeMillis();
//    assertEquals(Math.PI, Functions.exponent10_1(0.2), 0.000000000000001);
    System.out.println("Math.pow(10,0.2): " + Math.pow(10,Math.PI));
    System.out.println("Functions.exponent10_2(0.2): " + Functions.exponent10_1(Math.PI));
    System.out.println(("Runtime in milliseconds: " + (System.currentTimeMillis() - startTime)));
  }
}