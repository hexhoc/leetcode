package util;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Assertions {
    private Assertions() { }

    public static void assertEquals(Integer expected, Integer actual) {
        if (!Objects.equals(expected, actual)) {
            System.out.println("Expected: " + expected + ", Actual: " + actual);
        }
    }

    public static void assertEquals(List<Integer> expected, List<Integer> actual) {
        if (!expected.equals(actual)) {
            System.out.println("Expected: " + expected + ", Actual: " + actual);
        }
    }

    public static void assertEquals(int[] expected, int[] actual) {
        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual[i]) {
                System.out.println("Expected: " + Arrays.toString(expected) + ", Actual: " + Arrays.toString(actual));
                break;
            }
        }

    }
}
