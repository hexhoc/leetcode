package top_interview_150.arrays;

import java.util.HashMap;
import java.util.Map;

/*
169. Majority Element
Easy
 */
public class MajorityElement {

    public static void main(String[] args) {
        var s = new MajorityElement();
        System.out.println(s.majorityElement(new int[]{1,1,1,1}));
        System.out.println(s.majorityElement(new int[]{6,5,5}));
        System.out.println(s.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> mapCounter = new HashMap<>();
        int maxNumber = -1;
        int maxCount = -1;
        for (int i = 0; i < nums.length; i++) {
            if (!mapCounter.containsKey(nums[i])) {
                mapCounter.put(nums[i], 0);
            }
            var counter = mapCounter.get(nums[i]) + 1;
            mapCounter.put(nums[i], counter);
            if (counter > maxCount) {
                maxCount = counter;
                maxNumber = nums[i];
            }
        }

        return maxNumber;
    }
}
