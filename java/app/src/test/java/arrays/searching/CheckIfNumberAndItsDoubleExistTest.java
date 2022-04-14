package arrays.searching;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CheckIfNumberAndItsDoubleExistTest {
    @Test
    void testCheckIfExist() {
        assertEquals(true, CheckIfNumberAndItsDoubleExist.checkIfExist(new int[]{10,2,5,3})); 
        assertEquals(true, CheckIfNumberAndItsDoubleExist.checkIfExist(new int[]{7,1,14,11})); 
        assertEquals(false, CheckIfNumberAndItsDoubleExist.checkIfExist(new int[]{3,1,7,11})); 
    }
}
