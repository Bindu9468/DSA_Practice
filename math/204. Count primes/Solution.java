import java.util.Arrays;

class Solution {
    public int countPrimes(int n) {
        boolean[] isprime = new boolean[n];
        Arrays.fill(isprime, true);

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isprime[i]) {
                count++;

                for (int j = i * 2; j < n; j += i) {
                    isprime[j] = false;
                }
            }
        }
        return count;

    }
}