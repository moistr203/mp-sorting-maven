package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * A sorter that uses merge sort.
 *
 * @param <T> The types of values that are sorted.
 *
 * Author: Samuel A. Rebelsky, Moise Milenge
 */
public class MergeSorter<T> implements Sorter<T> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The way in which elements are ordered.
   */
  Comparator<? super T> order;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter using a particular comparator.
   *
   * @param comparator The order in which elements in the array should be ordered
   *                   after sorting.
   */
  public MergeSorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // MergeSorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using merge sort.
   *
   * @param values an array to sort.
   * @post The array has been sorted according to some order (often
   *       one given to the constructor).
   * @post For all i, 0 < i < values.length,
   *       order.compare(values[i-1], values[i]) <= 0
   */
  @Override
  public void sort(T[] values) {
    if (values.length > 1) {
      T[] aux = values.clone(); // Create auxiliary array for merging
      mergeSort(values, aux, 0, values.length - 1);
    }
  } // sort(T[])

  /**
   * Recursive merge sort function.
   *
   * @param values The array to sort.
   * @param aux    Auxiliary array used during merging.
   * @param left   The left index of the subarray to sort.
   * @param right  The right index of the subarray to sort.
   */
  private void mergeSort(T[] values, T[] aux, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      mergeSort(values, aux, left, mid);
      mergeSort(values, aux, mid + 1, right);
      merge(values, aux, left, mid, right);
    }
  } // mergeSort(T[], T[], int, int)

  /**
   * Merge two sorted subarrays into a single sorted subarray.
   *
   * @param values The main array containing the subarrays.
   * @param aux    Auxiliary array for temporary storage.
   * @param left   The left index of the first subarray.
   * @param mid    The middle index where the subarrays split.
   * @param right  The right index of the second subarray.
   */
  private void merge(T[] values, T[] aux, int left, int mid, int right) {
    // Copy both halves into auxiliary array
    System.arraycopy(values, left, aux, left, right - left + 1);

    int i = left;
    int j = mid + 1;
    int k = left;

    // Merge back to original array in sorted order
    while (i <= mid && j <= right) {
      if (order.compare(aux[i], aux[j]) <= 0) {
        values[k++] = aux[i++];
      } else {
        values[k++] = aux[j++];
      }
    }

    // Copy any remaining elements from left half
    while (i <= mid) {
      values[k++] = aux[i++];
    }
  } // merge(T[], T[], int, int, int)
} // class MergeSorter
