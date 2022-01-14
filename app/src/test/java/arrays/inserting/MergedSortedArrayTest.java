package arrays.inserting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class MergedSortedArrayTest {
    
    @Test
    public void check() {
        MergedSortedArray task = new MergedSortedArray();

        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        task.execute(nums1, 3, nums2, 3);

        assertArrayEquals(new int[]{1,2,2,3,5,6}, nums1);
    }
}
