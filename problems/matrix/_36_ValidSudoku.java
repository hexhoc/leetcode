package problems.matrix;

import java.util.HashSet;

public class _36_ValidSudoku {

    public static void main(String[] args) {
        char[][] board1 = new char[][] {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        char[][] board2 = new char[][] {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '3', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        char[][] board3 = new char[][] {
                {'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};

        var s = new _36_ValidSudoku();
        System.out.println(s.isValidSudoku(board3));
        System.out.println(s.isValidSudoku(board1));
        System.out.println(s.isValidSudoku(board2));

    }

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rowCheck = new HashSet[9];
        HashSet<Character>[] colCheck = new HashSet[9];
        HashSet<Character>[] subBoxCheck = new HashSet[9];

        for (int row = 0; row < 9; row++) {
            rowCheck[row] = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                if (colCheck[col] == null) {
                    colCheck[col] = new HashSet<>();
                }
                if (board[row][col] == '.') {
                    continue;
                }

                if (rowCheck[row].contains(board[row][col])) {
                    return false;
                } else {
                    rowCheck[row].add(board[row][col]);
                }

                if (colCheck[col].contains(board[row][col])) {
                    return false;
                } else {
                    colCheck[col].add(board[row][col]);
                }

                int subBox = 0;
                if (col < 3) {
                    if (row < 3) {
                        subBox = 0;
                    } else if (row < 6) {
                        subBox = 3;
                    } else {
                        subBox = 6;
                    }
                } else if (col < 6) {
                    if (row < 3) {
                        subBox = 1;
                    } else if (row < 6) {
                        subBox = 4;
                    } else {
                        subBox = 7;
                    }
                } else {
                    if (row < 3) {
                        subBox = 2;
                    } else if (row < 6) {
                        subBox = 5;
                    } else {
                        subBox = 8;
                    }
                }

                if (subBoxCheck[subBox] == null) {
                    subBoxCheck[subBox] = new HashSet<>();
                }
                if (subBoxCheck[subBox].contains(board[row][col])) {
                    return false;
                } else {
                    subBoxCheck[subBox].add(board[row][col]);
                }
            }
        }

        return true;
    }

}
