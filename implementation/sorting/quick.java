package implementation.sorting;

import java.util.Arrays;

public class quick {
    public static void main(String[] args) {

        int arr[] = { 12, 11, 13, 5, 6 };

        sort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: ");
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int arr[], int low, int high) {
        if (low >= high) {
            return;
        }
        int s = low;
        int e = high;
        int mid = arr[(s + e) / 2];
        while (s <= e) {
            while (arr[s] < mid) {
                s++;
            }
            while (arr[e] > mid) {
                e--;
            }

            if (s <= e) {
                int temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            }

        }

        // now pivot is at correct position, we need to sort left and right part of
        // pivot
        sort(arr, low, e);
        sort(arr, s, high);
    }
}
// Time Complexity: O(n log n) on average, O(n^2) in the worst case (when the
// array is already sorted or reverse sorted)
// Space Complexity: O(log n) due to the recursive stack space used by the
// algorithm.
// Stable: No, as it does not maintain the relative order of equal elements.
// Adaptive: No, as it does not adapt to the existing order of elements in the
// array.
// Online: No, as it requires the entire array to be available before sorting.
// Comparison-based: Yes, as it compares elements to sort them.
// Non-comparison-based: No, as it does not use any non-comparison-based sorting
// techniques.

// Divide and conquer: Yes, as it divides the array into smaller sub-arrays and
// conquers them recursively.
// Recursive: Yes, as it uses recursion to sort the sub-arrays.
// Iterative: No, as it is a recursive algorithm.
// In-place: Yes, as it does not require any additional storage for sorting,
// except for the recursive stack space.
// It is an in-place sorting algorithm as it sorts the array without using any
// additional storage space for another array.
// It is not a stable sorting algorithm as it does not maintain the relative
// order of equal elements.
// It is not adaptive as it does not adapt to the existing order of elements in
// the array.
// It is not an online sorting algorithm as it requires the entire array to be
// available before sorting.
// It is a comparison-based sorting algorithm as it compares elements to sort
// them.
// It is not a non-comparison-based sorting algorithm as it does not use any
// non-comparison-based sorting techniques.
// It is a divide and conquer sorting algorithm as it divides the array into
// smaller sub-arrays and conquers them recursively.
// It is a recursive sorting algorithm as it uses recursion to sort the
// sub-arrays.
