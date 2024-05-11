package algorithm;

import java.util.Arrays;

public class QuickSort {
    // Algorithm:
    // 1. Get all range from 0 to 5, get pivot value at arr[5]
    // 2. Using two pointer iteration, Those that are less than pivot are placed on the left
    public static void main(String[] args) {
        var arr = new int[]{20, 50, 40, 30, 60, 10};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    private static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int k = (begin-1);

        for (int i = begin; i < end; i++) {
            if (arr[i] <= pivot) {
                k++;

                int swapTemp = arr[k];
                arr[k] = arr[i];
                arr[i] = swapTemp;
            }
        }

        int swapTemp = arr[k+1];
        arr[k+1] = arr[end];
        arr[end] = swapTemp;

        return k+1;
    }
}
