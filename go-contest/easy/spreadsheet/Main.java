/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        var s = new Main();
        var r = s.sortTable(new int[][] {
                { 3, 4, 1 },
                { 2, 2, 5 },
                { 2, 4, 2 },
                { 2, 2, 1 } }, 
                3,
                new int[] { 2, 1, 3 });
        System.out.println(r);
    }

    public int[][] sortTable(int[][] matrix, int clickCount, int[] columnSortArr) {
        for (int col : columnSortArr) {
            boolean keepSort = true;
            while (keepSort) {
                keepSort = false;
                for (int row = 0; row < matrix.length - 1; row++) {
                    if (matrix[row][col - 1] > matrix[row + 1][col - 1]) {
                        keepSort = true;
                        int[] temp = matrix[row];
                        matrix[row] = matrix[row + 1];
                        matrix[row + 1] = temp;
                    }
                }
            }
        }

        return matrix;
    }

}
