package problems.arrays.deleting;

/*
80. Remove Duplicates from Sorted Array II
Medium
*/

public class _80_Remove_Duplicates_From_Sorted_Array_2 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{0,0,1,1,1,1,2,3,3};
        int[] arr2 = new int[]{1,1,2};
        int[] arr3 = new int[]{1,1,1,2,2,3};
        int[] arr4 = new int[]{0,1,2,2,3,3,4,4,4};

        var s = new _80_Remove_Duplicates_From_Sorted_Array_2();
        s.removeDuplicates(arr3);
        s.removeDuplicates(arr1);
        s.removeDuplicates(arr2);
        s.removeDuplicates(arr4);
    }

    public int removeDuplicates(int[] nums) {
        int k = 1;
        int gap = 0;
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i-1]) {
                gap++;
            } else {
                gap = 0;
            }

            nums[k] = nums[i];
            if (gap <= 1) {
                k++;
            }
        }

        for (int i = k; i < nums.length; i++) {
            nums[i]=0;
        }

        return k;
    }

}
