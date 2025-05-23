package CodeBattle_Test.MaximumNonAdjacentSubsequenceSum;

class Solution {
    public int maxNonAdjacentSum(int[] nums) {
        // write your code here
        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int curr = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;

    }
}

/*
 * 1. Maximum Non-Adjacent Subsequence Sum
 * Medium
 * Given an array of integers, find the maximum sum of a subsequence such that
 * no two elements of the subsequence are adjacent in the original array.
 * 
 * Example 1:
 * 
 * 5
 * 3 2 5 10 7
 * Input
 * 15
 * Output
 * Explaination:
 * 
 * The maximum sum of a non-adjacent subsequence is 15, which can be achieved by
 * selecting the elements 3, 5, and 7.
 * 
 * Constraints:
 * 
 * 1 <= n <= 104
 * 0 <= nums[i] <= 1000
 * Input Format:
 * 
 * An array of integers
 * 
 * Output Format:
 * 
 * The maximum sum of a non-adjacent subsequence
 */