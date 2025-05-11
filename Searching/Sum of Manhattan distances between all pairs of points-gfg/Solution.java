import java.util.*;

class Solution {
    public static int distance(int arr[], int n) {
        Arrays.sort(arr);
        int res = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            res += arr[i] * i - sum;
            sum += arr[i];
        }

        return res;
    }

    public static int totalDistance(int x[], int y[], int n) {
        return distance(x, n) + distance(y, n);
    }

    public static void main(String[] args) {
        int x[] = { -1, 1, 3, 2 };
        int y[] = { 5, 6, 5, 3 };
        int n = x.length;
        System.out.println(totalDistance(x, y, n)); // Output: 22
    }
}
//
// Time Complexity: O(nlogn) where n is the length of the input array nums.
// Space Complexity: O(1) as we are using only a constant amount of space
/*
 * Given n integer coordinates. The task is to find the sum of the Manhattan
 * distance between all pairs of coordinates.
 * Manhattan Distance between (x1, y1) and (x2, y2) is: |x1 – x2| + |y1 – y2|
 * 
 * Examples :
 * 
 * Input : n = 4, p1 = { -1, 5 }, p2 = { 1, 6 }, p3 = { 3, 5 }, p4 = { 2, 3 }
 * Output : 22
 * Explanation :
 * Distance of { 1, 6 }, { 3, 5 }, { 2, 3 } from { -1, 5 } are 3, 4, 5
 * respectively. Therefore, sum = 3 + 4 + 5 = 12.
 * Distance of { 3, 5 }, { 2, 3 } from { 1, 6 } are 3, 4 respectively.
 * Therefore, sum = 12 + 3 + 4 = 19
 * Distance of { 2, 3 } from { 3, 5 } is 3. Therefore, sum = 19 + 3 = 22.
 * 
 */