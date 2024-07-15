package problems.arrays;

import static util.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

/*
118. Pascal's Triangle
easy

MUST LEARN
 */
public class _118_PascalsTriangle {

    public static void main(String[] args) {
        var s = new _118_PascalsTriangle();
        assertEquals(List.of(
            List.of(1),
            List.of(1, 1),
            List.of(1, 2, 1),
            List.of(1, 3, 3, 1),
            List.of(1, 4, 6, 4, 1)), s.execute(5));
    }

    public List<List<Integer>> execute(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            var row = new ArrayList<Integer>();
            for (int j = 0; j < i+1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }

            result.add(row);
        }

        return result;
    }
}