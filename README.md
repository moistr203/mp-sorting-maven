# mp-sorting-maven

An exploration of sorting in Java.

## Authors

* Moise Milenge
* Samuel A. Rebelsky (starter code)

## Acknowledgements

* Thanks to [Grinnell College CSC207](https://www.cs.grinnell.edu/~rebelsky/Courses/CSC207/) for foundational material.
* Used Java API documentation and Stack Overflow for specific method references.
* evening tutorial

This code may be found at https://github.com/moistr203/mp-sorting-maven.git

## Description of Custom Sorting Algorithm

### LastFirstSort
The `LastFirstSort` algorithm is a hybrid sorting method that uses different sorting strategies based on the structure of the input array:

* **Hybrid Approach**: The algorithm initially performs Merge Sort but switches to Insertion Sort for smaller subarrays. This improves efficiency since Insertion Sort is generally faster for small, nearly sorted subarrays.

* **Pattern Analysis**: `LastFirstSort` includes a function to detect if an array is nearly sorted. If it is, the algorithm applies Insertion Sort for faster performance. Otherwise, it defaults to Merge Sort.

### Key Features
* **Efficient on Nearly Sorted Data**: The algorithm identifies nearly sorted arrays and switches to Insertion Sort, which has a better average runtime on such data.
* **Effective on Mixed Data Patterns**: For data that does not match specific patterns, Merge Sort handles larger and more unordered arrays effectively.

### Implementation Notes
The `LastFirstSort` class includes helper methods for:
  - Checking if an array is nearly sorted (`isNearlySorted`).
  - Sorting with Insertion Sort (`insertionSort`).
  - Sorting with Merge Sort (`mergeSort`).