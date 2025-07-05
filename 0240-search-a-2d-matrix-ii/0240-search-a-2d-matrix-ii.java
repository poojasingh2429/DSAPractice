public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            int value = matrix[row][col];

            if (value == target) {
                return true;
            } else if (value > target) {
                col--; // Move left
            } else {
                row++; // Move down
            }
        }

        return false; // Not found
    }
}
