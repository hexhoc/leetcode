package problems.arrays.deleting;

public class _26_remove_duplicates_from_sorted_array {
    public static void main(String[] args) {
        int[] arr1 = new int[]{0,0,1,1,1,2,2,3,3,4};
        int[] arr2 = new int[]{1,1,2};
        int[] arr3 = new int[]{1};
        int[] arr4 = new int[]{0,1,2,2,3,3,4,4,4};

        var s = new _26_remove_duplicates_from_sorted_array();
        var k1 = s.execute(arr1);
        var k2 = s.execute(arr2);
        var k3 = s.execute(arr3);
        var k4 = s.execute(arr4);

        assertEquals(arr1, new int[]{0,1,2,3,4}, k1);
        assertEquals(arr2, new int[]{1,2}, k2);
        assertEquals(arr3, new int[]{1}, k3);
        assertEquals(arr4, new int[]{0,1,2,3,4}, k4);
    }

    public int execute(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }

        return k;
    }

    private static void assertEquals(int[] actual, int[] expected, int actualLength) {
        if (expected.length != actualLength) {
            System.out.printf("wrong length. expected: %s, actual: %s%n", expected.length, actualLength);
        }
        for (int i = 0; i < actualLength; i++) {
            if (actual[i] != expected[i]) {
                System.out.printf("wrong element expected: %s, actual: %s%n", expected[i], actual[i]);
            }
        }
    }
}
