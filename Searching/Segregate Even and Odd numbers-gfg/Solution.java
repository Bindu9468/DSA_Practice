class Solution {
    void segregateEvenOdd(int arr[]) {
        // code here
        int left = 0, right = arr.length - 1;

        while (left < right) {
            while (arr[left] % 2 == 0 && left < right)
                left++;

            while (arr[right] % 2 == 1 && left < right)
                right--;

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        int evencount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                evencount++;
        }
        Arrays.sort(arr, 0, evencount);
        Arrays.sort(arr, evencount, arr.length);
    }
}

// or

class Solution {
    void segregateEvenOdd(int arr[]) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for (int num : arr) {
            if (num % 2 == 0)
                even.add(num);
            else
                odd.add(num);
        }
        Collections.sort(even);
        Collections.sort(odd);

        List<Integer> result = new ArrayList<>();
        result.addAll(even);
        result.addAll(odd);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result.get(i);
        }
    }
}

/*
 * Given an array arr, write a program segregating even and odd numbers. The
 * program should put all even numbers first in sorted order, and then odd
 * numbers in sorted order.
 * 
 * Note:- You don't have to return the array, you have to modify it in-place.
 * 
 * Example:
 * 
 * Input: arr[] = [12, 34, 45, 9, 8, 90, 3]
 * Output: [8, 12, 34, 90, 3, 9, 45]
 * Explanation: Even numbers are 12, 34, 8 and 90. Rest are odd numbers.
 * Input: arr[] = [0, 1, 2, 3, 4]
 * Output: [0, 2, 4, 1, 3]
 * Explanation: 0 2 4 are even and 1 3 are odd numbers.
 * Input: arr[] = [10, 22, 4, 6]
 * Output: [10, 22, 4, 6]
 * Explanation: Here all elements are even, so no need of segregataion
 * Constraints:
 * 1 ≤ arr.size() ≤ 106
 * 0 ≤ arr[i] <=105
 * 
 * Expected Complexities
 * Time Complexity: O(n log n)
 * Auxiliary Space: O(1)
 */

// Time Complexity: O(n log n) where n is the length of the input array arr.
// Space Complexity: O(1) as we are using only a constant amount of space
