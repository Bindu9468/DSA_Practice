
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++)
                arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    static int inversionCount(int arr[]) {
        int[] temp = new int[arr.length];
        return mergeSort(arr, temp, 0, arr.length - 1);
    }

    static int mergeSort(int[] arr, int[] temp, int left, int right) {
        int mid, invCount = 0;
        if (left < right) {
            mid = (left + right) / 2;

            invCount += mergeSort(arr, temp, left, mid);
            invCount += mergeSort(arr, temp, mid + 1, right);
            invCount += merge(arr, temp, left, mid + 1, right);
        }
        return invCount;
    }

    static int merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left; // left subarray pointer
        int j = mid; // right subarray pointer
        int k = left; // temp array pointer
        int invCount = 0;

        while (i <= mid - 1 && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                invCount += (mid - i); // Count inversions
            }
        }

        // Copy remaining elements
        while (i <= mid - 1)
            temp[k++] = arr[i++];
        while (j <= right)
            temp[k++] = arr[j++];

        // Copy back to original array
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return invCount;
    }
}
// Time Complexity: O(n log n) where n is the length of the input array nums.
// Space Complexity: O(n) as we are using an auxiliary array of size n to store
// the merged elements.
// Stable: Yes, as it maintains the relative order of equal elements.
// The algorithm uses a modified merge sort to count the number of inversions in
// the array.
// An inversion is a pair of indices (i, j) such that i < j and arr[i] > arr[j].
/*
 * Given an array of integers arr[]. Find the Inversion Count in the array.
 * Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i <
 * j.
 * 
 * Inversion Count: For an array, inversion count indicates how far (or close)
 * the array is from being sorted. If the array is already sorted then the
 * inversion count is 0.
 * If an array is sorted in the reverse order then the inversion count is the
 * maximum.
 * 
 * Examples:
 * 
 * Input: arr[] = [2, 4, 1, 3, 5]
 * Output: 3
 * Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1),
 * (4, 3).
 * Input: arr[] = [2, 3, 4, 5, 6]
 * Output: 0
 * Explanation: As the sequence is already sorted so there is no inversion
 * count.
 * Input: arr[] = [10, 10, 10]
 * Output: 0
 * Explanation: As all the elements of array are same, so there is no inversion
 * count.
 * Constraints:
 * 1 ≤ arr.size() ≤ 105
 * 1 ≤ arr[i] ≤ 104
 */