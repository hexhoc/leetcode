package arrays.deleting;

public class RemoveElement {
    public static void main(String[] args) {
        int[] arr1 = new int[]{0,1,2,2,3,0,4,2};
        RemoveElement.execute(arr1, 2);

        int[] arr2 = new int[]{3,2,2,3};
        RemoveElement.execute(arr2, 3);
    }

    public static int execute(int[] nums, int val) {
        
        int k = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = 0;
                k--;
            }
        }

        sortArray(nums);

        return k;
    }

    public static void sortArray(int[] arr) {
        boolean sorted = false;
        while(!sorted){
            sorted = true;
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i] < arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }
}
