package arrays.searching;

public class ValidMountainArray {
    public static void main(String[] args) {
        // ValidMountainArray.execute(new int[] { 2,1 });
        // ValidMountainArray.execute(new int[] { 0, 2, 3, 3, 5, 2, 1, 0 });
        ValidMountainArray.execute(new int[] { 0, 2, 3, 4, 5, 2, 1, 0 });
    }

    public static boolean execute(int[] nums) {

        int pathLength = nums.length;
        int i = 0;

        // step up
        while (i < pathLength-1 && nums[i] < nums[i+1]) {
            i++;
        }

        //peek cannot be first or last
        if(i == 0 || i == pathLength-1) {
            return false;
        }

        //step down
        while (i < pathLength-1 && nums[i] > nums[i+1]) {
            i++;
        }

        return i == pathLength-1;

    }
}
