package arrays.deleting;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr1 = new int[]{0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicatesFromSortedArray.execute(arr1);

        int[] arr2 = new int[]{1,1,2};
        RemoveDuplicatesFromSortedArray.execute(arr2);

        int[] arr3 = new int[]{1};
        RemoveDuplicatesFromSortedArray.execute(arr3);
    }

    public static int execute(int[] nums) {

        if (nums.length == 0) { 
            return 0;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                nums[j] = nums[i];
                j++;
            }
        }

        //set empty values
        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }

        return j;
    }
}
