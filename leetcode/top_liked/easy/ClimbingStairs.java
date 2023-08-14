package top_liked.easy;

import java.math.BigInteger;

/**
 * 70. Climbing Stairs
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        var s = new ClimbingStairs();
        System.out.println(s.climbStairs(8));//2
    }

    // Используем число фибоначи. Складываем два предыдущих числа.
    public int climbStairs(int n) {
        if(n==1) return 1;

        if(n==2) return 2;

        int[] a =  new int[n];
        a[0]=1;
        a[1]=2;

        for(int i=2;i<n;i++){
            a[i]=a[i-1]+a[i-2];
        }
        return a[n-1];
    }


    // Решение при помощи факториала
    public int climbStairsFactorial(int n) {
        var result = 1;
        int countOne = n-2;
        int countTwo = 1;
        while(countOne >= 0) {
            result = result + countCombination(countOne + countTwo, countTwo);
            countOne = countOne - 2;
            countTwo = countTwo + 1;
        }

        return result;
    }

    private int countCombination(int num1, int num2) {
        if (num2 <= 0) {
            return 0;
        }
        var n1 = BigInteger.valueOf(num1);
        var n2 = BigInteger.valueOf(num2);
        var sum = BigInteger.valueOf(num1 - num2 == 0 ? 1 : num1 - num2);
        return (factorial(n1).divide((factorial(n2).multiply(factorial(sum))))).intValue();
    }

    private BigInteger factorial(BigInteger k) {
        if (k.intValue() == 1) {
            return k;
        }
        return k.multiply(factorial(k.subtract(BigInteger.valueOf(1))));
    }
}
