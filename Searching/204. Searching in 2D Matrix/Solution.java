class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;

        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            }
        }
        return false;
    }
}

// Time Complexity: O(m + n) where m is the number of rows and n is the number
// of columns in the matrix
// Space Complexity: O(1) as we are using only a constant amount of space
// Stable: No, as it does not maintain the relative order of equal elements.
// Adaptive: No, as it does not adapt to the existing order of elements in the
// matrix
// Online: No, as it requires the entire matrix to be available before searching
/*
 * Write an efficient algorithm that searches for a value target in an m x n
 * integer matrix matrix. This matrix has the following properties:
 * 
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix =
 * [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]
 * , target = 5
 * Output: true
 */