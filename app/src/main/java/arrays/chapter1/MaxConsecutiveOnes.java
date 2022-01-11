package arrays.chapter1;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        MaxConsecutiveOnes task = new MaxConsecutiveOnes();
        task.findMaxConsecutiveOnes(new int[]{0,1,1,0,1,1,1});
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        
        // n(O)
        int max = 0;
        int length = 0;

        for (int i : nums) {
            if (i == 0) {
                max = (length > max) ? length : max;
                length = 0;
                continue;
            }
            length++;
        }
        
        return max;
    }
}
