class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length, left = 0;
        long sums = 0, count = 0;

        for (int right = 0; right < n; right++) {
            sums += nums[right];
            while (sums * (right - left + 1) >= k) {
                sums -= nums[left];
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
}
// Time Complexity: O(n) where n is the number of elements in the array.
// Space Complexity: O(1) as we are using only a constant amount of space.
// The algorithm uses a sliding window approach to find the number of subarrays
// whose score is less than k. It maintains a sum of the elements in the current
// window and checks if the score of the current window is less than k. If it
// is, it adds the number of subarrays ending at the current right index to the
// count. If the score is greater than or equal to k, it shrinks the window from

// the left until the score is less than k. The final count is returned as the
// result.
// The algorithm is efficient and runs in linear time, making it suitable for

/*
 * The score of an array is defined as the product of its sum and its length.
 * 
 * For example, the score of [1, 2, 3, 4, 5] is (1 + 2 + 3 + 4 + 5) * 5 = 75.
 * Given a positive integer array nums and an integer k, return the number of
 * non-empty subarrays of nums whose score is strictly less than k.
 * 
 * A subarray is a contiguous sequence of elements within an array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,1,4,3,5], k = 10
 * Output: 6
 * Explanation:
 * The 6 subarrays having scores less than 10 are:
 * - [2] with score 2 * 1 = 2.
 * - [1] with score 1 * 1 = 1.
 * - [4] with score 4 * 1 = 4.
 * - [3] with score 3 * 1 = 3.
 * - [5] with score 5 * 1 = 5.
 * - [2,1] with score (2 + 1) * 2 = 6.
 * Note that subarrays such as [1,4] and [4,3,5] are not considered because
 * their scores are 10 and 36 respectively, while we need scores strictly less
 * than 10.
 * Example 2:
 * 
 * Input: nums = [1,1,1], k = 5
 * Output: 5
 * Explanation:
 * Every subarray except [1,1,1] has a score less than 5.
 * [1,1,1] has a score (1 + 1 + 1) * 3 = 9, which is greater than 5.
 * Thus, there are 5 subarrays having scores less than 5.
 * 
 */