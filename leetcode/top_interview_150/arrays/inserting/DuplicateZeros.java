package top_interview_150.arrays.inserting;

/*
Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.

Example 1:

Input: arr = [1,0,2,3,0,4,5,0]
Output: [1,0,0,2,3,0,0,4]
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
*/

public class DuplicateZeros {
    public static void main(String[] args) {
        DuplicateZeros task = new DuplicateZeros();
        int[] arr = new int[]{1,0,2,3,0,4,5,0};
        task.execute(arr);
    }

    public void execute(int[] arr) {
        int[] newArr = new int[arr.length];
        for (int i = 0, k = 0; k < arr.length; i++, k++) {
            if (arr[i] == 0) {
                k++;
            }
            newArr[k] = arr[i];
        }

        for (int i = 0; i < newArr.length; i++) {
            arr[i] = newArr[i];
        }
    }

}
