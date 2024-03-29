package datastructures.sorting;

import java.util.*;

public class CompareTester {
  public static <E extends Comparable<E>> void test(
      E[] comparables) {
    test(comparables, Comparator.naturalOrder());
  }

  public static <E> void test(E[] comparables,
                              Comparator<E> comparator) {
    rule1(comparator, comparables);
    rule2(comparator, comparables);
    rule3(comparator, comparables);
    suggestion1(comparator, comparables);
  }

  // Quadratic
  private static <E> void rule1(Comparator<E> comparator,
                                E[] comparables) {
    for (E x : comparables) {
      for (E y : comparables) {
        int xy = comparator.compare(x, y);
        int yx = comparator.compare(y, x);
        if (sgn(xy) != -sgn(yx)) {
          System.out.printf("Rule 1 violated with" +
              " x=%s, y=%s%n", x, y);
        }
      }
    }
  }

  // Cubic
  private static <E> void rule2(Comparator<E> comparator,
                                E[] comparables) {
    for (E x : comparables) {
      for (E y : comparables) {
        for (E z : comparables) {
          int xy = comparator.compare(x, y);
          int yz = comparator.compare(y, z);
          if (xy < 0 && yz < 0) {
            int xz = comparator.compare(x, z);
            if (!(xz < 0)) {
              System.out.printf("Rule 2 violated with " +
                  "x=%s, y=%s, z=%s%n", x, y, z);
            }
          }
        }
      }
    }
  }

  // Cubic
  private static <E> void rule3(Comparator<E> comparator,
                                E[] comparables) {
    for (E x : comparables) {
      for (E y : comparables) {
        for (E z : comparables) {
          if (comparator.compare(x, y) == 0) {
            int xz = comparator.compare(x, z);
            int yz = comparator.compare(y, z);
            if (sgn(xz) != sgn(yz)) {
              System.out.printf("Rule 3 violated with " +
                  "x=%s, y=%s, z=%s%n", x, y, z);
            }
          }
        }
      }
    }
  }

  // Quadratic
  private static <E> void suggestion1(Comparator<E> comparator,
                                      E[] comparables) {
    for (E x : comparables) {
      for (E y : comparables) {
        int xy = comparator.compare(x, y);
        if ((xy == 0) != x.equals(y)) {
          System.out.printf("Suggestion 1 violated with" +
              " x=%s, y=%s%n", x, y);
        }
      }
    }
  }

  private static int sgn(int compareResult) {
    return Integer.compare(compareResult, 0);
  }
}  
