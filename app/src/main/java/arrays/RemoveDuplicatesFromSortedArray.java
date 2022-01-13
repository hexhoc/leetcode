package arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicatesFromSortedArray.execute(arr);
    }

    public static int execute(int[] nums) {
        int[] newNums = new int[nums.length];
        int total = 0;
        
        for (int i = 0, k = 0; i < nums.length; i++) {
            if (i == 0) {
                newNums[k] = nums[i];
                k++;
                continue;
            }

            if (nums[i] != nums[i-1]) {
                newNums[k] = nums[i];
                k++;
                total++;
            }
        }

        return total;
    }
}
