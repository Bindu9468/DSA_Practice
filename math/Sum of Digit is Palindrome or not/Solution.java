class Solution {
    boolean isDigitSumPalindrome(int n) {
        // code here
        int rem = 0, sum = 0;
        while (n > 0) {
            rem = n % 10;
            sum = sum + rem;
            n = n / 10;
        }
        String ori = Integer.toString(sum);
        String rev = new StringBuilder(ori).reverse().toString();

        return ori.equals(rev);
    }
}