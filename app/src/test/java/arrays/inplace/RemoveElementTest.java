package arrays.inplace;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RemoveElementTest {
    
    @Test
    public void check() {
        int[] nums = new int[]{3,2,2,3};
        int result = RemoveElement.execute(nums, 3);
        assertEquals(2, result);
        assertArrayEquals(new int[]{2,2,0,0}, nums);
    }
}
