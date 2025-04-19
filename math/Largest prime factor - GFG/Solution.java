class Solution {
    static int largestPrimeFactor(int n) {
        // code here
        while (n % 2 == 0) {
            n /= 2;
        }
        int largestprime = 2;

        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                largestprime = i;
                n /= i;
            }
        }
        if (n > 2) {
            largestprime = n;
        }
        return largestprime;

    }
}