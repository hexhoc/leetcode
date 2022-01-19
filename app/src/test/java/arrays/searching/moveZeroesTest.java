package arrays.searching;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class moveZeroesTest {
    
    @Test
    void check() {
        int[] nums1 = new int[]{0,1,0,3,12};
        moveZeroes.execute(nums1);
        assertArrayEquals(new int[]{1,3,12,0,0}, nums1);

        int[] nums2 = new int[]{0,1,3,12,0};
        moveZeroes.execute(nums2);
        assertArrayEquals(new int[]{1,3,12,0,0}, nums2);
        // moveZeroes.execute(nums);
    }
}
