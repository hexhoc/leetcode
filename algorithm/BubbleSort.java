package algorithm;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        var arr = new int[]{30, 60, 20, 10, 40, 50};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // Function to perform bubble sort on the array
    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then array is sorted
            if (!swapped)
                break;
        }
    }
}
