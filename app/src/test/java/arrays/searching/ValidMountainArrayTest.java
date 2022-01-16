package arrays.searching;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ValidMountainArrayTest {
    
    @Test
    void check() {

        assertFalse(ValidMountainArray.execute(new int[] { 2,1 }));
        assertFalse(ValidMountainArray.execute(new int[] {0,2,3,3,5,2,1,0}));
        assertTrue(ValidMountainArray.execute(new int[] {0,2,3,4,5,2,1,0}));
    }
}
