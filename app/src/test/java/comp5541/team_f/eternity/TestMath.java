package comp5541.teamf.eternity;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class TestMath {

  //Initial execution of both
  double testa = java.lang.Math.pow(10,1);
  double testb = Math.exponent10(1);

  @Test
  public void testExponent10() {

    double[][] values = new double[3][8];
    values[0] = new double[]{-10, -1.0, -0.1, 0.0, 0.1, 1.0, 10, java.lang.Math.PI};

    long builtinStartTime = System.currentTimeMillis();
    for (int i = 0; i < values[0].length; i++) {
      values[1][i] = java.lang.Math.pow(10, values[0][i]);
    }
    long builtinTotalTime = System.currentTimeMillis() - builtinStartTime;

    long customStartTime = System.currentTimeMillis();
    for (int i = 0; i < values[0].length; i++) {
      values[2][i] = Math.exponent10(values[0][i]);
    }
    long customTotalTime = System.currentTimeMillis() - customStartTime;

    System.out.println("10^x");
    for (int i = 0; i < values[0].length; i++) {
      assertEquals(values[1][i], values[1][2], 1e-16);
      System.out.println("Builtin:" + values[1][i] + "; Custom:" + values[2][i]);
    }
    System.out.println("Builtin Runtime:" + builtinTotalTime
                       + "; Custom Runtime:" + customTotalTime + "\n\n");
  }

  @Test
  public void testExponentNatural() {

    double[][] values = new double[3][8];
    values[0] = new double[]{-10, -1.0, -0.1, 0.0, 0.1, 1.0, 10, java.lang.Math.PI};

    long builtinStartTime = System.currentTimeMillis();
    for (int i = 0; i < values[0].length; i++) {
      values[1][i] = java.lang.Math.exp(values[0][i]);
    }
    long builtinTotalTime = System.currentTimeMillis() - builtinStartTime;

    long customStartTime = System.currentTimeMillis();
    for (int i = 0; i < values[0].length; i++) {
      values[2][i] = Math.exponentNatural(values[0][i]);
    }
    long customTotalTime = System.currentTimeMillis() - customStartTime;

    System.out.println("e^x");
    for (int i = 0; i < values[0].length; i++) {
      assertEquals(values[1][i], values[1][2], 1e-16);
      System.out.println("Builtin:" + values[1][i] + "; Custom:" + values[2][i]);
    }
    System.out.println("Builtin Runtime:" + builtinTotalTime
                       + "; Custom Runtime:" + customTotalTime + "\n\n");
  }

  @Test
  public void testLogarithm10() {

  }

  @Test
  public void testSine() {

  }

  @Test
  public void testSquareRoot() {

  }
}