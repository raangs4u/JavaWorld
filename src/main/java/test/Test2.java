package test;

import java.util.Random;
import java.util.Scanner;
import java.util.SortedMap;

/**
 * Created by rmandada on 22/1/15.
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            ar[i] = rand.nextInt(n);
        }
        long start1 = System.currentTimeMillis();
        System.out.println(start1);
        int[] result1 = findMaxSubArray(ar, 0, n - 1);
        long end1 =System.currentTimeMillis();
        System.out.println(end1);
        int[] result2 = findMaxSubArray(ar);
        long end2 =System.currentTimeMillis();
        System.out.println(end2);
        System.out.println("time taken for D & C: "+(end1-start1));
        System.out.println("time taken for Bruteforce : "+(end2-end1));
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
