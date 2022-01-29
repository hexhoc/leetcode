package arrays.searching;

public class moveZeroes {
    public static void main(String[] args) {

        moveZeroes.execute(new int[]{0,1,0,3,12});
        moveZeroes.execute(new int[]{0,1,3,12,0});
    }

    public static void execute(int[] nums) {

        int[] newNums = new int[nums.length];
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                newNums[k] = nums[i];
                k++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }
    }
}
