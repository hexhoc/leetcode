package arrays.deleting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class RemoveDuplicatesInNonSortedArrayTest {
    
    @Test
    void check() {
        int nums[] = new int[] {3,4,3,4,5,1,2,3,4,5};
        RemoveDuplicatesInNonSortedArray.execute(nums);
        assertArrayEquals(new int[]{0,0,0,0,0,1,2,0,0,0}, nums);

    }
}
