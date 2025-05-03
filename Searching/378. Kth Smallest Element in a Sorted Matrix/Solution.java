
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
                { 1, 5, 9 },
                { 10, 11, 13 },
                { 12, 13, 15 }
        };
        int k = 8;
        System.out.println(solution.kthSmallest(matrix, k)); // Output: 13
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countless(matrix, mid, n);

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    int countless(int[][] matrix, int mid, int n) {
        int count = 0;
        int row = n - 1;
        int col = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) {
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }
        return count;
    }

}

// time complexity: O(n log(max-min)) where n is the number of elements in the
// matrix and max and min are the maximum and minimum elements in the matrix
// respectively.
// space complexity: O(1) as we are using only a constant amount of space.
//// The algorithm uses binary search to find the kth smallest element in the matrix.
// The countless function counts the number of elements less than or equal to
// mid in the matrix.