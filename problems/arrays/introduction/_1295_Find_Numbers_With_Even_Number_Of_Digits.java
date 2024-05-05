package problems.arrays.introduction;

public class _1295_Find_Numbers_With_Even_Number_Of_Digits {
    
    public static void main(String[] args) {
        _1295_Find_Numbers_With_Even_Number_Of_Digits task2 = new _1295_Find_Numbers_With_Even_Number_Of_Digits();
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
