package arrays.deleting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RemoveElementTest {
 
    @Test
    public void check() {

        int[] arr = new int[]{0,1,2,2,3,0,4,2};
        int k = RemoveElement.execute(arr, 2);

        assertArrayEquals(new int[]{0,1,3,0,4,0,0,0}, arr);
        assertEquals(5, k);
    }
}
