package arrays.inplace;

public class ReplaceElementsWithGreatestElementOnRightSide {
    public static void main(String[] args) {
        int[] nums = new int[]{17,18,5,4,6,1};
        ReplaceElementsWithGreatestElementOnRightSide.execute(nums);
    }

    public static int[] execute(int[] nums) {

        int max = nums[nums.length-1];
        nums[nums.length-1] = -1;
        int temp = 0;

        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] > max) {
                temp = nums[i];
                nums[i] = max;
                max = temp;
            } else {
                nums[i] = max;
            }
        }

        return nums;
    }
}