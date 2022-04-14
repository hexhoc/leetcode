package arrays.conclusion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MaxConsecutiveOnes2Test {

    @Test
    public void check() {
        assertEquals(4, MaxConsecutiveOnes2.execute(new int[]{1,0,1,1,0})); 
        assertEquals(3, MaxConsecutiveOnes2.execute(new int[]{0,0,1,1,0})); 
        assertEquals(3, MaxConsecutiveOnes2.execute(new int[]{1,1,0})); 
        assertEquals(2, MaxConsecutiveOnes2.execute(new int[]{0,0,1,0,0})); 
        assertEquals(1, MaxConsecutiveOnes2.execute(new int[]{0,0,0,0,0})); 
    }
}
