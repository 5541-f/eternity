package comp5541.teamf.eternity;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class TestMath {

  double[][] values;


  @Before
  public void setUp() {
    values = new double[3][14];
    values[0] = new double[]{-100, -10, -1, -0.1, 0, 0.1, 1, 10, 100, 1000,
        Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, java.lang.Math.PI};
  }

  @Test
  public void testPI(){
    assertEquals(java.lang.Math.PI, Math.PI, 2e-15);
  }

  @Test
  public void testE(){
    assertEquals(java.lang.Math.E, Math.E, 2e-15);
  }

  @Test
  public void testExponent10() {

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

    String name = "exponent10";
    System.out.println(name + " Builtin Runtime:" + builtinTotalTime
                       + "; Custom Runtime:" + customTotalTime + "\n\n");
    for (int i = 0; i < values[0].length; i++) {
      try {
        assertEquals(values[1][i], values[2][i], 2e-11);
      } finally {
        System.out.printf("\n%s %.20f:\nBuiltin: %.20f\nCustom: %.20f\n",
            name, values[0][i], values[1][i], values[2][i]);
        System.out.printf("Difference: %.20f\n", values[1][i] - values[2][i]);
      }
    }
  }

  @Test
  public void testExponentNatural() {

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

    String name ="exponentNatural";
    System.out.println(name + " Builtin Runtime:" + builtinTotalTime
                       + "; Custom Runtime:" + customTotalTime + "\n\n");
    for (int i = 0; i < values[0].length; i++) {
      try {
        assertEquals(values[1][i], values[2][i], 2e-11);
      } finally {
        System.out.printf("\n%s %.20f:\nBuiltin: %.20f\nCustom: %.20f\n",
            name, values[0][i], values[1][i], values[2][i]);
        System.out.printf("Difference: %.20f\n", values[1][i] - values[2][i]);
      }
    }
  }

  @Test
  public void testLogarithm10() {

    long builtinStartTime = System.currentTimeMillis();
    for (int i = 0; i < values[0].length; i++) {
      values[1][i] = java.lang.Math.log10(values[0][i]);
    }
    long builtinTotalTime = System.currentTimeMillis() - builtinStartTime;

    long customStartTime = System.currentTimeMillis();
    for (int i = 0; i < values[0].length; i++) {
      values[2][i] = Math.logarithm10(values[0][i]);
    }
    long customTotalTime = System.currentTimeMillis() - customStartTime;

    String name = "logarithm10";
    System.out.println(name + " Builtin Runtime:" + builtinTotalTime
                       + "; Custom Runtime:" + customTotalTime + "\n\n");
    for (int i = 0; i < values[0].length; i++) {
      try {
        assertEquals(values[1][i], values[2][i], 2e-11);
      } finally {
        System.out.printf("\n%s %.20f:\nBuiltin: %.20f\nCustom: %.20f\n",
            name, values[0][i], values[1][i], values[2][i]);
        System.out.printf("Difference: %.20f\n", values[1][i] - values[2][i]);
      }
    }
  }

  @Test
  public void testSine() {

    long builtinStartTime = System.currentTimeMillis();
    for (int i = 0; i < values[0].length; i++) {
      values[1][i] = java.lang.Math.sin(java.lang.Math.toRadians(values[0][i]));
    }
    long builtinTotalTime = System.currentTimeMillis() - builtinStartTime;

    long customStartTime = System.currentTimeMillis();
    for (int i = 0; i < values[0].length; i++) {
      values[2][i] = Math.sine(values[0][i]);
    }
    long customTotalTime = System.currentTimeMillis() - customStartTime;

    String name = "sine";
    System.out.println(name + " Builtin Runtime:" + builtinTotalTime
                       + "; Custom Runtime:" + customTotalTime + "\n\n");
    for (int i = 0; i < values[0].length; i++) {
      try {
        assertEquals(values[1][i], values[2][i], 2e-11);
      } finally {
        System.out.printf("\n%s %.20f:\nBuiltin: %.20f\nCustom: %.20f\n",
            name, values[0][i], values[1][i], values[2][i]);
        System.out.printf("Difference: %.20f\n", values[1][i] - values[2][i]);
      }
    }
  }

  @Test
  public void testSquareRoot() {

    long builtinStartTime = System.currentTimeMillis();
    for (int i = 0; i < values[0].length; i++) {
      values[1][i] = java.lang.Math.sqrt(values[0][i]);
    }
    long builtinTotalTime = System.currentTimeMillis() - builtinStartTime;

    long customStartTime = System.currentTimeMillis();
    for (int i = 0; i < values[0].length; i++) {
      values[2][i] = Math.squareRoot(values[0][i]);
    }
    long customTotalTime = System.currentTimeMillis() - customStartTime;

    String name = "squareRoot";
    System.out.println(name + " Builtin Runtime:" + builtinTotalTime
                       + "; Custom Runtime:" + customTotalTime + "\n\n");
    for (int i = 0; i < values[0].length; i++) {
      try {
        assertEquals(values[1][i], values[2][i], 2e-11);
      } finally {
        System.out.printf("\n%s %.20f:\nBuiltin: %.20f\nCustom: %.20f\n",
            name, values[0][i], values[1][i], values[2][i]);
        System.out.printf("Difference: %.20f\n", values[1][i] - values[2][i]);
      }
    }
  }
}