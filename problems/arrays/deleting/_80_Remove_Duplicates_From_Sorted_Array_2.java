package problems.arrays.deleting;

import static util.Assertions.assertEquals;

public class _80_Remove_Duplicates_From_Sorted_Array_2 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        int[] arr2 = new int[]{1, 1, 2};
        int[] arr3 = new int[]{1, 1, 1, 2, 2, 3};
        int[] arr4 = new int[]{0, 1, 2, 2, 3, 3, 4, 4, 4};

        var s = new _80_Remove_Duplicates_From_Sorted_Array_2();
        var k1= s.removeDuplicates(arr1);
        var k2= s.removeDuplicates(arr2);
        var k3= s.removeDuplicates(arr3);
        var k4= s.removeDuplicates(arr4);

        assertEquals(7, k1);
        assertEquals(new int[]{0, 0, 1, 1, 2, 3, 3, 0, 0}, arr1);
        assertEquals(3, k2);
        assertEquals(new int[]{1, 1, 2}, arr2);
        assertEquals(5, k3);
        assertEquals(new int[]{1, 1, 2, 2, 3, 0}, arr3);
        assertEquals(8, k4);
        assertEquals(new int[]{0, 1, 2, 2, 3, 3, 4, 4, 0}, arr4);
    }

    public int removeDuplicates(int[] nums) {
        var k = 1;
        int matchCount = 0;
        for (int i = 1; i < nums.length; i++) {
            matchCount = nums[i] == nums[i-1] ? matchCount + 1 : 0;
            nums[k] = nums[i];
            if (matchCount < 2) {
                k++;
            }
        }

        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }

        return k;
    }

}
