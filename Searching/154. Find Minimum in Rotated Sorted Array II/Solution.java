class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                end--;
            }
        }
        return nums[start];

    }
}

// Condition Use Case
/*
 * start < end Searching for a minimum, not returning mid in loop
 * start <= end Searching for exact match (e.g., nums[mid] == target) and
 * returning in loop
 */

// Time Complexity: O(log n) in the average case, O(n) in the worst case (when
// all elements are the same)
// Space Complexity: O(1) as we are using only a constant amount of space
// Stable: No, as it does not maintain the relative order of equal elements.
// Adaptive: No, as it does not adapt to the existing order of elements in the
// array.