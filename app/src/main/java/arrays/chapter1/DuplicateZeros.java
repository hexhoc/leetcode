package arrays.chapter1;

public class DuplicateZeros {
    public static void main(String[] args) {
        DuplicateZeros task = new DuplicateZeros();
        task.execute(new int[]{1,0,2,3,0,4,5,0});
        int a = 0;
    }

    public void execute(int[] arr) {
        int[] newArr = new int[arr.length];

        for (int i = 0, j = 0; j < arr.length; i++, j++) {
            newArr[j] = arr[i];
            if (arr[i] == 0) {
                newArr[++j] = arr[i];
            }
        }

        arr = newArr;
    }
}
