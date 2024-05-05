package algorithm;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        var arr = new int[]{3,6,2,1,4,5};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int begin = 0;
        int end = arr.length-1;
        int mid = begin + (end - begin) / 2;
        int[] leftArr = Arrays.stream(arr).filter(value -> value < arr[mid]).toArray();
        int[] rightArr = Arrays.stream(arr).filter(value -> value > arr[mid]).toArray();

        quickSort(leftArr);
        quickSort(rightArr);

        // Выполняем конкатенацию в исходный массив: leftArr + mid + rightArr
        // Устанавливаем среднее значение после левой части
        arr[leftArr.length] = arr[mid];
        // Затем устанавливае левую часть
        System.arraycopy(leftArr,0, arr, 0, leftArr.length);
        // Устанавливаем правую часть
        System.arraycopy(rightArr,0, arr, leftArr.length+1, rightArr.length);

    }

}
