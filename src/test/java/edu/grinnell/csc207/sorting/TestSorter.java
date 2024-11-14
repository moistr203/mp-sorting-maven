package edu.grinnell.csc207.sorting;

import edu.grinnell.csc207.util.ArrayUtils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Tests for Sorter objects, designed to apply to various sorting implementations
 * (InsertionSort, SelectionSort, MergeSort, QuickSort, and custom sorts).
 *
 * @author Moise Milenge
 * @author Samuel A. Rebelsky
 */
public class TestSorter {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  /**
   * Sorter for string arrays.
   */
  static Sorter<String> stringSorter = null;

  /**
   * Sorter for integer arrays.
   */
  static Sorter<Integer> intSorter = null;

  // +-----------+---------------------------------------------------
  // | Utilities |
  // +-----------+

  /**
   * Given a sorted array and a permutation of the array, sort the
   * permutation and assert that it equals the original.
   *
   * @param <T> The type of values in the array.
   * @param sorted The sorted array.
   * @param perm The permuted sorted array.
   * @param sorter The sorter to use for sorting.
   */
  public <T> void assertSorts(T[] sorted, T[] perm, Sorter<? super T> sorter) {
    T[] tmp = perm.clone();
    sorter.sort(perm);
    assertArrayEquals(sorted, perm,
      () -> String.format("sort(%s) yields %s rather than %s",
          Arrays.toString(tmp),
          Arrays.toString(perm),
          Arrays.toString(sorted)));
  } // assertSorts

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  /**
   * Test for an empty array: Sorting should not change the array.
   */
  @Test
  public void emptyArrayTest() {
    if (null == intSorter) {
      return;
    }
    Integer[] original = {};
    Integer[] expected = {};
    assertSorts(expected, original, intSorter);
  } // emptyArrayTest

  /**
   * Test for a single element array: Sorting should return the array as-is.
   */
  @Test
  public void singleElementTest() {
    if (null == intSorter) {
      return;
    }
    Integer[] original = {42};
    Integer[] expected = {42};
    assertSorts(expected, original, intSorter);
  } // singleElementTest

  /**
   * Test for a sorted array: Sorting should not alter the array.
   */
  @Test
  public void sortedArrayTest() {
    if (null == intSorter) {
      return;
    }
    Integer[] original = {1, 2, 3, 4, 5};
    Integer[] expected = {1, 2, 3, 4, 5};
    assertSorts(expected, original, intSorter);
  } // sortedArrayTest

  /**
   * Test for a reverse-sorted array: Sorting should reorder it correctly.
   */
  @Test
  public void reverseArrayTest() {
    if (null == intSorter) {
      return;
    }
    Integer[] original = {5, 4, 3, 2, 1};
    Integer[] expected = {1, 2, 3, 4, 5};
    assertSorts(expected, original, intSorter);
  } // reverseArrayTest

  /**
   * Test for an array with mixed/random elements: Sorting should order it correctly.
   */
  @Test
  public void mixedArrayTest() {
    if (null == intSorter) {
      return;
    }
    Integer[] original = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
    Integer[] expected = {1, 1, 2, 3, 3, 4, 5, 5, 6, 9};
    assertSorts(expected, original, intSorter);
  } // mixedArrayTest

  /**
   * Test for an array with duplicate values: Sorting should keep duplicates in order.
   */
  @Test
  public void duplicateElementsTest() {
    if (null == intSorter) {
      return;
    }
    Integer[] original = {2, 3, 2, 3, 2, 3};
    Integer[] expected = {2, 2, 2, 3, 3, 3};
    assertSorts(expected, original, intSorter);
  } // duplicateElementsTest

  /**
   * Test for a permuted larger array: Sorting should order it correctly.
   */
  @Test
  public void permutedLargeArrayTest() {
    int SIZE = 100;
    if (null == intSorter) {
      return;
    }
    Integer[] original = new Integer[SIZE];
    for (int i = 0; i < SIZE; i++) {
      original[i] = i;
    }
    Integer[] expected = original.clone();
    ArrayUtils.permute(original);
    assertSorts(expected, original, intSorter);
  } // permutedLargeArrayTest
} // class TestSorter
