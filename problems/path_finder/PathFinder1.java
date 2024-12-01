package problems.path_finder;

import static util.Assertions.assertEquals;

public class PathFinder1 {
    public static void main(String[] args) {
        var a = ".W.\n"+
                ".W.\n"+
                "...";

        var d = "......\n"+
                "......\n"+
                "......\n"+
                "......\n"+
                ".....W\n"+
                "....W.";

        assertEquals(true, pathFinder(a));
        assertEquals(false, pathFinder(d));
    }

    static boolean pathFinder(String maze) {
        // convert string to matrix
        var arr = maze.split("\n");
        int width = arr[0].length();
        int height = arr.length;
        char[][] mazeMatrix = new char[height][width];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length(); j++) {
                mazeMatrix[i][j] = arr[i].charAt(j);
            }
        }

        boolean[][] visited = new boolean[height][width];
        visit(0, 0, mazeMatrix, visited);

        return visited[height-1][width-1];
    }

    static void visit(int x, int y, char[][] maze, boolean[][] visited) {
        if (visited[y][x]) {
            return;
        }
        visited[y][x] = true;
        if (maze[y][x] == 'W') {
            return;
        }

        if (x - 1 >= 0) {
            visit(x - 1, y, maze, visited);
        }

        if (x + 1 < maze[0].length) {
            visit(x + 1, y, maze, visited);
        }

        if (y - 1 >= 0) {
            visit(x, y - 1, maze, visited);
        }

        if (y + 1 < maze.length) {
            visit(x, y + 1, maze, visited);
        }
    }

}
