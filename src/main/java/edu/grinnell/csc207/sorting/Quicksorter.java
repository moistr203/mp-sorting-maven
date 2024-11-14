package edu.grinnell.csc207.sorting;

import java.util.Comparator;
import java.util.Random;

/**
 * A sorter that uses Quicksort.
 *
 * @param <T> The types of values that are sorted.
 *
 * @author Samuel A. Rebelsky
  * @author Moise Milenge

 */
public class Quicksorter<T> implements Sorter<T> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The way in which elements are ordered.
   */
  Comparator<? super T> order;

  /**
   * Random instance to help select pivot indices.
   */
  private final Random random = new Random();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter using a particular comparator.
   *
   * @param comparator The order in which elements in the array should be ordered
   *                   after sorting.
   */
  public Quicksorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // Quicksorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using Quicksort.
   *
   * @param values an array to sort.
   * @post The array has been sorted according to some order (often
   *       one given to the constructor).
   * @post For all i, 0 &lt; i &lt; values.length,
   *       order.compare(values[i-1], values[i]) &lt;= 0
   */
  @Override
  public void sort(T[] values) {
    quickSort(values, 0, values.length - 1);
  } // sort(T[])

  /**
   * Recursive quicksort function.
   *
   * @param values The array to sort.
   * @param low    The starting index of the segment to sort.
   * @param high   The ending index of the segment to sort.
   */
  private void quickSort(T[] values, int low, int high) {
    if (low < high) {
      int pivotIndex = partition(values, low, high);
      quickSort(values, low, pivotIndex - 1);
      quickSort(values, pivotIndex + 1, high);
    }
  } // quickSort(T[], int, int)

  /**
   * Partition the array segment around a pivot.
   *
   * @param values The array to partition.
   * @param low    The starting index of the segment.
   * @param high   The ending index of the segment.
   * @return The final index of the pivot.
   */
  private int partition(T[] values, int low, int high) {
    // Select a random pivot and move it to the end
    int pivotIndex = low + random.nextInt(high - low + 1);
    T pivotValue = values[pivotIndex];
    swap(values, pivotIndex, high);

    int i = low - 1;
    for (int j = low; j < high; j++) {
      if (order.compare(values[j], pivotValue) <= 0) {
        i++;
        swap(values, i, j);
      }
    }
    swap(values, i + 1, high);
    return i + 1;
  } // partition(T[], int, int)

  /**
   * Swap two elements in an array.
   *
   * @param values The array in which to swap elements.
   * @param i      The index of the first element.
   * @param j      The index of the second element.
   */
  private void swap(T[] values, int i, int j) {
    T temp = values[i];
    values[i] = values[j];
    values[j] = temp;
  } // swap(T[], int, int)

} // class Quicksorter
