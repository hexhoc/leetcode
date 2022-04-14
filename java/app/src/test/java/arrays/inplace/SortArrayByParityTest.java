package arrays.inplace;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class SortArrayByParityTest {
    
    @Test
    public void check() {
       assertArrayEquals(new int[]{2,4,3,1}, SortArrayByParity.execute(new int[]{3,1,2,4}));
    }
}
