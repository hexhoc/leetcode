package arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,2,3,0,4,2};

        int k = RemoveElement.execute(arr, 2);
    }

    public static int execute(int[] nums, int val) {
        
        int k = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = 0;
                for (int j = i; j < nums.length-1; j++) {
                    nums[j] = nums[j+1];
                    nums[j+1] = 0;
                }
                k--;
                i--;
            }
        }

        return k;
    }
}
