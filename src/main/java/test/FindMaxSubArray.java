package test;

import java.util.Scanner;

/**
 * Created by rmandada on 22/1/15.
 */
public class FindMaxSubArray {

    public static void main(String[] args) {

        /**
         * By Divide and conquer  method O(nlogn)
         */

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        int[] result = findMaxSubArray(ar, 0, n - 1);
        for (int i = result[0]; i <=result[1] ; i++) {
            System.out.println(ar[i]);
        }
    }

    private static int[] findMaxSubArray(int[] a, int low, int high) {
        if(low == high) return new int[]{low,high,a[low]};
        else {
            int mid = (low+high)/2;
            int[] leftAr = findMaxSubArray(a, low, mid);
            int[] rightAr = findMaxSubArray(a, mid + 1, high);
            int[] crossAr = FindMaxCrossingSubArray(a,low,mid,high);

            if(leftAr[2] >= rightAr[2] && leftAr[2] >= crossAr[2]){
                return leftAr;
            } else if(rightAr[2]>= leftAr[2] && rightAr[2] >= crossAr[2]){
                return rightAr;
            } else {
                return crossAr;
            }
        }
    }

    private static int[] FindMaxCrossingSubArray(int[] a, int low, int mid, int high){
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum =0;
        int maxLeft=mid;
        int maxRight = mid;
        for (int i = mid; i >=low ; i--) {
            sum = sum+a[i];
            if(sum>leftSum){
                leftSum =sum;
                maxLeft = i;
            }
        }
        sum = 0;
        for (int i = mid; i <=high ; i++) {
            sum = sum+a[i];
            if(sum>rightSum){
                rightSum =sum;
                maxRight = i;
            }
        }

        return new int[]{maxLeft,maxRight,leftSum+rightSum};

    }
}
