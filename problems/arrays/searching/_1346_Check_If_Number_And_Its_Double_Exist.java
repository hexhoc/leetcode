package problems.arrays.searching;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Given an array arr of integers, check if there exists two integers N and M such that N is the double of M 
( i.e. N = 2 * M).

Example 1:

Input: arr = [10,2,5,3]
Output: true
Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.

*/

public class _1346_Check_If_Number_And_Its_Double_Exist {

    public static void main(String[] args) {
        checkIfExist(new int[]{10,2,5,3});
    }

    public static boolean checkIfExist(int[] arr) {

        Set<Integer> set = IntStream.of(arr)
                .boxed()
                .collect(Collectors.toSet());

        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i]*2)) {
                return true;
            }
        }

        return false;
    }

}
