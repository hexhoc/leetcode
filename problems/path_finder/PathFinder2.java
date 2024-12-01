package problems.path_finder;

import static util.Assertions.assertEquals;

public class PathFinder2 {
    public static void main(String[] args) {
        var a = ".W.\n" +
                ".W.\n" +
                "...";

        var d = "......\n" +
                "......\n" +
                "......\n" +
                "......\n" +
                ".....W\n" +
                "....W.";

//        assertEquals(4, pathFinder(a));
        assertEquals(-1, pathFinder(d));
    }

    static int pathFinder(String maze) {
        var lines = maze.split("\n");
        int height = lines.length;
        int width = lines[0].length();
        char[][] mazeMatrix = new char[height][width];
        int[][] visited = new int[height][width];

        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length(); j++) {
                mazeMatrix[i][j] = lines[i].charAt(j);
            }
        }

        visit(0, 0, mazeMatrix, visited, 1);

        return visited[height - 1][width - 1] - 1;
    }

    static void visit(int x, int y, char[][] maze, int[][] visited, int step) {
        if ((visited[y][x] > 0 && visited[y][x] <= step) || maze[y][x] == 'W') {
            return;
        }

        visited[y][x] = step;

        if (x + 1 < maze[0].length) {
            visit(x + 1, y, maze, visited, step + 1);
        }

        if (y + 1 < maze.length) {
            visit(x, y + 1, maze, visited, step + 1);
        }

        if (x - 1 >= 0) {
            visit(x - 1, y, maze, visited, step + 1);
        }

        if (y - 1 >= 0) {
            visit(x, y - 1, maze, visited, step + 1);
        }

        System.out.println(1);
    }

}