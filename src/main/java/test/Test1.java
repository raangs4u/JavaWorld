package test;

import java.util.Scanner;

/**
 * Created by rmandada on 20/1/15.
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i <n ; i++) {
            ar[i]=in.nextInt();
        }
        partition(ar,0,n-1);
        //printArray(ar);
    }

    private static void partition(int[] a, int i, int j){
        int x = i, y = j;
        if(j-i<1) return;
        int p = j;
        int swap = 0;
        while (i<j) {
            while (a[i] <= a[p] && i < j) {
                i = i + 1;
            }
            while (a[j] >= a[p] && i < j) {
                j = j - 1;
            }
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            if(i!=j) swap++;
        }
        int tmp = a[p];
        a[p] = a[i];
        a[i] = tmp;
        if(swap>0)printArray(a);
        partition(a,x,j-1);
        partition(a,j,y);
    }

    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }


}
