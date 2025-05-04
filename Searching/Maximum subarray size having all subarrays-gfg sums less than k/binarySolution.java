class binarySolution {
    public static int maxSubarraySize(int[] arr, int n, int k) {
        int left = 1, right = n;
        int maxSize = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isValid(arr, n, mid, k)) {
                maxSize = mid; // try to find a bigger size
                left = mid + 1;
            } else {
                right = mid - 1; // try smaller size
            }
        }

        return maxSize;
    }

    private static boolean isValid(int[] arr, int n, int size, int k) {
        int sum = 0;
        // sum of first 'size' elements
        for (int i = 0; i < size; i++) {
            sum += arr[i];
        }
        if (sum >= k)
            return false;

        for (int i = size; i < n; i++) {
            sum += arr[i] - arr[i - size];
            if (sum >= k)
                return false;
        }

        return true; // all subarrays of this size have sum < k
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        int k = 8;
        int result = maxSubarraySize(arr, arr.length, k);
        System.out.println("Maximum subarray size with sum < " + k + " is: " + result);
    }
}
