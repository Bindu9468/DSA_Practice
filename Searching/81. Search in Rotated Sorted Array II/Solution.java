class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target)
                return true;

            if (nums[start] == nums[mid] && nums[end] == nums[mid]) {
                start++;
                end--;
            }
            // left
            else if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // right
            else {
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}

// Time Complexity: O(n) in the worst case (when all elements are the same and
// we have to check each element)
// Space Complexity: O(1) as we are using only a constant amount of space
// Stable: No, as it does not maintain the relative order of equal elements.
// Adaptive: No, as it does not adapt to the existing order of elements in the
// array.
// Online: No, as it requires the entire array to be available before searching.
// Comparison-based: Yes, as it compares elements to search for the target.