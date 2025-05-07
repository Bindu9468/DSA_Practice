class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        if (a == 1 || b == 1 || c == 1)
            return n;

        long ab = lcm(a, b);
        long bc = lcm(b, c);
        long ac = lcm(a, c);
        long abc = lcm(a, lcm(b, c));
        long left = 1, right = 2_000_000_000L;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (countugly(mid, a, b, c, ab, bc, ac, abc) < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (int) left;
    }

    private long countugly(long num, int a, int b, int c, long ab, long bc, long ca, long abc) {
        return num / a + num / b + num / c - num / ab - num / bc - num / ca + num / abc;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}

// Time Complexity: O(log n) where n is the number of ugly numbers to be found
// Space Complexity: O(1) as we are using only a constant amount of space
// Stable: No, as it does not maintain the relative order of equal elements.
// Adaptive: No, as it does not adapt to the existing order of elements in the
// array

/*
 * An ugly number is a positive integer that is divisible by a, b, or c.
 * 
 * Given four integers n, a, b, and c, return the nth ugly number.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 3, a = 2, b = 3, c = 5
 * Output: 4
 * Explanation: The ugly numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3rd is 4.
 * Example 2:
 * 
 * Input: n = 4, a = 2, b = 3, c = 4
 * Output: 6
 * Explanation: The ugly numbers are 2, 3, 4, 6, 8, 9, 10, 12... The 4th is 6.
 * Example 3:
 * 
 * Input: n = 5, a = 2, b = 11, c = 13
 * Output: 10
 * Explanation: The ugly numbers are 2, 4, 6, 8, 10, 11, 12, 13... The 5th is
 * 10.
 * 
 * 
 * Constraints:
 * 
 * 1 <= n, a, b, c <= 109
 * 1 <= a * b * c <= 1018
 * It is guaranteed that the result will be in range [1, 2 * 109].
 */