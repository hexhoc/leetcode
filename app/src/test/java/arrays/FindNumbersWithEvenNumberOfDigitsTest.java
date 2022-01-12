package arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FindNumbersWithEvenNumberOfDigitsTest {
    
    @Test
    public void findNumbers() {
        FindNumbersWithEvenNumberOfDigits task = new FindNumbersWithEvenNumberOfDigits();
        assertEquals(2, task.findNumbers(new int[]{123,11,321,4444}));
        assertEquals(1, task.findNumbers(new int[]{123,111,321,4444}));
    }
}
