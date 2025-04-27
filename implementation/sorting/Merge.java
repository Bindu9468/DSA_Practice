package implementation.sorting;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int arr[] = { 25, 23, 1, 4, 5, 6, 45, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        arr = mergesort(arr);
        System.out.println("Sorted array: ");
        System.out.println(Arrays.toString(arr));
    }

    static int[] mergesort(int arr[]) {
        if (arr.length == 1) {
            return arr;
        }
        int mid = arr.length / 2;

        int[] left = mergesort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergesort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    static int[] merge(int left[], int right[]) {
        int i = 0, j = 0, k = 0;
        int[] merged = new int[left.length + right.length];
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                merged[k++] = left[i++];

            } else {
                merged[k++] = right[j++];
            }
        }

        // Copy remaining elements of left array if any
        while (i < left.length) {
            merged[k++] = left[i++];
        }
        // Copy remaining elements of right array if any
        while (j < right.length) {
            merged[k++] = right[j++];
        }
        return merged;

    }
}
