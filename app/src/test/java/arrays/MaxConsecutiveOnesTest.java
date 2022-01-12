package arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MaxConsecutiveOnesTest {
    
    @Test
    @DisplayName("find max consecutive ones")
    public void findMaxConsecutiveOnes() {
        MaxConsecutiveOnes testClass = new MaxConsecutiveOnes();
        assertEquals(3, testClass.findMaxConsecutiveOnes(new int[]{0,1,1,0,1,1,1}));
        assertEquals(1, testClass.findMaxConsecutiveOnes(new int[]{0,1,0,1}));
        assertEquals(0, testClass.findMaxConsecutiveOnes(new int[]{0,0,0,0,0,0,0}));
        assertEquals(7, testClass.findMaxConsecutiveOnes(new int[]{1,1,1,1,1,1,1}));
        assertEquals(1, testClass.findMaxConsecutiveOnes(new int[]{0,0,0,0,0,0,1}));
        assertEquals(1, testClass.findMaxConsecutiveOnes(new int[]{1,0,0,0,0,0,0}));
    }
}
