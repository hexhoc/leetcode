package problems.sliding_window;

import static util.Assertions.assertEquals;

import java.util.PriorityQueue;

public class _239_SlidingWindowMaximum {

    public static void main(String[] args) {
        var s = new _239_SlidingWindowMaximum();

        assertEquals(new int[]{6, 7}, s.maxSlidingWindow(new int[]{1,2,3,4,5,6,7}, 6));
        assertEquals(new int[]{1, -1}, s.maxSlidingWindow(new int[]{1, -1}, 1));
        assertEquals(new int[]{7, 4}, s.maxSlidingWindow(new int[]{7, 2, 4}, 2));
        assertEquals(new int[]{1}, s.maxSlidingWindow(new int[]{1}, 1));
        assertEquals(new int[]{3, 3, 5, 5, 6, 7}, s.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.add(num);
        }
        for (int i = 0; i < result.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            result[i] = max;
        }

        return result;
    }

}
