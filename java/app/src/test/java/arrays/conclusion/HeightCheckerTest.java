package arrays.conclusion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class HeightCheckerTest {
    
    @Test
    public void check() {
        assertEquals(3, HeightChecker.execute(new int[]{1,1,4,2,1,3}));
        assertEquals(5, HeightChecker.execute(new int[]{5,1,2,3,4}));
        assertEquals(0, HeightChecker.execute(new int[]{1,2,3,4,5}));
    }
}
