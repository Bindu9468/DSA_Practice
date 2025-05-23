
//{ Driver Code Starts
class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        // Your Code Here
        int temp[] = new int[arr.length];
        return mergecount(arr, temp, 0, arr.length - 1);
    }

    static int mergecount(int arr[], int temp[], int left, int right) {
        int count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            count += mergecount(arr, temp, left, mid);
            count += mergecount(arr, temp, mid + 1, right);
            count += merge(arr, temp, left, mid, right);
        }
        return count;
    }

    static int merge(int arr[], int temp[], int left, int mid, int right) {
        int i = left, j = mid + 1, k = left, count = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += mid - i + 1;
            }
        }
        while (i <= mid)
            temp[k++] = arr[i++];
        while (j <= right)
            temp[k++] = arr[j++];
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
        return count;
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