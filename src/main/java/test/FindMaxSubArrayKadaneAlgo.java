package test;

import java.util.Scanner;

/**
 * Created by rmandada on 22/1/15.
 */
public class FindMaxSubArrayKadaneAlgo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }

        int[] result = findMaxSubArray(ar);
        for (int i = result[0]; i <=result[1] ; i++) {
            System.out.println(ar[i]);
        }

    }
    private static int[] findMaxSubArray(int[] a){

        /**
         * kadanes algorithm of O(n) including all negative nos case
         */

        int bestSoFar = a[0];
        int bestEndingHere = a[0];
        int bestStartIndexSoFar = 0;
        int bestStopIndexSoFar = 0;
        int bestStartIndexNow = 0;
        for (int i = 1; i <a.length ; i++) {
            int value = bestEndingHere+a[i];
            if(value>a[i]){
                /*if(bestEndingHere == 0){
                    bestStartIndexNow = i;
                }*/
                bestEndingHere = value;
            }else {
                bestEndingHere = a[i];
                bestStartIndexNow = i;
            }
            if(bestEndingHere> bestSoFar){
                bestSoFar = bestEndingHere;
                bestStopIndexSoFar = i;
                bestStartIndexSoFar = bestStartIndexNow;
            }
        }
        return new int[]{bestStartIndexSoFar,bestStopIndexSoFar,bestSoFar};
    }
}
