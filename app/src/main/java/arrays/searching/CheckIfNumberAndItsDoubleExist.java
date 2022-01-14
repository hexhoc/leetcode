package arrays.searching;

public class CheckIfNumberAndItsDoubleExist {

    public static void main(String[] args) {
        checkIfExist(new int[]{10,2,5,3});
    }

    public static boolean checkIfExist(int[] arr) {
        
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]*2 == arr[j] || arr[i] == arr[j]*2) {
                    return true;
                }
            }
        }

        return false;
    }

}
