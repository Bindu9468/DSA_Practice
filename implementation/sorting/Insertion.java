package implementation.sorting;

public class Insertion {
    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6 };
        int n = arr.length;
        insertionSort(arr, n);
        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    static void insertionSort(int arr[], int n) {
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }

            }
            arr[j + 1] = key;
        }
    }
}
// Time Complexity: O(n^2) in worst case, O(n) in best case (when the array is
// already sorted)
// Space Complexity: O(1) as it is an in-place sorting algorithm.
// Stable: Yes, as it maintains the relative order of equal elements.
// Adaptive: Yes, as it is efficient for data that is already substantially
// sorted.
// Online: Yes, as it can sort a list as it receives it.
// Comparison-based: Yes, as it compares elements to sort them.
// Non-comparison-based: No, as it does not use any non-comparison-based sorting
// techniques.
// Divide and conquer: No, as it does not use the divide and conquer approach.
// Recursive: No, as it is an iterative algorithm.
// Iterative: Yes, as it uses a loop to iterate through the array and sort it.
// In-place: Yes, as it does not require any additional storage for sorting.