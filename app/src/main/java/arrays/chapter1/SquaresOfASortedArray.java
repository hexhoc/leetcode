package arrays.chapter1;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        SquaresOfASortedArray task = new SquaresOfASortedArray();
        task.sortedSquares(new int[]{-4,-1,0,3,10});
    }

    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }

        java.util.Arrays.sort(nums);

        return nums;
    }

}
