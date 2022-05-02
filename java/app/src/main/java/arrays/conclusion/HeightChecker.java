package arrays.conclusion;

import java.util.stream.IntStream;

public class HeightChecker {
    public static void main(String[] args) {
        HeightChecker.execute(new int[]{1,1,4,2,1,3});
    }

    public static int execute(int[] heights) {
        int result = 0;
        int[] expected = IntStream.of(heights).sorted().toArray();

        for (int i = 0; i < expected.length; i++) {
            if (heights[i] != expected[i]) {
                result++;
            }
        }

        return result;
    }

}
