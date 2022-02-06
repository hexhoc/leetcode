package sberfight.sum_is_less;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SumIsLessTest {

    @Test
    public void check() {
        Assertions.assertTrue(SumIsLess.execute(new int[]{3, 2, 4, 5}, 9));
        Assertions.assertTrue(SumIsLess.execute(new int[]{52, 2, 2, 2, 2}, 14));
    }
}
