package top_liked.medium;

import java.util.TreeMap;

/**
 * 74. Search a 2D Matrix
 */
public class Search2DMatrix {


    public static void main(String[] args) {
        var s = new Search2DMatrix();
        var matrix = new int[][]{{1}};
        System.out.println(s.searchMatrix(matrix, 2));

        matrix = new int[][]{{1},{3}};
        System.out.println(s.searchMatrix(matrix, 3));

        matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(s.searchMatrix(matrix, 3));
        System.out.println(s.searchMatrix(matrix, 13));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        boolean result = false;
//        int row = approximateBinarySearch(matrix, target);
        int row = approximateBinarySearch(matrix, target);
        int col = binarySearch(matrix[row], target);
        if (col >= 0) {
            result = true;
        }

        return result;
    }

    public int approximateBinarySearch(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length-1;
        TreeMap<Integer, Integer> map = new TreeMap();

        while(left <= right ) {
            int mid = (left + right) / 2;
            if (target - matrix[mid][0] >= 0) {
                map.put(target - matrix[mid][0], mid);
            }
            if (matrix[mid][0] > target) {
                mid--;
                right = mid;
            } else {
                mid++;
                left = mid;
            }
        }

        return map.size() == 0 ? 0 : map.get(map.firstKey());
    }


    public int binarySearch(int[] matrix, int target) {
        int left = 0;
        int right = matrix.length-1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if (matrix[mid] == target) {
                return mid;
            } else if (matrix[mid] > target) {
                mid--;
                right = mid;
            } else {
                mid++;
                left = mid;
            }
        }

        return -1;
    }
}
