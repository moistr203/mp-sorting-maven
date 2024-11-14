package edu.grinnell.csc207.sorting;

/**
 * A custom sorter that uses a hybrid approach to sorting.
 * Starts with Merge Sort but switches to Insertion Sort
 * for small subarrays or nearly sorted arrays.
 *
 * @param <T> The types of values that are sorted.
 * @author Moise Milenge
 */
public class LastFirstSort<T extends Comparable<T>> implements Sorter<T> {

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sorts an array by using a hybrid approach. Switches between
   * Merge Sort and Insertion Sort based on the array properties.
   *
   * @param values an array to sort.
   */
  @Override
  public void sort(T[] values) {
    if (isNearlySorted(values)) {
      insertionSort(values);
    } else {
      mergeSort(values, 0, values.length - 1);
    }
  } // sort(T[])

  /**
   * Checks if the array is nearly sorted.
   *
   * @param values The array to evaluate.
   * @return true if nearly sorted, false otherwise.
   */
  private boolean isNearlySorted(T[] values) {
    // Implement logic to check if the array is nearly sorted.
    return false; // Placeholder
  } // isNearlySorted(T[])

  /**
   * Performs Insertion Sort on the array.
   *
   * @param values The array to sort.
   */
  private void insertionSort(T[] values) {
    for (int i = 1; i < values.length; i++) {
      T key = values[i];
      int j = i - 1;
      while (j >= 0 && values[j].compareTo(key) > 0) {
        values[j + 1] = values[j];
        j--;
      }
      values[j + 1] = key;
    }
  } // insertionSort(T[])

  /**
   * Performs Merge Sort on the array.
   *
   * @param values The array to sort.
   * @param left The left bound of the subarray.
   * @param right The right bound of the subarray.
   */
  private void mergeSort(T[] values, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      mergeSort(values, left, mid);
      mergeSort(values, mid + 1, right);
      merge(values, left, mid, right);
    }
  } // mergeSort(T[], int, int)

  /**
   * Merges two sorted halves of the array.
   *
   * @param values The array to merge.
   * @param left The left bound of the subarray.
   * @param mid The midpoint of the subarray.
   * @param right The right bound of the subarray.
   */
  private void merge(T[] values, int left, int mid, int right) {
    // Merge logic to combine sorted halves.
  } // merge(T[], int, int, int)

} // class LastFirstSort
