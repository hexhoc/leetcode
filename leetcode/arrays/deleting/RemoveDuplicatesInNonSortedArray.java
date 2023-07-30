package arrays.deleting;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesInNonSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{3,4,3,4,5,1,2,3,4,5}; 
        RemoveDuplicatesInNonSortedArray.execute(nums);
        //Should be {1,2}
    }
    
    public static void execute(int[] nums) {
        int i = 0;
        Set<Integer> alreadyProcessed = new HashSet<>();
        for (int j = 0; j < nums.length; j++) {
            if (!alreadyProcessed.contains(nums[j])) {
                nums[i] = nums[j];
                i++;
            }
        }

        for (int j = i; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
