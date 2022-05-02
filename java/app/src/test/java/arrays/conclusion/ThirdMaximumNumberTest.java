package arrays.conclusion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ThirdMaximumNumberTest {
    
    @Test
    public void test() {

        assertEquals(1, ThirdMaximumNumber.execute(new int[]{3,2,1}));
        assertEquals(2, ThirdMaximumNumber.execute(new int[]{1,2}));
        assertEquals(1, ThirdMaximumNumber.execute(new int[]{2,2,3,1}));

    }
}
