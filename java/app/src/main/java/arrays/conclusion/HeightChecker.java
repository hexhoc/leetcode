package arrays.conclusion;

import java.util.Arrays;

public class HeightChecker {
    public static void main(String[] args) {
        HeightChecker.execute(new int[]{1,1,4,2,1,3});
    }

    public static int execute(int[] heights) {
        int result = 0;
        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);
        
        for (int i = 0; i < heights.length; i++) {
            if(heights[i] != expected[i]) {
                result++;
            }
        }

        return result;
    }

}
