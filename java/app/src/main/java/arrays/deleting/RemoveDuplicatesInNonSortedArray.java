package arrays.deleting;


public class RemoveDuplicatesInNonSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,3,4,5,1,2,3,4,5}; 
        RemoveDuplicatesInNonSortedArray.execute(nums);
        //Should be {1,2}
    }
    
    public static void execute(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            boolean isDublicate = false;

            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    nums[j] = 0;
                    isDublicate = true;
                }
            }

            if (isDublicate) {
                nums[i] = 0;
            }
        }
    }
}
