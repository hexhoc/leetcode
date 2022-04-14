package arrays.inserting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class DuplicateZerosTest {
    
    @Test
    public void check() {
        DuplicateZeros task = new DuplicateZeros();
        
        int[] arr1 = new int[] {1,0,2,3,0,4,5,0};
        task.execute(arr1);

        int[] arr2 = new int[] {1,2,3};
        task.execute(arr2);

        int[] arr3 = new int[] {0,0,0};
        task.execute(arr3);

        assertArrayEquals(new int[] {1,0,0,2,3,0,0,4}, arr1);
        assertArrayEquals(new int[] {1,2,3}, arr2);
        assertArrayEquals(new int[] {0,0,0}, arr3);
    }
}
