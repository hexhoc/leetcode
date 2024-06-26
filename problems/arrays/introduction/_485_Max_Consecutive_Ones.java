package problems.arrays.introduction;

public class _485_Max_Consecutive_Ones {
    public static void main(String[] args) {
        _485_Max_Consecutive_Ones task = new _485_Max_Consecutive_Ones();
        task.findMaxConsecutiveOnes(new int[]{0,1,1,0,1,1,1});
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        
        // O(n)
        int max = 0, length = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                length++;
            }

            if (nums[i] == 0 || i == (nums.length-1)) {
                //reset
                max = max < length ? length : max;
                length = 0;
            }
        }
     
        return max;
    }
}
