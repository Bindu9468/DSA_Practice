class Solution {
    public double myPow(double x, int n) {
        return Math.pow(x, n);
    }
}

// or
/*
 * class Solution {
 * public double myPow(double x, int n) {
 * // Handle edge cases
 * if (n == 0) return 1;
 * if (x == 1) return 1;
 * if (x == -1) return n % 2 == 0 ? 1 : -1;
 * 
 * // Convert n to long to handle Integer.MIN_VALUE
 * long N = n;
 * if (N < 0) {
 * x = 1 / x;
 * N = -N;
 * }
 * 
 * return binaryPow(x, N);
 * }
 * 
 * private double binaryPow(double x, long n) {
 * if (n == 0) return 1;
 * 
 * // Calculate half power
 * double half = binaryPow(x, n / 2);
 * 
 * // If n is odd, multiply by x one extra time
 * if (n % 2 == 0) {
 * return half * half;
 * } else {
 * return half * half * x;
 * }
 * }
 * }
 * 
 * //Time Complexity: O(log n) for the recursive approach, O(1) for the
 * iterative approach
 * //Space Complexity: O(log n) for the recursive approach, O(1) for the
 * iterative approach
 * /*
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * Example 2:
 * 
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * Example 3:
 * 
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * 
 * 
 * Constraints:
 * 
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * n is an integer.
 * Either x is not zero or n > 0.
 * -104 <= xn <= 104
 */