package top_interview_150.arrays.deleting;

/*
26. Remove Duplicates from Sorted Array
Easy
*/

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr1 = new int[]{0,0,1,1,1,2,2,3,3,4};
        int[] arr2 = new int[]{1,1,2};
        int[] arr3 = new int[]{1};
        int[] arr4 = new int[]{0,1,2,2,3,3,4,4,4};

        var s = new RemoveDuplicatesFromSortedArray();
        s.removeDuplicates(arr1);
        s.removeDuplicates(arr2);
        s.removeDuplicates(arr3);
        s.removeDuplicates(arr4);
    }

    public int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                continue;
            }

            nums[k] = nums[i];
            k++;
        }

        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }

        return k;
    }

}
