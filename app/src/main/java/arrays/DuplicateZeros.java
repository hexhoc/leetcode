package arrays;

public class DuplicateZeros {
    public static void main(String[] args) {
        DuplicateZeros task = new DuplicateZeros();
        int[] arr = new int[]{1,0,2,3,0,4,5,0};
        task.execute(arr);
        int a = 0;
    }

    public void execute(int[] arr) {

        int[] newArr = new int[arr.length];

        for (int i = 0, j = 0; j < arr.length; i++, j++) {
            newArr[j] = arr[i];

            if (arr[i] == 0) {
                j++;
                if (j != arr.length) {
                    newArr[j] = arr[i];
                }
            }
        }

        for (int i = 0; i < newArr.length; i++) {
            arr[i] = newArr[i];
        }
    }
}
