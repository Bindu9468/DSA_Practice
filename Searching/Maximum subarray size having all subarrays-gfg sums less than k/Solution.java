class Solution {
    public static int maxSubarraySize(int[] arr, int n, int k) {
        int maxSize = 0;

        for (int size = 1; size <= n; size++) {
            int sum = 0;
            boolean allLessThanK = true;

            // First window of size 'size'
            for (int i = 0; i < size; i++) {
                sum += arr[i];
            }
            if (sum >= k) {
                allLessThanK = false;
            }

            // Slide the window
            for (int i = size; i < n && allLessThanK; i++) {
                sum += arr[i] - arr[i - size];
                if (sum >= k) {
                    allLessThanK = false;
                }
            }

            if (allLessThanK) {
                maxSize = size;
            }
        }

        return maxSize;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        int k = 8;
        int result = maxSubarraySize(arr, arr.length, k);
        System.out.println("Maximum subarray size with sum < " + k + " is: " + result);
    }
}
// Time Complexity: O(n^2) in the worst case, where n is the size of the array.
// Space Complexity: O(1) as we are using only a constant amount of space.
// The algorithm uses a brute-force approach to find the maximum subarray size
// with a sum less than k. It iterates through all possible subarray sizes and
// checks if the sum of each subarray is less than k. If it is, it updates the
// maximum size. The final result is returned as the output.