package problems.binary_search;

import static util.Assertions.assertEquals;

/**
 * 74. Search a 2D Matrix
 */
public class _74_Search2DMatrix {


    public static void main(String[] args) {
        var s = new _74_Search2DMatrix();

        var matrix = new int[][]{
            {1,3,5,7},
            {10,11,16,20},
            {23,30,34,60}};
        assertEquals(true, s.searchMatrix(matrix, 3));
        assertEquals(false, s.searchMatrix(matrix, 13));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int lengthX = matrix[0].length;
        int lengthY = matrix.length;
        int left = 0;
        int right = (lengthX * lengthY) - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midX = mid % lengthX;
            int midY = Math.min(mid / lengthX, lengthY - 1);

            if (matrix[midY][midX] == target) {
                return true;
            } else if (matrix[midY][midX] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

}
