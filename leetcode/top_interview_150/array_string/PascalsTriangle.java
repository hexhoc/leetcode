package top_interview_150.array_string;

import java.util.ArrayList;
import java.util.List;

/*
118. Pascal's Triangle
 */
public class PascalsTriangle {

    public static void main(String[] args) {
        var s = new PascalsTriangle();
        s.generate(5);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> prevRow = List.of(1);
        result.add(prevRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i+1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            row.add(1);

            result.add(row);
            prevRow = row;
        }

        return result;
    }
}
