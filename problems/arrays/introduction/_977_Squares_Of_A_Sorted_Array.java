package problems.arrays.introduction;

public class _977_Squares_Of_A_Sorted_Array {
    public static void main(String[] args) {
        _977_Squares_Of_A_Sorted_Array task = new _977_Squares_Of_A_Sorted_Array();
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
