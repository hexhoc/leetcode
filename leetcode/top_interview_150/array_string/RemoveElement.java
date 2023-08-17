package top_interview_150.array_string;

/*
27. Remove Element
easy
*/

public class RemoveElement {

    public static void main(String[] args) {
        int[] arr1 = new int[] {0, 1, 2, 2, 3, 0, 4, 2};
        int[] arr2 = new int[] {3, 2, 2, 3};

        var s = new RemoveElement();
        s.removeElement(arr2, 3);
        s.removeElement(arr1, 2);

    }

    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
            if (i > k) {
                nums[i] = 0;
            }
        }

        return k;
    }

}
