import java.util.*;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int mindist = 0, maxdist = nums[nums.length - 1] - nums[0];

        while (mindist < maxdist) {
            int mid = mindist + (maxdist - mindist) / 2;
            int countpairs = count(nums, mid);
            if (countpairs < k) {
                mindist = mid + 1;
            } else {
                maxdist = mid;
            }
        }
        return mindist;
    }

    private static int count(int[] nums, int k) {
        int left = 0, count = 0;
        for (int right = 1; right < nums.length; right++) {
            while (nums[right] - nums[left] > k) {
                left++;
            }
            count += right - left;
        }
        return count;
    }
}

// Time Complexity: O(n log n) where n is the length of the input array nums.
// space complexity is O(1) as we are using only a constant amount of space
// Stable: No, as it does not maintain the relative order of equal elements.
/*
 * The distance of a pair of integers a and b is defined as the absolute
 * difference between a and b.
 * 
 * Given an integer array nums and an integer k, return the kth smallest
 * distance among all the pairs nums[i] and nums[j] where 0 <= i < j <
 * nums.length.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,1], k = 1
 * Output: 0
 * Explanation: Here are all the pairs:
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * Then the 1st smallest distance pair is (1,1), and its distance is 0.
 * Example 2:
 * 
 * Input: nums = [1,1,1], k = 2
 * Output: 0
 * Example 3:
 * 
 * Input: nums = [1,6,1], k = 3
 * Output: 5
 * 
 * 
 * Constraints:
 * 
 * n == nums.length
 * 2 <= n <= 104
 * 0 <= nums[i] <= 106
 * 1 <= k <= n * (n - 1) / 2
 */