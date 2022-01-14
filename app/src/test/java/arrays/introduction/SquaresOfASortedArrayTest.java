package arrays.introduction;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SquaresOfASortedArrayTest {
    
    @Test
    public void sortedSquares() {
        SquaresOfASortedArray task = new SquaresOfASortedArray();
        assertArrayEquals(new int[]{0,1,9,16,100}, task.sortedSquares(new int[]{-4,-1,0,3,10}));
        assertArrayEquals(new int[]{4,9,9,49,121}, task.sortedSquares(new int[]{-7,-3,2,3,11}));
    }
}
