
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (mid % 2 == 1)
                mid--;

            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
// time complexity: O(log n) where n is the number of elements in the array.
// space complexity: O(1) as we are using only a constant amount of space.

// if sorted use binary search to find the single element
// if not sorted use a set to find the single element

/*
 * 
 * or
 * 
 * import java.util.*;
 * 
 * class Solution {
 * public int singleNonDuplicate(int[] nums) {
 * Set<Integer> seen = new HashSet<>();
 * 
 * for (int num : nums) {
 * if (!seen.add(num)) {
 * seen.remove(num);
 * }
 * }
 * 
 * return seen.iterator().next();
 * }
 * }
 * // time complexity: O(n) where n is the number of elements in the array.
 * // space complexity: O(n) for the set to store the elements.
 * 
 * /*
 * You are given a sorted array consisting of only integers where every element
 * appears exactly twice, except for one element which appears exactly once.
 * 
 * Return the single element that appears only once.
 * 
 * Your solution must run in O(log n) time and O(1) space.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 * 
 * Input: nums = [3,3,7,7,10,11,11]
 * Output: 10
 */