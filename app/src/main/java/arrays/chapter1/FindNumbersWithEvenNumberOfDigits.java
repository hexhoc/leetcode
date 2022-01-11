package arrays.chapter1;

public class FindNumbersWithEvenNumberOfDigits {
    
    public static void main(String[] args) {
        FindNumbersWithEvenNumberOfDigits task2 = new FindNumbersWithEvenNumberOfDigits();
        task2.findNumbers(new int[]{123,11,321,4444});
    }

    public int findNumbers(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (String.valueOf(nums[i]).length() % 2 == 0) {
                count++;
            }
        }

        return count;
    }
}
