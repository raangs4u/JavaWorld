package test;

import java.util.Scanner;

/**
 * Created by rmandada on 22/1/15.
 */
public class FindMaxSubArray1 {
    /**
     * By bruteforce method O(n^2)
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i <n ; i++) {
            ar[i]=in.nextInt();
        }
        int[] result = findMaxSubArray(ar);
        for (int i = result[0]; i <=result[1] ; i++) {
            System.out.println(ar[i]);
        }
    }

    private static int[] findMaxSubArray(int[] a) {
        int left =0;
        int right =0;
        int maxSum =Integer.MIN_VALUE;
        for (int i = 0; i <a.length ; i++) {
            int sum = 0;
            for (int j = i; j <a.length ; j++) {
                sum = sum+a[j];
                if(sum>maxSum){
                    maxSum = sum;
                    left = i;
                    right = j;
                }
            }
        }
        return new int[]{left,right,maxSum};
    }
}
