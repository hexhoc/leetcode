package arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class RemoveDuplicatesFromSortedArrayTest {
    
    @Test
    public void check() {
        int[] arr1 = new int[]{0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicatesFromSortedArray.execute(arr1);

        int[] arr2 = new int[]{1,1,2};
        RemoveDuplicatesFromSortedArray.execute(arr2);

        int[] arr3 = new int[]{1};
        RemoveDuplicatesFromSortedArray.execute(arr3);

        assertArrayEquals(new int[]{0,1,2,3,4,0,0,0,0,0}, arr1);
        assertArrayEquals(new int[]{1,2,0}, arr2);
        assertArrayEquals(new int[]{1}, arr3);
    }
}
