package arrays.inplace;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class ReplaceElementsWithGreatestElementOnRightSideTest {
    
    @Test
    void check() {
        assertArrayEquals(new int[]{18,6,6,6,1,-1}, ReplaceElementsWithGreatestElementOnRightSide.execute(new int[]{17,18,5,4,6,1}));
        assertArrayEquals(new int[]{-1}, ReplaceElementsWithGreatestElementOnRightSide.execute(new int[]{400}));
    }
}
